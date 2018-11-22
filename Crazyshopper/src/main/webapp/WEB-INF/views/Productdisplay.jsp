<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" /> 


	<div class="container">
	
	<c:if test="${not empty prodlist}">
	<table border="1" class="table">

<thead>
<tr>
<th>Product Name</th>
<th>Product Id</th>
<th>Product Prize</th>
<th>Product Description</th>
<th>Product Quantity</th>
<th>Image</th>



</tr>
</thead>
<tbody>
</tbody>
<c:forEach var="j" items="${prodlist}">
<tr>

<td>${j.prodname}</td>
<td>${j.prodid}</td>
<td>${j.prize}</td>
<td>${j.prodetails}</td>
<td>${j.quantity}</td>
<td>${j.image}
<img src="<c:url value="/resources/images/${j.prodid}.jpg" />" width="100" height="50"/></td> 
<c:if test="${pageContext.request.userPrincipal.name == 'anu@gmail.com'}">
<td>

					<a href="<c:url value='/admin/deleteproduct?id=${j.prodid }'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>
					<a href="<c:url value='/admin/getupdateproduct?id=${j.prodid }'></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>
					</td></c:if>
					<c:if test="${pageContext.request.userPrincipal.name != 'anu@gmail.com'}">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
<td>
					<a href="<c:url value='/viewproduct-${j.prodid}'></c:url>"><button type="button" class="btn btn-primary">Add to cart</button></a>
					</td></c:if></c:if>
</tr>
</c:forEach>
</tbody>
</table>
</c:if>
</div>
</body>
</html>