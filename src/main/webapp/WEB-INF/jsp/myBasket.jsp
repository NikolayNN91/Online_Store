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
		<li><a href="/home">Home</a></li>
        <li><a href="/myBasket">My Basket</a></li>
        <li><a href="/contacts">Contacts</a></li>
		<li><a href="/registration">Registration</a></li>
		<li><a href="/authorization">Authorization</a></li>
		<li><a href="/admin">Administration</a></li>
	</ul>
    <h1>
        My Basket
    </h1>
    <div align=center>
        ${successMessage}
    </div>
    <c:forEach items="${productList}" var="product">
        <a href="/product?id=${product.id}">Name: ${product.type}</a><br>
                                            Price: ${product.price} <br>
                                            Manufacturer: ${product.manufacturer}<br>
    </c:forEach><br>

    <div align=center>
        ${errorMessage}
    </div>
    <div>
        <form method="POST" action="myBasket/pay">
            <fieldset>
                 <input type="hidden" value="${productList}" name="productList" />
                 <input type="hidden" value="${user}" name="user" />
                <div align=center>
                    <button id="pay">Оплатить</button>
                </div>
            </fieldset>
        </form>
    </div>


</body>
</html>