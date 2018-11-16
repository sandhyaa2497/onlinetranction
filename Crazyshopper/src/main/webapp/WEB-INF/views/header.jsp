<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <%@ page isELIgnored="false" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value='/resources/css/registrationform.css'></c:url>">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/navbar.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<nav class="navbar navbar-default" id="navbar-bg">
<div class="navbar-header">
				<a href="" class="navbar-brand"><img src="<c:url value='/resources/images/niit.jpg'></c:url>" alt="NIIT" height="30px" width="60px"></a>
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
<li><a href="#">AboutUs</a></li>
<li><a href="<c:url value='/getproductform'></c:url>"><span class="glyphicon glyphicon-plus"></span>Add Product</a></li>
<li><a href="<c:url value='/productlist'></c:url>">Browse all products</a></li>
<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Select By Category<span class="caret"></span></a>
					
				<ul class="dropdown-menu">
				<li><a href="#">Kitchen and Dining</a></li>
				<li><a href="#">Furniture</a><li>
				<li><a href="#">All</a></li>
				</ul>
</li>
<li><a href=""><span class="glyphicon glyphicon-registration-mark"></span>Sign up</a></li>
<li><a href="#"><span class="glyphicon glyphicon-log-out"></span>Sign Out</a></li>		
<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
</ul>
</div>
</nav>

</div>
<div class="container">
  <h2>IMAGES</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
   
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

   
    <div class="carousel-inner">
      <div class="item active">
        <img src="38.jpg" alt="Los Angeles" style="width:100%;">
      </div>

      <div class="item">
        <img src="55.jpg" alt="Chicago" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="26.jpg" alt="New york" style="width:100%;">
      </div>
    </div>
    
<div class="item">
        <img src="49.jpg" alt="New york" style="width:100%;">
      </div>
    </div>

    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
</html>