package com.example.inventorysystem;

import java.time.LocalDate;

public class Cleaners extends Item{

    public Cleaners(){
        super();
    }
    public int cleaners_id;
    public String description;
    public Cleaners(int id, int code, String item_name, String category, LocalDate expiry, int buy_price, int sel_price, int quantity, int gross_total, int cleaners_id, String description) {
        super(id, code, item_name, category, expiry, buy_price, sel_price, quantity, gross_total);

        this.cleaners_id = cleaners_id;
        this.description = description;

    }

    public int getCleaners_id() {
        return cleaners_id;
    }

    public void setCleaners_id(int cleaners_id) {
        this.cleaners_id = cleaners_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
