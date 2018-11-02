<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Product Choosen
${prodname}
${prodid}
<br/><br/>
<table border="1">
<tr>
<th>Product Name</th>
<th>Product Id</th>
<th>Product Prize</th>
<th>Product Description</th>
<th>Product Quantity</th>
</tr>

<c:forEach var="j" items="${products}">
<tr>
<td>${j.prodname}</td>
<td>${j.prodid}</td>
<td>${j.prize}</td>
<td>${j.prodetails}</td>
<td>${j.quantity}</td>
</tr>
</c:forEach>
</body>
</html>