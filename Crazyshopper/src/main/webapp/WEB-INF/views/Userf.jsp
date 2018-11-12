<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>USER DEATILS</h2>
      <form:form method = "POST" action = "adduser">
         <table>
            <tr>
               <td><form:label path = "username">Name</form:label></td>
               <td><form:input path = "username" /></td>
               <form:errors path="username" cssStyle="color:red"></form:errors>
            </tr>
            <tr>
               <td><form:label path = "email">Email</form:label></td>
               <td><form:input path = "email" /></td>
               <form:errors path="email" cssStyle="color:red"></form:errors>
            </tr>
            <tr>
               <td><form:label path = "phno">Phone Number</form:label></td>
               <td><form:input path = "phno" /></td>
               <form:errors path="phno" cssStyle="color:red"></form:errors>
            </tr>
            <tr>
               <td><form:label path = "password">Password</form:label></td>
               <td><form:input path = "password" /></td>
               <form:errors path="password" cssStyle="color:red"></form:errors>
            </tr>
            <tr>
               <td><form:label path = "address">Address</form:label></td>
               <td><form:input path = "address" /></td>
               <form:errors path="address" cssStyle="color:red"></form:errors>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
           
         </table>  
      </form:form>
   </body>
   
</html>