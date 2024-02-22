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
            case "create":
                showFormCreate(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                deletePhone (req,resp);
                break;
            default:
                listPhone(req,resp);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt (req.getParameter ("id"));
        Phone phone = phoneService.findById (id);
        RequestDispatcher dispatcher;
        if (phone == null){
            dispatcher = req.getRequestDispatcher ("/");
        }else {
            req.setAttribute ("phone",phone);
            req.setAttribute ("categorys",categoryService.findAll ());
            dispatcher = req.getRequestDispatcher ("phone/delete.jsp");
        }
        try {
            dispatcher.forward (req,resp);
        } catch (ServletException e) {
            throw new RuntimeException (e);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }

    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
    int id = Integer.parseInt (req.getParameter ("id"));
    Phone phone = phoneService.findById (id);
    RequestDispatcher dispatcher;
    if (phone == null){
        dispatcher = req.getRequestDispatcher ("error-404.jsp");
    }else {
        req.setAttribute ("phone",phone);
        req.setAttribute ("categorys",categoryService.findAll ());
        dispatcher = req.getRequestDispatcher ("phone/edit.jsp");
    }
        try {
            dispatcher.forward (req,resp);
        } catch (ServletException e) {
            throw new RuntimeException (e);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }

    private void listPhone(HttpServletRequest req, HttpServletResponse resp) {
    List<Phone> phoneList = phoneService.findAll ();
    req.setAttribute ("phoneList",phoneList);
    req.setAttribute ("categorys",categoryService.findAll ());
        RequestDispatcher dispatcher = req.getRequestDispatcher ("phone/index.jsp");
        try {
            dispatcher.forward (req,resp);
        } catch (ServletException e) {
            throw new RuntimeException (e);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("phone/create.jsp");
        req.setAttribute("category",categoryService.findAll ());
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter ("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createNewPhone(req,resp);
                break;
            case "edit":
                updatePhone(req,resp);
                break;
            case "delete":
                deletePhone(req,resp);
                break;
            default:
                listPhone(req,resp);
                break;
        }
    }

    private void deletePhone(HttpServletRequest req, HttpServletResponse resp) {
    int id = Integer.parseInt (req.getParameter ("id"));
    Phone phone =phoneService.findById (id);
    RequestDispatcher requestDispatcher;
    if (phone == null){
        requestDispatcher =req.getRequestDispatcher ("/");
    }else {
        phoneService.delete (id);
        try {
            resp.sendRedirect ("/phone");
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
        }
    }

    private void updatePhone(HttpServletRequest req, HttpServletResponse resp) {
    int id = Integer.parseInt (req.getParameter ("id"));
    String name = req.getParameter ("name");
    int price = Integer.parseInt (req.getParameter ("price"));
    int phoneCategoryId = Integer.parseInt (req.getParameter ("category"));
    String description = req.getParameter ("description");
    Phone phone = phoneService.findById (id);
    RequestDispatcher dispatcher;
    if (phone == null){
        dispatcher = req.getRequestDispatcher ("/");
    }else {
        phone.setName (name);
        phone.setPrice (price);
        phone.setPhoneCategoryId (phoneCategoryId);
        phone.setDescription (description);
        phoneService.update (id,phone);
        try {
            resp.sendRedirect ("/phone");
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }

    }

    private void createNewPhone(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        String description = req.getParameter("description");
        int categoryId = Integer.parseInt(req.getParameter("category"));
        Phone phone = new Phone(name,price,categoryId,description);
        phoneService.add(phone);
        try {
            resp.sendRedirect ("/phone");
        } catch (IOException e) {
            throw new RuntimeException (e);
        }

    }
}
