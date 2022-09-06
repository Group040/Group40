package com.example.inventorysystem.salesManagement;

import com.example.inventorysystem.Entities.Item;
import com.example.inventorysystem.productManagement.ProductServices;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SalesServices {

    public SalesServices(){

    }
    @FXML
    private Label gtotal;

    @FXML
    private TextField search;
    @FXML
    private TableView<Item> itemTable;

    @FXML
    private TableColumn<Item, Integer> sid;

    @FXML
    private TableColumn<Item, String> sname;

    @FXML
    private TableColumn<Item, Integer> squantity;

    @FXML
    private TableColumn<Item, Integer> stotal;

    @FXML
    private TableColumn<Item, Integer> tbId;

    @FXML
    private TableColumn<Item, String> tbname;

    @FXML
    private TableColumn<Item,Integer> thbuy_price;

    @FXML
    private TableColumn<Item, String> thcategory;

    @FXML
    private TableColumn<Item, Integer> thquantity;

    @FXML
    private TableColumn<Item, Integer> thsel_price;

    // Allitems
    @FXML
    public  void getItems(MouseEvent event){
//                    itemsI.add(new Item(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),LocalDate.parse((resultSet.getString(5))),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getInt(9)));


        tbId.setCellValueFactory(new PropertyValueFactory<Item, Integer>("id"));
        tbname.setCellValueFactory(new PropertyValueFactory<Item, String>("item_name"));
        thcategory.setCellValueFactory(new PropertyValueFactory<Item, String>("category"));
        thbuy_price.setCellValueFactory(new PropertyValueFactory<Item, Integer>("buy_price"));
        thsel_price.setCellValueFactory(new PropertyValueFactory<Item, Integer>("sel_price"));
        thquantity.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
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
                }else if (item.getItem_name().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
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

}
