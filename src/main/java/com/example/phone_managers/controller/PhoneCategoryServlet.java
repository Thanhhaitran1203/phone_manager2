package com.example.phone_managers.controller;

import com.example.phone_managers.model.Phone;
import com.example.phone_managers.model.PhoneCategory;
import com.example.phone_managers.service.phone_category.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category")
public class PhoneCategoryServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryService ();
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
                deleteCategory (req,resp);
                break;
            default:
                listPhoneCategory(req,resp);
                break;
        }
    }
    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt (req.getParameter ("id"));
        PhoneCategory phoneCategory = categoryService.findById (id);
        RequestDispatcher dispatcher;
        if (phoneCategory == null){
            dispatcher = req.getRequestDispatcher ("/");
        }else {
            req.setAttribute ("phoneCategory",phoneCategory);
            dispatcher = req.getRequestDispatcher ("category/delete.jsp");
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
        PhoneCategory phoneCategory = categoryService.findById (id);
        RequestDispatcher dispatcher;
        if (phoneCategory == null){
            dispatcher = req.getRequestDispatcher ("/");
        }else {
            req.setAttribute ("phoneCategory",phoneCategory);
            dispatcher = req.getRequestDispatcher ("category/edit.jsp");
        }
        try {
            dispatcher.forward (req,resp);
        } catch (ServletException e) {
            throw new RuntimeException (e);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("category/create.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void listPhoneCategory(HttpServletRequest req, HttpServletResponse resp) {
        List<PhoneCategory> phoneCategoryList = categoryService.findAll ();
        req.setAttribute ("phoneCategoryList",phoneCategoryList);
        RequestDispatcher dispatcher = req.getRequestDispatcher ("category/index.jsp");
        try {
            dispatcher.forward (req,resp);
        } catch (ServletException e) {
            throw new RuntimeException (e);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter ("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createCategory(req,resp);
                break;
            case "edit":
                updateCategory(req,resp);
                break;
            case "delete":
                deleteCategory(req,resp);
                break;
            default:
                listPhoneCategory(req,resp);
                break;
        }
    }
    private void deleteCategory(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt (req.getParameter ("id"));
        PhoneCategory phoneCategory = categoryService.findById (id);
        RequestDispatcher requestDispatcher;
        if (phoneCategory == null){
            requestDispatcher =req.getRequestDispatcher ("/");
        }else {
            categoryService.delete (id);
            try {
                resp.sendRedirect ("/category");
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
    private void updateCategory(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt (req.getParameter ("id"));
        String name = req.getParameter ("name");
        PhoneCategory phoneCategory = categoryService.findById (id);
        RequestDispatcher dispatcher;
        if (phoneCategory == null) {
            dispatcher = req.getRequestDispatcher ("/");
        } else {
            phoneCategory.setName (name);
            categoryService.update (id, phoneCategory);
            try {
                resp.sendRedirect ("/category");
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }
    }
    private void createCategory(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        PhoneCategory phoneCategory = new PhoneCategory (name);
        categoryService.add(phoneCategory);
        try {
            resp.sendRedirect ("/category");
        } catch (IOException e) {
            throw new RuntimeException (e);
        }

    }
}
