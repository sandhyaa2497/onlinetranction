<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

</head>
<body>

<div class="container">
<nav class="navbar navbar-default" id="navbar-bg">
<div class="navbar-header">

				<button type="button" class="navbar-toggle collapsed" 
   data-toggle="collapse" data-target="#navbardemo" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
</div>
<div class="collapse navbar-collapse" id="navbardemo">
<ul class="nav navbar-nav">
<li><a href="<c:url value='/home'></c:url>"><span class="glyphicon glyphicon-home"></span>Home</a></li>
<li><a href="#">AboutUs</a></li><c:if test="${pageContext.request.userPrincipal.name == 'anu@gmail.com'}">
<li><a href="<c:url value='/admin/adminpage'></c:url>"><span class="glyphicon glyphicon-plus"></span>Manage store</a></li></c:if>
<li><a href="<c:url value='/productlist'></c:url>">Browse all products</a></li>
<li class="dropdown"><a  class="dropdown-toggle" data-toggle="dropdown"href="#">Select By Category<span class="caret"></span></a>
					
				<ul class="dropdown-menu">
			    <c:forEach var="c" items="${categories}">
				<li><a href="<c:url value='/filterproduct/${c.cid}' ></c:url>" >${c.categoryname}</a></li>
				</c:forEach>
				</ul>
</li>

  
  <c:if test="${pageContext.request.userPrincipal.name == null}">
<li><a href="<c:url value='/all/getregistrationform'></c:url>"><span class="glyphicon glyphicon-registration-mark"></span>Sign up</a></li>
<li><a href="<c:url value='/login'></c:url>"><span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
</c:if>

 <c:if test="${pageContext.request.userPrincipal.name != 'anu@gmail.com'}">
<c:if test="${pageContext.request.userPrincipal.name  != null}">
<li><a href="<c:url value="/cart/getcart" />"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a>${cartSize}</li>
</c:if></c:if>

<c:if test="${pageContext.request.userPrincipal.name != null}">
<li><a href="#">Hello, ${pageContext.request.userPrincipal.name}</a></li>	
<li><a href="<c:url value='/j_spring_security_logout' ></c:url>"><span class="glyphicon glyphicon-log-out"></span>Sign Out</a></li>		
</c:if>
</ul>
</div>
</nav>

</div>

</body>
</html>