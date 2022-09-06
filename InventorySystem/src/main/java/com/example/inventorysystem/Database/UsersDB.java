package com.example.inventorysystem.Database;

import com.example.inventorysystem.Entities.Users;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;

public class UsersDB {


    public void insertUser(Users users){

        String itsql = "INSERT INTO `users`(`id`, `name`, `email`, `contact`, `role`, `username`, `password`) VALUES (?,?,?,?,?,?,?)";

        try {
            // try-with-resource statement will auto close the connection.
            // Step 1: Establishing a Connection and

            Connection connection = DBCon.getConnection();
            PreparedStatement itemStatement = connection.prepareStatement(itsql);


            itemStatement.setInt(1, users.getId());
            itemStatement.setString(2, users.getName());
            itemStatement.setString(3, users.getEmail());
            itemStatement.setString(4, users.getContact());
            itemStatement.setString(5, users.getRole());
            itemStatement.setString(6, users.getUsername());
            itemStatement.setString(7, users.getPassword());

            System.out.println(itemStatement);

            itemStatement.execute();





            Alert alert = new Alert(Alert.AlertType.INFORMATION, "UserAdded Added Successfully", ButtonType.OK);
            alert.show();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error " + e, ButtonType.OK);
            alert.show();

        }
    }




    // User login
    public static boolean loginUser(String username, String password,String role){
        String sql = "SELECT  `role`, `username`, `password` FROM users WHERE role = ? and email = ? and password = ? ";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, role);
            preparedStatement.setString(2, username);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                Alert alert = new Alert(Alert.AlertType.ERROR, "Enter Correct Email and Password\", \"Failed", ButtonType.OK);
                alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login Successfull\", \"Success\"", ButtonType.OK);
                alert.show();
                return true;

            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}