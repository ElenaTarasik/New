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
    <li_top> Здравствуйте! Хотите <a href="/user/login"> войти </a> или </li_top>
    <li_top><a href="/user/registration">зарегистрироваться</a>?</li_top>
    <li_top style="float:right"><a href=""><image src="" width=30 height=15 /></a></li_top>
    <li_top style="float:right"> <a href="">Корзина</a> </li_top>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
      <li_top style="float:right"> <a class="adminLink" href="/admin/admin">Личный кабинет администратора</a> </li_top>
    </sec:authorize>
</ul_top>

<ul_bottom>
    <li_bottom class="dropdown" id="man_winter">
        <span class="coll">Мужская коллекция осень-зима</span>
        <div class="dropdown-content">
            <span bdcat="outerwear" class="cat">Верхняя одежда</span>
            <span bdcat="hats_scarves" class="cat">Шапки Шарфы</span>
            <span bdcat="sweaters" class="cat">Свитера Кофты</span>
            <span bdcat="pants" class="cat">Брюки Джинсы</span>
        </div>
    </li_bottom>
    <li_bottom class="dropdown" id="man_summer">
        <span class="coll">Мужская коллекция весна-лето</span>
        <div class="dropdown-content">
            <span bdcat="outerwear" class="cat">Верхняя одежда</span>
            <span bdcat="shirts" class="cat">Рубашки</span>
            <span bdcat="singlet" class="cat">Майки Футболки</span>
            <span bdcat="pants_shorts" class="cat">Брюки Джинсы Шорты</span>
        </div>
    </li_bottom>
    <li_bottom class="dropdown" id="woman_winter">
        <span class="coll">Женская коллекция осень-зима</span>
        <div class="dropdown-content">
            <span bdcat="outerwear" class="cat">Верхняя одежда</span>
            <span bdcat="hats_scarves" class="cat">Шапки Шарфы</span>
            <span bdcat="sweaters" class="cat">Свитера Кофты</span>
            <span bdcat="pants" class="cat">Брюки Джинсы</span>
            <span bdcat="dresses_skirts" class="cat">Платья Юбки</span>
        </div>
    </li_bottom>
    <li_bottom class="dropdown" id="woman_summer">
        <span class="coll">Женская коллекция весна-лето</span>
        <div class="dropdown-content">
            <span bdcat="outerwear" class="cat">Верхняя одежда</span>
            <span bdcat="shirts" class="cat">Рубашки</span>
            <span bdcat="singlet" class="cat">Майки Футболки</span>
            <span bdcat="pants" class="cat">Брюки Джинсы</span>
            <span bdcat="skirts_shorts" class="cat">Юбки Шорты</span>
            <span bdcat="dresses" class="cat">Платья</span>
        </div>
    </li_bottom>
</ul_bottom>
</div>
</body>
</html>
