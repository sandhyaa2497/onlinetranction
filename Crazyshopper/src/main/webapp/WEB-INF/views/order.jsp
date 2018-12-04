<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp" /> 
<div class="container">
<table class="table table-striped">
<thead id="thead">
<tr><th>OrderId</th><th>Purchased Date</th><th>Grand Total</th><th>User Email</th>
</tr>
</thead>
<c:set var="grandTotal" value="0"></c:set>
<tbody id="tbody">
<c:forEach items="${customerorders}" var="order">
<tr>
<td>${order.orderId}</td>
<td>${order.purchaseDate}</td>
<td>${order.grandTotal}</td>

<td>${order.user.email}</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="<c:url value='/home'></c:url>"><button type="button" class="btn btn-primary">continue shopping</button></a>
</div>

</body>
</html>