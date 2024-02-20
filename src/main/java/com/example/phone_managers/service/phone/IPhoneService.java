package com.example.phone_managers.service.phone;

import java.util.List;

public interface IPhoneService<T> {
    List<T> findAll();
    void add(T t,int categoryId);
    T findById(int id);
    void update(int id,T t);

    void delete(int id);
}
