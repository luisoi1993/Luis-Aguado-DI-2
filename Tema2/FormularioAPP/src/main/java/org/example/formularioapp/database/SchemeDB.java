package org.example.formularioapp.database;

public interface SchemeDB {
    //variables -> final static
    //metodos -> sin cuerpo abstractos

    final static  String DB_NAME = "javafx1";
    String URL = "127.0.0.1";
    String PORT ="3306";
    String TAB_NAME = "newtable";
    String COL_ID ="id";
    String COL_NAME = "nombre";
    String COL_MAIL = "correo";
    String COL_LOCATE = "localizacion";
    String COL_EDAD = "edad";
    String COL_GENERO = "genero";

}
