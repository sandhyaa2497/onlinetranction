<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
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
            </tr>
            
            <tr>
               <td><form:label path = "supid">id</form:label></td>
               <td><form:input path = "supid" /></td>
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