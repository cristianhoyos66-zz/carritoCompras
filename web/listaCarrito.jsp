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
        <title>Carrito</title>
    </head>
    <body>
        <div class="container">
            <h1>Carrito</h1>
            <div class="panel panel-default">
                <div class="panel-heading">Lista de productos en el carrito</div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>email</th>
                            <th>id producto</th>
                            <th>Precio</th>
                            <th>Estado</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${carritos}" var = "carrito">
                            <tr>
                                <td><c:out value="${carrito.getId_cart()}"/></td>
                                <td><c:out value="${carrito.getUser_email()}"/></td>
                                <td><c:out value="${carrito.getId_product()}"/></td>
                                <td><c:out value="${carrito.getPrice()}"/></td>
                                <td><c:out value="${carrito.getStatus()}"/></td>
                                <td><a href="cartsController?accion=editarCarrito&id_cart=<c:out value="${carrito.getId_cart()}"/>" class="btn btn-success">Ejecutar compra</a></td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
