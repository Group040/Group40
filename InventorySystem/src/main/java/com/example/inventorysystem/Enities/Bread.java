package com.example.inventorysystem.Enities;

import java.util.Date;

public class Bread extends Item{
    private int bread_id;
    private String description;

    public Bread(int id, int code, String item_name, Category cagetroy, Date expiry, int buy_price, int sel_price, int quantity, int gross_total, int bread_id, String description) {
        super(id, code, item_name, cagetroy, expiry, buy_price, sel_price, quantity, gross_total);

        this.bread_id = id;
        this.description = description;
    }

    public int getBread_id() {
        return bread_id;
    }

    public void setBread_id(int bread_id) {
        this.bread_id = bread_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
