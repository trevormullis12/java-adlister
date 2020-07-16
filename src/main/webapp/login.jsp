<%--
  Created by IntelliJ IDEA.
  User: noppy
  Date: 7/15/20
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile");
        }
    }
%>
<html>
<head>
    <title>Login Form</title>
</head>
<body>

<h2>LOGIN HERE</h2>
<form method="POST" action="login.jsp">
    <input type="text" id="username" name="username"><br>
    <input type="password" id="password" name="password"><br>
    <button type="submit">Login</button>
</form>

</body>
</html>
