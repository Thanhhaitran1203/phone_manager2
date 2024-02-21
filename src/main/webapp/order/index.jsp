<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/02/2024
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Order Manager</title>
</head>
<body>
    <h1>Order Manager</h1>
    <a href="/order?action=create">Create new order</a>
    <table border="1px">
        <tr>
            <td>User</td>
            <td>Date</td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items='${requestScope["orderList"]}' var="order">
            <c:if test="${order.getDisplay() == 1}">
                <tr>
                <td>
                    <c:forEach items='${requestScope["userList"]}' var="user">
                        <c:if test="${order.getUserId() == user.getId()}">
                            <a href="/order?action=view&id=${order.getId()}">${user.getName()}</a>
                        </c:if>
                    </c:forEach>
                </td>
                    <td><a href="/order?action=view&id=${order.getId()}">${order.getDate()}</a></td>
                    <td><a href="/order?action=view&id=${order.getId()}">${order.getTotalProduct(order.getId())}</a></td>
                <td><a href="/order?action=edit&id=${order.getId()}">Edit</a></td>
                <td><a href="/order?action=delete&id=${order.getId()}">Delete</a></td>
                </tr>
            </c:if>

        </c:forEach>
    </table>
</body>
</html>
