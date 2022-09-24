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


        <div class="input-group">
            <label>
                <input hidden name="name" value="${id}">
            </label>
        </div>

        <label for="price">Price</label>
        <input type="number" name="price" id="price">

        <label for="description">Description</label>
        <input type="text" name="description" id="description">


        <input type="text">
    </div>
</body>
</html>
