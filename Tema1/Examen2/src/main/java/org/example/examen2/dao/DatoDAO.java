package org.example.examen2.dao;

import java.sql.SQLException;
import java.util.List;

public interface DatoDAO {
    void insertarPedido(Pedido pedido) throws SQLException;

    int obtenerIdPizza(String nombre , String tamano);

    List<Pedido> obtenerPedidos() ;

    String obtenerInfoPizza(int id_pizza);
}
