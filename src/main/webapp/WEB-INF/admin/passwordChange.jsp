<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PASSWORD_CHANGE</title>
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
    <span class="head">Смена пароля</span><br>
        <div class="editForm">
            <form action="editPassword" method="get" modelAttribute="user">
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
    </div>
    <p><span class="delMess">${message}</span></p>
</div>
<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>
</body>
</html>
