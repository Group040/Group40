package com.example.inventorysystem.dataStructures;

import com.example.inventorysystem.Database.DBCon;
import com.example.inventorysystem.Entities.Item;
import com.example.inventorysystem.Entities.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HashMapClass {
    public HashMapClass(){}



    public static   HashMap<Integer,Users> addVendor(int id,
            String name,
            String email,
            String contact,
            String role,
            String username,
            String password)
    {
        Users vendor = new Users();
        vendor.setId(id);
        vendor.setName(name);
        vendor.setRole(role);
        vendor.setContact(contact);
        vendor.setUsername(username);
        vendor.setPassword(password);
        vendor.setEmail(email);

        HashMap<Integer, Users> newVendor = new HashMap<>();
        newVendor.put(id,vendor);



        return newVendor;


    }


    public static void createVendor(HashMap<Integer, Users> vendor, Integer id) throws SQLException {

        String itsql = "INSERT INTO `users`(`id`, `name`, `email`, `contact`, `role`, `username`, `password`) VALUES (?,?,?,?,?,?,?,?,?)";

        ResultSet resultSet = null;

        try {
            // try-with-resource statement will auto close the connection.
            // Step 1: Establishing a Connection and

            Connection connection = DBCon.getConnection();
            PreparedStatement itemStatement = connection.prepareStatement(itsql);

            itemStatement.setInt(1, vendor.get(id).getId());
            itemStatement.setString(2, vendor.get(id).getName());
            itemStatement.setString(3, vendor.get(id).getEmail());
            itemStatement.setString(4, vendor.get(id).getContact());
            itemStatement.setString(5, vendor.get(id).getRole());
            itemStatement.setString(6, vendor.get(id).getUsername());
            itemStatement.setString(7,vendor.get(id).getPassword());

            System.out.println(itemStatement);

            itemStatement.execute();



            // Step 3: Execute the query or update query


            Alert alert = new Alert(Alert.AlertType.INFORMATION, "User Added Successfully", ButtonType.OK);
            alert.show();
        } catch (SQLException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR, "Error " + e, ButtonType.OK);
            alert.show();

        }


    }



    public static ObservableList<Users> getAllUsers(){

            Connection connection = null;
            PreparedStatement statement = null;

            String selectsql = "SELECT `id`, `name`, `email`, `contact`, `role`, `username`, `password` FROM `users` WHERE 1";
            int counter = 1;

            ObservableList<Users> usersI = null;
            try {
                usersI = FXCollections.observableArrayList();

                connection = DBCon.getConnection();
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(selectsql);
                ResultSet resultSet = statement.executeQuery();
                System.out.println(resultSet);
                System.out.println(selectsql);

                while (resultSet.next()) {

                    Users users = new Users();
                    users.setId(resultSet.getInt(1));
                    users.setName(resultSet.getString(2));
                    users.setEmail(resultSet.getString(3));
                    users.setContact(resultSet.getString(4));
                    users.setRole(resultSet.getString(5));
                    users.setUsername(resultSet.getString(6));
                    users.setPassword(resultSet.getString(7));
                    usersI.add(users);

                }
            } catch (SQLException ex) {

                Alert alert = new Alert(Alert.AlertType.ERROR, "Error occurred during sql injection");
                alert.show();
            }
            return usersI;
        }




}
