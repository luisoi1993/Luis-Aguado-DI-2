package org.example.pizzeria.dao;

import org.example.pizzeria.model.Pedido;

import java.sql.SQLException;
import java.util.List;

public interface PedidoDAO {
    void insertarPedido(Pedido pedido) throws SQLException;

    int obtenerIdPizza(String nombre , String tamano);

    List<Pedido> obtenerPedidos() ;

    String obtenerInfoPizza(int id_pizza);
}
