<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

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
	Registration
	</h1>
	<form action="registration" method="post" id="registration-form">
			<p align=center>
				Login:<br>
				<input type="text" name="login">
			</p>
			<br>
			<p align=center>
				User password:<br>
				<input type="password" name="password">
			</p>
			<p align=center>
				Name:<br>
				<input type="text" name="name">
			</p>
			<br><br>
			<p align=center>
				<input type="submit" value="Submit">
			</p>
			<c:forEach var="error" items="${error}">
			${error.defaultMessage}<br>
			</c:forEach>
			<br><br>
		</form>

</body>
</html>