package com.example.phone_managers.service.order;

import com.example.phone_managers.config.ConnectionJDBC;
import com.example.phone_managers.model.OrderDetail;
import com.example.phone_managers.model.Phone;
import com.example.phone_managers.service.IService;
import com.example.phone_managers.service.phone_category.CategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailService implements IService<OrderDetail> {
    private static final String UPDATE_ORDER_DETAIL = "update order_detail set order_id=?, phone_id=?, quantity=? where id=?";
    public static final String ADD_ORDER_DETAIL = "insert into order_detail(order_id,phone_id,quantity) values (?,?,?)";
    private static final String SELECT_ORDER_DETAIL_BY_ORDER_ID = "select * from order_detail where order_id=?";
    Connection connection = ConnectionJDBC.getConnection ();
    private final String SELECT_ALL_ORDER_DETAIL = "select * from order_detail";
    private final String FIND_ORDER_DETAIL_BY_ID = "select * from order_detail where id=?";
    private final String REMOVE_ORDER_DETAIL_BY_ID = "delete from order_detail where id=?";

    @Override
    public List<OrderDetail> findAll() {
        List<OrderDetail> orderDetails = new ArrayList<> ();
        try {
            PreparedStatement statement = connection.prepareStatement (SELECT_ALL_ORDER_DETAIL);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()){
                int id = resultSet.getInt ("id");
                int orderId = resultSet.getInt ("order_id");
                int phoneId = resultSet.getInt ("phone_id");
                int quantity = resultSet.getInt ("quantity");
                orderDetails.add (new OrderDetail (id,orderId,phoneId,quantity));
            }

        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return orderDetails;
    }

    @Override
    public void add(OrderDetail orderDetail) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_ORDER_DETAIL);
            statement.setInt(1,orderDetail.getOrderId ());
            statement.setInt(2,orderDetail.getPhoneId ());
            statement.setInt(3,orderDetail.getQuantity ());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrderDetail findById(int id) {
        OrderDetail orderDetail = null;
        try {
            PreparedStatement statement = connection.prepareStatement (FIND_ORDER_DETAIL_BY_ID);
            statement.setInt (1,id);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()){
                int orderId = resultSet.getInt ("order_id");
                int phoneId = resultSet.getInt ("phone_id");
                int quantity = resultSet.getInt ("quantity");
                orderDetail =  new OrderDetail (id,orderId,phoneId,quantity);
            }
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return orderDetail;
    }

    @Override
    public void update(int id, OrderDetail orderDetail) {
        try {
            PreparedStatement statement = connection.prepareStatement (UPDATE_ORDER_DETAIL);
            statement.setInt(1,orderDetail.getOrderId ());
            statement.setInt(2,orderDetail.getPhoneId ());
            statement.setInt(3,orderDetail.getQuantity ());
            statement.setInt (4,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement =connection.prepareStatement (REMOVE_ORDER_DETAIL_BY_ID);
            statement.setInt (1,id);
            statement.executeUpdate ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }
    public List<OrderDetail> findOrderDetailByOrderId(int id){
        List<OrderDetail> orderDetails = new ArrayList<> ();
        try {
            PreparedStatement statement = connection.prepareStatement (SELECT_ORDER_DETAIL_BY_ORDER_ID);
            statement.setInt (1,id);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()){
                int orderId = resultSet.getInt ("order_id");
                int phoneId = resultSet.getInt ("phone_id");
                int quantity = resultSet.getInt ("quantity");
                orderDetails.add (new OrderDetail (id,orderId,phoneId,quantity));
            }

        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return orderDetails;
    }
}
