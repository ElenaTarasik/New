<%--
  Created by IntelliJ IDEA.
  User: Paragvai
  Date: 25.09.2017
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>ORDERING_FORM</title>
    <script src="/resources/js/leftMenu.js"></script>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <script src="/resources/js/productPage.js"></script>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>
<div class="loginField">
    <p><h1>Ваш заказ</h1></p>

    <table border="2px solid #BC8F8F;"  width="90%">



        <c:forEach items="${basketOrder}" var="basketProduct">



    <c:forEach items="${quantity}" var="item">
        <c:if test="${basketProduct.id eq item.key}">



        <tr>
            <td>Артикул</td>
            <td>Наименование товара</td>
            <td>Количество</td>
            <td>Цена за ед.</td>
            <td>Общая цена</td>
        </tr>
        <tr>
            <td>00${basketProduct.id}</td>
            <td>${basketProduct.name}</td>
            <td>${item.value}</td>
            <td>${basketProduct.price}</td>
            <td>${basketProduct.price*item.value}</td>
        </tr>

        </c:if>

    </c:forEach>

</c:forEach>
    </table>
<form action="addOrder" method="get" >
    <p><button >Сделать покупку</button></p>
   <p><span class="delMess">${basketMessage}</span></p>
</form>

</div>
<%--<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>--%>
</body>
</html>
