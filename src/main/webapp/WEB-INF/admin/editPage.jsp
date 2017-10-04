<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EDIT_PAGE</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/admin.css"/>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <script src="/resources/js/admin.js"></script>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>
<div class="adminField">
    <div class="adminMenu">
        <c:import url="/WEB-INF/blocks/adminMenu.jsp"/>
    </div>
    <div class="mainField">
<span class="head">Заполните, пожалуйста, поля формы:</span>
<div class="editForm">
    <spring:form action="editUser" method="get" modelAttribute="userEdit">
    <span class="formLab">Фамилия:</span>
        <spring:input cssClass="editForm" path="surname" type="text" required="true" value="${userEdit.surname}" />
        <spring:errors path="surname" cssClass="error" /><br>
    <span class="formLab">Имя:</span>
        <spring:input cssClass="editForm" path="name" type="text" required="true" value="${userEdit.name}" />
        <spring:errors path="name" cssClass="error" /><br>
    <span class="formLab">Электронный адрес:</span>
        <spring:input cssClass="editForm" path="email" type="email" required="true" value="${userEdit.email}" />
        <spring:errors path="email" cssClass="error" /><br>
    <span class="formLab">Пароль:</span>
        <spring:input cssClass="editForm" path="password" type="password" required="true" value="${userEdit.password}"/>
        <spring:errors path="password" cssClass="error" /><br>
    <span class="formLab">Телефона:</span>
        <spring:input cssClass="editForm" path="phone" type="tel" required="true" value="${userEdit.phone}"/>
        <spring:errors path="phone" cssClass="error" /><br>
    <span class="formLab">Адрес:</span>
        <spring:input cssClass="editForm" path="address" type="address" value="${userEdit.address}"/><br>
        <br><p><button class="editBut" type="submit">Обновить данные пользователя</button></p>
</spring:form>
</div>
<p class="delMess">${message}</p>
</div>
</div>
<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>
</body>
</html>
