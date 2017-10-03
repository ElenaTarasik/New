<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>PRODUCTS</title>
    <script src="/resources/js/leftMenu.js"></script>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/productTable.css"/>
    <script src="/resources/js/jquery-3.2.1.js"></script>
    <script src="/resources/js/productPage.js"></script>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>

<div class="productsContent">
<div class="leftMenu">
    <c:import url="/WEB-INF/blocks/leftMenu.jsp"/>
</div>

<c:if test="${!empty productsList}">
    <div class="productField">
        <div class="cell">
                <c:forEach items="${productsList}" var="product">
                <table class="productTable">
                    <tr>
                        <td colspan="2">${product.name}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><img class="productImg" src="/resources/image/${product.pictureLink}" width="200" height="240"/></td>
                    </tr>
                    <tr>
                        <td>${product.price} руб.</td>
                        <td><button><a style="border: none" class="productImg" >Просмотреть</a></button></td>
                        <input class="prodId" type="hidden" value="${product.id}">
                    </tr>
                </table>
                </c:forEach>
        </div>
    </div>
</c:if>
</div>
<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>
</body>
</html>
