<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="WEB-INF/pages/import.jsp" %>
<head>
    <meta charset="UTF-8">
    <title>Main Client Menu of TokarServrciceStation</title>


</head>

<body>
<%@include file="WEB-INF/mainLogoImport.jsp"%>
<link rel="stylesheet" href="stylesheet.css">

<div class="login form">

    <form action="login" method="post">
        Email : <input name="email" type="text"><br>
        Pass : <input name="pass" type="text"><br>
        DriverLicenseNumber : <input name="driverLicenseNumber" type="text"><br>
            <input type="submit">

    </form>
</div>

<br>

<div class="Head Menu">
    <ul>
        <li><a href="WEB-INF/pages/showServices.jsp">services</a></li>
        <li>Store</li>

    </ul>
</div>

</body>
</html>