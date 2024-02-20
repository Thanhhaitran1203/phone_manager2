<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 20/02/2024
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create phone</title>
</head>
<body>
<h1>Create phone</h1>
<form method="post">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="price" placeholder="price">
<%--    <input type="text" name="img" placeholder="image">--%>
    <input type="text" name="description" placeholder="description">
    <select name="category" id="category">
        <c:forEach items="${category}" var="c">
            <option value="${c.id}">${c.name}</option>
        </c:forEach>
    </select>
    <input value="submit" type="submit">
</form>
</body>
</html>
