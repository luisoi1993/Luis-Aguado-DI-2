package org.example.appinicial4;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class App4Controller implements Initializable {

    @FXML
    private Label LabelNombre;

    @FXML
    private TextField TextFieldNombre;

    @FXML
    private Button botonBorrar;

    @FXML
    private Button botonEnviar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void acciones(){

    }

    class ManejoAccion implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Pulsado un boton");

            if(actionEvent.getSource()== botonEnviar){
                String nombre = TextFieldNombre.getText();
                if (nombre.isBlank()){
                    System.out.println("Digite un nombre");
                } else {
                    LabelNombre.setText(String.format("Enorabuena %s has completado el primer ejercicio",nombre));
                }
            } else if (actionEvent.getSource() == botonBorrar) {
                TextFieldNombre.clear();
                LabelNombre.setText("");
            }
        }
    }
}
