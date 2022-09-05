package com.example.inventorysystem.dataStructures;

import com.example.inventorysystem.Enities.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        }
        return items;
    }

    public ObservableList<Item> dequeue(ObservableList<Item> objects){
        Item peek = objects.get(objects.size()-1);
        objects.remove(peek);
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
