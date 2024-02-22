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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<nav class="navbar  navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">LOGO</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/phone">Phone</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/category">Category</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/order">Order</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/user">User</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div>
    <div class="md:flex md:items-center md:justify-between">
        <div class="flex-1 min-w-0">
            <h2 style="margin-left: 10px" class="text-2xl font-bold leading-7 text-gray-900 sm:text-3xl sm:truncate">Category List</h2>
        </div>
    </div>

    <div class="grid grid-cols-3 gap-6">

        <div class="col-span-3 xl:col-span-2">
            <div class="md:flex md:items-center md:justify-between">
            </div>

            <div class="mt-6 flex flex-col">
                <div class="-my-2 overflow-x-auto -mx-4 sm:-mx-6 lg:-mx-8">
                    <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
                        <div class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
                            <a style="margin-left: 10px" href="/category?action=create" >Create new category</a>
                            <table class="min-w-full divide-y divide-gray-200">
                                <thead class="bg-gray-50">
                                <tr>
                                    <th scope="col" class="px-4 sm:px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Name</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items='${requestScope["phoneCategoryList"]}' var="category">
                                    <c:if test="${category.getDisplay() == 1}">
                                        <tr class="odd:bg-white even:bg-gray-100">
                                            <td class="px-4 sm:px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">${category.getName()}</td>
                                            <td class="px-4 sm:px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"><a href="/category?action=edit&id=${category.getId()}" class="hover:text-indigo-500">Edit</a></td>
                                            <td class="px-4 sm:px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"><a href="/category?action=delete&id=${category.getId()}" class="hover:text-indigo-500">Delete</a></td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-span-3 xl:col-span-1">

        </div>
    </div>
</div>

<%--<h1>Category list</h1>--%>
<%--<a href="/category?action=create">Create new category</a>--%>
<%--<table border="1px">--%>
<%--    <tr>--%>
<%--        <td>Name</td>--%>
<%--        <td></td>--%>
<%--        <td></td>--%>
<%--    </tr>--%>
<%--    <c:forEach items='${requestScope["phoneCategoryList"]}' var="category">--%>
<%--        <c:if test="${category.getDisplay() == 1}">--%>
<%--            <tr>--%>
<%--                <td>${category.getName()}</td>--%>
<%--                <td><a href="/category?action=edit&id=${category.getId()}">Edit</a></td>--%>
<%--                <td><a href="/category?action=delete&id=${category.getId()}">Delete</a></td>--%>
<%--            </tr>--%>
<%--        </c:if>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
</body>
</html>
