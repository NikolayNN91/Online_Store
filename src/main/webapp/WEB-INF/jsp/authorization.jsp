<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="head.jsp"%>
        <div class=title id="ff">
			<h1>Введите логин и пароль для авторизации, либо пройдите регистрацию нажав по кнопке "Регистрация"</h1>
		</div>

		<form:form modelAttribute="user" method="post" action="authorization">
            <fieldset>
                <div align=center>
                    Login:<br>
                    <form:input path="login" placeholder="Введите логин"/><br>
                    ${loginMessage}
                </div><br>

                <div align=center>
                    Password:<br>
                    <form:input path="password" placeholder="Введите пароль"/><br>
                    ${passwordMessage}
                </div><br><br>

                <div align=center>
                    <form:button id="auth">Submit</form:button>
                </div>
            </fieldset>

            <div align=center>
                ${error}
            </div>
		</form:form>

		<a class=bot  href="/registration">Регистрация</a><br/>
		<input type="button" onclick="alert('Нажмите по ссылке!')" value="Регистрация">
</body>
</html>