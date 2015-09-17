<html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Client Menu</title>

</head>
<body>
<%@include file="import.jsp" %>

<div class="clien menu">

    <h1>Client</h1>
    id : <c:out value="${client.id}"/><br>
    email : <c:out value="${client.email}"/><br>
    phone : <c:out value="${client.phone}"/><br>

    <ul>
        <li><a href="showServices.jsp">services</a></li>
        <li>store</li>
        <li>recording on diagnostic</li>
        <li>order service</li>
        <li>check status of service</li>
        <li>exit</li>

    </ul>

</div>





</body>

