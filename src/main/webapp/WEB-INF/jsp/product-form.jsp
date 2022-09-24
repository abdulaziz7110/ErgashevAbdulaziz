<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 9/24/2022
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.2.0/css/bootstrap.min.css">
</head>
<body>
    <div class="text-center">


        <form action="/products" method="post">

            <input hidden name="name" value="${id}">
        <label for="price">Price</label>
        <input type="number" name="price" id="price">

        <label for="description">Description</label>
        <input type="text" name="description" id="description">

        <select name="categoryId" >
        <c:forEach items="${categoryList}" var="category">
            <option value="${category.id}" >${category.name}</option>
        </c:forEach>
        </select>


            <button type="submit">submit</button>

            <select name="categoryId">
                <c:forEach items="${makerList}" var="maker">
                    <option value="${maker.id} >${maker.name}</option>
                </c:forEach>
            </select>
        </form>
    </div>
</body>
</html>
