package com.example.inventorysystem;
import java.io.IOException;

import com.example.inventorysystem.Database.UsersDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;





    public class SceneController {
        @FXML
        private ComboBox<String> role;
        @FXML
        private TextField password;

        @FXML
        private TextField username;

        private Stage stage;
        private Scene scene;
        private Parent root;

        @FXML
        public void changeRole(MouseEvent event) {
            ObservableList<String> cat = FXCollections.observableArrayList();
            cat.clear();
            System.out.println("Clicked");
            cat.clear();
            cat.addAll("admin","user");
            role.getItems().addAll(cat);


        }


        public void loginScreen(ActionEvent event) throws IOException {
            if(role.getValue() == "admin") {
                Boolean isUser = UsersDB.loginUser(username.getText(), password.getText(), role.getValue());

                if (isUser) {

                }
                root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }else if (role.getValue() == "vendor"){
                Boolean isUser = UsersDB.loginUser(username.getText(), password.getText(), role.getValue());

                if (isUser) {
                    root = FXMLLoader.load(getClass().getResource("salesvendor.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }

        public void dashboardScreen(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        public void vendorScreen(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("sales.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

