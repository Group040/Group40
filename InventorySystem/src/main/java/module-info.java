module com.example.inventorysystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.inventorysystem to javafx.fxml;
    exports com.example.inventorysystem;
    exports com.example.inventorysystem.Enities;
    opens com.example.inventorysystem.Enities to javafx.fxml;
    exports com.example.inventorysystem.Database;
    opens com.example.inventorysystem.Database to javafx.fxml;
}