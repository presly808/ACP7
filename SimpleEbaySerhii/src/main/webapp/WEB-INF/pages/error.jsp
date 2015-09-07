<%@include file="import.jsp"%>
<html>
<head>
    <title>Error</title>
</head>
<body>

    <%@include file="menu.jsp"%>
    <br>r

    <h1>Error</h1>
    <c:set var="message" value="${ex.message}"/>

    Message : <br>
    <c:out value="${message}"/>


</body>
</html>
