package com.example.inventorysystem.userManagement;

import com.example.inventorysystem.Database.UsersDB;
import com.example.inventorysystem.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UserControlller {
    @FXML
    private ComboBox<String> role;
    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    void login(ActionEvent event) {
        if(role.getValue() == "admin") {
            Boolean isUser = UsersDB.loginUser(username.getText(), password.getText(), role.getValue());

            if(isUser){
            }
        }
    }

}
