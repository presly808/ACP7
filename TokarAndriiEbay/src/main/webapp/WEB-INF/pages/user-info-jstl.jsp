<%@include file="import.jsp" %>

<html>
<head>
    <title>UserInfo</title>
</head>
<body>

<%@include file="menu.jsp" %>


<h1>User</h1>
id : <c:out value="${user.id}"/><br>
email : <c:out value="${user.email}"/><br>
phone : <c:out value="${user.phone}"/><br>

</body>
</html>
