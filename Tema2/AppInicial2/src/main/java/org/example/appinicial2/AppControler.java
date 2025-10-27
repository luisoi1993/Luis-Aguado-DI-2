package org.example.appinicial2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AppControler implements Initializable {
    @FXML
    private Button botonPulsar , botonVaciar;

    @FXML
    private Label labelSaludo;

    @FXML
    private TextField texfieldNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        acciones();
    }

    private void acciones(){

        /*
        botonPulsar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String nombre = texfieldNombre.getText();
                if (nombre.isBlank()){
                    System.out.println("Por favor rellena el nombre");
                }else {
                    labelSaludo.setText(String.format("Enorabuena %s has completado el primer ejercicio",nombre));
                }
            }
        });

        botonVaciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labelSaludo.setText("");
                texfieldNombre.clear();
            }
        });

         */

        botonVaciar.setOnAction(new ManejoAccion());
        botonPulsar.setOnAction(new ManejoAccion());
    }

    class ManejoAccion implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Pulsado boton");

            if(actionEvent.getSource()== botonPulsar){
                String nombre = texfieldNombre.getText();
                if(nombre.isBlank()){
                    System.out.println("Por favor rellena el nombre");
                }else {
                    labelSaludo.setText(String.format("Enorabuena %s has completado la primera actividad",nombre));
                }
            }else if(actionEvent.getSource()== botonVaciar){
                labelSaludo.setText("");
                texfieldNombre.clear();
            }
        }
    }


}
