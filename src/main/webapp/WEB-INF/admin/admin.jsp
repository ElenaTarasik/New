<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@page session="true"%>
<html>
<head>
    <title>ADMIN_PAGE</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>
<div class="loginField">
<sec:authentication property="name" /><br>
<sec:authentication property="authorities"/><br>
<h1>${message}</h1><br>
<h3><a href="logout">Logout</a></h3>
</div>
</body>
</html>