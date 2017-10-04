<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HEADER</title>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <script src="/resources/js/topNavigation.js"></script>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/topNavigation.css"/>
</head>
<body>
<div class="topNavigation">

<ul_top>
    <li_top> <a href="/index" style="font-style: italic; font-weight: bold; color: #FFD700"> BigRoiWear  </a> приветствует Вас!
        Хотите <a href="/user/login"> войти </a> или </li_top>
    <li_top><a href="/user/registration">зарегистрироваться</a>?</li_top>
    <li_top style="float:right"><a href=""><image src="" width=30 height=15 /></a></li_top>
    <li_top style="float:right"> <a href="/basket/basket">Корзина</a> </li_top>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
      <li_top style="float:right"> <a class="adminLink" href="/admin/admin">Личный кабинет администратора</a> </li_top>
    </sec:authorize>
</ul_top>

<ul_bottom>
    <li_bottom class="dropdown" id="man_winter">
        <span class="coll"><spring:message code="man_winter"/></span>
        <div class="dropdown-content">
            <span bdcat="outerwear" class="cat"><spring:message code="outerwear"/></span>
            <span bdcat="hats_scarves" class="cat"><spring:message code="hats_scarves"/></span>
            <span bdcat="sweaters" class="cat"><spring:message code="sweaters"/></span>
            <span bdcat="pants" class="cat"><spring:message code="pants"/></span>
        </div>
    </li_bottom>
    <li_bottom class="dropdown" id="man_summer">
        <span class="coll"><spring:message code="man_summer"/></span>
        <div class="dropdown-content">
            <span bdcat="outerwear" class="cat"><spring:message code="outerwear"/></span>
            <span bdcat="shirts" class="cat"><spring:message code="shirts"/></span>
            <span bdcat="singlet" class="cat"><spring:message code="singlet"/></span>
            <span bdcat="pants_shorts" class="cat"><spring:message code="pants_shorts"/></span>
        </div>
    </li_bottom>
    <li_bottom class="dropdown" id="woman_winter">
        <span class="coll"><spring:message code="woman_winter"/></span>
        <div class="dropdown-content">
            <span bdcat="outerwear" class="cat"><spring:message code="outerwear"/></span>
            <span bdcat="hats_scarves" class="cat"><spring:message code="hats_scarves"/></span>
            <span bdcat="sweaters" class="cat"><spring:message code="sweaters"/></span>
            <span bdcat="pants" class="cat"><spring:message code="pants"/></span>
            <span bdcat="dresses_skirts" class="cat"><spring:message code="dresses_skirts"/></span>
        </div>
    </li_bottom>
    <li_bottom class="dropdown" id="woman_summer">
        <span class="coll"><spring:message code="woman_summer"/></span>
        <div class="dropdown-content">
            <span bdcat="outerwear" class="cat"><spring:message code="outerwear"/></span>
            <span bdcat="shirts" class="cat"><spring:message code="shirts"/></span>
            <span bdcat="singlet" class="cat"><spring:message code="singlet"/></span>
            <span bdcat="pants" class="cat"><spring:message code="pants"/></span>
            <span bdcat="skirts_shorts" class="cat"><spring:message code="skirts_shorts"/></span>
            <span bdcat="dresses" class="cat"><spring:message code="dresses"/></span>
        </div>
    </li_bottom>
</ul_bottom>
</div>
</body>
</html>
