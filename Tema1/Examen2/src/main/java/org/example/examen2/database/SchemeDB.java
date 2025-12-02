package org.example.examen2.database;

public interface SchemeDB {
    String URL = "127.0.0.1";
    String PORT = "3306";
    String DB_NAME = "examen";
    String USER = "root";
    String PASSWORD = "";

    String COL_ID_PEDIDO = "id";
    String TABLE_PEDIDO = "pedido";
    String COL_NOMBRE_PEDIDO = "nombre_cliente";
    String COL_TELEFONO_PEDIDO = "telefono";
    String COL_IDPIZZA_PEDIDO = "id_pizza";
    String COL_ESTADO_PEDIDO = "entregado";
}
