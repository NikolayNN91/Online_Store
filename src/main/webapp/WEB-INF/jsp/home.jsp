<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="head.jsp" %>
	<h1>
	    Home
	</h1>

    <c:forEach items="${productList}" var="product">
        <a href="/product?id=${product.id}">${product.type}</a>
        <br>
        ${product.price}
        <br><br>
    </c:forEach>


</body>
</html>