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
      <h2>SUPPLIER DETAILS</h2> <c:url value='/admin/addsupplier' var="url"></c:url>
      <form:form method = "POST" action = "${url}">
         <form:label path = "supname">Name</form:label>
              <form:input path = "supname" />
               <form:errors path="supname" cssStyle="color:red"></form:errors>
            
              <form:label path = "supid">id</form:label>
              <form:input path = "supid" />
               <form:errors path="supid" cssStyle="color:red"></form:errors>
            
                  <input type = "submit" class="btn btn-warning" value = "Submit"/>
                 
             
      </form:form>
   </body>
   
</html>