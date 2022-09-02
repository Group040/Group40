package com.example.inventorysystem;

import java.time.LocalDate;

public class Diary extends Item{

    public Diary(){
        super();
    }
    public int diary_id;
    public String description;
    public Diary(int code, String item_name, String category, LocalDate expiry, int buy_price, int sel_price, int quantity, int gross_total, int diary_id, String description) {
        super( code, item_name, category, expiry, buy_price, sel_price, quantity, gross_total);

        this.diary_id = diary_id;
        this.description = description;
    }

    public int getDiary_id() {
        return diary_id;
    }

    public void setDiary_id(int diary_id) {
        this.diary_id = diary_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
