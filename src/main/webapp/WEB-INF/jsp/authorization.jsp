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
        <div class=title id="ff">
			<h1>Введите логин и пароль для авторизации, либо пройдите регистрацию нажав по кнопке "Регистрация"</h1>
		</div>

		<form method="POST" action="authorization">
            <fieldset>
                <div align=center>
                    Login:<br>
                    <input type="text" name="username" placeholder="Введите логин"/><br>
                </div><br>

                <div align=center>
                    Password:<br>
                    <input type="password" name="password" placeholder="Введите пароль"/><br>
                </div><br><br>

                <div align=center>
                    <button id="auth">Submit</button>
                </div>
            </fieldset>

            <div align=center>
                ${error}
            </div>
		</form><br><br>

        <form method="POST" action="logout">
                <div align=center>
                    <button id="logout">LogOut</button>
                </div>
        </form>
</body>
</html>