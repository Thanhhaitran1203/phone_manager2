package com.example.phone_managers.model;

public class Phone {
    private int id;
    private  String name;
    private int price;
    private String img;
    private int phoneCategoryId;
    private String description;

    public Phone() {
    }

    public Phone(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Phone(String name, int price, int phoneCategoryId, String description) {
        this.name = name;
        this.price = price;
        this.phoneCategoryId = phoneCategoryId;
        this.description = description;
    }

    public Phone(int id, String name, int price, String img, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.description = description;
    }

    public Phone(int id, String name, int price, String img, int phoneCategoryId, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.phoneCategoryId = phoneCategoryId;
        this.description = description;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPhoneCategoryId() {
        return phoneCategoryId;
    }

    public void setPhoneCategoryId(int phoneCategoryId) {
        this.phoneCategoryId = phoneCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
