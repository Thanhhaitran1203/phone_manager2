package com.example.phone_managers.model;

import java.util.Date;

public class Order {
    private int id;
    private int userId;
    private Date date;

    public Order() {
    }

    public Order(int id, int userId, Date date) {
        this.id = id;
        this.userId = userId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
