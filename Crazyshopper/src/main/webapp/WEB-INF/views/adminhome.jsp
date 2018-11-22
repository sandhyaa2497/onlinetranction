<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<table border="1" class="table"> 
<h3>Manage Products</h3><c:url value='/admin/getproductform' var="url"></c:url>
<a href="${url}">Add product</a>
<br/>
<c:url value='/productlist' var="prodl"></c:url>
<a href="${prodl}">Update or delete product</a>
<br/>

<h3>Manage Supplier</h3><c:url value='/admin/getsupplierform' var="addsupp"></c:url>
<a href="${addsupp}">Add Supplier</a>
<br/>
<c:url value='/supplierlist' var="supl"></c:url>
<a href="${supl}">Update or delete supplier</a>
<br/>

<h3>Manage Category</h3><c:url value='/admin/getcategoryform' var="addcat"></c:url>
<a href="${addcat}">Add category</a>
<br/>
<c:url value='/categorylist' var="catl"></c:url>
<a href="${catl}">Update or delete category</a>
<br/>
</body>
</html>