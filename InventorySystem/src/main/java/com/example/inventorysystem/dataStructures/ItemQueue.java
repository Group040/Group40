package com.example.inventorysystem.dataStructures;

import com.example.inventorysystem.Entities.Item;
import com.example.inventorysystem.productManagement.ProductServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class ItemQueue {

    public ItemQueue(){

    }
    public ObservableList<Item> enqueue(ObservableList<Item> queue, Item object){

        queue.add(object);
        return queue;
    }

    // Creating a list of items in stack
    public ObservableList<Item> printQueue(ObservableList<Item> objects){
        // List to contain items
        ObservableList<Item> items = FXCollections.observableArrayList();
        for(int i =0; i< objects.size(); i++){

            Item peek = objects.get(0);
            items.add(peek);
            objects.remove(peek);
            ProductServices.removeItem(peek);

        }
        return items;
    }

    public ObservableList<Item> dequeue(ObservableList<Item> objects) {
        Item fistItem = null;
        if (objects.size() < 4) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Low Stalk");
            alert.show();
        } else {
            fistItem = objects.get(0);
            ProductServices.removeItem(fistItem);
            objects.remove(fistItem);
            return objects;

        }
        return objects;
    }


    public boolean isEmpty(ObservableList<Item> objects){

        if(objects.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }

}
