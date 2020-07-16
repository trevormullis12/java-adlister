<%--
  Created by IntelliJ IDEA.
  User: noppy
  Date: 7/14/20
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! String firstName = "Trevor"; %>
<%! String lastName = "Mullis"; %>

<html>
<head>
    <title>Home Page</title>
</head>
<body>

    <%@ include file="partials/navbar.jsp"%>
    <h1>Hello <%= firstName %> <%= lastName %>!</h1>
    <%@ include file="partials/footer.jsp"%>
    <h3>About Me</h3>
    <%@ include file="partials/aboutme.jsp"%>

    <form action="user-profile.jsp" >
        <button type="submit">Go There</button>
    </form>

</body>
</html>
