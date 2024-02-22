package com.example.phone_managers.controller;

import com.example.phone_managers.model.Phone;
import com.example.phone_managers.model.User;
import com.example.phone_managers.service.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    UserService userService = new UserService ();
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
                deleteUser (req,resp);
                break;
            default:
                listUser(req,resp);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt (req.getParameter ("id"));
        User user = userService.findById (id);
        RequestDispatcher dispatcher;
        if (user == null){
            dispatcher = req.getRequestDispatcher ("/");
        }else {
            req.setAttribute ("user",user);
            dispatcher = req.getRequestDispatcher ("user/delete.jsp");
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
        User user = userService.findById (id);
        RequestDispatcher dispatcher;
        if (user == null){
            dispatcher = req.getRequestDispatcher ("/");
        }else {
            req.setAttribute ("user",user);
            dispatcher = req.getRequestDispatcher ("user/edit.jsp");
        }
        try {
            dispatcher.forward (req,resp);
        } catch (ServletException e) {
            throw new RuntimeException (e);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) {
        List<User> userList = userService.findAll ();
        req.setAttribute ("userList",userList);
        RequestDispatcher dispatcher = req.getRequestDispatcher ("user/index.jsp");
        try {
            dispatcher.forward (req,resp);
        } catch (ServletException e) {
            throw new RuntimeException (e);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }
    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("user/create.jsp");
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
                createNewUser(req,resp);
                break;
            case "edit":
                updateUser(req,resp);
                break;
            case "delete":
                deleteUser(req,resp);
                break;
            default:
                listUser(req,resp);
                break;
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt (req.getParameter ("id"));
        User user = userService.findById (id);
        RequestDispatcher requestDispatcher;
        if (user == null){
            requestDispatcher =req.getRequestDispatcher ("/");
        }else {
            userService.delete (id);
        try {
            resp.sendRedirect ("/user");
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
        }
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt (req.getParameter ("id"));
        String name = req.getParameter ("name");
        int phoneNumber = Integer.parseInt (req.getParameter ("phoneNumber"));
        String address = req.getParameter ("address");
        User user = userService.findById (id);
        RequestDispatcher dispatcher;
        if (user == null){
            dispatcher = req.getRequestDispatcher ("/");
        }else {
            user.setName (name);
            user.setPhoneNumber (phoneNumber);
            user.setAddress (address);
            userService.update (id,user);
            try {
                resp.sendRedirect ("/user");
            } catch (IOException e) {
                throw new RuntimeException (e);
            }
        }

    }

    private void createNewUser(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter ("name");
        int phoneNumber = Integer.parseInt (req.getParameter ("phoneNumber"));
        String address = req.getParameter ("address");
        User user = new User (name,phoneNumber,address);
        userService.add(user);
        try {
            resp.sendRedirect ("/user");
        } catch (IOException e) {
            throw new RuntimeException (e);
        }

    }
}
