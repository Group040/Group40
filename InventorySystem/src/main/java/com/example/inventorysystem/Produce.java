package com.example.inventorysystem;

import java.time.LocalDate;

public class Produce extends Item{

    public Produce(){
        super();
    }
    public int produce_id;
    public String description;


    public Produce(int code, String item_name, String category, LocalDate expiry, int buy_price, int sel_price, int quantity, int gross_total, int produce_id, String description) {
        super(code, item_name, category, expiry, buy_price, sel_price, quantity, gross_total);

        this.produce_id = produce_id;
        this.description = description;
    }

    public int getProduce_id() {
        return produce_id;
    }

    public void setProduce_id(int produce_id) {
        this.produce_id = produce_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
