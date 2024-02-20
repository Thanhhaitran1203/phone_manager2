<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/02/2024
  Time: 01:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1>Delete category</h1>
<form method="post">
    <input type="text" name="name" placeholder="name" value="${requestScope["phoneCategory"].getName()}">
    <input value="delete" type="submit">
</form>
</body>
</html>
