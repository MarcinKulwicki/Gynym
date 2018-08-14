<%--
  Created by IntelliJ IDEA.
  User: wdr434
  Date: 09.08.18
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rest</title>

    <meta charset="UTF-8">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/JS/index.js"></script>
    <script src="/JS/login.js"></script>
</head>
<body>

<h1>Login</h1>
<p id="login">
<form method="post" id="formLogin">
    <input type="text" id="username" placeholder="Login">
    <input type="password" id="password" placeholder="Password">
    <input type="submit" value="Login" id="loginButton">
</form>
<button id='logout' value='Logout' hidden>Logout</button>
</p>

<button id="buttonBody">Body</button>
<button id="buttonTraining">Training</button>

<h1>List bodies</h1>
<div id="listBodies" class="context">
</div>
<h1>List training</h1>
<div id="listTraining" class="context">
</div>

</body>
</html>
