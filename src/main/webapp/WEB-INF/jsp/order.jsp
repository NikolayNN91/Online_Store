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
	    <li><a href="/admin/orders">Orders</a></li>
		<li><a href="/order/${order.getId()}">Order: ${order.getId()}</a></li>
	</ul>

	<h1>
        Order: ${order.getId()}
	</h1>

	<div>
        Price: ${order.getPrice()} <br>
        Date: ${order.getDate()} <br>
        User Login: ${order.getUser().getLogin()}
	</div>

	<form method="POST" action="order">
                <fieldset>
                    <input type="hidden" value="${order.getId()}" name="id" />
                    <div align=center>
                        <button id="closeOrder">Закрыть заказ</button>
                    </div>
                </fieldset>
    		</form>

</body>
</html>