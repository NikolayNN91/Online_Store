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
		<li><a href="/product_change">Add products</a></li>
		<li><a href="/product_update">Change products</a></li>
		<li><a href="/orders">Orders</a></li>
		<li><a href="/authorization">Authorization</a></li>
		<li><a href="/home">Home</a></li>
	</ul>
	<h1>
Change products or add products
	</h1>

	<form method="POST" action="add">
        <fieldset>
            <div align=center>
                Наименование продукта:<br>
                <input type="text" name="type" placeholder="Введите наименование продукта"/><br>
            </div><br>
            <div align=center>
                Цена:<br>
                <input type="text" name="type" placeholder="Введите стоимость продукта"/><br>
            </div><br>
            <div align=center>
                Количество на складе:<br>
                <input type="text" name="type" placeholder="Введите количество продукта"/><br>
            </div><br>
            <div align=center>
                Производитель:<br>
                <input type="text" name="type" placeholder="Введите производителя продукта"/><br>
            </div><br>
            <div align=center>
                Описание:<br>
                <input type="text" name="type" placeholder="Введите описание продукта"/><br>
            </div><br>

            <div align=center>
                <button id="add">Add product</button>
            </div>

        </fieldset>

    </form>


</body>
</html>