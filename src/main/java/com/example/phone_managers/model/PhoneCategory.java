package com.example.phone_managers.model;

public class PhoneCategory {
    private int id;
    private String name;
    private int display;

    public PhoneCategory() {
    }

    public PhoneCategory(String name) {
        this.name = name;
    }

    public PhoneCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PhoneCategory(String name, int display) {
        this.name = name;
        this.display = display;
    }

    public PhoneCategory(int id, String name, int display) {
        this.id = id;
        this.name = name;
        this.display = display;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
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
