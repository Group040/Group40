package com.example.inventorysystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1174, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add("sytles.css");

    }

    public static void main(String[] args) {
        launch();
    }
}