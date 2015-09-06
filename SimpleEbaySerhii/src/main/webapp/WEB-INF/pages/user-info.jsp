<%@ page import="ua.artcode.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: serhii
  Date: 06.09.15
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserInfo</title>
</head>
<body>
<%User user = (User) request.getAttribute("user");%>


<h1>User</h1>
id : <%= user.getId()%><br>
email : <%= user.getEmail()%><br>
phone : <%= user.getPhone()%><br>

</body>
</html>
