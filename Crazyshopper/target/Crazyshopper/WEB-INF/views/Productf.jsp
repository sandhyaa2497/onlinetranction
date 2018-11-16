<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
   <head>
      <title>Spring MVC Form Handling</title>
   </head>

   <body>
      <h2>PRODUCT DETAILS</h2>
      <form:form method = "POST" action = "addproduct" modelAttribute="product"  enctype="multipart/form-data">
         <table>
          <tr>
               <td><form:label path = "prodid">id</form:label></td>
               <td><form:input type="hidden" path = "prodid" /></td>
            </tr>
            <tr>
               <td><form:label path = "prodname">Name</form:label></td>
               <td><form:input path = "prodname" /></td>
               <form:errors path="prodname" cssStyle="color:red"></form:errors>
            </tr>
            <tr>
               <td><form:label path = "prize">Price</form:label></td>
               <td><form:input path = "prize" /></td>
               <form:errors path="prize" cssStyle="color:red"></form:errors>
            </tr>
            <tr>
              
               <td><form:label path = "prodetails">Description</form:label></td>
               <td><form:input path = "prodetails" /></td>
               <form:errors path="prodetails" cssStyle="color:red"></form:errors>
            </tr>
            <tr>
               <td><form:label path = "quantity">Quantity</form:label></td>
               <td><form:input path = "quantity" /></td>
               <form:errors path="quantity" cssStyle="color:red"></form:errors>
            </tr>
            <tr>
		<td>Select Category</td>
		<td><form:select path="category.cid">
		<c:forEach items="${categories}" var="c">
		<form:option value="${c.cid }">${c.categoryname }</form:option>
		
		</c:forEach>
	
		</form:select>
		<form:errors path="category" cssStyle="color:red"></form:errors>
		</td>
		</tr>
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