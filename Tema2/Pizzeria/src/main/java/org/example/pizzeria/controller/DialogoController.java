package org.example.pizzeria.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.example.pizzeria.model.Pedido;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogoController implements Initializable {

    @FXML
    private Label textoEdad;

    @FXML
    private Label textoGenero;

    @FXML
    private Label textoLocalizacion;

    @FXML
    private Label textoMail;

    @FXML
    private Label textoNombre;

    private PizzeriaController pizzeriaController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setPizzeriaController(PizzeriaController controller){
        this.pizzeriaController = controller;
    }

    public void setPedido(Pedido pedido){
        textoNombre.setText(pedido.getNombreCliente());
        textoMail.setText(String.valueOf(pedido.getTelefono()));
        textoGenero.setText(String.valueOf(pedido.getId_pizza()));
        textoEdad.setText(pedido.isEntregado() ? "Sí" : "No");
        textoLocalizacion.setText(String.valueOf(pedido.getId_pedido()));
    }
}
