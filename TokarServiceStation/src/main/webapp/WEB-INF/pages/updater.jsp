
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="import.jsp" %>
<link rel="stylesheet" href="stylesheet.css">
<%@include file="../mainLogoImport.jsp"%>
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
