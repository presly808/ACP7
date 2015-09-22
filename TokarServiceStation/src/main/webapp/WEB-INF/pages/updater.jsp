<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 20.09.15
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="import.jsp" %>
<head>
    <title>Update Client info</title>
</head>
<body>

<div class="updater">

  <form action="updater" method="post">
    Email : <input name="email" type="text"><br>
    PhoneNumber : <input name="phoneNumber" type="text"><br>
    Pass : <input name="pass" type="text"><br>
    DriverLicenseNumber : <input name="driverLicenseNumber" type="text"><br>
    <input type="submit">

  </form>
</div>





</body>
</html>
