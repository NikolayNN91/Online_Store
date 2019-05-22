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
		<li><a href="/admin/product_update">Change products</a></li>
		<li><a href="/admin/orders">Orders</a></li>
		<li><a href="/authorization">Authorization</a></li>
		<li><a href="/home">Home</a></li>
	</ul>

	<h1>
        Orders
	</h1>

	<c:forEach items="${orders}" var="order">
        <a href="/admin/order?id=${order.id}">${order.id}: Price: ${order.price} User login: ${order.getUser().getLogin()}</a>
        <br><br>
    </c:forEach>

</body>
</html>