package org.example.appinicio3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class App3Controller implements Initializable {
    @FXML
    private Button botonBorrar;

    @FXML
    private Button botonEnviar;

    @FXML
    private Label laberArriba;

    @FXML
    private TextField textfieldNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones(){
        botonBorrar.setOnAction(new ManejoAcciones());
        botonEnviar.setOnAction(new ManejoAcciones());
    }

    class ManejoAcciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Pulsado boton");

            if(actionEvent.getSource() == botonEnviar){
                String nombre = textfieldNombre.getText();

                if(nombre.isBlank()){
                    System.out.println("Por favor rellene el nombre");
                }else {
                    laberArriba.setText(String.format("Enorabuena %s has completado la primera tarea",nombre));
                }
            } else if (actionEvent.getSource() == botonBorrar) {
                laberArriba.setText("");
                textfieldNombre.clear();
            }
        }
    }
}
