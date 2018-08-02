<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wdr434
  Date: 31.07.18
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">

    <title>Exercise</title>
</head>
<body>
<c:import url="../fragments/header.jsp"/>


<div class="card text-center">
    <div class="card-header">
        <ul class="nav nav-pills card-header-pills">
            <li class="nav-item">
                <a class="nav-link disabled" href="${pageContext.request.contextPath}/exercise/add">Add Exercise</a>
            </li>
        </ul>
    </div>
    <div class="card-body">
        <c:if test="${noTraining}">
        <h5 class="card-title">
                You don't chose any traning, back to the Training Tab and Chose trening
        </h5>
        </c:if>
        <h5 class="card-title">
            <table class="table table-sm">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Recommend</th>
                    <th scope="col">Series</th>
                    <th scope="col">Repeats</th>
                    <th scope="col">Weight</th>
                    <th scope="col">Time</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
        <c:forEach items="${exercise}" var="tmp">
        <h5 class="card-title">
            <tr>
                <td>${tmp.name}</td>
                <td>${tmp.description}</td>
                <td>${tmp.recommend}</td>
                <td>${tmp.series}</td>
                <td>${tmp.repeats}</td>
                <td>${tmp.weight}</td>
                <td>${tmp.time}</td>
                <td><a class="nav-link disabled" href="${pageContext.request.contextPath}/exercise/edit/${tmp.id}">Edit</a></td>
                <td><a class="nav-link disabled" href="${pageContext.request.contextPath}/exercise/delete/${tmp.id}">Delete</a></td>
            </tr>
        </h5>
        </c:forEach>
                </tbody>
            </table>
    </div>
</div>






<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>

</body>
</html>
