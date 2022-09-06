package com.example.inventorysystem.dataStructures;

import com.example.inventorysystem.Entities.Item;
import com.example.inventorysystem.productManagement.ProductServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class ItemStack {


    public ItemStack(){

    }


    public ObservableList<Item> pushToStack(ObservableList<Item> stack, Item item){

        stack.add(item);
        System.out.println(item);
        return stack;
    }

    // Creating a list of items in stack
    public ObservableList<Item> printStack(ObservableList<Item> item){
        // List to contain items
        ObservableList<Item> items = FXCollections.observableArrayList();
        for(int i =0; i< item.size(); i++){

            Item peek = item.get(item.size()-1);
            items.add(peek);
            item.remove(peek);
        }
        return items;
    }

    public ObservableList<Item> popStack(ObservableList<Item> objects) {
        Item peek = null;
        if (objects.size() < 4) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Low Stalk");
            alert.show();
        } else {
            peek = objects.get(objects.size() - 1);
            ProductServices.removeItem(peek);
            objects.remove(peek);
            return objects;

        }
        return objects;
    }


    public boolean isEmpty(ObservableList<Item> objects) {

        if (objects.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
