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
      <h2>Shipping Address</h2>
      <c:url value='/cart/createorder' var="url"></c:url>
      <form:form method = "POST" action = "${url}" modelAttribute="shippingaddress" >
      
        <form:label path = "shippingId">id</form:label>
        <form:input type="hidden" path = "shippingId" />
       
            <form:label path = "apartmentnumber">Appartment Number</form:label>
            <form:input path = "apartmentnumber" />
            <form:errors path="apartmentnumber" cssStyle="color:red"></form:errors>
            
          <form:label path = "streetname">StreetName</form:label><form:input path = "streetname" />
               <form:errors path="streetname" cssStyle="color:red"></form:errors>
               
           <form:label path = "city">City</form:label><form:input path = "city" />
               <form:errors path="city" cssStyle="color:red"></form:errors>
               
            <form:label path = "state">State</form:label><form:input path = "state" />
               <form:errors path="state" cssStyle="color:red"></form:errors>
            
            <form:label path = "country">Country</form:label><form:input path = "country" />
               <form:errors path="country" cssStyle="color:red"></form:errors>
               
               <form:label path = "zipcode">Zipcode</form:label><form:input path = "zipcode" />
               <form:errors path="zipcode" cssStyle="color:red"></form:errors>
            
            
                  <input type = "submit" class="btn btn-warning" value = "Submit"/>
          </form:form>
          </body>
          </html>