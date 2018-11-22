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
<c:url value='/aboutus' var="abt"></c:url>
<form method = "POST" action = "${abt} "> 
<h1><i>CRAZY SHOPPER</i></h1>
<P>
CrazyShopper online shopping app is a place where you any find trending products with 
resonable prize..This app has been created to make the shopping easy.And the products will be delivered 
with 2-3 days all around the world.We assure of the quantity of our product which as been approvide by the Indian government...So shop without any 
dought...
<h2>Keeping Shopping</h2>
<h3><i>Thank you</i></h3>
</form>

</body>
</html>