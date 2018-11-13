<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
               <form:errors path="categoryname" cssStyle="color:red"></form:errors>
            </tr>
           <%--  <tr>
               <td><form:label path = "cid">Id</form:label></td>
               <td><form:input path = "cid" /></td>
            </tr> --%>
            <tr>
		<td>Upload an image</td>
		<td><form:input type="file" path="image" ></form:input></td>
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