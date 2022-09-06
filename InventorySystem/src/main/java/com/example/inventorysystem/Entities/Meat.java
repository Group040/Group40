package com.example.inventorysystem.Entities;

import java.time.LocalDate;

public class Meat extends Item{

    public Meat(){
        super();
    }

    public int meat_id;
    public String description;


    public Meat( int code, String item_name, String category, LocalDate expiry, int buy_price, int sel_price, int quantity, int gross_total, int meat_id, String description) {
        super(code, item_name, category, expiry, buy_price, sel_price, quantity, gross_total);

        this.meat_id= meat_id;
        this.description = description;
    }

    public int getMeat_id() {
        return meat_id;
    }

    public void setMeat_id(int meat_id) {
        this.meat_id = meat_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
