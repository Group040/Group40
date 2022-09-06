package com.example.inventorysystem.Entities;

public class Users {
    private int id;
    private String name;
    private String email;
    private String contact;
    private String role;
    private String username;
    private String password;

    public Users(String name, String email,String contact, String role, String username, String password) {
        this.name = name;
        this.contact = contact;
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Users(){}

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
