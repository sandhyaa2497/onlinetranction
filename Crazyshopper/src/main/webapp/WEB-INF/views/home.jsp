<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
      <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
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
  <h2>IMAGES</h2>  
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
   
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

   
    <div class="carousel-inner">
      <div class="item active">
       <a href="<c:url value='/productlist'></c:url>" ><img src="<c:url value='/resources/images/img2.jpg'></c:url>"  style="width:100%;"></a>
      </div>

      <div class="item">
        <a href="<c:url value='/productlist'></c:url>" ><img src="<c:url value='/resources/images/img.jpg'></c:url>" style="width:100%;"></a>
      </div>
    
     <div class="item">
       <a href="<c:url value='/productlist'></c:url>" > <img src="<c:url value='/resources/images/img3.jpg'></c:url>"  style="width:100%;"></a>
      </div>
      
       <div class="item">
       <a href="<c:url value='/productlist'></c:url>" > <img src="<c:url value='/resources/images/img1.jpg'></c:url>"  style="width:100%;"></a>
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
<div class="container">
 <div class="row">
 <h1>${prodcat}</h1>
 <c:forEach items="${products}" var="p">
    <div class="col-md-4"><img src="<c:url value='/resources/images/${p.prodid}.jpg'></c:url>" style="width:"100%;">
    <br/>
    <center>Name:${p.prodname}<br/>Rs.${p.prize}<br/><a href="viewproduct-${p.prodid}"><button type="button" class="btn btn-primary">Add to cart</button></a></center>
    </div>

</c:forEach>
</div>
</div>

</body>
</html>