package com.example.inventorysystem.Enities;

import java.util.Date;

public class Diary extends Item{
    public int diary_id;
    public String description;
    public Diary(int id, int code, String item_name, Category cagetroy, Date expiry, int buy_price, int sel_price, int quantity, int gross_total, int diary_id, String description) {
        super(id, code, item_name, cagetroy, expiry, buy_price, sel_price, quantity, gross_total);
    }
}
