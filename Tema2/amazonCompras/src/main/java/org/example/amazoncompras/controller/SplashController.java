package org.example.amazoncompras.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.amazoncompras.HelloApplication;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashController implements Initializable {

    @FXML
    private ImageView logoAmazon;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iniciarAnimacion();
    }

    private void iniciarAnimacion() {
        FadeTransition fade = new FadeTransition(Duration.seconds(3),logoAmazon);
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.setCycleCount(1);
        fade.play();

        fade.setOnFinished(event ->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            abrirVentanaPrincipal();
        });

    }

    private void abrirVentanaPrincipal() {
        try{
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("inicio-view.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Amazon Compras");
            stage.show();

            //Cierra la ventana
            Stage splahStage = (Stage) logoAmazon.getScene().getWindow();
            splahStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
