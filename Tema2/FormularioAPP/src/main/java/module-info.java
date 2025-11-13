module org.example.formularioapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;
    requires java.sql;
    requires lombok;
    requires java.desktop;
    requires javafx.base;

    opens org.example.formularioapp to javafx.fxml,java.sql;
    exports org.example.formularioapp;
    exports org.example.formularioapp.contorller;
    opens org.example.formularioapp.contorller to javafx.fxml,java.sql;

    exports org.example.formularioapp.model to lombok,java.sql;
    opens org.example.formularioapp.model;


}