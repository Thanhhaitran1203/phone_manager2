<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/02/2024
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<h1>Edit user</h1>
<form method="post">
  <input type="text" name="name" placeholder="name" value="${requestScope["user"].getName()}">
  <input type="text" name="phoneNumber" placeholder="Phone number" value="${requestScope["user"].getPhoneNumber()}">
  <input type="text" name="address" placeholder="address" value="${requestScope["user"].getAddress()}">
  <input value="submit" type="submit">
</form>
</body>
</html>
