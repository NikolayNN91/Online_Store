<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        Registration
        </h1>

        <form:form method="POST" modelAttribute="user" action="registration">
            <fieldset>
                <div align=center>
                    Login:<br>
                    <form:input path="login" placeholder="Введите логин"/><br>
                    <form:errors path="login" /><br>
                </div>

                <div align=center>
                    User password:<br>
                    <form:input path="password" placeholder="Введите пароль"/><br>
                    <form:errors path="password" /><br>
                </div>

                <div align=center>
                    Name:<br>
                    <form:input path="name" placeholder="Введите никнейм"/><br>
                    <form:errors path="name" /><br>
                </div>

                <br>
                <div align=center>
                    <form:button id="add-user">Submit</form:button>
                </div>
            </fieldset>
            <br>

            <div align=center>
                ${errorMessage}
            </div>

        </form:form>

    </body>
</html>