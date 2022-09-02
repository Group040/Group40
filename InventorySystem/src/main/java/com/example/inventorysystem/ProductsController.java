package com.example.inventorysystem;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Random;

public class ProductsController {

    public ProductsController(){

    }
    @FXML
    public static TableColumn<Item, Integer> tbId;

    @FXML
    public static TableView<Item> itemTable ;
    @FXML
    public static TableColumn<Item, String> tbname ;

    @FXML
    public static TableColumn<Item, Integer> thbuy_price;

    @FXML
    public static TableColumn<Item, String> thcategory ;

    @FXML
    public static TableColumn<Item, LocalDate> thexpiry;

    @FXML
    public static TableColumn<Item, Integer> thgross_total ;

    @FXML
    public static TableColumn<Item, Integer> thquantity ;

    @FXML
    public static TableColumn<Item, Integer> thsel_price;
    @FXML
    public TextField buy_price;

    @FXML
    public ComboBox<String> category ;
    @FXML
    public TextArea description;

    @FXML
    public TextField gross_total;
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
    public void setmenu(MouseEvent event) {

        System.out.println("Clicked");
        ObservableList<String> cat = FXCollections.observableArrayList("Beverages","Bread/Bakery");
        category.getItems().addAll(cat);

    }

    public static ObservableList<Item> itemsI = FXCollections.observableArrayList();


    // Generating Id
    public int genId(int min, int max) {
        Random random = new Random();


        return random.nextInt(max - min) + min;
    }
    private static final Logger logger = Logger.getLogger(ProductsController.class.getName());

