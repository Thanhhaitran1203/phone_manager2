package com.example.phone_managers.model;

public class OrderDetail {
    private int id;
    private int orderId;
    private int phoneId;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int id, int orderId, int phoneId, int quantity) {
        this.id = id;
        this.orderId = orderId;
        this.phoneId = phoneId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
