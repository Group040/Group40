package com.example.inventorysystem.Entities;

import com.example.inventorysystem.dataStructures.HashMapClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