    public void createProduct(ActionEvent ae) throws SQLException {


        if ((description.getText().length() < 2) && (description.getText().length() > 100)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please take note of the description format", ButtonType.OK);
            alert.show();
        } else if ((name.getText().length() < 1) && (name.getText().length() > 20)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please take note of the description format", ButtonType.OK);
            alert.show();
        } else if (buy_price.getText().length() < 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter buy price", ButtonType.OK);
            alert.show();
        } else if (sel_price.getText().length() < 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter sel price", ButtonType.OK);
            alert.show();
        } else if (quantity.getText().length() < 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Enter quantity", ButtonType.OK);
            alert.show();
        } else if (category.getValue().toString().length() < 1) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Select a Category", ButtonType.OK);
            alert.show();
        }
        if (category.getValue().toString() == "Beverages") {
            Beverages item = new Beverages();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Beverage");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setBeverage_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());
            itemsI.add(item);
            itemTable.setItems(itemsI);


            gross_total.appendText(String.valueOf(item.getGross_total()));
            ProductsDB.createProduct(item, "beverages", item.getBeverage_id(), item.getDescription());
        } else if (category.getValue().toString() == "Bread/Bakery") {
            Bread item = new Bread();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Beverage");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setBread_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());


            gross_total.appendText(String.valueOf(item.getGross_total()));
            ProductsDB.createProduct(item, "bread", item.getBread_id(), item.getDescription());

        } else if (category.getValue().toString() == "Dairy") {
            Diary item = new Diary();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Beverage");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setDiary_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());


            gross_total.appendText(String.valueOf(item.getGross_total()));
            ProductsDB.createProduct(item, "bread", item.getDiary_id(), item.getDescription());
        } else if (category.getValue().toString() == "Dry/Baking Goods") {
            Dry item = new Dry();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Beverage");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setDry_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());


            gross_total.appendText(String.valueOf(item.getGross_total()));
            ProductsDB.createProduct(item, "bread", item.getDry_id(), item.getDescription());
        } else if (category.getValue().toString() == "Frozen Foods") {
            Frozen item = new Frozen();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Beverage");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setFrozen_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());


            gross_total.appendText(String.valueOf(item.getGross_total()));
            ProductsDB.createProduct(item, "bread", item.getFrozen_id(), item.getDescription());
        } else if (category.getValue().toString() == "Meat") {
            Meat item = new Meat();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Beverage");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setMeat_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());


            gross_total.appendText(String.valueOf(item.getGross_total()));
            ProductsDB.createProduct(item, "bread", item.getMeat_id(), item.getDescription());
        } else if (category.getValue().toString() == "Produced") {
            Produce item = new Produce();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Beverage");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setProduce_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());


            gross_total.appendText(String.valueOf(item.getGross_total()));
            ProductsDB.createProduct(item, "bread", item.getProduce_id(), item.getDescription());
        } else if (category.getValue().toString() == "Cleaners") {
            Cleaners item = new Cleaners();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Beverage");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setCleaners_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());
            refreshTable();

            gross_total.appendText(String.valueOf(item.getGross_total()));
            ProductsDB.createProduct(item, "bread", item.getCleaners_id(), item.getDescription());
        } else if (category.getValue().toString() == "Paper Goods") {
            Paper item = new Paper();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Beverage");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setPaper_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());


            gross_total.appendText(String.valueOf(item.getGross_total()));
            ProductsDB.createProduct(item, "bread", item.getPaper_id(), item.getDescription());
        } else if (category.getValue().toString() == "Personal Care") {
            PersonalCare item = new PersonalCare();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Beverage");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setPersonal_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());


            gross_total.appendText(String.valueOf(item.getGross_total()));
            ProductsDB.createProduct(item, "bread", item.getPersonal_id(), item.getDescription());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Specify all fields", ButtonType.OK);
            alert.show();
        }
    }

        @FXML
        public static ObservableList<Item> showTable(){
            Connection connection = null;
            PreparedStatement statement = null;

            String selectsql = "SELECT `id`, `code`, `item_name`, `category`, `expiry`, `buy_price`, `sel_price`, `quantity`, `gross_total` FROM `item` ";
            int counter = 1;

            try{
//                ObservableList<Item> itemsI = FXCollections.observableArrayList();

                connection = DBCon.getConnection();
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(selectsql);
                ResultSet resultSet = statement.executeQuery();
                System.out.println(resultSet);
                System.out.println(selectsql);

                while (resultSet.next()){

//                    Item item =new Item();
//                    item.setId(resultSet.getInt(1));
//                    item.setCode(resultSet.getInt(2));
//                    item.setItem_name(resultSet.getString(3));
//                    item.setCategory(resultSet.getString(4));
//                    item.setExpiry(LocalDate.parse((resultSet.getString(5))));
//                    item.setBuy_price(resultSet.getInt(6));
//                    item.setSel_price(resultSet.getInt(7));
//                    item.setQuantity(resultSet.getInt(8));
//                    item.setGross_total(resultSet.getInt(9));


//                    System.out.println(itemTable.getColumns());





                    itemsI.add(new Item(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),LocalDate.parse((resultSet.getString(5))),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getInt(9)));
                    System.out.println(itemsI.get(0).buy_price);

//                    tbId.setCellValueFactory(new PropertyValueFactory<Item, Integer>("id"));
//                    tbname.setCellValueFactory(new PropertyValueFactory<Item, String>("item_name"));
//                    thcategory.setCellValueFactory(new PropertyValueFactory<Item, String>("category"));
//                    thbuy_price.setCellValueFactory(new PropertyValueFactory<Item, Integer>("buy_price"));
//                    thexpiry.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("expiry"));
//
//                    thsel_price.setCellValueFactory(new PropertyValueFactory<Item, Integer>("sel_price"));
//                    thquantity.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
//                    thgross_total.setCellValueFactory(new PropertyValueFactory<Item, Integer>("gross_total"));


                      System.out.println(itemTable.getItems());



//                    ObservableList<Item> itemsI = FXCollections.observableArrayList(new Item( resultSet.getInt("id"), resultSet.getInt("code")resultSet.getString("item_name"), resultSet.getString("category"),resultSet.getInt("buy_price"),resultSet.getInt("sel_price"), resultSet.getInt("gross_total")));


                }

            }catch(SQLException ex){

                Alert alert = new Alert(Alert.AlertType.ERROR, "Error occurred during sql injection");
                alert.show();
            }
            return itemsI;

        }
@FXML
public static void refreshTable(){


                    tbId.setCellValueFactory(new PropertyValueFactory<Item, Integer>("id"));
                    tbname.setCellValueFactory(new PropertyValueFactory<Item, String>("item_name"));
                    thcategory.setCellValueFactory(new PropertyValueFactory<Item, String>("category"));
                    thbuy_price.setCellValueFactory(new PropertyValueFactory<Item, Integer>("buy_price"));
                     thexpiry.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("expiry"));

                        thsel_price.setCellValueFactory(new PropertyValueFactory<Item, Integer>("sel_price"));
                    thquantity.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
                    thgross_total.setCellValueFactory(new PropertyValueFactory<Item, Integer>("gross_total"));
                    itemTable.setItems(showTable());

}

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        tbId.setCellValueFactory(new PropertyValueFactory<Item, Integer>("id"));
//        tbname.setCellValueFactory(new PropertyValueFactory<Item, String>("item_name"));
//        thcategory.setCellValueFactory(new PropertyValueFactory<Item, String>("category"));
//        thbuy_price.setCellValueFactory(new PropertyValueFactory<Item, Integer>("buy_price"));
//        thsel_price.setCellValueFactory(new PropertyValueFactory<Item, Integer>("sel_price"));
//        thquantity.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
//        thgross_total.setCellValueFactory(new PropertyValueFactory<Item, Integer>("gross_total"));
//        refreshTable();
//
//
//    }

    // Sql queries

    }






