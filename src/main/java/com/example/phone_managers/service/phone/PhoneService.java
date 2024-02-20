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

public class PhoneService implements IPhoneService{
    Connection connection = ConnectionJDBC.getConnection ();
    ICategoryService categoryService = new CategoryService ();
    private final String SELECT_ALL_PHONE = "select * from phone";


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
                String phoneCategory = categoryService.findCategoryById (phoneCategoryId);
                phoneList.add (new Phone (id,name,price,img,phoneCategory,description));
            }

        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    return phoneList;
    }

    @Override
    public void add(Object o, int categoryId) {

    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Object o) {

    }

    @Override
    public void delete(int id) {

    }
}
