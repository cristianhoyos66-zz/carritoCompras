<%-- 
    Document   : listaProductos
    Created on : 11-mar-2015, 21:02:20
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="">
    <head>
         <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de productos</title>
    </head>
    <body>
        <div class="container">
            <h1>Lista de productos</h1>
            <a href="cartsController?accion=listarCarrito&email=${email}" class="btn btn-success">ver mi carrito</a>
            <br><br>
            <div class="panel panel-default">
                <div class="panel-heading">Lista de productos</div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Código de producto</th>
                            <th>Nombre de producto</th>
                            <th>Precio</th>
                            <th>Cantidad</th>
                            <th>Total</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${productos}" var = "producto">
                            <tr  ng-init="cantidad${producto.getProduct_id()}=0">
                                <td><c:out value="${producto.getProduct_id()}"/></td>
                                <td><c:out value="${producto.getProduct_code()}"/></td>
                                <td><c:out value="${producto.getProduct_name()}"/></td>
                                <td><c:out value="${producto.getPrice()}"/></td>
                                <td>{{cantidad${producto.getProduct_id()}*${producto.getPrice()}}}</td>
                                <td><input ng-model="cantidad${producto.getProduct_id()}" type="number" name="cantidad" min="0"></td>
                                <td><a href="cartsController?accion=guardarCarrito&email=${email}&id_product=${producto.getProduct_id()}&price=${producto.getPrice()}&total={{cantidad${producto.getProduct_id()}*${producto.getPrice()}}}" type="submit" class="btn btn-success">Añadir al carrito</a></td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
