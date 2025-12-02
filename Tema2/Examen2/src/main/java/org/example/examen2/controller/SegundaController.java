package org.example.examen2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import org.example.examen2.dao.DatoDAOImp;
import org.example.examen2.model.Dato;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SegundaController implements Initializable {

    @FXML
    private ListView<Dato> listViewProductos;

    @FXML
    private ComboBox<String> comboCategorias;

    @FXML
    private Button botonFiltrar;

    @FXML
    private Button botonVerDetalle;

    private ObservableList<Dato> listaProductos;

    private DatoDAOImp datoDAO;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        initGUI();
        acciones();
    }

    private void instancias() {
        datoDAO = new DatoDAOImp();
        listaProductos = FXCollections.observableArrayList();
    }

    private void initGUI() {

        comboCategorias.getItems().addAll("tecnología", "ropa", "muebles", "todo");
        comboCategorias.getSelectionModel().select("todo");


        List<Dato> todos = datoDAO.obtenerProductos();
        listaProductos.setAll(todos);
        listViewProductos.setItems(listaProductos);


        listViewProductos.setCellFactory(lv -> new ListCell<>() {
            @Override
            protected void updateItem(Dato item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getNombre() + " - " + item.getPrecio() + " euros -" + item.getCategoria() + " - " + item.getDescripcion());
                }
            }
        });
    }

    private void acciones() {
        botonFiltrar.setOnAction(e -> {
            String categoria = comboCategorias.getValue();
            if (categoria == null || categoria.equalsIgnoreCase("todo")) {
                listaProductos.setAll(datoDAO.obtenerProductos());
            } else {
                listaProductos.setAll(datoDAO.obtenerProductosPorCategoria(categoria));
            }
        });

        botonVerDetalle.setOnAction(e -> {
            Dato seleccionado = listViewProductos.getSelectionModel().getSelectedItem();
            if (seleccionado == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Sin selección");
                alert.setHeaderText(null);
                alert.setContentText("Selecciona un producto para ver el detalle.");
                alert.show();
                return;
            }


            String info = "Nombre: " + seleccionado.getNombre() +
                    "\nPrecio: " + seleccionado.getPrecio() + " €" +
                    "\nCategoría: " + seleccionado.getCategoria() +
                    "\nDescripción: " + (seleccionado.getDescripcion() == null ? "" : seleccionado.getDescripcion());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Detalle del producto");
            alert.setHeaderText("Información del producto (ID: " + seleccionado.getId() + ")");
            alert.setContentText(info);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        });
    }
}
