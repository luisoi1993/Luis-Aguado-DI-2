package org.example.amazoncompras.controller;

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
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.amazoncompras.HelloApplication;
import org.example.amazoncompras.model.Compra;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioController implements Initializable {
    @FXML
    private Button botonCarrito;

    @FXML
    private Button botonCompra;

    @FXML
    private ToggleButton botonPanel;

    @FXML
    private Label labelTotal;

    @FXML
    private ListView<Compra> listViewProductos;

    @FXML
    private ObservableList<Compra> listaProductos;

    @FXML
    private GridPane panelDerecha;

    @FXML
    private BorderPane panelGeneral;

    @FXML
    private RadioButton radioMensual;

    @FXML
    private RadioButton radioPuntual;

    @FXML
    private TextField textFieldCategoria;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldPrecio;

    @FXML
    private TextField textFieldRecurrencia;

    private ToggleGroup grupoRadio;

    private double suma = 0;

    private DropShadow sombra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
    }

    private void acciones(){
        botonCarrito.setOnAction(new ManejoAcciones());
        botonCompra.setOnAction(new ManejoAcciones());
        botonCarrito.setOnMouseEntered(new ManejoRaton());
        botonCompra.setOnMouseEntered(new ManejoRaton());
        botonPanel.setOnMouseEntered(new ManejoRaton());
        botonPanel.setOnMouseExited(new ManejoRaton());
        botonCompra.setOnMouseExited(new ManejoRaton());
        botonCarrito.setOnMouseExited(new ManejoRaton());

        botonPanel.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1){
                    panelGeneral.setRight(panelDerecha);
                }else {
                    panelGeneral.setRight(null);
                }
            }
        });

        radioPuntual.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                textFieldRecurrencia.setDisable(t1);
            }
        });




    }

    private void initGUI(){
        listViewProductos.setItems(listaProductos);
        if(botonPanel.isSelected()){
            panelGeneral.setRight(panelDerecha);
        }else {
            panelGeneral.setRight(null);
        }




    }

    private void instancias(){
        sombra = new DropShadow();
        grupoRadio = new ToggleGroup();
        grupoRadio.getToggles().addAll(radioMensual,radioPuntual);
        listaProductos = FXCollections.observableArrayList();
    }

    private void limpiarDatos(){
        textFieldCategoria.clear();
        textFieldNombre.clear();
        textFieldPrecio.clear();
        textFieldRecurrencia.clear();
        grupoRadio.selectToggle(null);
    }


    class ManejoAcciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonCompra){
                if(!textFieldCategoria.getText().isEmpty() && !textFieldNombre.getText().isEmpty()
               && !textFieldPrecio.getText().isEmpty() && grupoRadio.getSelectedToggle() != null){
                    if (grupoRadio.getSelectedToggle() == radioPuntual){
                        String producto = textFieldNombre.getText();
                        String categoria = textFieldCategoria.getText();
                        double precio = Double.parseDouble(textFieldPrecio.getText());

                        Compra compra = new Compra(producto,categoria,precio);
                        listaProductos.add(compra);
                        System.out.println("Producto agregado");
                        limpiarDatos();
                        suma = suma + precio;
                        labelTotal.setText(String.valueOf(suma));
                    } else if (grupoRadio.getSelectedToggle() == radioMensual) {
                        String producto = textFieldNombre.getText();
                        String categoria = textFieldCategoria.getText();
                        double precio = Double.parseDouble(textFieldPrecio.getText());
                        int mensualidad = Integer.parseInt(textFieldRecurrencia.getText());
                        precio = precio * mensualidad;

                        Compra compra = new Compra(producto,categoria,precio);
                        listaProductos.add(compra);
                        System.out.println("Producto agregado");
                        limpiarDatos();
                        suma = suma + precio;

                        labelTotal.setText(String.valueOf(suma));
                    } else {
                        System.out.println("Tienes que marcar uno de los radios");
                    }
                }
            } else if (actionEvent.getSource() == botonCarrito) {
                if (suma == 0){
                    System.out.println("No hay ningun articulo en el carrito");
                } else {
                    try {
                        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("salir-view.fxml"));
                        Parent root = loader.load();
                        Stage stage = new Stage();
                        stage.setTitle("Finalizar compra");
                        stage.setScene(new Scene(root));
                        stage.show();

                        // Cerrar la ventana actual
                        Stage currentStage = (Stage) botonCarrito.getScene().getWindow();
                        currentStage.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("❌ Error al abrir salir-view.fxml. Verifica la ruta del archivo.");
                    }
                }



            }
        }

    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            javafx.scene.control.ButtonBase boton = (javafx.scene.control.ButtonBase) mouseEvent.getSource();
           // Button boton = (Button) mouseEvent.getSource();

            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                boton.setEffect(sombra);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                boton.setEffect(null);
            }
        }
    }

}
