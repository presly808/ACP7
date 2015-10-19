<%@ page import="model.Client" %>
<html>
<%@include file="import.jsp" %>

</head>
<body>
<%@include file="../mainLogoImport.jsp"%>
<link rel="stylesheet" href="stylesheet.css">

<div class="client menu">

    <h1>Client</h1>
    firstName : <c:out value="${client.firstName}"/><br>
    secondName : <c:out value="${client.secondName}"/><br>
    id : <c:out value="${client.id}"/><br>
    email : <c:out value="${client.email}"/><br>

    <div class="updater">

            <a href="/${APP_NAME}/updater">Update</a>

    </div>

    <div class="deleter">

        <a href="/${APP_NAME}/deleter">Delete</a>

    </div>



    <ul>

        <li><a href="/WEB-INF/pages/showServices.jsp">services</a></li>
        <li>store</li>
        <li>recording on diagnostic</li>
        <li>order service</li>
        <li>check status of service</li>
        <li>exit</li>

    </ul>

</div>

</body>
</html>
