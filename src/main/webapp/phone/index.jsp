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
    <table border="1px">
        <tr>
            <td>Name</td>
            <td>Price</td>
<%--            <td>Img</td>--%>
            <td>Phone Category</td>
            <td>Decriptiom</td>
        </tr>
        <c:forEach items='${requestScope["phoneList"]}' var="phone">
            <tr>
                <td>${phone.getName()}</td>
                <td>${phone.getPrice()}</td>
<%--                <td><img src="${phone.getImg}"></td>--%>
                <td>${phone.getPhoneCategory()}</td>
                <td>${phone.getDescription()}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
