<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>AUTHORIZED_USER_PAGE</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/base.css"/>
</head>
<body>
<div class="topNavigation">
    <c:import url="/WEB-INF/blocks/topNavigation.jsp"/>
</div>
<sec:authentication property="name" /><br>
<sec:authentication property="authorities"/><br>
<h1>${message}</h1><br>
<h3><a href="logout">Logout</a></h3>
</body>
</html>