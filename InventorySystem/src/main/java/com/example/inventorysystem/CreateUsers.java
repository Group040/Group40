package com.example.inventorysystem;

import com.example.inventorysystem.Entities.Users;
import com.example.inventorysystem.dataStructures.HashMapClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;

public class CreateUsers {
    @FXML
    private TextField email;

    @FXML
    private TextField name;
    @FXML
    private TextField contact;

    @FXML
    private TextField password;

    @FXML
    private ComboBox<String> role;

    @FXML
    public void changeRole(MouseEvent event) {
        ObservableList<String> cat = FXCollections.observableArrayList();
        cat.clear();
        System.out.println("Clicked");
        cat.clear();
        cat.addAll("admin","vendor");
        role.getItems().addAll(cat);


    }
    @FXML
    private TextField username;
    public static int genId(int min, int max) {
        Random random = new Random();


        return random.nextInt(max - min) + min;
    }


    @FXML
    void createUser(ActionEvent event) throws SQLException {
        int id = genId(10,10000);
        HashMap <Integer, Users> vendor = HashMapClass.addVendor(id,name.getText(),email.getText(),contact.getText(),role.getValue(),username.getText(),password.getText());
        HashMapClass.createVendor(vendor, id);
    }
}
