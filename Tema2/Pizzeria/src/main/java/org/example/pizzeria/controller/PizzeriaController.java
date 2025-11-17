package org.example.pizzeria.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.pizzeria.HelloApplication;
import org.example.pizzeria.dao.PedidoDAOImp;
import org.example.pizzeria.model.Pedido;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PizzeriaController implements Initializable {
    @FXML
    private Button buttonDetalle;

    @FXML
    private Button buttonPedido;

    @FXML
    private Button buttonPendientes;

    @FXML
    private Button buttonServir;

    @FXML
    private ComboBox<String> comboBoxPizzas;

    @FXML
    private RadioButton radioButtonFamiliar;

    @FXML
    private RadioButton radioButtonMediana;

    @FXML
    private RadioButton radioButtonPequenia;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldTelefono;

    private ObservableList<Pedido> listaPedidos;

    private ObservableList<String> listaPizzas;

    @FXML
    private ListView<Pedido> listViewPedidos;

    private ToggleGroup grupoTipo;

    private PedidoDAOImp pedidoDAOImp;
    private int contador = 1;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
    }

    private void acciones(){
        buttonPedido.setOnAction(new ManejoAcciones());
        buttonServir.setOnAction(new ManejoAcciones());
        buttonPendientes.setOnAction(new ManejoAcciones());
        buttonDetalle.setOnAction(new ManejoAcciones());
    }

    private void instancias(){
        listaPedidos = FXCollections.observableArrayList();
        grupoTipo = new ToggleGroup();
        grupoTipo.getToggles().addAll(radioButtonFamiliar, radioButtonMediana, radioButtonPequenia);
        listaPizzas = FXCollections.observableArrayList();
        radioButtonFamiliar.setUserData("Familiar");
        radioButtonMediana.setUserData("Mediana");
        radioButtonPequenia.setUserData("Pequena");
        listaPizzas.addAll("Barbacoa","Hawaiana","Jamon y queso","Cuatro quesos");
        pedidoDAOImp = new PedidoDAOImp();
        listaPedidos.addAll(pedidoDAOImp.obtenerPedidos());

    }

    private void initGUI() {
        comboBoxPizzas.setItems(listaPizzas);
        listViewPedidos.setItems(listaPedidos);
        listViewPedidos.getSelectionModel().selectedItemProperty().addListener((obs, oldV, newV) -> {
            if (newV != null) {
                mostrarDetallePedido(newV);
            }
        });
    }

    private void mostrarDetallePedido(Pedido pedido) {

        String infoPizza = pedidoDAOImp.obtenerInfoPizza(pedido.getId_pizza());

        String info = "=== DETALLE DEL PEDIDO ===\n" +
                "ID: " + pedido.getId_pedido() + "\n" +
                "Cliente: " + pedido.getNombreCliente() + "\n" +
                "Teléfono: " + pedido.getTelefono() + "\n" +
                "Entregado: " + (pedido.isEntregado() ? "Sí" : "No") + "\n\n" +
                "=== PIZZA ===\n" +
                infoPizza;


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Detalle del pedido");
        alert.setHeaderText("Información del pedido");
        alert.setContentText(info);
        alert.showAndWait();
    }

    private void limpiarDatos(){
        textFieldNombre.clear();
        textFieldTelefono.clear();
        comboBoxPizzas.getSelectionModel().clearSelection();
        grupoTipo.selectToggle(null);
    }

    private void mostrarPendientes() {
        listaPedidos.setAll(pedidoDAOImp.obtenerPedidosPendientes());
        listViewPedidos.setItems(listaPedidos);
    }

    private void mostrarTodos() {
        listaPedidos.setAll(pedidoDAOImp.obtenerPedidos());
        listViewPedidos.setItems(listaPedidos);
    }

    class ManejoAcciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource() == buttonPedido){
                if (!textFieldNombre.getText().isEmpty() && !textFieldTelefono.getText().isEmpty()
                && grupoTipo.getSelectedToggle() != null && comboBoxPizzas.getValue() != null){

                    String nombre = textFieldNombre.getText();
                    int telefono = Integer.parseInt(textFieldTelefono.getText());
                    String pizzas = comboBoxPizzas.getValue();
                    String tipo = grupoTipo.getSelectedToggle().getUserData().toString();
                    int pizza_id = pedidoDAOImp.obtenerIdPizza(pizzas,tipo);

                    Pedido pedido = new Pedido(nombre,telefono,pizza_id,false);
                    boolean fallo = false;
                    try{
                        pedidoDAOImp.insertarPedido(pedido);
                        listaPedidos.add(pedido);
                    }catch (SQLException e){
                        System.out.println(e.getMessage());
                        fallo = true;
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Error al insertar el pedido");
                        alert.setContentText(e.getMessage());
                        alert.show();
                    }
                    if(!fallo){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Insercion correcta");
                        alert.setContentText("Pedido insertado correctamente");
                        alert.show();
                        limpiarDatos();
                    }

                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error al insertar el pedido");
                    alert.setContentText("Debe completar todos los campos");
                    alert.show();
                }
            } else if (actionEvent.getSource()==buttonServir) {

                Pedido seleccionado = listViewPedidos.getSelectionModel().getSelectedItem();

                if (seleccionado == null) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sin selección");
                    alert.setHeaderText("No hay pedido seleccionado");
                    alert.setContentText("Selecciona un pedido para marcarlo como servido.");
                    alert.show();
                    return;
                }


                pedidoDAOImp.marcarComoServido(seleccionado.getId_pedido());


                seleccionado.setEntregado(true);

                // Refrescar la lista visualmente
                listViewPedidos.refresh();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pedido servido");
                alert.setHeaderText(null);
                alert.setContentText("El pedido ha sido marcado como entregado.");
                alert.show();
            } else if (actionEvent.getSource() == buttonPendientes) {

                if (contador ==1){
                    mostrarPendientes();
                    System.out.println("Boton pendientes pulsado");
                    contador++;
                } else if (contador == 2) {
                    mostrarTodos();
                    contador = 1;
                }

            } else if (actionEvent.getSource() == buttonDetalle) {
                int posicionSeleccionada = listViewPedidos.getSelectionModel().getSelectedIndex();
                if (posicionSeleccionada != -1) {
                    Pedido pedido = listViewPedidos.getSelectionModel().getSelectedItem();
                    Stage ventanaDetalle = new Stage();
                    FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("detalle-view.fxml"));
                    Parent root = null;
                    try {
                        root = loader.load();
                        DialogoController dialogoController = loader.getController();
                        dialogoController.setPedido(pedido);
                        dialogoController.setPizzeriaController(PizzeriaController.this);
                        Scene scene = new Scene(root);
                        ventanaDetalle.setScene(scene);
                        ventanaDetalle.initModality(Modality.APPLICATION_MODAL);
                        ventanaDetalle.setTitle("Ventana detalle");
                        ventanaDetalle.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
