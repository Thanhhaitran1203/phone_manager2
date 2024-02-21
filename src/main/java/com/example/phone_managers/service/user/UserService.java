package com.example.phone_managers.service.user;

import com.example.phone_managers.config.ConnectionJDBC;
import com.example.phone_managers.model.Phone;
import com.example.phone_managers.model.User;
import com.example.phone_managers.service.IService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IService<User>{
    Connection connection = ConnectionJDBC.getConnection ();
    private final String SELECT_ALL_USER = "select * from user";
    private final String FIND_USER_BY_ID = "select * from user where id=?";
    private final String REMOVE_USER_BY_ID = "update user set display=0 where id=?";
    private static final String UPDATE_USER = "update user set name=?, phone_number=?, address=? where id=?";
    public static final String ADD_USER = "insert into user(name,phone_number,address) values (?,?,?)";

    @Override
    public List<User> findAll() {
    List<User> users = new ArrayList<> ();
        try {
            PreparedStatement statement = connection.prepareStatement (SELECT_ALL_USER);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()){
                int id = resultSet.getInt ("id");
                String name = resultSet.getString ("name");
                int phoneNumber = resultSet.getInt ("phone_number");
                String address = resultSet.getString ("address");
                int display = resultSet.getInt ("display");
                users.add (new User (id,name,phoneNumber,address,display));
            }

        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return users;
    }

    @Override
    public void add(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_USER);
            statement.setString(1,user.getName());
            statement.setInt(2,user.getPhoneNumber ());
            statement.setString (3,user.getAddress ());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(int id) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement (FIND_USER_BY_ID);
            statement.setInt (1,id);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()){
                String name = resultSet.getString ("name");
                int phoneNumber = resultSet.getInt ("phone_number");
                String address = resultSet.getString ("address");
                user = new User (id,name,phoneNumber,address);
            }
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return user;
    }

    @Override
    public void update(int id, User user) {
        try {
            PreparedStatement statement = connection.prepareStatement (UPDATE_USER);
            statement.setString (1,user.getName ());
            statement.setInt (2,user.getPhoneNumber ());
            statement.setString (3,user.getAddress ());
            statement.setInt (4,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement (REMOVE_USER_BY_ID);
            statement.setInt (1,id);
            statement.executeUpdate ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }
}
