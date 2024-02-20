<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/02/2024
  Time: 00:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1>Delete phone</h1>
<form method="post">
  <input type="text" name="name" placeholder="name" value="${requestScope["phone"].getName()}">
  <input type="text" name="price" placeholder="price" value="${requestScope["phone"].getPrice()}">
  <%--    <input type="text" name="img" placeholder="image">--%>
  <input type="text" name="description" placeholder="description" value="${requestScope["phone"].getDescription()}">
  <select name="category" id="category">
    <c:forEach items="${categorys}" var="c">
      <option value="${c.id}">${c.name}</option>
    </c:forEach>
  </select>
  <input value="submit" type="submit">
</form>
</body>
</html>
