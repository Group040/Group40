package com.example.inventorysystem;

import com.example.inventorysystem.Enities.Beverages;
import com.example.inventorysystem.Enities.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Products {


    @FXML
    private TextField buy_price;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private TextArea description;

    @FXML
    private TextField gross_total;
    @FXML
    private DatePicker expiry_date;

    @FXML
    private Button insert_product;

    @FXML
    private TextField name;

    @FXML
    private TextField profit;

    @FXML
    private TextField quantity;

    @FXML
    private TextField sel_price;

    @FXML
    private Button update_product;


    @FXML
    void setAction(ActionEvent event) {
        ObservableList<String> categories = FXCollections.observableArrayList("Beverages","Bread/Bakery","Canned/Jarred Goods", "Dairy,","Dry/Baking Goods","Frozen Foods", "Meat","Produced","Paper Goods", "Personal Care");
        combo.getItems().addAll(categories);

    }


    // Generating Id
    public int genId(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    @FXML
    public void createProduct(ActionEvent ae) throws SQLException {


        //adding cagegory items
        if (combo.getValue()== "Beverage") {

            if((description.getText().length() < 2) && (description.getText().length() > 100)){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Please take note of the description format", ButtonType.OK);
                alert.show();
            }
            if((name.getText().length() < 1) && (name.getText().length() > 20)){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Please take note of the description format", ButtonType.OK);
                alert.show();
            }
            if(buy_price.getText().length() <1){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Enter buy price", ButtonType.OK);
                alert.show();
            }
            if(sel_price.getText().length() <1){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Enter sel price", ButtonType.OK);
                alert.show();
            }
            if(quantity.getText().length() <1){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Enter quantity", ButtonType.OK);
                alert.show();
            }
            Beverages beverages = new Beverages();
            Beverages item = (Beverages) new Item();
            item.setDescription(description.getText());
            item.setId(genId(1000, 1000000));
            item.setCategory(combo.getValue());
            item.setItem_name(name.getText());
            item.setBuy_price(Integer.parseInt(buy_price.getText()));
            item.setSel_price(Integer.parseInt(sel_price.getText()));
            item.setQuantity(Integer.parseInt(quantity.getText()));
            item.setBeverage_id(item.getId());
            item.setExpiry(expiry_date.getValue());
            item.setGross_total(item.getSel_price() * item.getQuantity());

            // Sql queries

            String insert_sql1 = "INSERT INTO item VALUES(?,?,?,?,?,?,?,?)";
            String delete_sql = "DELETE FROM item WHERE id = ?";
            String update_sql = "UPDATE item SET id=?, code= ?, item_name=?, category=?, expiry=?, buy_price=?, sel_price=? , quantity=? , gross_total=? WHERE ?";

            try (
                    // try-with-resource statement will auto close the connection.
                    // Step 1: Establishing a Connection and


                    Connection con = DBCon.getConnection();
                    // Step 2:Create a statement using connection object
                    PreparedStatement preparedStatement = con.prepareStatement(insert_sql1)) {
                preparedStatement.setString(1, String.valueOf(item.getId()));
                preparedStatement.setString(2, item.getItem_name());
                preparedStatement.setString(3, item.getCategory());
                preparedStatement.setString(4, item.getExpiry().toString());
                preparedStatement.setString(5, String.valueOf(item.getBuy_price()));
                preparedStatement.setString(6, String.valueOf(item.getSel_price()));
                preparedStatement.setString(7, String.valueOf(item.getQuantity()));
                preparedStatement.setString(8, String.valueOf(item.gross_total));
                preparedStatement.execute();


                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Product Added Successfully", ButtonType.OK);
            } catch (SQLException e) {
                printSQLException(e);
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error " + e, ButtonType.OK);

            }


        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}

