module org.example.calculadora {
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
    requires lombok;

    opens org.example.calculadora to javafx.fxml;
    exports org.example.calculadora;
    exports org.example.calculadora.controller;
    opens org.example.calculadora.controller to javafx.fxml;

    exports org.example.calculadora.model to lombok;
    opens org.example.calculadora.model;

}