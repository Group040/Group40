package com.example.inventorysystem.Enities;

import java.time.LocalDate;
import java.util.Date;


public class Item {
    public int id;
    public int code;
    public String item_name;
    public String category;
    public LocalDate expiry;
    public int buy_price;
    public int sel_price;
    public int quantity;
    public int gross_total;
    public String remove;


    public Item() {

    }

    public Item( int code, String item_name, String category, LocalDate expiry, int buy_price, int sel_price, int quantity, int gross_total) {
        this.code = code;
        this.item_name = item_name;
        this.category = category;
        this.expiry = expiry;
        this.buy_price = buy_price;
        this.sel_price = sel_price;
        this.quantity = quantity;
        this.gross_total = gross_total;
        this.remove = "Remove";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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


    public LocalDate getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDate expiry) {
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
