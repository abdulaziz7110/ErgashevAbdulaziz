<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.2.0/css/bootstrap.min.css">
</head>
<body>

    <div class="container text-center">
        <h1> Product </h1>
    <a href="/products/get-form">Add product</a>

            <div class="col-md-6 offset-3">

              <table class="table">

                  <thead>

                  <th scope="col">#</th>
                  <th scope="col">name</th>
                  <th scope="col">price</th>
                  <th scope="col">category</th>
                  <th scope="col">maker</th>
                  <th scope="col">action</th>


                  </thead>
                  <tbody>

                  <c:forEach items="${productList}" var="product" varStatus="loop">

                      <th>${loop.index+1}</th>
                      <td>${product.name}</td>
                      <td>${product.price}</td>
                      <td>${product.category.name}</td>
                      <td>${product.maker.name}</td>
                      <td>
                          <a href="/products/edit/${product.id}" class="btn btn-warning">Edit</a>
                          <a href="/products/delete/${product.id}" class="btn btn-warning">Delete</a>
                      </td>
                  </c:forEach>



                  </tbody>


              </table>

            </div>
        </div>


</body>
</html>