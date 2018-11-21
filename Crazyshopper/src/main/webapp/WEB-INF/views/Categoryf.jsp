<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
   <head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   </head>

   <body>
   <jsp:include page="header.jsp" /> 
      <h2>CATEGORY DETAILS</h2>
      <form:form method = "POST" action = "admin/addcategory" >
        <form:label path = "categoryname">Name</form:label>
               <form:input path = "categoryname" />
               <form:errors path="categoryname" cssStyle="color:red"></form:errors>
            
              
      </form:form>
   </body>
   
</html>