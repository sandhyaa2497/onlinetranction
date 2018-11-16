<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>SUPPLIER DETAILS</h2>
      <form:form method = "POST" action = "addsupplier">
         <table>
            <tr>
               <td><form:label path = "supname">Name</form:label></td>
               <td><form:input path = "supname" /></td>
               <form:errors path="supname" cssStyle="color:red"></form:errors>
            </tr>
            
            <tr>
               <td><form:label path = "supid">id</form:label></td>
               <td><form:input path = "supid" /></td>
               <form:errors path="supid" cssStyle="color:red"></form:errors>
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