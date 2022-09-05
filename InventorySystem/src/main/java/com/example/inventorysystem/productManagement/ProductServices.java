package com.example.inventorysystem.productManagement;

import com.dlsc.formsfx.model.structure.IntegerField;
import com.example.inventorysystem.Database.DBCon;
import com.example.inventorysystem.Database.ProductsDB;
import com.example.inventorysystem.Enities.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Random;

public class ProductServices {

    public ProductServices(){}


    public static int genId(int min, int max) {
        Random random = new Random();


        return random.nextInt(max - min) + min;
    }



    // Adding items to database
    public static Item addItem( TextArea description,
                               TextField name,
                               TextField buy_price,
                               TextField sel_price,
                               TextField quantity,
                               ComboBox<String> category,
                               String gross_total,
                               DatePicker expiry_date) throws SQLException {


        // Validating fields
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

            ProductsDB.createProduct(item, "beverage", item.getBeverage_id(), item.getDescription());
            return item;



        } else if (category.getValue().toString() == "Bread/Bakery") {
            Bread item = new Bread();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Bread/Bakery");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setBread_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());
            ProductsDB.createProduct(item, "bread", item.getBread_id(), item.getDescription());
            return item;





        } else if (category.getValue().toString() == "Dairy") {
            Diary item = new Diary();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Dairy");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setDiary_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());


            ProductsDB.createProduct(item, "diary", item.getDiary_id(), item.getDescription());
            return item;



        } else if (category.getValue().toString() == "Dry/Baking Goods") {
            Dry item = new Dry();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Dry/Baking Goods");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setDry_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());
            ProductsDB.createProduct(item, "dry", item.getDry_id(), item.getDescription());
            return item;




        } else if (category.getValue().toString() == "Frozen Foods") {
            Frozen item = new Frozen();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Frozen Foods");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setFrozen_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());


            ProductsDB.createProduct(item, "frozen", item.getFrozen_id(), item.getDescription());
            return item;



        } else if (category.getValue().toString() == "Meat") {
            Meat item = new Meat();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Meat");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setMeat_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());


            ProductsDB.createProduct(item, "meat", item.getMeat_id(), item.getDescription());
            return item;




        } else if (category.getValue().toString() == "Produced") {
            Produce item = new Produce();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Produced");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setProduce_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());
            ProductsDB.createProduct(item, "produce", item.getProduce_id(), item.getDescription());

            return item;

        } else if (category.getValue().toString() == "Cleaners") {
            Cleaners item = new Cleaners();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Cleaners");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setCleaners_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());
            ProductsDB.createProduct(item, "cleaners", item.getCleaners_id(), item.getDescription());
            return item;



        } else if (category.getValue().toString() == "Paper Goods") {
            Paper item = new Paper();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Paper Goods");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setPaper_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());
            ProductsDB.createProduct(item, "paper", item.getPaper_id(), item.getDescription());
            return item;




        } else if (category.getValue().toString() == "Personal Care") {
            PersonalCare item = new PersonalCare();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Personal Care");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setPersonal_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());
            ProductsDB.createProduct(item, "personalcare", item.getPersonal_id(), item.getDescription());
            return item;


        }else if (category.getValue().toString() == "Canned/Jarred Goods") {
            PersonalCare item = new PersonalCare();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCode(genId(1000, 10000000));
            item.setCategory("Canned/Jarred Goods");
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setPersonal_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());
            ProductsDB.createProduct(item, "canned", item.getPersonal_id(), item.getDescription());

