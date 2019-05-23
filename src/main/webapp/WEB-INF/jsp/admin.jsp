<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width='device-width', initial-scale='1'"/>
        <link href="/css/home.css" rel="stylesheet"/>
        <title>Hotel</title>
    </head>
    <body>
        <ul class='list' style='list-style-type:none'>
            <li><a href="/admin">Administration</a></li>
            <li><a href="/admin/product_add">Add products</a></li>
            <li><a href="/admin/orders">Orders</a></li>
            <li><a href="/authorization">Authorization</a></li>
            <li><a href="/home">Home</a></li>
        </ul>

        <h1>
            ${hello}
        </h1>
        <br>
        <div>
            ${message}
        </div>

        <c:forEach items="${productList}" var="product">
            <a href="/product?id=${product.id}">${product.type}</a>
            <br>
            ${product.price}
            <br>
            <div>
                <form method="GET" action="admin/product_update">
                    <fieldset>
                         <input type="hidden" value="${product.getId()}" name="id" />

                        <div>
                            <button id="update">Изменить описание продукта</button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </c:forEach>
    </body>
</html>