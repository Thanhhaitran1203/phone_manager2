package com.example.phone_managers.service.order;

import com.example.phone_managers.config.ConnectionJDBC;
import com.example.phone_managers.model.Order;
import com.example.phone_managers.model.OrderDetail;
import com.example.phone_managers.model.Phone;
import com.example.phone_managers.service.IService;
import com.example.phone_managers.service.phone.PhoneService;
import com.example.phone_managers.service.phone_category.CategoryService;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IService<Order>{
    Connection connection = ConnectionJDBC.getConnection ();

    private static final String UPDATE_ORDER = "update orders set user_id=?, date=? where id=?";
    public static final String ADD_ORDER = "insert into orders(user_id,date) values (?,?)";
    private final String SELECT_ALL_ORDER = "select * from orders";
    private final String FIND_ORDER_BY_ID = "select * from orders where id=?";
    private final String REMOVE_ORDER_BY_ID = "update orders set display=0 where id=?";

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<> ();
        try {
            PreparedStatement statement = connection.prepareStatement (SELECT_ALL_ORDER);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()){
                int id = resultSet.getInt ("id");
                int userId = resultSet.getInt ("user_id");
                LocalDate date = LocalDate.parse (resultSet.getString ("date"), DateTimeFormatter.ISO_DATE);
                int display = resultSet.getInt ("display");
                orderList.add (new Order (id,userId,date,display));
            }

        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return orderList;
    }

    @Override
    public void add(Order order) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_ORDER);
            statement.setInt(1,order.getUserId ());
            statement.setDate (2, Date.valueOf (order.getDate ()));
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order findById(int id) {
        Order order = null;
        try {
            PreparedStatement statement = connection.prepareStatement (FIND_ORDER_BY_ID);
            statement.setInt (1,id);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()){
                int userId = resultSet.getInt ("user_id");
                LocalDate date = LocalDate.parse (resultSet.getString ("date"), DateTimeFormatter.ISO_DATE);
                order = new Order (id,userId,date);
            }
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return order;
    }

    @Override
    public void update(int id, Order order) {
        try {
            PreparedStatement statement = connection.prepareStatement (UPDATE_ORDER);
            statement.setInt (1,order.getUserId ());
            statement.setDate (2, Date.valueOf (order.getDate ()));
            statement.setInt (3,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement =connection.prepareStatement (REMOVE_ORDER_BY_ID);
            statement.setInt (1,id);
            statement.executeUpdate ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }
}

