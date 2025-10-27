package org.example.appinicial;

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

public class MainController implements Initializable {
    @FXML
    private Label labelSaludo;
    @FXML
    private Button botonPulsar , botonVaciar, buttonLimpiar;
    @FXML
    private TextField textfieldNombre;

    private DropShadow sombra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Ejecutado directamente en la asociacion de la stage
        instancias();
        initGUI();
        acciones();



    }
    private void instancias(){
        sombra = new DropShadow();
    }

    private void initGUI(){
        //personalizara las partes de la interfaz grafica
       // botonPulsar.setEffect(sombra);
    }

    private void acciones(){
        /*
        botonPulsar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Al pulsar el boton se capture el texto que esta en el textfield y se ponga en el label
                //el mensaje "Enorabuena borja, has completado el primer ejercicio"
               String nombre = textfieldNombre.getText();
               if(nombre.isBlank()){
                   System.out.println("Por favor rellena el nombre");
               }else{
                   labelSaludo.setText(String.format("Enorabuena %s has completado el primer ejercicio",nombre));
               }

            }
        });

        botonVaciar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                labelSaludo.setText("");
                textfieldNombre.clear();
            }
        });
        */
         botonVaciar.setOnAction(new ManejoAccion());
         botonPulsar.setOnAction(new ManejoAccion());
         /*
         botonPulsar.setOnMouseEntered(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent mouseEvent) {
                 botonPulsar.setEffect(sombra);
             }
         });

         botonPulsar.setOnMouseExited(new EventHandler<MouseEvent>() {
             @Override
             public void handle(MouseEvent mouseEvent) {
                 botonPulsar.setEffect(null);
             }
         });

          */
        botonPulsar.setOnMouseExited(new ManejoRaton());
        botonPulsar.setOnMouseEntered(new ManejoRaton());
        botonVaciar.setOnMouseExited(new ManejoRaton());
        botonVaciar.setOnMouseEntered(new ManejoRaton());
        botonPulsar.setOnMousePressed(new ManejoRaton());
        botonPulsar.setOnMouseReleased(new ManejoRaton());
        buttonLimpiar.addEventHandler(ActionEvent.ACTION,new ManejoAccion());

        /*
        botonPulsar.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                botonPulsar.setCursor(Cursor.OPEN_HAND);
            }
        });
            */
        /*
        botonPulsar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                botonPulsar.setCursor(Cursor.CLOSED_HAND);
            }
        });
        */

    }

    class ManejoAccion implements  EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            System.out.println("Pulsado boton");
            // que boton se ha pulsado
            if(actionEvent.getSource()==botonPulsar){
                String nombre = textfieldNombre.getText();
                if(nombre.isBlank()){
                    System.out.println("Por favor rellena el nombre");
                }else{
                    labelSaludo.setText(String.format("Enorabuena %s has completado el primer ejercicio",nombre));
                }
            } else if (actionEvent.getSource()==botonVaciar) {
                labelSaludo.setText("");
                textfieldNombre.clear();
            } else if (actionEvent.getSource()==buttonLimpiar) {
                textfieldNombre.clear();
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            Button boton = (Button) mouseEvent.getSource();
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                boton.setEffect(sombra);
                if(boton== botonPulsar){
                    boton.setCursor(Cursor.OPEN_HAND);
                }


            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                boton.setEffect(null);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                botonPulsar.setCursor(Cursor.CLOSED_HAND);

            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED){
                botonPulsar.setCursor(Cursor.OPEN_HAND);
                System.out.println("Soltado");
            }
        }
    }
}
