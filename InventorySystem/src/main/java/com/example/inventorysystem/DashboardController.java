package com.example.inventorysystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.ImageInput;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private Label account;

    @FXML
    private Button addGoods;

    @FXML
    private AnchorPane mainBorderPane;
    @FXML
    private Button customers;

    @FXML
    private Button dashboard;

    @FXML
    private Label goodname;

    @FXML
    private Label goodproduct;

    @FXML
    private Button goodsIssued;

    @FXML
    private Label goodsale;

    @FXML
    private Button issueGoods;

    @FXML
    private Button purchases;

    @FXML
    private Button sales;

    @FXML
    private Label totalPurchases;

    @FXML
    private Label totalSales;

    @FXML
    private Button vendors;

    @FXML
    private Button viewBills;
    @FXML
    private VBox goodItems;


    @FXML
    void showAdd(ActionEvent event) {

    }

    @FXML
    void showBills(ActionEvent event) {

    }


    @FXML
    void showCustomers(ActionEvent event) {

    }

    @FXML
    void showDashboard(ActionEvent event) {

    }

    @FXML
    void showIG(ActionEvent event) {

    }

    @FXML
    void showIssued(ActionEvent event) {

    }

    @FXML
    void showPurchase(ActionEvent event) {

    }

    @FXML
    void showSales(ActionEvent event) {

    }

    @FXML
    void showVendors(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Node[] nodes =new Node[10];
            try {
                for(int i =0; i< nodes.length; i++){

                    nodes[i] = (Node) FXMLLoader.load(getClass().getResource("good-product.fxml"));
                    goodItems.getChildren().add(nodes[i]);

            }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }
}