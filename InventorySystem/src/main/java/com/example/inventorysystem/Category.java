package com.example.inventorysystem;

public class Category {
    public int id;
    public String category_name;
    public String description;

    public Category(int id, String category_name, String description) {
        this.id = id;
        this.category_name = category_name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
