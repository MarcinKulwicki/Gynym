<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wdr434
  Date: 31.07.18
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Body</title>
</head>
<body>
<c:import url="../fragments/header.jsp"/>

<form:form method="post" modelAttribute="body">
    <form:input path="hight" placeholder="Height in cm"/>
    <form:input path="weight" placeholder="Weight in kg"/>
    <form:input path="bicepsLeft" placeholder="Biceps Left in cm"/>
    <form:input path="bicepsRight" placeholder="Biceps Right in cm"/>
    <form:input path="chest" placeholder="Chest in cm"/>
    <form:input path="waist" placeholder="Waist in cm"/>
    <form:input path="hips" placeholder="Hips in cm"/>
    <form:input path="thighLeft" placeholder="Thigh Left in cm"/>
    <form:input path="thighRight" placeholder="Thigh Right in cm"/>
    <form:input path="calfLeft" placeholder="Calf Left in cm"/>
    <form:input path="calfRight" placeholder="Calf Right in cm"/>
    <input type="submit" value="Add body">
</form:form>

</body>
</html>
