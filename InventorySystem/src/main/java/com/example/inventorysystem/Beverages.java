package com.example.inventorysystem;

import java.time.LocalDate;

public class Beverages extends Item {
    public int beverage_id;
    public String description;


    public Beverages(){
        super();
    }
    public Beverages( int code, String item_name, String category, LocalDate expiry, int buy_price, int sel_price, int quantity, int gross_total, int beverage_id, String description) {
        super( code, item_name, category, expiry, buy_price, sel_price, quantity, gross_total);
        this.beverage_id = beverage_id;
        this.description = description;
    }

    public int getBeverage_id() {
        return beverage_id;
    }

    public void setBeverage_id(int beverage_id) {
        this.beverage_id = beverage_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
