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
 <c:url value='/admin/updateproduct' var="url"></c:url>
<form:form modelAttribute="product" action="${url}" method="post" enctype="multipart/form-data">
<form:hidden path="prodid"></form:hidden>
	   Enter Product Name
			
			<form:input path="prodname" value="${prodname}"/>
			<form:errors path="prodname" cssStyle="color:red"></form:errors>

			
			Enter Product Description
			
			<form:textarea path="prodetails"/>
			<form:errors path="prodetails" cssStyle="color:red"></form:errors>
			Enter Product Price
			
			<form:input path="prize"/>
			Enter Product Quantity
			
			<form:input path="quantity"/>
			<form:errors path="quantity" cssStyle="color:red"></form:errors>
			Select Category
		<form:select path="category.cid">
		<c:forEach items="${categories}" var="c">
		<form:option value="${c.cid }">${c.categoryname }</form:option>
		
		</c:forEach>
		</form:select>
		<form:errors path="category" cssStyle="color:red"></form:errors>
		
		Upload an image
		<form:input type="file" path="image" ></form:input>
		
		<input type="submit" class="btn btn-warning" value="Edit Product"> 


</form:form>
</div>
</body>
</html>