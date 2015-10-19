
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="import.jsp" %>
<%@include file="../../stylesheet.css" %>
<%@include file="../mainLogoImport.jsp"%>
<head>
  <title>Delete Client from data base</title>
</head>
<body>

<div class="deleter">

  <form action="deleter" method="post">
    Email : <input name="email" type="text"><br>
    Pass : <input name="pass" type="text"><br>
    DriverLicenseNumber : <input name="driverLicenseNumber" type="text"><br>
    Id: <input name="id" type="number"><br>
    <input type="submit">

  </form>
</div>



</body>
</html>