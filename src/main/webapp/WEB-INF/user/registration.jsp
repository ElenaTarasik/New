<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>REGISTRATION_FORM</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>
<div class="loginField">
<p><h1>Регистрация</h1></p>
<h3>Заполните, пожалуйста, поля формы:</h3>
<p>
<spring:form action="saveUser" method="get" modelAttribute="user">
    Фамилия:<br>
                <spring:input path="surname" type="text" required="true" placeholder="Your surname" /><br>
                <spring:errors path="surname" cssClass="error" /><br>
    Имя:<br>
                <spring:input path="name" type="text" required="true" placeholder="Your name" /><br>
                <spring:errors path="name" cssClass="error" /><br>
    Электронный адрес:<br>
                <spring:input path="email" type="email" required="true" placeholder="bigroiWear.2017@gmail.com" /><br>
                <spring:errors path="email" cssClass="error" /><br>
    Пароль:<br>
                <spring:input path="password" type="password" required="true" placeholder="123AsKKl5"/><br>
                <spring:errors path="password" cssClass="error" /><br>
    Мобильный номер телефона:<br>
                <spring:input path="phone" type="tel" required="true" placeholder="+375(xx) xxx xx xx"/><br>
                <spring:errors path="phone" cssClass="error" /><br>
    <p><button type="submit">Зарегистрироваться</button></p>
</spring:form>
</p>
<h3 class="error">${message}</h3>
</div>
<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>
</body>
</html>
