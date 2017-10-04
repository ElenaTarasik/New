<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ROLE_PAGE</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/admin.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/jquery.fancybox.css"/>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <script src="/resources/js/jquery.fancybox.js"></script>
    <script src="/resources/js/jquery.fancybox.pack.js"></script>
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
    <span class="head">Список ролей пользователей</span>
    <table class="editTable">
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Электронный адрес</th>
            <th>Роль</th>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <th colspan="2">Действие</th>
            </sec:authorize>
        </tr>
            <tr>
                <td>${userForRole.surname}</td>
                <td>${userForRole.name}</td>
                <td>${userForRole.email}</td>
                <td>
                    <c:forEach items="${userRoles}" var="role">
                    <table style="text-align: center">
                        <tr style="border: none">
                            ${role.value}
                        </tr>
                    </table>
                    </c:forEach>
                </td>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
<td><a href="#fancyField" rel="nofollow" class="editRole" style="cursor: pointer; font-size: 20px; font-weight: bold; color: maroon" >Изменить роли</a></td>
                </sec:authorize>
            </tr>
    </table>
</div>
</div>

<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>
</body>
</html>
