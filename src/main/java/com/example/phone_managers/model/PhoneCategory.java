package com.example.phone_managers.model;

public class PhoneCategory {
    private int id;
    private String name;

    public PhoneCategory() {
    }

    public PhoneCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
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
}
