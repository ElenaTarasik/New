<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PRODUCT_PAGE</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/productDescription.css"/>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>
<div class="oneProduct">
<div class="productName">${product.name}</div>
<table class="descriptionTable">
    <tr>
        <td><img class="productImg" src="${product.pictureLink}" width="400" height="480"/></td>
        <td style="text-align: left">
            <b>Артикул:</b> 00${product.id}<br>
            <b>Описание: </b>${product.description}<br>
            <b>Производитель: </b>${product.maker}<br>
        </td>
    </tr>
    <tr>
        <td style="font-weight: bold">Цена: ${product.price} руб.</td>
        <td><button><a href="  " >Добавить в корзину</a></button></td>
    </tr>
</table>
</div>
</body>
</html>
