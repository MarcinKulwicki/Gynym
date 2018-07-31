<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wdr434
  Date: 31.07.18
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Exercise</title>
</head>
<body>

<form:form method="post" modelAttribute="exercise">
    <form:input path="name" placeholder="Name exercise"/>
    <form:input path="description" placeholder="Description"/>
    <form:input path="series" placeholder="Series"/>
    <form:input path="repeats" placeholder="repeats"/>
    <form:input path="weight" placeholder="weight"/>
    <input type="submit" value="Add exercise to Trening">
</form:form>

</body>
</html>
