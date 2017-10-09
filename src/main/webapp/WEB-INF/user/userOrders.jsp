<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>
<html>
<head>
    <title>USER_ORDERS</title>
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
<%--<sec:authentication property="name" /><br>
<sec:authentication property="authorities"/><br>--%>
<div class="adminMenu">
   <c:import url="/WEB-INF/blocks/userMenu.jsp"/>
</div>
    <div class="mainField">
<span class="head">
    Список заказов пользователя
 <table border="2px solid #BC8F8F;"  width="90%">
        <tr>
            <td>Номер заказа</td>
            <td>Дата заказа</td>
            <td>Количество товара</td>
            <td>Общая цена</td>
        </tr>
      <c:forEach items="${list}" var="ordersList">
           <tr>
            <td>${ordersList.id}</td>
            <td>${ordersList.date}</td>
            <td>${ordersList.quantity}</td>
            <td>${ordersList.price}</td>
        </tr>


      </c:forEach>

 </table>


</span>
    <%--<c:if test="${!empty userList}">
                    <table class="editTable">
                        <tr>
                            <th>№</th>
                            <th>Фамилия</th>
                            <th>Имя</th>
                            <th>Электронный адрес</th>
                            <th>Телефон</th>
                            <th>Адрес</th>
                            <th>Дата регистрации</th>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <th colspan="3">Действие</th>
                            </sec:authorize>
                        </tr>
                        <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.surname}</td>
                            <td>${user.name}</td>
                            <td>${user.email}</td>
                            <td>${user.phone}</td>
                            <td>${user.address}</td>
                            <td>${user.regDate}</td>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <td><a class="rolePage" style="font-weight: bold; color: maroon"  href="/admin/rolePage?email=${user.email}">Cписок ролей</a></td>
                                <td><a class="editUserPage" style="font-weight: bold; color: maroon" href="/admin/editUserPage?email=${user.email}">Редактировать</a></td>
                                <td><span class="delBut" style="cursor:pointer; font-weight: bold; color: maroon" attr="${user.email}">Удалить</span></td>
                            </sec:authorize>
                        </tr>
                        </c:forEach>
                    </table>
    </c:if>
    <p><span class="delMess">${delMessage}</span></p>--%>
</div>
</div>
<div class="footerField">
    <c:import url="/WEB-INF/blocks/footer.jsp"/>
</div>
</body>
</html>