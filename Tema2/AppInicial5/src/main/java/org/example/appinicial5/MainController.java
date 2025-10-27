package org.example.appinicial5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button BotonPulsar;

    @FXML
    private Button BotonVaciar;

    @FXML
    private Label labelBienvenida;

    @FXML
    private TextField textFieldNombre;

    private DropShadow sombra;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void instancias(){
        sombra = new DropShadow();
    }

    private void acciones() {
        BotonPulsar.setOnAction(new ManejoAcciones());
        BotonVaciar.setOnAction(new ManejoAcciones());
        BotonPulsar.setOnMouseEntered(new ManejoRaton());
    }

    class ManejoAcciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == BotonPulsar){
                String nombre = textFieldNombre.getText();
                System.out.println("Pulsando boton");
                if (nombre.isBlank()){
                    System.out.println("Por favor rellena el nombre");
                }else {
                    labelBienvenida.setText(String.format("Enorabuena %s has completado tu primera tarea",nombre));
                }
            } else if (actionEvent.getSource()==BotonVaciar) {
                labelBienvenida.setText("");
                textFieldNombre.clear();
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            Button boton = (Button) mouseEvent.getSource();
            if(mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                boton.setEffect(sombra);
            }
        }
    }
}
