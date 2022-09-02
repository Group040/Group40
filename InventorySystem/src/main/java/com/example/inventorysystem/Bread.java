package com.example.inventorysystem;

import java.time.LocalDate;

public class Bread extends Item{
    private int bread_id;
    private String description;


    public Bread(){
        super();
    }
    public Bread( int code, String item_name, String category, LocalDate expiry, int buy_price, int sel_price, int quantity, int gross_total, int bread_id, String description) {
        super(code, item_name, category, expiry, buy_price, sel_price, quantity, gross_total);

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
