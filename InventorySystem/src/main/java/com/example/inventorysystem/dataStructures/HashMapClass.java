package com.example.inventorysystem.dataStructures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class HashMapClass {
    public HashMapClass(){}



    public ObservableList<Map<Integer,Object>> addVendor(ObservableList<Map<Integer,Object>> vendors,Integer id, Object vendor){
        Map<Integer, Object> vm = new HashMap<>();
        vm.put(id,vendor);
        vendors.add(vm);
        return vendors;


    }

}
