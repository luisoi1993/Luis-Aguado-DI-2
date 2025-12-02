package org.example.examen2.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection(){


        if(connection == null){
            // inicializo la conexion
            createConection();
        }
        return connection;
    }

    private static void createConection(){
        String user = "root";
        String pass = "";
        try {
            // connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javafx1",user,pass);
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s",SchemeDB.URL,SchemeDB.PORT,SchemeDB.DB_NAME),user,pass);
        } catch (SQLException e) {
            System.out.println("Error en la conexión de la base de datos");
        }

    }
}