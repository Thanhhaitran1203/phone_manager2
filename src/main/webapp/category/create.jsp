<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 21/02/2024
  Time: 01:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
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
<body>
<h2 style="margin-left: 10px">Create category</h2>
<div>
    <form method="post">
        <div class="input-group input-group-sm mb-3">
            <span class="input-group-text" >Name</span>
            <input type="text" name="name" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
        </div>
        <input value="Submit" type="submit" class="btn btn-primary">
    </form>
</div>
<%--<form method="post">--%>
<%--    <input type="text" name="name" placeholder="name">--%>
<%--    <input value="submit" type="submit">--%>
<%--</form>--%>
</body>
</html>
