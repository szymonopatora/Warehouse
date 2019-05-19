<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szymo
  Date: 19.05.2019
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="hidden" name="submitted" value="true">
    Username:<br>
    <input type="text" name="username"><br>
    Password:<br>
    <input type="text" name="password"><br>
    <input type="submit" name="Log in"><br>
</form>
<c:if test="${param.submitted}">
    <h3>Login not successful</h3>
</c:if>
</body>
</html>
