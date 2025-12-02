package org.example.examen2.dao;

import org.example.examen2.database.DBConnection;
import org.example.examen2.database.SchemeDB;
import org.example.examen2.model.Dato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatoDAOImp {

    private Connection connection;

    public DatoDAOImp() {
        connection = DBConnection.getConnection();
    }


    public boolean validarUsuario(String correo, String pass) {
        String sql = "SELECT COUNT(*) FROM Usuarios WHERE correo = ? AND pass = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, correo);
            ps.setString(2, pass);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void insertarProductosSiNecesario() {
        String contadorSql = "SELECT COUNT(*) FROM Productos";
        try (PreparedStatement ps = connection.prepareStatement(contadorSql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return;
                }
            }
        } catch (SQLException e) {

            e.printStackTrace();
            return;
        }


        String insertSql = "INSERT INTO Productos (nombre, categoria, precio, descripcion) VALUES (?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(insertSql)) {

            ps.setString(1, "Laptop Lenovo");
            ps.setString(2, "tecnología");
            ps.setDouble(3, 799.99);
            ps.setString(4, "Portátil de alto rendimiento, 16GB RAM");
            ps.executeUpdate();

            ps.setString(1, "Smartphone Samsung");
            ps.setString(2, "tecnología");
            ps.setDouble(3, 599.50);
            ps.setString(4, "Teléfono móvil con pantalla Super AMOLED");
            ps.executeUpdate();

            ps.setString(1, "Smartwatch Xiaomi");
            ps.setString(2, "tecnología");
            ps.setDouble(3, 89.90);
            ps.setString(4, "Reloj inteligente con monitoreo de salud");
            ps.executeUpdate();

            ps.setString(1, "Televisor LG 4K");
            ps.setString(2, "tecnología");
            ps.setDouble(3, 1100.00);
            ps.setString(4, "Smart TV 55 pulgadas, 4K Ultra HD");
            ps.executeUpdate();

            ps.setString(1, "Auriculares Sony");
            ps.setString(2, "tecnología");
            ps.setDouble(3, 129.99);
            ps.setString(4, "Auriculares inalámbricos con cancelación de ruido");
            ps.executeUpdate();


            ps.setString(1, "Camisa azul");
            ps.setString(2, "ropa");
            ps.setDouble(3, 34.99);
            ps.setString(4, "Jeans unisex de corte recto");
            ps.executeUpdate();

            ps.setString(1, "Chaqueta de cuero");
            ps.setString(2, "ropa");
            ps.setDouble(3, 99.99);
            ps.setString(4, "Chaqueta negra, estilo moderno");
            ps.executeUpdate();

            ps.setString(1, "Sudadera deportiva");
            ps.setString(2, "ropa");
            ps.setDouble(3, 42.00);
            ps.setString(4, "Sudadera con capucha, algodón");
            ps.executeUpdate();


            ps.setString(1, "Sillón reclinable");
            ps.setString(2, "muebles");
            ps.setDouble(3, 249.99);
            ps.setString(4, "Sillón tapizado, mecanismo reclinable");
            ps.executeUpdate();

            ps.setString(1, "Mesa de comedor");
            ps.setString(2, "muebles");
            ps.setDouble(3, 150.00);
            ps.setString(4, "Mesa rectangular para 6 personas");
            ps.executeUpdate();

            ps.setString(1, "Estante para libros");
            ps.setString(2, "muebles");
            ps.setDouble(3, 75.50);
            ps.setString(4, "Estante de madera, 5 niveles");
            ps.executeUpdate();


            ps.setString(1, "Cama doble");
            ps.setString(2, "muebles");
            ps.setDouble(3, 320.00);
            ps.setString(4, "Cama de matrimonio, colchón incluido");
            ps.executeUpdate();

            ps.setString(1, "Silla ergonómica");
            ps.setString(2, "muebles");
            ps.setDouble(3, 115.00);
            ps.setString(4, "Silla de oficina, respaldo ajustable");
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Dato> obtenerProductos() {
        List<Dato> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, categoria, precio, descripcion FROM Productos";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Dato p = new Dato();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setCategoria(rs.getString("categoria"));
                p.setPrecio(rs.getDouble("precio"));
                p.setDescripcion(rs.getString("descripcion"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }


    public List<Dato> obtenerProductosPorCategoria(String categoria) {
        List<Dato> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, categoria, precio, descripcion FROM Productos WHERE categoria = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, categoria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Dato p = new Dato();
                    p.setId(rs.getInt("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setCategoria(rs.getString("categoria"));
                    p.setPrecio(rs.getDouble("precio"));
                    p.setDescripcion(rs.getString("descripcion"));
                    lista.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }



}
