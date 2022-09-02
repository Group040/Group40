package com.example.inventorysystem;

import java.time.LocalDate;

public class Dry extends Item{

    public Dry(){
        super();
    }
    public int dry_id;
    public String description;

    public Dry( int code, String item_name, String category, LocalDate expiry, int buy_price, int sel_price, int quantity, int gross_total, int dry_id, String description) {
        super( code, item_name, category, expiry, buy_price, sel_price, quantity, gross_total);

        this.dry_id = dry_id;
        this.description  = description;
    }

    public int getDry_id() {
        return dry_id;
    }

    public void setDry_id(int dry_id) {
        this.dry_id = dry_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
