package com.example.phone_managers.controller;

import com.example.phone_managers.model.Order;
import com.example.phone_managers.model.Phone;
import com.example.phone_managers.model.User;
import com.example.phone_managers.service.order.OrderDetailService;
import com.example.phone_managers.service.order.OrderService;
import com.example.phone_managers.service.phone.PhoneService;
import com.example.phone_managers.service.user.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderServlet extends HttpServlet {
    OrderService orderService = new OrderService ();
    UserService userService = new UserService ();
    OrderDetailService orderDetailService = new OrderDetailService ();
    PhoneService phoneService = new PhoneService ();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter ("action");
        if (action == null){
            action = "";
        }
        switch (action){
//            case "create":
//                showFormCreate(req,resp);
//                break;
//            case "edit":
//                showEditForm(req,resp);
//                break;
//            case "delete":
//                showDeleteForm (req,resp);
            case "view":
                showView(req,resp);
                break;
            default:
                listOrder(req,resp);
                break;
        }
    }

    private void showView(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt (req.getParameter ("id"));
        RequestDispatcher dispatcher = req.getRequestDispatcher ("order/view.jsp");
        Order order = orderService.findById (id);
        req.setAttribute ("order",order);
        req.setAttribute ("user",userService.findById (order.getUserId ()));
        req.setAttribute ("phoneList",phoneService.findAll());
        req.setAttribute ("orderDetail",orderDetailService.findOrderDetailByOrderId (id));
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
//            case "create":
//                createNewOrder(req,resp);
//                break;
//            case "edit":
//                updateOrder(req,resp);
//                break;
//            case "delete":
//                deleteOrder(req,resp);
//                break;
            default:
                listOrder(req,resp);
                break;
        }
    }

    private void listOrder(HttpServletRequest req, HttpServletResponse resp) {
        List<Order> orderList = orderService.findAll ();
        req.setAttribute ("orderList",orderList);
        req.setAttribute ("userList",userService.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher ("order/index.jsp");
        try {
            dispatcher.forward (req,resp);
        } catch (ServletException e) {
            throw new RuntimeException (e);
        } catch (IOException e) {
            throw new RuntimeException (e);
        }

    }
}
