<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</p>
<h3 class="error">
    <span>${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>
</h3>
</div>
</body>
</html>
