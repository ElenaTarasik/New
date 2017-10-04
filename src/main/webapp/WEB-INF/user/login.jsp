<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>LOGIN_FORM</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>
<div class="loginField">
<p><h1>Вход</h1></p>
<h3>Заполните, пожалуйста, поля формы:</h3>
<p>
<form action="/j_spring_security_check" method="POST">
    <h4>
   Электронный адрес:<br>
      <input type="text" name="j_username" /><br><br>
   Пароль:<br>
      <input type="password" name="j_password"/><br><br>
      <input type="submit" value="Вход"/>
    </h4>
</form>
    <sec:authorize access="hasRole('ROLE_USER')">
        <button><a class="secureLink" href="/user/secure/">Сменить пароль</a></button>
        <button><a href="/logout">Выход</a></button>
    </sec:authorize>
</p>
<h3 class="error">
    <span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
</h3>
</div>
<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>
</body>
</html>
