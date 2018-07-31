<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wdr434
  Date: 31.07.18
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Training List</title>
</head>
<body>


<c:forEach items="${training}" var="tmp">
    Training:
    ${tmp.id}
    ${tmp.name}
    <a href="${pageContext.request.contextPath}/exercise/${tmp.id}">Exercises</a>
    <br/>
</c:forEach>
</body>
</html>
