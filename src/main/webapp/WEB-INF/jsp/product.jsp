<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width='device-width', initial-scale='1'"/>
        <link href="/css/home.css" rel="stylesheet"/>
        <title>Hotel</title>
    </head>
    <body>

        <div class='head' style='list-style-type:none'>
            <h1>Type:${product.getType()}</h1>
        </div>
        <br>
        <img src="https://hyperpc.ru/images/product/gaming-notebook/extreme/asus/rog_g703vi/main/laptop-detail-asus-rog-g703vi.jpg" alt="Foto of product" width="270" height="200" />
        <br>
        <p>Price: ${product.getPrice()} $;</p>
        <p>Manufacturer: ${product.getManufacturer()};</p>
        <p>Amount on stock: ${product.getAmountOfProduct()};</p>

    </body>
</html>