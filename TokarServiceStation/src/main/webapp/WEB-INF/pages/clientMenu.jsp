<%@ page import="model.Client" %>
<html>
<%@include file="import.jsp" %>

</head>
<body>


<div class="client menu">

    <h1>Client</h1>
    firstName : <c:out value="${client.firstName}"/><br>
    secondName : <c:out value="${client.secondName}"/><br>
    id : <c:out value="${client.id}"/><br>
    email : <c:out value="${client.email}"/><br>
    phone : <c:out value="${client.phoneNumber}"/><br>


<%--
    <%Client client = (Client) request.getAttribute("client");%>

    <h1>Client</h1>
    id : <%= client.getId()%><br>
    email : <%= client.getEmail()%><br>
    phone : <%= client.getPhoneNumber()%><br>--%>

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
