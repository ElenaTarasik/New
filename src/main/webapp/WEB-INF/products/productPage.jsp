<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PRODUCT_PAGE</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/productDescription.css"/>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <script src="/resources/js/productPage.js"></script>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>
<div class="oneProduct">
<div class="productName">${product.name}</div>
<table class="descriptionTable">
    <tr>
        <td><img class="productImg" src="/resources/image/${product.pictureLink}" width="400" height="480"/></td>
        <td style="text-align: left">
            <b>Артикул:</b> 00${product.id}<br>
            <b>Описание: </b>${product.description}<br>
            <b>Производитель: </b>${product.maker}<br>
        </td>
    </tr>
    <tr>
        <td style="font-weight: bold">Цена: ${product.price} руб.</td>
        <td><button class="addBasket" data-art=${product.id}>Добавить в корзину</button></td>
    </tr>
</table>
</div>
<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>
</body>
</html>
