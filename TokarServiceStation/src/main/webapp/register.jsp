<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 17.09.15
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="WEB-INF/pages/import.jsp" %>
<head>
    <title>Register page</title>
</head>
<body>
<div class="register form">

    <form action="register" method="post">
        FirstName : <input name="firstName" type="text"><br>
        SecondName : <input name="secondName" type="text"><br>
        PhoneNumber : <input name="phoneNumber" type="text"><br>
        Email : <input name="email" type="text"><br>
        DriverLicenseNumber : <input name="driverLicenseNumber" type="text"><br>
        Pass : <input name="pass" type="text"><br>
        <input type="submit">

    </form>
</div>

</body>

</html>
