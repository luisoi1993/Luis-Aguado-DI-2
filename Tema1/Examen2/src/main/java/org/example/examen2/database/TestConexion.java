package org.example.examen2.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/examen";
        String user = "root";
        String pass = ""; // cambia si tienes contraseña

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Conectado correctamente: " + con);
            con.close();
        } catch (Exception e) {
            System.out.println("❌ Error en la conexión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}