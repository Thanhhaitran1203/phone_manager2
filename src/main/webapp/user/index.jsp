<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/02/2024
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>User Manager</title>
</head>
<body>
<h1>User Manager</h1>
<a href="/user?action=create">Create new phone</a>
<table border="1px">
    <tr>
        <td>Name</td>
        <td>Phone number</td>
        <td>Address</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach items='${requestScope["userList"]}' var="user">
        <c:if test="${user.getDisplay() == 1}">
            <tr>
                <td>${user.getName()}</td>
                <td>${user.getPhoneNumber()}</td>
                <td>${user.getAddress()}</td>
                <td><a href="/user?action=edit&id=${user.getId()}">Edit</a></td>
                <td><a href="/user?action=delete&id=${user.getId()}">Delete</a></td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>

