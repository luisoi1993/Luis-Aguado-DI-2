package org.example.formularioapp.dao;

import org.example.formularioapp.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {

    void insertarUsuario(Usuario usuario) throws SQLException;
    List<Usuario> obtenerUsuario();
    int borrarUsuario(String nombre);
  //  int borrarUsuario(String correo,String nombre);

    //firma de todos los metodos que necsito contra base de datos
}
