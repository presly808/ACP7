<%@include file="import.jsp" %>

<html>
<head>
  <title>ProductInfo</title>
</head>
<body>

<%@include file="menu.jsp" %>


<h1>Product</h1>
id : <c:out value="${product.id}"/><br>
title : <c:out value="${product.title}"/><br>
desc : <c:out value="${product.description}"/><br>
price : <c:out value="${product.price}"/><br>
</body>
</html>