            return item;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Specify all fields", ButtonType.OK);
            alert.show();
        }
        return null;
    }


        // Getting all items for database
    public static ObservableList<Item> getallProducts() {

        Connection connection = null;
        PreparedStatement statement = null;

        String selectsql = "SELECT `id`, `code`, `item_name`, `category`, `expiry`, `buy_price`, `sel_price`, `quantity`, `gross_total` FROM `item` ";
        int counter = 1;

        ObservableList<Item> items = null;
        try {
            items = FXCollections.observableArrayList();

            connection = DBCon.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectsql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
            System.out.println(selectsql);

            while (resultSet.next()) {

                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setCode(resultSet.getInt(2));
                item.setItem_name(resultSet.getString(3));
                item.setCategory(resultSet.getString(4));
                item.setExpiry(LocalDate.parse((resultSet.getString(5))));
                item.setBuy_price(resultSet.getInt(6));
                item.setSel_price(resultSet.getInt(7));
                item.setQuantity(resultSet.getInt(8));
                item.setGross_total(resultSet.getInt(9));
                items.add(item);

            }
        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "Error occurred during sql injection");
            alert.show();
        }
        return items;
    }




    //Searching an item from a database

    public static ObservableList<Item> getItem(String name){

        Connection connection = null;
        PreparedStatement statement = null;

        String selectsql = "SELECT `id`, `code`, `item_name`, `category`, `expiry`, `buy_price`, `sel_price`, `quantity`, `gross_total` FROM `item` WHERE `item_name` = `"+name+"`";
        int counter = 1;

        ObservableList<Item> items = null;
        try {
            items = FXCollections.observableArrayList();

            connection = DBCon.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectsql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
            System.out.println(selectsql);

            while (resultSet.next()) {

                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setCode(resultSet.getInt(2));
                item.setItem_name(resultSet.getString(3));
                item.setCategory(resultSet.getString(4));
                item.setExpiry(LocalDate.parse((resultSet.getString(5))));
                item.setBuy_price(resultSet.getInt(6));
                item.setSel_price(resultSet.getInt(7));
                item.setQuantity(resultSet.getInt(8));
                item.setGross_total(resultSet.getInt(9));
                items.add(item);

            }
        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "Error occurred during sql injection");
            alert.show();
        }
        return items;


    }




    // Removing items for database
    public static void removeItem(String name) {
        Connection connection = null;
        PreparedStatement statement = null;

        String selectsql = "DELETE FROM `item` WHERE `item_name` = `" + name + "`";
        int counter = 1;

        ObservableList<Item> items = null;
        try {
            items = FXCollections.observableArrayList();

            connection = DBCon.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectsql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
            System.out.println(selectsql);

        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "Product Removed");
            alert.show();
        }
    }



    //Getting the number of Items in database
    public static int getAllItemCount(){
        int count = 0;

        Connection connection = null;
        PreparedStatement statement = null;

        String selectsql = "SELECT  COUNT(*) FROM `item` AS itemCount";


        ObservableList<Item> items = null;
        try {
            items = FXCollections.observableArrayList();

            connection = DBCon.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectsql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
            System.out.println(selectsql);
            if (resultSet.next()) {
                int theCount = resultSet.getInt(1);
                System.out.println(theCount);
            }
            count = resultSet.getInt("COUNT(*)");

        } catch (SQLException ex) {

        }
        return count;
    }




    //Getting the number of Items in a Category in database

    public static int getCategoryCount(String cat){

        Connection connection = null;
        PreparedStatement statement = null;

        String selectsql = "SELECT  COUNT(*) FROM `item` AS itemCount WHERE  `category` =  `"+cat+"`";
        int count =  0;

        ObservableList<Item> items = null;
        try {
            items = FXCollections.observableArrayList();
            count = 0;

            connection = DBCon.getConnection();
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(selectsql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
            System.out.println(selectsql);

            if (resultSet.next()) {
                int theCount = resultSet.getInt(1);
                System.out.println(theCount);
            }


        } catch (SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "Product Removed");
            alert.show();
        }
        return count;
    }



    public static void selItems(ObservableList<Item> items ){

        Connection connection = null;
        PreparedStatement statement = null;

        for(int i= 0; i < items.size()-1; i++) {

            String selectsql = "UPDATE `item` SET `quantity`='[value-8]' WHERE `category`='"+items.get(i).getCategory()+"'";

            try {

                connection = DBCon.getConnection();
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(selectsql);
                ResultSet resultSet = statement.executeQuery();
                System.out.println(resultSet);
                System.out.println(selectsql);


            } catch (SQLException ex) {

                Alert alert = new Alert(Alert.AlertType.ERROR, "Items Soled");
                alert.show();
            }
        }
}
}

