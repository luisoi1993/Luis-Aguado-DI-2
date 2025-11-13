package org.example.formularioapp.contorller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.formularioapp.HelloApplication;
import org.example.formularioapp.dao.UsuarioDAOImp;
import org.example.formularioapp.model.Usuario;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FormController implements Initializable {
    public MenuItem menuLista;
    public MenuItem menuDetalle;
    public MenuItem menuEliminar;
    @FXML
    private Button verDetalle, botonModificar;
    @FXML
    private Button buttonAgregar;

    @FXML
    private Button buttonEliminar;

    @FXML
    private CheckBox checkDisponibilidad;

    @FXML
    private ComboBox<Integer> comboEdad;

    @FXML
    private BorderPane panelGeneral;


    @FXML
    private RadioButton radioFemenino;

    @FXML
    private RadioButton radioMasculino;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textfieldCorreo;

    @FXML
    private TextField textfieldLocalizacion;

    @FXML
    private ToggleButton toggleLista;

    private ToggleGroup grupoGenero;

    private ObservableList<Integer> listaEdades;

    private ObservableList<Usuario> listaUsuarios;
    @FXML
    private ListView<Usuario> listViewUsuarios;
    @FXML
    private GridPane panelDerecha;

    private UsuarioDAOImp usuarioDAOImp;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
    }

    private void acciones() {
        menuDetalle.setOnAction(new ManejoActions());
        menuLista.setOnAction(new ManejoActions());
        menuEliminar.setOnAction(new ManejoActions());
        verDetalle.setOnAction(new ManejoActions());
        buttonAgregar.setOnAction(new ManejoActions());
        buttonEliminar.setOnAction(new ManejoActions());
        botonModificar.setOnAction(new ManejoActions());

        checkDisponibilidad.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                System.out.println("Venimos de " + oldValue);
                System.out.println("Estamos en " + newValue);
                buttonAgregar.setDisable(!newValue);
            }
        });

        toggleLista.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {

                if (newValue) {
                    panelGeneral.setRight(panelDerecha);
                } else {
                    panelGeneral.setRight(null);
                }
            }
        });
    }


    private void initGUI() {
        listViewUsuarios.setItems(listaUsuarios);
        comboEdad.setItems(listaEdades);
        buttonAgregar.setDisable(!checkDisponibilidad.isSelected());
        if (toggleLista.isSelected()) {
            panelGeneral.setRight(panelDerecha);
        } else {
            panelGeneral.setRight(null);
        }

    }

    private void instancias() {
        grupoGenero = new ToggleGroup();
        grupoGenero.getToggles().addAll(radioMasculino, radioFemenino);

        listaEdades = FXCollections.observableArrayList();
        for (int i = 18; i < 91; i++) {
            listaEdades.add(i);
        }

        listaUsuarios = FXCollections.observableArrayList(); // lista vacía inicial
        usuarioDAOImp = new UsuarioDAOImp();
        listaUsuarios.addAll(usuarioDAOImp.obtenerUsuario()); // agrega elementos, no sobrescribir la lista
    }


    private void limpiarDatos() {
        textFieldNombre.clear();
        textfieldCorreo.clear();
        textfieldLocalizacion.clear();
        grupoGenero.selectToggle(null);
        checkDisponibilidad.setSelected(false);
        comboEdad.getSelectionModel().clearSelection();
    }

    private Usuario estaUsuario(String correo) {
        for (Usuario item : listaUsuarios) {
            if (item.getCorreo().equalsIgnoreCase(correo)) {
                return item;
            }
        }
        return null;
    }

    public void actualizarUsuario(Usuario u) {
        //actualizar el usuario
        System.out.println("Contestacion realizada con exito");
    }

    class ManejoActions implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == buttonAgregar) {
                if (!textFieldNombre.getText().isEmpty()
                        && !textfieldLocalizacion.getText().isEmpty()
                        && grupoGenero.getSelectedToggle() != null
                        && comboEdad.getSelectionModel().getSelectedItem() >= 0) {

                    String nombre = textFieldNombre.getText();
                    String correo = textfieldCorreo.getText();
                    String localizacion = textfieldLocalizacion.getText();
                    String genero = ((RadioButton) grupoGenero.getSelectedToggle()).getText();
                    boolean disponibilidad = checkDisponibilidad.isSelected();
                    int edad = comboEdad.getSelectionModel().getSelectedItem();

                    Usuario usuario = new Usuario(nombre, correo, localizacion, genero, edad, disponibilidad);
                    boolean fallo = false;
                    try {
                        usuarioDAOImp.insertarUsuario(usuario);
                        listaUsuarios.add(usuario);
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                        fallo = true;
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error en insercion");
                        alert.setContentText("correo duplicado introsuce uno nuevo");
                        alert.show();

                    }
                    if(!fallo){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Insercion correcta");
                        alert.setContentText("Usuario insertado correctamente");
                        alert.show();
                        limpiarDatos();
                    }
                    /*
                    if (estaUsuario(correo) != null){
                        System.out.println("El usuario ya esta en la lista");
                        Stage ventanaDialogo = new Stage();
                        try {

                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("dialogoUsuario-view.fxml"));
                            Scene scena = new Scene(loader.load());
                            ventanaDialogo.setScene(scena);
                            ventanaDialogo.setTitle("Usuario duplicado");
                            ventanaDialogo.setResizable(false);
                            ventanaDialogo.initModality(Modality.APPLICATION_MODAL);
                            ventanaDialogo.showAndWait();
                        } catch (IOException e){
                            throw new RuntimeException(e);
                        }
                    }else {
                        Usuario usuario = new Usuario(nombre,correo,localizacion,genero,edad,disponibilidad);
                        listaUsuarios.add(usuario);
                        System.out.println("Usuario agregado correctamente");
                        Stage ventanaDialogo = new Stage();
                        try {

                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("dialogoUsuarioCorrecto-view.fxml"));
                            Scene scena = new Scene(loader.load());
                            ventanaDialogo.setScene(scena);
                            ventanaDialogo.setTitle("Usuario correcto");
                            ventanaDialogo.setResizable(false);
                            ventanaDialogo.initModality(Modality.APPLICATION_MODAL);
                            ventanaDialogo.showAndWait();
                        } catch (IOException e){
                            throw new RuntimeException(e);
                        }


                        limpiarDatos();

                    }



                }else{
                    System.out.println("Error, faltan datos");
                    Stage ventanaDialogo = new Stage();
                    try {

                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("dialogoErrorDatos-view.fxml"));
                        Scene scena = new Scene(loader.load());
                        ventanaDialogo.setScene(scena);
                        ventanaDialogo.setTitle("Usuario duplicado");
                        ventanaDialogo.setResizable(false);
                        ventanaDialogo.initModality(Modality.APPLICATION_MODAL);
                        ventanaDialogo.showAndWait();
                    } catch (IOException e){
                        throw new RuntimeException(e);
                    }
                }

                    */

                } else if (actionEvent.getSource() == verDetalle || actionEvent.getSource() == menuDetalle) {
                    int posicionSeleccionada = listViewUsuarios.getSelectionModel().getSelectedIndex();
                    if (posicionSeleccionada != -1) {
                        Usuario usuario = listViewUsuarios.getSelectionModel().getSelectedItem();
                        Stage ventanaDetalle = new Stage();
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("detalle-view.fxml"));
                        Parent root = null;
                        try {
                            root = loader.load();
                            DialogoController dialogoController = loader.getController();
                            dialogoController.setUsuario(usuario);
                            dialogoController.setFormController(FormController.this);
                            Scene scene = new Scene(root);
                            ventanaDetalle.setScene(scene);
                            ventanaDetalle.initModality(Modality.APPLICATION_MODAL);
                            ventanaDetalle.setTitle("Ventana detalle");
                            ventanaDetalle.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                /*Usuario usuarioSeleccionado = listViewUsuarios.getSelectionModel().getSelectedItem();
                System.out.println("La posicion seleccionada es " + posicionSeleccionada);
                System.out.println("El elemento seleccionado es " + usuarioSeleccionado.getCorreo());

                 */
                } else if (actionEvent.getSource() == buttonEliminar || actionEvent.getSource() == menuEliminar) {
                    Usuario usuarioSeleccionado = listViewUsuarios.getSelectionModel().getSelectedItem();

                    if (usuarioSeleccionado == null) {
                        System.out.println("No se seleccionó ningún usuario.");
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sin selección");
                        alert.setContentText("Por favor selecciona un usuario de la lista.");
                        alert.show();
                        return;
                    }

                    System.out.println("Usuario seleccionado para borrar: " + usuarioSeleccionado.getCorreo());

                    Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                    confirm.setTitle("Confirmar eliminación");
                    confirm.setHeaderText("¿Seguro que quieres eliminar este usuario?");
                    confirm.setContentText("Correo: " + usuarioSeleccionado.getCorreo());

                    confirm.showAndWait().ifPresent(response -> {
                        if (response == ButtonType.OK) {
                            try {
                                int filas = usuarioDAOImp.borrarUsuario(usuarioSeleccionado.getCorreo());
                                if (filas > 0) {
                                    listaUsuarios.remove(usuarioSeleccionado); // elimina de la lista
                                    System.out.println("Usuario eliminado de la lista y base de datos.");
                                    Alert ok = new Alert(Alert.AlertType.INFORMATION);
                                    ok.setTitle("Usuario eliminado");
                                    ok.setContentText("Usuario eliminado correctamente.");
                                    ok.show();
                                } else {
                                    System.out.println("No se encontró el usuario en la base de datos.");
                                    Alert error = new Alert(Alert.AlertType.ERROR);
                                    error.setTitle("Error");
                                    error.setContentText("No se pudo eliminar el usuario. Revisa el correo.");
                                    error.show();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                Alert error = new Alert(Alert.AlertType.ERROR);
                                error.setTitle("Error SQL");
                                error.setContentText("Ocurrió un error: " + e.getMessage());
                                error.show();
                            }
                        }
                    });
                }


                else if (actionEvent.getSource() == botonModificar) {
                    int posicionSeleccionada = listViewUsuarios.getSelectionModel().getSelectedIndex();
                    if (posicionSeleccionada != -1) {
                        Usuario usuario = listViewUsuarios.getSelectionModel().getSelectedItem();
                        try {
                            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("modificar-view.fxml"));
                            Parent root = loader.load();
                            ModificarController modificarController = loader.getController();
                            modificarController.setUsuario(usuario);

                            Stage ventanaModificar = new Stage();
                            ventanaModificar.setScene(new Scene(root));
                            ventanaModificar.initModality(Modality.APPLICATION_MODAL);
                            ventanaModificar.setTitle("Modificar usuario");
                            ventanaModificar.showAndWait();

                            // 🔄 Refresca la lista
                            listViewUsuarios.refresh();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("No hay usuario seleccionado");
                    }
                } else if (actionEvent.getSource() == menuLista) {

                    toggleLista.setSelected(!toggleLista.isSelected());
                }
            }
        }
    }
}
