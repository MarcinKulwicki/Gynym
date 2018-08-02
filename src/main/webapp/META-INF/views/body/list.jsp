<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>List Body</title>
</head>
<body>
<c:import url="../fragments/header.jsp"/>

<div class="card text-center">
    <div class="card-header">
        <ul class="nav nav-pills card-header-pills">
                <a class="nav-link disabled" href="${pageContext.request.contextPath}/body/add">Add Body</a>
                <a class="nav-link disabled" href="${pageContext.request.contextPath}/body/target">Change Target</a>
                <a class="nav-link disabled" href="${pageContext.request.contextPath}/body/start">Change Start</a>
                <a class="nav-link disabled" href="${pageContext.request.contextPath}/user/delete">Delete User</a>
        </ul>
    </div>

    <div class="progress">
        <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="${now}" aria-valuemin="${start}" aria-valuemax="${end}" style="width: ${proc}%"></div>
    </div>

    <div class="card-body">

            <h5 class="card-title">
                <table class="table table-sm">
                    <thead>
                    <tr>
                        <th scope="col">Date</th>
                        <th scope="col">Height [cm]</th>
                        <th scope="col"><a class="nav-link disabled" href="${pageContext.request.contextPath}/body/Weight">Weight</a> [kg]</th>
                        <th scope="col"><a class="nav-link disabled" href="${pageContext.request.contextPath}/body/BicepsLeft">BicepsLeft</a> [cm]</th>
                        <th scope="col"><a class="nav-link disabled" href="${pageContext.request.contextPath}/body/BicepsRight">BicepsRight</a> [cm]</th>
                        <th scope="col"><a class="nav-link disabled" href="${pageContext.request.contextPath}/body/Chest">Chest</a> [cm]</th>
                        <th scope="col"><a class="nav-link disabled" href="${pageContext.request.contextPath}/body/Waist">Waist</a> [cm]</th>
                        <th scope="col"><a class="nav-link disabled" href="${pageContext.request.contextPath}/body/Hips">Hips</a> [cm]</th>
                        <th scope="col"><a class="nav-link disabled" href="${pageContext.request.contextPath}/body/ThighLeft">ThighLeft</a> [cm]</th>
                        <th scope="col"><a class="nav-link disabled" href="${pageContext.request.contextPath}/body/ThighRight">ThighRight</a> [cm]</th>
                        <th scope="col"><a class="nav-link disabled" href="${pageContext.request.contextPath}/body/CalfLeft">CalfLeft</a> [cm]</th>
                        <th scope="col"><a class="nav-link disabled" href="${pageContext.request.contextPath}/body/CalfRight">CalfRight</a> [cm]</th>
                        <th scope="col">Delete</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${body}" var="tmp">
                    <tr>
                        <td>
                                <c:if test="${tmp.flag == 'target'}">
                                    <span style="color: magenta; ">${tmp.flag}</span> <br/>
                                </c:if>
                                <c:if test="${tmp.flag == 'start'}">
                                    <span style="color: magenta; ">${tmp.flag}</span> <br/>
                                </c:if>
                                ${tmp.data_mod}</td>
                        <td>${tmp.hight}</td>
                        <td>${tmp.weight}</td>
                        <td>${tmp.bicepsLeft}</td>
                        <td>${tmp.bicepsRight}</td>
                        <td>${tmp.chest}</td>
                        <td>${tmp.waist}</td>
                        <td>${tmp.hips}</td>
                        <td>${tmp.thighLeft}</td>
                        <td>${tmp.thighRight}</td>
                        <td>${tmp.calfLeft}</td>
                        <td>${tmp.calfRight}</td>
                        <td><a class="nav-link disabled" href="${pageContext.request.contextPath}/body/delete/${tmp.id}">Delete</a></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </h5>

    </div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>

</body>
</html>
