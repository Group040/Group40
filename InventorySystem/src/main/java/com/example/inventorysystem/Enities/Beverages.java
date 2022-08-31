package com.example.inventorysystem.Enities;

import java.util.Date;

public class Beverages extends Item {
    public int beverage_id;
    public String description;

    public Beverages(int id, int code, String item_name, Category cagetroy, Date expiry, int buy_price, int sel_price, int quantity, int gross_total, int beverage_id, String description) {
        super(id, code, item_name, cagetroy, expiry, buy_price, sel_price, quantity, gross_total);
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
