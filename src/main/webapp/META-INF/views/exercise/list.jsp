<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wdr434
  Date: 31.07.18
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${exercise}" var="tmp">
    Exercise:
    ${tmp.id}
    ${tmp.name}
    ${tmp.description}
    ${tmp.recommend}
    ${tmp.series}
    ${tmp.repeats}
    ${tmp.weight}
</c:forEach>


</body>
</html>
