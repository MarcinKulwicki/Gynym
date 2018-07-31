<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wdr434
  Date: 31.07.18
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Training Form</title>
</head>
<body>
<c:import url="../fragments/header.jsp"/>

<form:form method="post" modelAttribute="training">
    <form:input path="name"/>
    <input type="submit" value="Add training">
</form:form>

</body>
</html>
