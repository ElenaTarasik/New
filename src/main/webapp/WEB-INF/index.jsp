<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WELCOME_PAGE</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/index.css"/>
    <script src="/resources/js/jquery-3.2.1.js"></script>
</head>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>
<div class="startField">
    <div class="head">Самые модные новинки 2017 года в BigRoiWear!</div>
    <table>
        <tr>
            <td><img class="indexImg" src="/resources/image/pictures/мужчина.jpg" /></td>
            <td><img class="indexImg" src="/resources/image/pictures/женщина.jpg" /></td>
        </tr>
    </table>
    <div class="head">Время покупать!</div>
</div>
<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>
</body>
</html>
