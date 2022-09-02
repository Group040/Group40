package com.example.inventorysystem;

import java.time.LocalDate;

public class PersonalCare extends Item{

    public PersonalCare(){
        super();
    }
    public int personal_id;
    public String description;

    public PersonalCare(int code, String item_name, String category, LocalDate expiry, int buy_price, int sel_price, int quantity, int gross_total, int personal_id, String description) {
        super(code, item_name, category, expiry, buy_price, sel_price, quantity, gross_total);

        this.personal_id =personal_id;
        this.description = description;
    }

    public int getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(int personal_id) {
        this.personal_id = personal_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
