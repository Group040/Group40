package com.example.inventorysystem;

import com.almasb.fxgl.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.ImageInput;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController{
    @FXML
    private Button addGoods1;

    @FXML
    private Button customers1;

    @FXML
    private Button dashboard1;

    @FXML
    private Label delivered;

    @FXML
    private Label exGoods1;

    @FXML
    private Label expired;

    @FXML
    private VBox goodItems;

    @FXML
    private Button goodsIssued1;

    @FXML
    private Label invoice;

    @FXML
    private Button issueGoods1;

    @FXML
    private Label purchased;

    @FXML
    private Label purchasedGoods1;

    @FXML
    private Label purchasedGoods11;

    @FXML
    private Label purchasedGoods111;

    @FXML
    private Button purchases1;

    @FXML
    private Button sales1;

    @FXML
    private Button viewBills1;

    @FXML
    private Pane mainBody;

    @FXML
    void showProducts(ActionEvent event) throws IOException{
        URL url = getClass().getResource("products.fxml");
        mainBody.getChildren().clear();
        try {
            Pane home = (Pane) FXMLLoader.load(url);
//            Parent fxml = FXMLLoader.load(url);
            System.out.println("cretaed");
           mainBody.getChildren().add(home);
            System.out.println(mainBody.getChildren());



        }catch (IOException e){
            e.printStackTrace();
        }


    }
    @FXML
    void viewVendors(ActionEvent event) throws IOException{
        URL url = getClass().getResource("viewVendors.fxml");
        mainBody.getChildren().clear();
        try {
            Pane home = (Pane) FXMLLoader.load(url);
//            Parent fxml = FXMLLoader.load(url);
            System.out.println("cretaed");
            mainBody.getChildren().add(home);
            System.out.println(mainBody.getChildren());



        }catch (IOException e){
            e.printStackTrace();
        }


    }



    @FXML
    void showBills(ActionEvent event) throws  IOException {
        URL url = getClass().getResource("bill.fxml");
        mainBody.getChildren().clear();
        try {
            Pane home = (Pane) FXMLLoader.load(url);
//            Parent fxml = FXMLLoader.load(url);
            System.out.println("cretaed");
            mainBody.getChildren().add(home);
            System.out.println(mainBody.getChildren());



        }catch (IOException e){
            e.printStackTrace();
        }

    }



    @FXML
    void showDashboard(ActionEvent event) throws IOException{
        URL url = getClass().getResource("home.fxml");
        mainBody.getChildren().clear();

        try {
            Pane home = (Pane) FXMLLoader.load(url);
//            Parent fxml = FXMLLoader.load(url);
            System.out.println("cretaed");
            mainBody.getChildren().add(home);
            System.out.println(mainBody.getChildren());



        }catch (IOException e){
            e.printStackTrace();
        }    }

    @FXML
    void showComodities(ActionEvent event) throws IOException{
        URL url = getClass().getResource("comodity.fxml");
        mainBody.getChildren().clear();
        try {
            Pane home = (Pane) FXMLLoader.load(url);
//            Parent fxml = FXMLLoader.load(url);
            System.out.println("cretaed");
            mainBody.getChildren().add(home);
            System.out.println(mainBody.getChildren());



        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    void showIssued(ActionEvent event) throws  IOException {
        URL url = getClass().getResource("issueGoods.fxml");
        mainBody.getChildren().clear();
        try {
            Pane home = (Pane) FXMLLoader.load(url);
//            Parent fxml = FXMLLoader.load(url);
            System.out.println("cretaed");
            mainBody.getChildren().add(home);
            System.out.println(mainBody.getChildren());



        }catch (IOException e){
            e.printStackTrace();
        }

    }


    @FXML
    void showSales(ActionEvent event) throws IOException {
        URL url = getClass().getResource("sales.fxml");
        mainBody.getChildren().clear();
        try {
            Pane home = (Pane) FXMLLoader.load(url);
//            Parent fxml = FXMLLoader.load(url);
            System.out.println("cretaed");
            mainBody.getChildren().add(home);
            System.out.println(mainBody.getChildren());



        }catch (IOException e){
            e.printStackTrace();
        }
    }






//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//       URL url1 = getClass().getClassLoader().getResource("dashboard.fxml");
//        try {
//            Parent fxml = FXMLLoader.load(url1);
//            mainBody.getChildren().removeAll();
//            mainBody.getChildren().add(fxml);
//
//
//        } catch (IOException ex) {
//
//        }
//
//    }

}


