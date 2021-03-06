<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <script src="/resources/js/leftMenu.js"></script>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/leftMenu.css"/>
    <script src="/resources/js/jquery-3.2.1.js"></script>
</head>
<body>

<div class="catalogField">
    <p><span class="head">Мода тебя</span></p>
    <p class="head_coll" attr="${collName}"><spring:message code="${collName}" /></p>
<c:forEach items="${catalogsList}" var="catalog">
    <table class="catalogTable">
        <tr>
            <td class="catalogLink" attr="${catalog.name}"><spring:message code="${catalog.name}"/></td>
        </tr>
    </table>
</c:forEach>
</div>
</body>
</html>
