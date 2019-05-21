<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="head.jsp"%>
        <div class=title id="ff">
			<h1>Введите логин и пароль для авторизации, либо пройдите регистрацию нажав по кнопке "Регистрация"</h1>
		</div>

		<form method="POST" action="authorization">
            <fieldset>
                <div align=center>
                    Login:<br>
                    <input type="text" name="username" placeholder="Введите логин"/><br>

                    ${loginMessage}
                </div><br>

                <div align=center>
                    Password:<br>
                    <input type="password" name="password" placeholder="Введите пароль"/><br>

                    ${passwordMessage}
                </div><br><br>

                <div align=center>
                    <button id="auth">Submit</button>
                </div>
            </fieldset>

            <div align=center>
                ${error}
            </div>
		</form>

		<a class=bot  href="/registration">Регистрация</a><br/>
		<input type="button" onclick="alert('Нажмите по ссылке!')" value="Регистрация">
</body>
</html>