<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
<title>product details </title>
</head>

<body>

<h1> Product Details </h1>


Product Id: <c:out value="${product.id}" />
<br>
Product Name: <c:out value="${product.productName}" />
<br>
Product Price: <c:out value="${product.price}" />
</body>

</html>



