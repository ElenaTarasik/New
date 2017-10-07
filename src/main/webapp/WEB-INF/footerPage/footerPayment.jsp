<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INFO</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/index.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/footer.css"/>
    <script src="/resources/js/jquery-3.2.1.js"></script>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>
<div class="startField">
<div id="payment">
    <H2>Способы оплаты</H2>
    <p>Оплатить заказ вы можете следующими способами:</p>
    <p>1. Наличными в пункте самовывоза</p>
    <p>2. Наличными курьеру в случае доставки</p>
    <p>3. Банковской картой</p>
</div>
</div>
<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>
</body>
</html>


