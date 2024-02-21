<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/02/2024
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Order Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1>Order Detail</h1>
<div class="input-group input-group-sm mb-3">
    <span class="input-group-text" style="width: 8%">Name</span>
    <input type="text" name="name" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value='${user.getName()}'>
</div>
<div class="input-group input-group-sm mb-3">
    <span class="input-group-text" style="width: 8%">Phone Number</span>
    <input type="text" name="phoneNumber" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value='${user.getPhoneNumber()}'>
</div>
<div class="input-group input-group-sm mb-3">
    <span class="input-group-text" style="width: 8%">Phone Number</span>
    <input type="text" name="address" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value='${user.getAddress()}'>
</div>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Product</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${requestScope["orderDetail"]}' var="orderDetail">
    <tr>
        <c:forEach items='${requestScope["phoneList"]}' var="phone">
            <c:if test="${phone.getId() == orderDetail.getPhoneId()}">
                <td>${phone.getName()}</td>
                <td>${phone.getPrice()}</td>
            </c:if>
        </c:forEach>
        <td>${orderDetail.getQuantity()}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
