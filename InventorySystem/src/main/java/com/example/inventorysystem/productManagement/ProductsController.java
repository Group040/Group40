package com.example.inventorysystem.productManagement;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Logger;

import com.example.inventorysystem.Enities.*;
import com.example.inventorysystem.dataStructures.ItemQueue;
import com.example.inventorysystem.dataStructures.ItemStack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ProductsController {

    public ProductsController(){

    }

    @FXML
    private TableView<?> remove;

    @FXML
    private TextField search;
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

    @FXML
    private ComboBox<String> category1;



    @FXML
    public void setmenu(MouseEvent event) {
        ObservableList<String> cat = FXCollections.observableArrayList();

        System.out.println("Clicked");
        cat.clear();
        cat.addAll("Beverages","Bread/Bakery","Canned/Jarred","Dairy","Dry/Baking Goods", "Frozen Goods","Meat","Produced","Cleaners","Paper Goods", "Personal Care");
        category.getItems().addAll(cat);

    }

    // Instance of the Stack Class

    ItemStack beverageStack = new ItemStack();
    ItemStack breadStack = new ItemStack();
    ItemStack cannedStack = new ItemStack();
    ItemStack diaryStack = new ItemStack();


    //Instance of Queue Class
    ItemQueue dryQueue = new ItemQueue();
    ItemQueue frozenQueue = new ItemQueue();
    ItemQueue meatQueue = new ItemQueue();
    ItemQueue producedQueue = new ItemQueue();



    ObservableList<Item> bvs = FXCollections.observableArrayList();
    ObservableList<Item> bs = FXCollections.observableArrayList();

    ObservableList<Item> cans = FXCollections.observableArrayList();

    ObservableList<Item> dis = FXCollections.observableArrayList();

    ObservableList<Item> drq = FXCollections.observableArrayList();

    ObservableList<Item> frq = FXCollections.observableArrayList();

    ObservableList<Item> mq = FXCollections.observableArrayList();

    ObservableList<Item> allList = FXCollections.observableArrayList();




    // Generating Id
    private static final Logger logger = Logger.getLogger(ProductsController.class.getName());

    public void createProduct(ActionEvent ae) throws SQLException {

       Item item = ProductServices.addItem(description,name, buy_price, sel_price, quantity, category, "0",expiry_date);

        switch(item.getCategory()) {
            case "Beverages":
                beverageStack.pushToStack(bvs, item);
                break;
            case "Bread/Bakery":
                breadStack.pushToStack(bvs, item);
                break;
            case "Dairy":
                diaryStack.pushToStack(bvs, item);
                break;
            case "Dry/Baking Goods":
                dryQueue.enqueue(bvs, item);
                break;

                case "Frozen Foods":
                    frozenQueue.enqueue(bvs, item);
                break;
            case "Meat":
                meatQueue.enqueue(bvs, item);
                break;

            default:
                beverageStack.pushToStack(bvs, item);

                // code block
        }
        if(item.getCategory() == "Beverages" ||
                item.getCategory() == "Bread/Bakery" ||

                item.getCategory() == "Dairy"

        ){
            beverageStack.pushToStack(bvs, item);
        }
        else if(item.getCategory() == "Dry/Baking Goods" ||
                item.getCategory() == "Bread/Bakery" ||
                item.getCategory() == "Frozen Foods"||
                item.getCategory() == "Dairy"

        ){
            breadStack.pushToStack(bs,item);
        }else if(item.getCategory() == "Canned/Jarred Goods"){

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

                    FilteredList<Item> filteredData = new FilteredList<>(ProductServices.getallProducts(), p -> true);
//                    itemTable.setItems(ProductServices.getallProducts());
//                    total_product.setText(String.valueOf(ProductServices.getAllItemCount()));

            search.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(item -> {
                    // If filter text is empty, display all persons.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (item.getCategory().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches first name.
                    }
                    return false;
                    // Does not match.
                });
            });
            // 3. Wrap the FilteredList in a SortedList.
            SortedList<Item> sortedData = new SortedList<>(filteredData);

            // 4. Bind the SortedList comparator to the TableView comparator.
            sortedData.comparatorProperty().bind(itemTable.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            itemTable.setItems(sortedData);


                if(ProductServices.getallProducts().size() == 0){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "There are no items in the System", ButtonType.OK);
                    alert.show();
                }

            }


    @FXML
    public void changeCat(MouseEvent event) {
        ObservableList<String> cat = FXCollections.observableArrayList();

        System.out.println("Clicked");
        cat.clear();
        cat.addAll("Beverages","Bread/Bakery","Canned/Jarred","Dairy","Dry/Baking Goods", "Frozen Goods","Meat","Produced","Cleaners","Paper Goods", "Personal Care");
        category1.getItems().addAll(cat);

    }



    @FXML
    void removeItem(ActionEvent event) {

    }

}






