<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   </head>

   <body>
   <jsp:include page="header.jsp" /> 
      <h2>USER DEATILS</h2> <c:url value='/adduser' var="url"></c:url>
      <form:form method = "POST" action = "${url}">
         <form:label path = "username">Name</form:label>
             <form:input path = "username" />
               <form:errors path="username" cssStyle="color:red"></form:errors>
               
           <form:label path = "email">Email</form:label>
               <form:input path = "email" />
               <form:errors path="email" cssStyle="color:red"></form:errors>
               
           <form:label path = "phno">Phone Number</form:label>
               <td><form:input path = "phno" />
               <form:errors path="phno" cssStyle="color:red"></form:errors>
               
           <form:label path = "password">Password</form:label>
              <form:input path = "password" />
               <form:errors path="password" cssStyle="color:red"></form:errors>
               
          <form:label path = "address">Address</form:label>
               <form:input path = "address" />
               <form:errors path="address" cssStyle="color:red"></form:errors>
            
                  <input type = "submit" class="btn btn-warning" value = "Submit"/>
              
      </form:form>
   </body>
   
</html>