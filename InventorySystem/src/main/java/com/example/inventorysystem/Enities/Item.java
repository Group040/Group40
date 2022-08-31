package com.example.inventorysystem.Enities;

import java.util.Date;

public class Item {
    public int id;
    public int code;
    public String item_name;
    public Category Cagetroy;
    public Date expiry;
    public int buy_price;
    public int sel_price;
    public int quantity;
    public int gross_total;

    public Item(int id, int code, String item_name, Category cagetroy, Date expiry, int buy_price, int sel_price, int quantity, int gross_total) {
        this.id = id;
        this.code = code;
        this.item_name = item_name;
        Cagetroy = cagetroy;
        this.expiry = expiry;
        this.buy_price = buy_price;
        this.sel_price = sel_price;
        this.quantity = quantity;
        this.gross_total = gross_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Category getCagetroy() {
        return Cagetroy;
    }

    public void setCagetroy(Category cagetroy) {
        Cagetroy = cagetroy;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public int getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(int buy_price) {
        this.buy_price = buy_price;
    }

    public int getSel_price() {
        return sel_price;
    }

    public void setSel_price(int sel_price) {
        this.sel_price = sel_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getGross_total() {
        return gross_total;
    }

    public void setGross_total(int gross_total) {
        this.gross_total = gross_total;
    }
}
