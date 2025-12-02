package org.example.examen2.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Modality;
import org.example.examen2.dao.DatoDAOImp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InicioController implements Initializable {

    @FXML
    private TextField textFieldCorreo;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button botonLogin;

    private DatoDAOImp datoDAO;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
    }

    private void instancias() {
        datoDAO = new DatoDAOImp();
    }

    private void initGUI() {

    }

    private void acciones() {
        botonLogin.setOnAction(new ManejoAcciones());
    }

    class ManejoAcciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            String correo = textFieldCorreo.getText().trim();
            String pass = passwordField.getText().trim();

            if (correo.isEmpty() || pass.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campos incompletos");
                alert.setHeaderText(null);
                alert.setContentText("Debes introducir correo y contraseña.");
                alert.show();
                return;
            }

            boolean existe = datoDAO.validarUsuario(correo, pass);
            if (!existe) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login fallido");
                alert.setHeaderText(null);
                alert.setContentText("Usuario o contraseña incorrectos.");
                alert.show();
                return;
            }


            datoDAO.insertarProductosSiNecesario();


            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/examen2/segunda-view.fxml"));
                Parent root = loader.load();
                Stage ventana = new Stage();
                ventana.setScene(new Scene(root));
                ventana.initModality(Modality.APPLICATION_MODAL);
                ventana.setTitle("Tienda - Productos");

                Stage current = (Stage) botonLogin.getScene().getWindow();
                ventana.show();
                current.close();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No se pudo abrir la ventana");
                alert.setContentText(e.getMessage());
                alert.show();
            }
        }
    }
}
