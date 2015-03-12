<%-- 
    Document   : listaProductos
    Created on : 11-mar-2015, 21:02:20
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de productos</title>
    </head>
    <body>
        <div class="container">
            <h1>Lista de productos</h1>
            <a href="cartsController?accion=listarCarrito" class="btn btn-success">ver mi carrito</a>
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
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${productos}" var = "producto">
                            <tr>
                                <td><c:out value="${producto.getProduct_id()}"/></td>
                                <td><c:out value="${producto.getProduct_code()}"/></td>
                                <td><c:out value="${producto.getProduct_name()}"/></td>
                                <td><c:out value="${producto.getPrice()}"/></td>
                                <td><input type="number" name="cantidad" min="1"></td>
                                <td><a type="submit" class="btn btn-success">Añadir al carrito</a></td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
