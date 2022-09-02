package com.example.inventorysystem;

import java.time.LocalDate;

public class Frozen extends Item{

    public Frozen(){
        super();
    }

    public int frozen_id;
    public String description;


    public Frozen(int id, int code, String item_name, String category, LocalDate expiry, int buy_price, int sel_price, int quantity, int gross_total, int frozen_id, String description) {
        super(id, code, item_name, category, expiry, buy_price, sel_price, quantity, gross_total);

        this.frozen_id = frozen_id;
        this.description = description;


    }

    public int getFrozen_id() {
        return frozen_id;
    }

    public void setFrozen_id(int frozen_id) {
        this.frozen_id = frozen_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
