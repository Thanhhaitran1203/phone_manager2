package com.example.phone_managers.service.phone;

import com.example.phone_managers.config.ConnectionJDBC;
import com.example.phone_managers.model.Phone;
import com.example.phone_managers.service.phone_category.CategoryService;
import com.example.phone_managers.service.phone_category.ICategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneService implements IPhoneService<Phone>{
    private static final String UPDATE_PHONE = "update phone set name=?, price=?, phone_categoryid=?, description=? where id=?";
    public static final String ADD_PHONE = "insert into phone(name,price,phone_categoryid,description) values (?,?,?,?)";
    Connection connection = ConnectionJDBC.getConnection ();
    ICategoryService categoryService = new CategoryService ();
    private final String SELECT_ALL_PHONE = "select * from phone";
    private final String FIND_PHONE_BY_ID = "select * from phone where id=?";
    private final String REMOVE_PHONE_BY_ID = "update phone set display=0 where id=?";


    @Override
    public List<Phone> findAll() {
        List<Phone> phoneList = new ArrayList<> ();
        try {
            PreparedStatement statement = connection.prepareStatement (SELECT_ALL_PHONE);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()){
                int id = resultSet.getInt ("id");
                String name = resultSet.getString ("name");
                int price = resultSet.getInt ("price");
                String img = resultSet.getString ("img");
                int phoneCategoryId = resultSet.getInt ("phone_categoryid");
                String description = resultSet.getString ("description");
                int display = resultSet.getInt ("display");
                phoneList.add (new Phone (id,name,price,img,phoneCategoryId,description,display));
            }

        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    return phoneList;
    }

    @Override
    public void add(Phone phone, int categoryId) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_PHONE);
            statement.setString(1,phone.getName());
            statement.setInt(2,phone.getPrice());
            statement.setInt(3,categoryId);
            statement.setString(4, phone.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Phone findById(int id) {
        Phone phone = null;
        try {
            PreparedStatement statement = connection.prepareStatement (FIND_PHONE_BY_ID);
            statement.setInt (1,id);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()){
                String name = resultSet.getString ("name");
                int price = resultSet.getInt ("price");
                String img = resultSet.getString ("img");
                int phoneCategoryId = resultSet.getInt ("phone_categoryid");
                String description = resultSet.getString ("description");
                phone = new Phone (id,name,price,img,phoneCategoryId,description);
            }
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return phone;
    }

    @Override
    public void update(int id, Phone phone) {
        try {
            PreparedStatement statement = connection.prepareStatement (UPDATE_PHONE);
            statement.setString (1,phone.getName ());
            statement.setInt (2,phone.getPrice ());
            statement.setInt (3,phone.getPhoneCategoryId ());
            statement.setString (4, phone.getDescription ());
            statement.setInt (5,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement =connection.prepareStatement (REMOVE_PHONE_BY_ID);
            statement.setInt (1,id);
            statement.executeUpdate ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }
}
