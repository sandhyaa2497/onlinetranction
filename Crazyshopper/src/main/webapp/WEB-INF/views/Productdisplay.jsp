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

	<div class="container">
<table border="1">

<thead>
<tr>
<th>Product Name</th>
<th>Product Id</th>
<th>Product Prize</th>
<th>Product Description</th>
<th>Product Quantity</th>
<th>Image</th>
<th>Action</th>


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

<td>

					<a href="<c:url value='/deleteproduct?id=${j.prodid }'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>
					<a href="<c:url value='/getupdateproduct?id=${j.prodid }'></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>
					</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>