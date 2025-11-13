module org.example.amazoncompras {
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
    requires java.desktop;
    requires lombok;
    requires javafx.graphics;

    opens org.example.amazoncompras to javafx.fxml;
    exports org.example.amazoncompras;
    exports org.example.amazoncompras.controller;
    opens org.example.amazoncompras.controller to javafx.fxml;

    exports org.example.amazoncompras.model to lombok;
    opens org.example.amazoncompras.model;
}