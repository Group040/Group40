package com.example.inventorysystem;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {

    double x, y;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

        Scene scene = new Scene(root, 1174, 700);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

//        ProductsController products = new ProductsController();
//
//
//        ObservableList<String> categories = FXCollections.observableArrayList("Beverages","Bread/Bakery","Canned/Jarred Goods", "Dairy,","Dry/Baking Goods","Frozen Foods", "Meat","Produced","Paper Goods", "Personal Care");
//        products.categoryBox.getItems().addAll(categories);


    }

    public static void main(String[] args) {
        launch();
    }
}