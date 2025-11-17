module org.example.pizzeria {
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
    requires javafx.graphics;

    opens org.example.pizzeria to javafx.fxml ;
    exports org.example.pizzeria;

    exports org.example.pizzeria.controller;
    opens org.example.pizzeria.controller to javafx.fxml,java.sql;

    exports org.example.pizzeria.model to lombok,java.sql;
    opens org.example.pizzeria.model;
}