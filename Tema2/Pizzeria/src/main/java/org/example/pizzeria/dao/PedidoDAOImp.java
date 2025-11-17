package org.example.pizzeria.dao;

import org.example.pizzeria.database.DBConnection;
import org.example.pizzeria.database.SchemeDB;
import org.example.pizzeria.model.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImp implements PedidoDAO{

    private Connection connection;

    private PreparedStatement preparedStatement;

    public PedidoDAOImp(){
        connection = DBConnection.getConnection();
    }
    @Override
    public void insertarPedido(Pedido pedido) throws SQLException {

        String query = String.format("INSERT INTO %S (%s, %s, %s, %s) VALUES (?,?,?,?)",
                SchemeDB.TABLE_PEDIDO,
                SchemeDB.COL_NOMBRE_PEDIDO,SchemeDB.COL_TELEFONO_PEDIDO,SchemeDB.COL_IDPIZZA_PEDIDO,SchemeDB.COL_ESTADO_PEDIDO);

                preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, pedido.getNombreCliente());
                preparedStatement.setInt(2,pedido.getTelefono());
                preparedStatement.setInt(3,pedido.getId_pizza());
                preparedStatement.setBoolean(4,pedido.isEntregado());
                preparedStatement.execute();

        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            pedido.setId_pedido(rs.getInt(1));
        }

    }

    @Override
    public int obtenerIdPizza(String nombre, String tamano) {
        int id = -1;
        String sql = "SELECT id_pizza FROM pizza WHERE nombre = ? AND tamano = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, tamano);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_pizza");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public List<Pedido> obtenerPedidos() {
        List<Pedido> lista = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM " + SchemeDB.TABLE_PEDIDO);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id_pedido = resultSet.getInt(SchemeDB.COL_ID_PEDIDO);
                String nombre =resultSet.getString(SchemeDB.COL_NOMBRE_PEDIDO);
                int telefono =resultSet.getInt(SchemeDB.COL_TELEFONO_PEDIDO);
                int id_pizza =resultSet.getInt(SchemeDB.COL_IDPIZZA_PEDIDO);
                boolean entregado =resultSet.getBoolean(SchemeDB.COL_ESTADO_PEDIDO);

                Pedido pedido = new Pedido(id_pedido,nombre,telefono,id_pizza,entregado);
                lista.add(pedido);
            }
        }catch (SQLException e){
            System.out.println("Errror en la query");
            System.out.println(e.getMessage());
        }

        return lista;
    }

    @Override
    public String obtenerInfoPizza(int id) {
        String texto = "Pizza no encontrada";

        String sql = "SELECT nombre, tamano, precio FROM pizza WHERE id_pizza = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                texto = "Nombre: " + rs.getString("nombre") +
                        "\nTamaño: " + rs.getString("tamano") +
                        "\nPrecio: " + rs.getDouble("precio") + " €";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return texto;
    }

    public void marcarComoServido(int idPedido) {
        String sql = "UPDATE pedido SET entregado = TRUE WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pedido> obtenerPedidosPendientes() {
        List<Pedido> lista = new ArrayList<>();

        String sql = "SELECT * FROM " + SchemeDB.TABLE_PEDIDO + " WHERE " + SchemeDB.COL_ESTADO_PEDIDO + " = FALSE";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id_pedido = rs.getInt(SchemeDB.COL_ID_PEDIDO);
                String nombre = rs.getString(SchemeDB.COL_NOMBRE_PEDIDO);
                int telefono = rs.getInt(SchemeDB.COL_TELEFONO_PEDIDO);
                int id_pizza = rs.getInt(SchemeDB.COL_IDPIZZA_PEDIDO);
                boolean entregado = rs.getBoolean(SchemeDB.COL_ESTADO_PEDIDO);

                lista.add(new Pedido(id_pedido, nombre, telefono, id_pizza, entregado));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
