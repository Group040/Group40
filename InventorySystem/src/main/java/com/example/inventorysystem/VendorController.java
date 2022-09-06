package com.example.inventorysystem;

import com.example.inventorysystem.Entities.Item;
import com.example.inventorysystem.Entities.Users;
import com.example.inventorysystem.dataStructures.HashMapClass;
import com.example.inventorysystem.productManagement.ProductServices;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class VendorController {


    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML
    private TableView<Users> itemTable;

    @FXML
    private TableColumn<Users, Integer> contact;

    @FXML
    private TableColumn<Users, String> email;

    @FXML
    private TableColumn<Users, String> name;

    @FXML
    private TableColumn<Users, String> role;

    @FXML
    private TextField search;


    @FXML
    public  void getVendors(MouseEvent event){
//                    itemsI.add(new Item(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),LocalDate.parse((resultSet.getString(5))),resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getInt(9)));


        name.setCellValueFactory(new PropertyValueFactory<Users, String>("name"));
        role.setCellValueFactory(new PropertyValueFactory<Users, String>("role"));
        email.setCellValueFactory(new PropertyValueFactory<Users, String>("email"));
        contact.setCellValueFactory(new PropertyValueFactory<Users, Integer>("contact"));
        System.out.println("setting Table");

        FilteredList<Users> filteredData = new FilteredList<>(HashMapClass.getAllUsers(), p -> true);
//                    itemTable.setItems(ProductServices.getallProducts());
//                    total_product.setText(String.valueOf(ProductServices.getAllItemCount()));

        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(user -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (user.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }else if (user.getRole().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false;
                // Does not match.
            });
        });
        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Users> sortedData = new SortedList<>(filteredData);

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
    void addVendor(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("addVendor.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }








}
