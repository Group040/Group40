package com.example.inventorysystem.Database;
import com.example.inventorysystem.Enities.Item;
import com.example.inventorysystem.productManagement.ProductsController;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;
import java.util.logging.Logger;



public class ProductsDB {
    private static final Logger logger = Logger.getLogger(ProductsController.class.getName());
    // Inserting Into a Category

    ProductsDB(){

    }
    public static void createProduct(Item item, String cate, int id, String description ) throws SQLException {

        String itsql = "INSERT INTO `item`(`id`, `code`, `item_name`, `category`, `expiry`, `buy_price`, `sel_price`, `quantity`, `gross_total`) VALUES (?,?,?,?,?,?,?,?,?)";
        String bvsal = "INSERT INTO `"+cate+"`(`id`, `description`) VALUES (?,?)";
//        String brsql = "INSERT INTO `bread`(`id`, `description`) VALUES (?,?)";
//        String clsqll = "INSERT INTO `cleaners`(`id`, `description`) VALUES (?,?)";
//        String disql = "INSERT INTO `diary`(`id`, `description`) VALUES (?,?)";
//        String drysql = "INSERT INTO `dry`(`id`, `description`) VALUES (?,?)";
//        String mesql = "INSERT INTO `meat`(`id`, `description`) VALUES (?,?)";


        ResultSet resultSet = null;

        try {
            // try-with-resource statement will auto close the connection.
            // Step 1: Establishing a Connection and

            Connection connection = DBCon.getConnection();
            PreparedStatement itemStatement = connection.prepareStatement(itsql);
            PreparedStatement catStatement  = connection.prepareStatement(bvsal);


            itemStatement.setInt(1, item.getId());
            itemStatement.setInt(2, item.getCode());
            itemStatement.setString(3, item.getItem_name());
            itemStatement.setString(4, item.getCategory());
            itemStatement.setDate(5, Date.valueOf(item.getExpiry()));
            itemStatement.setInt(6, item.getBuy_price());
            itemStatement.setInt(7, item.getSel_price());
            itemStatement.setInt(8, item.getQuantity());
            itemStatement.setInt(9, item.getGross_total());

            catStatement.setInt(1,id);
            catStatement.setString(2,description);


            System.out.println(itemStatement);

            itemStatement.execute();
            catStatement.execute();



            // Step 3: Execute the query or update query


            Alert alert = new Alert(Alert.AlertType.INFORMATION, "ProductServices Added Successfully", ButtonType.OK);
            alert.show();
        } catch (SQLException e) {
            printSQLException(e);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error " + e, ButtonType.OK);

        }


    }



    public static void showProducts() throws SQLException {
        String selectsql = "SELECT * FROM `item`";


    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error occurred during sql injection");
                alert.show();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }

    }
}
