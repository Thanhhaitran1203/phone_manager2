package com.example.phone_managers.controller;

import com.example.phone_managers.model.Phone;
import com.example.phone_managers.service.phone.PhoneService;
import com.example.phone_managers.service.phone_category.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhoneServlet", value = "/phone")
public class PhoneServlet extends HttpServlet {
    private PhoneService phoneService = new PhoneService ();
    private CategoryService categoryService = new CategoryService ();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter ("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                listPhone(req,resp);
                break;
        }
    }

    private void listPhone(HttpServletRequest req, HttpServletResponse resp) {
    List<Phone> phoneList = phoneService.findAll ();
    req.setAttribute ("phoneList",phoneList);
        RequestDispatcher dispatcher = req.getRequestDispatcher ("phone/index.jsp");
        try {
            dispatcher.forward (req,resp);
        } catch (ServletException e) {
            throw new RuntimeException (e);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter ("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                listPhone(req,resp);
                break;
        }
    }
}
