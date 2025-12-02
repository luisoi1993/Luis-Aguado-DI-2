module org.example.examen2 {
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
    requires static lombok;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;

    opens org.example.examen2 to javafx.fxml;
    exports org.example.examen2;
    exports org.example.examen2.dao;
    opens org.example.examen2.dao to javafx.fxml;

    exports org.example.examen2.controller;
    opens org.example.examen2.controller to javafx.fxml,java.sql;

    exports org.example.examen2.model to lombok,java.sql;
    opens org.example.examen2.model;
}