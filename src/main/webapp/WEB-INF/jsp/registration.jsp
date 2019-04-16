<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
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

    <spring:form action="registration" method="post" modelAttribute="user">
        <fieldset>
            <p align=center>
                    Login:<br>
                    <spring:input path="User.login" placeholder="Введите логин"/>
                    <spring:errors path="User.login"/>
                </p>

                <br>

                <p align=center>
                    User password:<br>
                    <input type="password" name="password" placeholder="Введите пароль"/>
                </p>


                <p align=center>
                    Name:<br>
                    <input type="text" name="name" placeholder="Введите никнейм">
                </p>

                <br><br>
                <div align=center>
                    <input type="submit" value="Submit">
                </div>
			</fieldset>
            <br>
			<p align=center>
			${errorMessage}
			</p>



			<br><br>
		</spring:form>

</body>
</html>