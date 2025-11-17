package org.example.formularioapp.dao;

import org.example.formularioapp.database.DBConnection;
import org.example.formularioapp.database.SchemeDB;
import org.example.formularioapp.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImp implements UsuarioDAO{
    private Connection connection;

    private PreparedStatement preparedStatement;
    //INSERT
    //UPDATE
    //DELETE
    //SELECT
    // STATEMENT O PREPARESTATEMENT
        // execute -> bool -> INSERT
        //executeUpdate -> int -> UPDATE DELETE
    //PS O ST -> executeQuery
    //RESULTSET -> SELECT
    public  UsuarioDAOImp(){
        connection = DBConnection.getConnection();
    }
    @Override
    public void insertarUsuario(Usuario usuario) throws SQLException {

        String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s) VALUES (?,?,?,?,?)",
                SchemeDB.TAB_NAME,
                SchemeDB.COL_NAME, SchemeDB.COL_MAIL,SchemeDB.COL_LOCATE,SchemeDB.COL_GENERO,SchemeDB.COL_EDAD);


            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,usuario.getNombre());
            preparedStatement.setString(2,usuario.getCorreo());
            preparedStatement.setString(3,usuario.getLocalizacion());
            preparedStatement.setString(4,usuario.getGenero());
            preparedStatement.setInt(5,usuario.getEdad());
            preparedStatement.execute();





    }

    @Override
    public List<Usuario> obtenerUsuario() {
        List<Usuario> lista = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM " + SchemeDB.TAB_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            //[            x]
            //[r,r,r,r,r]
            while (resultSet.next()){
                //añadir los usuarios a al lista
                String nombre =resultSet.getString(SchemeDB.COL_NAME);
                String mail=resultSet.getString(SchemeDB.COL_MAIL);
                String localizacion =resultSet.getString(SchemeDB.COL_LOCATE);
                String genero =resultSet.getString(SchemeDB.COL_GENERO);
                int edad =resultSet.getInt(SchemeDB.COL_EDAD);

                Usuario usuario = new Usuario(nombre,mail,localizacion,genero,edad,true);
                lista.add(usuario);
            }
        }catch (SQLException e){
            System.out.println("Errror en la query");
            System.out.println(e.getMessage());
        }

        return lista;
    }

    @Override
    public int borrarUsuario(String correo) {
        int filasAfectadas = 0;
        try {
            String query = "DELETE FROM " + SchemeDB.TAB_NAME + " WHERE " + SchemeDB.COL_MAIL + " = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, correo.trim()); // eliminamos espacios extra
            filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Intentando borrar usuario con correo: " + correo + ". Filas afectadas: " + filasAfectadas);
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
            e.printStackTrace();
        }
        return filasAfectadas;
    }



}
