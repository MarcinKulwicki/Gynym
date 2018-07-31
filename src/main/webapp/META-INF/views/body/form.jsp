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
<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">

    <title>Add Body</title>
</head>
<body>
<c:import url="../fragments/header.jsp"/>

<div class="card">
    <div class="card-header">
        Body
    </div>
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
    <input type="submit" value="Save">
</form:form>

</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>

</body>
</html>
