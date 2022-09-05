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



    public static ObservableList<Item> bvs = FXCollections.observableArrayList();
    public static ObservableList<Item> bs = FXCollections.observableArrayList();

    public static ObservableList<Item> cans = FXCollections.observableArrayList();

    public static ObservableList<Item> dis = FXCollections.observableArrayList();

    public static ObservableList<Item> drq = FXCollections.observableArrayList();

    public static ObservableList<Item> frq = FXCollections.observableArrayList();

    public static ObservableList<Item> mq = FXCollections.observableArrayList();

    public static ObservableList<Item> allList = FXCollections.observableArrayList();




    // Generating Id
    private static final Logger logger = Logger.getLogger(ProductsController.class.getName());

    public void createProduct(ActionEvent ae) throws SQLException {

       Item item = ProductServices.addItem(description,name, buy_price, sel_price, quantity, category, "0",expiry_date);

        switch(item.getCategory()) {
            case "Beverage":
                bvs = beverageStack.pushToStack(bvs, item);
                System.out.println(bvs.size());

                System.out.println("Added");
                break;
            case "Bread/Bakery":
               bs = breadStack.pushToStack(bs, item);
                break;
            case "Dairy":
                dis = diaryStack.pushToStack(dis, item);
                break;
            case "Dry/Baking Goods":
                drq = dryQueue.enqueue(drq, item);
                break;

                case "Frozen Foods":
                   frq = frozenQueue.enqueue(frq, item);
                break;
            case "Meat":
              mq =   meatQueue.enqueue(mq, item);
                break;

            default:
                allList.add(item);

                // code block
        }
        System.out.println(bvs.size());


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
        cat.clear();
        System.out.println("Clicked");
        cat.clear();
        cat.addAll("Beverages","Bread/Bakery","Canned/Jarred","Dairy","Dry/Baking Goods", "Frozen Goods","Meat","Produced","Cleaners","Paper Goods", "Personal Care");
        category1.getItems().addAll(cat);
        System.out.println(bvs.size());


    }



    @FXML
    void removeItem(ActionEvent event) {
        if(category1.getValue().toString() == "Beverages"){
            System.out.println(bvs.size());
            beverageStack.popStack(bvs);
        } else if(category1.getValue().toString() == "Bread/Bakery"){
                breadStack.popStack(bs);
        }else if(category1.getValue().toString() == "Canned/Jarred Goods"){
            cannedStack.popStack(cans);
        }else if(category1.getValue().toString() == "Dairy"){
            diaryStack.popStack(dis);
        }else if(category1.getValue().toString() == "Dry/Baking Goods"){
            dryQueue.dequeue(drq);
        }else if(category1.getValue().toString() == "Frozen Foods"){
            frozenQueue.dequeue(frq);
        }else if(category1.getValue().toString() == "Meat"){
            meatQueue.dequeue(mq);
        }else{
            allList.remove(allList.size()-1);
        }

    }

}






