<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>CATEGORY DETAILS</h2>
      <form:form method = "POST" action = "addcategory">
         <table>
            <tr>
               <td><form:label path = "categoryname">Name</form:label></td>
               <td><form:input path = "categoryname" /></td>
            </tr>
            <tr>
               <td><form:label path = "cid">Id</form:label></td>
               <td><form:input path = "cid" /></td>
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