<%@include file="import.jsp" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>

<%@include file="menu.jsp" %>

<div class="form-div">
    <form action="/${APP_NAME}/add-product" method="post">
        Title : <input name="title" type="text"><br>
        Description: <br>
        <textarea name="description"></textarea><br>
        Price: <input name="price" type="text"><br>
        <input type="submit">
    </form>
</div>


</body>
</html>
