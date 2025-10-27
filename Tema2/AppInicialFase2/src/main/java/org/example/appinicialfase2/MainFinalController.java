package org.example.appinicialfase2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainFinalController implements Initializable {
    @FXML
    private Button botonLimpiar;

    @FXML
    private Button botonPulsar;

    @FXML
    private Button botonVaciar;

    @FXML
    private Label labelTop;

    private DropShadow sombra;

    @FXML
    private TextField textFieldNombre;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias(){
        sombra = new DropShadow();
    }

    private void acciones(){
        botonVaciar.setOnAction(new ManejoAccion());
        botonPulsar.setOnAction(new ManejoAccion());
        botonLimpiar.addEventHandler(ActionEvent.ACTION,new ManejoAccion());
        botonPulsar.setOnMouseEntered(new ManejoRaton());
        botonVaciar.setOnMouseEntered(new ManejoRaton());
        botonPulsar.setOnMouseExited(new ManejoRaton());
        botonVaciar.setOnMouseExited(new ManejoRaton());
        botonPulsar.setOnMousePressed(new ManejoRaton());
        botonPulsar.setOnMouseReleased(new ManejoRaton());
    }

    class ManejoAccion implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Pulsando el botón");

            if(actionEvent.getSource() == botonPulsar){
                String nombre = textFieldNombre.getText();
                if (nombre.isBlank()){
                    System.out.println("Por favor rellena el nombre: ");
                } else {
                    labelTop.setText(String.format("Enhorabuena %s has completado la primera tarea",nombre));
                }
            } else if (actionEvent.getSource() == botonVaciar) {
                textFieldNombre.setText("");
                labelTop.setText("");
            } else if (actionEvent.getSource() == botonLimpiar) {
                textFieldNombre.clear();
            }

        }
    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            Button boton = (Button) mouseEvent.getSource();
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                boton.setEffect(sombra);
                if(boton == botonPulsar){
                    boton.setCursor(Cursor.OPEN_HAND);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                boton.setEffect(null);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                if(boton == botonPulsar){
                    botonPulsar.setCursor(Cursor.CLOSED_HAND);
                }

            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                boton.setCursor(Cursor.OPEN_HAND);
                System.out.println("Clik soltado");

            }
        }
    }
}
