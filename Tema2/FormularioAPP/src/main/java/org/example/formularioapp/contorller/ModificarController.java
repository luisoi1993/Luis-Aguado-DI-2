package org.example.formularioapp.contorller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.formularioapp.model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class ModificarController implements Initializable {

    public Button botonGuardar;
    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldCorreo;

    @FXML
    private TextField textFieldLocalizacion;

    @FXML
    private CheckBox checkDisponibilidad;

    @FXML
    private ComboBox<Integer> comboEdad;



    private Usuario usuario;
    private ObservableList<Integer> listaEdades;

    private FormController formController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
    }

    private void instancias() {
        listaEdades = FXCollections.observableArrayList();
        for (int i = 18; i <= 90; i++) {
            listaEdades.add(i);
        }
    }

    private void initGUI() {
        comboEdad.setItems(listaEdades);
    }

    private void acciones() {
        botonGuardar.setOnAction(new ManejoActions());
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        cargarDatos();
    }

    private void cargarDatos() {
        if (usuario != null) {
            textFieldNombre.setText(usuario.getNombre());
            textFieldCorreo.setText(usuario.getCorreo());
            textFieldLocalizacion.setText(usuario.getLocalizacion());
            checkDisponibilidad.setSelected(usuario.isDisponibilidad());
            comboEdad.getSelectionModel().select(Integer.valueOf(usuario.getEdad()));
        }
    }

    class ManejoActions implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonGuardar) {
                if (!textFieldNombre.getText().isEmpty()
                        && !textFieldCorreo.getText().isEmpty()
                        && !textFieldLocalizacion.getText().isEmpty()
                        && comboEdad.getSelectionModel().getSelectedItem() != null) {

                    usuario.setNombre(textFieldNombre.getText());
                    usuario.setCorreo(textFieldCorreo.getText());
                    usuario.setLocalizacion(textFieldLocalizacion.getText());
                    usuario.setDisponibilidad(checkDisponibilidad.isSelected());
                    usuario.setEdad(comboEdad.getSelectionModel().getSelectedItem());

                    System.out.println("✅ Cambios guardados correctamente");
                    Stage stage = (Stage) botonGuardar.getScene().getWindow();
                    stage.close();
                } else {
                    System.out.println("⚠️ Faltan datos para guardar");
                    Alert alerta = new Alert(Alert.AlertType.WARNING);
                    alerta.setTitle("Faltan datos");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Por favor, completa todos los campos antes de guardar.");
                    alerta.showAndWait();
                }
            }
        }
    }

}
