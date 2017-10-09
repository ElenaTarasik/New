<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>AUTHORIZED_USER_PAGE</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/admin.css"/>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <script src="/resources/js/admin.js"></script>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>
<%--<sec:authentication property="name" /><br>
<sec:authentication property="authorities"/><br>--%>
<div class="userField">
    <div class="adminMenu">
        <c:import url="/WEB-INF/blocks/userMenu.jsp"/>
    </div>
    <div class="mainField">
    <span class="head">Смена пароля</span><br>
    <div class="editForm">
       <form action="/secure/editUserPassword" method="get" modelAttribute="user">
            <span class="formLab">Введите старый пароль:</span>
            <input class="editForm" name="oldPass" type="password" required="true" placeholder="123AsKKl5"/><br>
            <span class="formLab">Введите новый пароль:</span>
            <input class="editForm" name="new1Pass" minlength="5" type="password" required="true" placeholder="123AsKKl5"/><br>
            <span class="formLab">Подтвердите новый пароль:</span>
            <input class="editForm" name="new2Pass" minlength="5" type="password" required="true" placeholder="123AsKKl5"/><br>
            <input name="login" type="hidden" value="<sec:authentication property="name"/>"/>
            <br><p><button type="submit">Сохранить новый пароль</button></p>
        </form>
    </div>
    <p><span class="delMess">${message}</span></p>
</div>
</div>
<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>
</body>
</html>