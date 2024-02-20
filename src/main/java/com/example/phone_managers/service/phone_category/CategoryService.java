package com.example.phone_managers.service.phone_category;

import com.example.phone_managers.config.ConnectionJDBC;
import com.example.phone_managers.model.PhoneCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements ICategoryService<PhoneCategory> {
    private static final String ADD_CATEGORY = "insert into phone_category(name) value(?);";
    private static final String FIND_PHONECATEGORY_BY_ID = "select * from phone_category where id=?";
    Connection connection = ConnectionJDBC.getConnection ();
    private final String SELECT_ALL_CATEGORY = "select * from phone_category";
    private final String UPDATE_PHONECATEGORY = "update phone_category set name=? where id=?";
    private final String REMOVE_PHONECATEGORY_BY_ID = "update phone_category set display=0 where id=?";
    public final  String SELECT_CATEGORY_BY_PHONE_ID = "select * from phone_category pc join phone p on pc.id = p.phone_categoryid where p.phone_categoryid = ?;";

    @Override
    public List<PhoneCategory> findAll() {
        List<PhoneCategory> phoneCategories = new ArrayList<> ();
        try {
            PreparedStatement statement = connection.prepareStatement (SELECT_ALL_CATEGORY);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()){
                int id = resultSet.getInt ("id");
                String name = resultSet.getString ("name");
                int display = resultSet.getInt ("display");
                phoneCategories.add (new PhoneCategory (id,name,display));
            }
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return phoneCategories;
    }

    @Override
    public void add(PhoneCategory phoneCategory) {
        try {
            PreparedStatement statement = connection.prepareStatement(ADD_CATEGORY);
            statement.setString(1,phoneCategory.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PhoneCategory findById(int id) {
        PhoneCategory phoneCategory = null;
        try{
            PreparedStatement statement = connection.prepareStatement (FIND_PHONECATEGORY_BY_ID);
            statement.setInt (1,id);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()) {
                String name = resultSet.getString ("name");
                phoneCategory = new PhoneCategory (name);
            }
        }catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return phoneCategory;
    }

    @Override
    public void update(int id, PhoneCategory phoneCategory) {
        try {
            PreparedStatement statement = connection.prepareStatement (UPDATE_PHONECATEGORY);
            statement.setString (1,phoneCategory.getName ());
            statement.setInt (2,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement =connection.prepareStatement (REMOVE_PHONECATEGORY_BY_ID);
            statement.setInt (1,id);
            statement.executeUpdate ();
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    public String findCategoryById(int phone_id) {
        String category = "";
        try {
            PreparedStatement statement = connection.prepareStatement (SELECT_CATEGORY_BY_PHONE_ID);
            statement.setInt (1,phone_id);
            ResultSet resultSet = statement.executeQuery ();
            while (resultSet.next ()){
                category = resultSet.getString ("name");
            }
        } catch (SQLException e) {
            throw new RuntimeException (e);
        }
        return category;
    }
}
