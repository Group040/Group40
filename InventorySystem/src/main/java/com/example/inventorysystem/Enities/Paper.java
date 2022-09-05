package com.example.inventorysystem.Enities;

import java.time.LocalDate;

public class Paper extends Item{

    public Paper(){
        super();
    }

    public int paper_id;
    public String description;
    public Paper( int code, String item_name, String category, LocalDate expiry, int buy_price, int sel_price, int quantity, int gross_total, int paper_id, String description ) {
        super( code, item_name, category, expiry, buy_price, sel_price, quantity, gross_total);

        this.paper_id = paper_id;
        this.description = description;
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
