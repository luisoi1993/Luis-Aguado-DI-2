package org.example.bienvenidopro;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class ProController implements Initializable {
    @FXML
    private Button botonLimpiar;

    @FXML
    private Button botonSaludar ,botonContador;

    @FXML
    private Button botonVaciar;

    @FXML
    private ChoiceBox<String> choiceSaludo;

    @FXML
    private Label labelTitle;

    @FXML
    private Slider sliderTamano;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField textFieldNombre;

    private int contador = 0;

    private DropShadow sombra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();

    }

    private void instancias(){
        sombra = new DropShadow();
        choiceSaludo.getItems().addAll("Formal", "Informal", "Divertido");
        choiceSaludo.setValue("Formal");
        sliderTamano.valueProperty().addListener((observable, oldValue, newValue) -> {
            labelTitle.setFont(Font.font(newValue.doubleValue())); // Cambia el tamaño de letra
        });
        labelTitle.sceneProperty().addListener((obs,oldScene, newScene) -> {
            if (newScene != null){
                newScene.addEventHandler(KeyEvent.KEY_PRESSED,new ManejoAtajos());
            }
        });
    }

    private void acciones(){
        botonSaludar.setOnAction(new ManejoAcciones());
        botonVaciar.setOnAction(new ManejoAcciones());
        botonContador.setOnAction(new ManejoAcciones());
        botonLimpiar.setOnAction(new ManejoAcciones());
        botonSaludar.setOnMouseEntered(new ManejoRaton());
        botonVaciar.setOnMouseEntered(new ManejoRaton());
        botonSaludar.setOnMouseExited(new ManejoRaton());
        botonVaciar.setOnMouseExited(new ManejoRaton());
        botonSaludar.setOnMousePressed(new ManejoRaton());
        botonVaciar.setOnMousePressed(new ManejoRaton());
        botonSaludar.setOnMouseReleased(new ManejoRaton());
        botonVaciar.setOnMouseReleased(new ManejoRaton());
    }

    class ManejoAcciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            var nombre = textFieldNombre.getText();

            if(actionEvent.getSource() == botonSaludar){
                if (nombre.isBlank()){
                    System.out.println("El nombre esta vacío");
                    statusLabel.setText("Rellena el nombre");
                    textFieldNombre.setStyle("-fx-border-color: red; -fx-border-width: 2px");
                }else {
                    textFieldNombre.setStyle("");
                    String saludo = choiceSaludo.getValue();

                    switch (saludo) {
                        case "Formal" :
                            labelTitle.setText(String.format("Estimado/a %s, enhorabuena.",nombre));
                            break;

                        case "Informal" :
                            labelTitle.setText(String.format("¡Hola %s! ¡Buen trabajo!", nombre));
                            break;

                        case "Divertido" :
                            labelTitle.setText(String.format("¡Woohoo %s! Lo has petado.",nombre));
                    }
                }
            } else if (actionEvent.getSource() == botonVaciar) {
                textFieldNombre.clear();
                labelTitle.setText("");
                statusLabel.setText("");
                contador = 0;
            } else if (actionEvent.getSource() == botonContador){
                contador++;
                String contadorString = "" + contador;
                statusLabel.setText("Saludos: " + contador);
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
                if (boton == botonSaludar || boton == botonVaciar){
                    boton.setEffect(sombra);
                    boton.setCursor(Cursor.OPEN_HAND);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                boton.setEffect(null);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                boton.setCursor(Cursor.CLOSED_HAND);
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                boton.setCursor(Cursor.OPEN_HAND);
            }
        }
    }

    class ManejoAtajos implements EventHandler<KeyEvent>{

        @Override
        public void handle(KeyEvent keyEvent) {
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.ENTER){
                botonSaludar.fire();
            } else if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.L) {
                botonLimpiar.fire();
            } else if(keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.DIGIT0){
                contador = 0;
                statusLabel.setText("Contador reiniciado");
            }
        }
    }
}
