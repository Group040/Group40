package com.example.inventorysystem;

import java.sql.*;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.logging.Logger;

import com.example.inventorysystem.Database.DBCon;
import com.example.inventorysystem.Database.ProductsDB;
import com.example.inventorysystem.Enities.*;
import com.example.inventorysystem.dataStructures.ItemQueue;
import com.example.inventorysystem.dataStructures.ItemStack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Random;

public class ProductsController {

    public ProductsController(){

    }
    @FXML
    public  TableColumn<Item, Integer> tbId;

    @FXML
    public  TableView<Item> itemTable ;
    @FXML
    public  TableColumn<Item, String> tbname ;

    @FXML
    public  TableColumn<Item, Integer> thbuy_price;

    @FXML
    public  TableColumn<Item, String> thcategory ;

    @FXML
    public  TableColumn<Item, LocalDate> thexpiry;

    @FXML
    public  TableColumn<Item, Integer> thgross_total ;

    @FXML
    public  TableColumn<Item, Integer> thquantity ;

    @FXML
    public  TableColumn<Item, Integer> thsel_price;
    @FXML
    public TextField buy_price;

    @FXML
    public ComboBox<String> category ;
    @FXML
    public TextArea description;

    @FXML
    public TextField gross_total = null;
    @FXML
    public DatePicker expiry_date;


    @FXML
    public VBox listbox;
    @FXML
    public Button insert_product;


    @FXML
    private TextField name;

    @FXML
    private TextField profit;

    @FXML
    private TextField quantity;

    @FXML
    private TextField sel_price;

    @FXML
    public static Pane products;

    @FXML
    private Button update_product;

    @FXML
    private Label total_product;

    ObservableList<String> cat = FXCollections.observableArrayList();

    @FXML
    public void setmenu(MouseEvent event) {
        System.out.println("Clicked");
        cat.clear();
        cat.addAll("Beverages","Bread/Bakery","Canned/Jarred","Dairy","Dry/Baking Goods", "Frozen Goods","Meat","Produced","Cleaners","Paper Goods", "Personal Care");
        category.getItems().addAll(cat);

    }

    ItemStack itemStack = new ItemStack();
    ItemQueue itemQueue = new ItemQueue();


    ObservableList<Item> queueItems = FXCollections.observableArrayList();
    ObservableList<Item> stackItems = FXCollections.observableArrayList();



    // Generating Id
    private static final Logger logger = Logger.getLogger(ProductsController.class.getName());

    public void createProduct(ActionEvent ae) throws SQLException {

       Item item = ProductServices.addItem(description,name, buy_price, sel_price, quantity, category, "0",expiry_date);
        if(item.getCategory() == "Beverages" ||
                item.getCategory() == "Bread/Bakery" ||
                item.getCategory() == "Canned/Jarred Goods"||
                item.getCategory() == "Dairy"

        ){
            stackItems.add(item);
        }
        else if(item.getCategory() == "Dry/Baking Goods" ||
                item.getCategory() == "Bread/Bakery" ||
                item.getCategory() == "Frozen Foods"||
                item.getCategory() == "Dairy"

        ){
            queueItems.add(item);
        }

    }

        @FXML
        public  void getItems(MouseEvent event){
//                    itemsI.add(new Item(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),LocalDate.parse((resultSet.getString(5))),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getInt(9)));

                    tbId.setCellValueFactory(new PropertyValueFactory<Item, Integer>("id"));
                    tbname.setCellValueFactory(new PropertyValueFactory<Item, String>("item_name"));
                    thcategory.setCellValueFactory(new PropertyValueFactory<Item, String>("category"));
                    thbuy_price.setCellValueFactory(new PropertyValueFactory<Item, Integer>("buy_price"));
                    thexpiry.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("expiry"));
                    thsel_price.setCellValueFactory(new PropertyValueFactory<Item, Integer>("sel_price"));
                    thquantity.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
                    thgross_total.setCellValueFactory(new PropertyValueFactory<Item, Integer>("gross_total"));
                    System.out.println("setting Table");
                    itemTable.setItems(ProductServices.getallProducts());


                    // String items in various Structures.
            // clearing previous data


                total_product.setText(String.valueOf(ProductServices.getAllItemCount()));


                if(ProductServices.getallProducts().size() == 0){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "There are no items in the System", ButtonType.OK);
                    alert.show();
                }

            }


}






