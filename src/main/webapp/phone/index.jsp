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
    <title>Phone Store</title>
</head>
<body>
    <h1>Phone Store</h1>
    <a href="/phone?action=create">Create new phone</a>
    <table border="1px">
        <tr>
            <td>Name</td>
            <td>Price</td>
<%--            <td>Img</td>--%>
            <td>Phone Category</td>
            <td>Decriptiom</td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items='${requestScope["phoneList"]}' var="phone">
            <tr>
                <td>${phone.getName()}</td>
                <td>${phone.getPrice()}</td>
<%--                <td><img src="${phone.getImg}"></td>--%>
                <c:forEach items='${requestScope["categorys"]}' var="category">
                    <c:if test="${phone.getPhoneCategoryId() == category.getId()}">
                        <td>${category.getName()}</td>
                    </c:if>

                </c:forEach>
                <td>${phone.getDescription()}</td>
                <td><a href="/phone?action=edit&id=${phone.getId()}">Edit</a></td>
                <td><a href="/phone?action=delete&id=${phone.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
