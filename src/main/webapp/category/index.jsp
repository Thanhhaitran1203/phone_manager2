<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/02/2024
  Time: 01:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Category list</h1>
<a href="/category?action=create">Create new category</a>
<table border="1px">
    <tr>
        <td>Name</td>
        <td></td>
        <td></td>
    </tr>
    <c:forEach items='${requestScope["phoneCategoryList"]}' var="category">
        <c:if test="${category.getDisplay() == 1}">
            <tr>
                <td>${category.getName()}</td>
                <td><a href="/category?action=edit&id=${category.getId()}">Edit</a></td>
                <td><a href="/category?action=delete&id=${category.getId()}">Delete</a></td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>
