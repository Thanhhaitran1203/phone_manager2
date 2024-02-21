package com.example.phone_managers.model;

import com.example.phone_managers.service.order.OrderDetailService;
import com.example.phone_managers.service.phone.PhoneService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private int userId;
    private LocalDate date;
    private int display;
    PhoneService phoneService = new PhoneService ();
    OrderDetailService orderDetailService = new OrderDetailService ();

    public Order() {
    }

    public Order(int id, int userId, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.date = date;
    }

    public Order(int id, int userId, LocalDate date, int display) {
        this.id = id;
        this.userId = userId;
        this.date = date;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public int getTotalProduct(int id){
        int total = 0;
        List<Phone> phoneList = phoneService.findAll ();
        List<OrderDetail> orderDetails = orderDetailService.findOrderDetailByOrderId (id);
        for (OrderDetail o : orderDetails) {
            for (Phone p : phoneList) {
                if (o.getPhoneId () == p.getId ()){
                    total += (o.getQuantity ()*p.getPrice ());
                }
            }
        }
        return total;
    }
}
