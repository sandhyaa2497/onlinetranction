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
      <h2>PRODUCT DETAILS</h2>
      <c:url value='/admin/addproduct' var="url"></c:url>
      <form:form  method = "POST" action ="${url}" modelAttribute="product"  enctype="multipart/form-data">
        
              <form:label path = "prodid">id</form:label>
               <form:input type="hidden" path = "prodid" />
            
               <form:label path = "prodname">Name</form:label>
              <form:input path = "prodname" />
               <form:errors path="prodname" cssStyle="color:red"></form:errors>
               
           <form:label path = "prize">Price</form:label>
               <form:input path = "prize" />
               <form:errors path="prize" cssStyle="color:red"></form:errors>
               
            <form:label path = "prodetails">Description</form:label>
               <form:input path = "prodetails" />
               <form:errors path="prodetails" cssStyle="color:red"></form:errors>
               
            <form:label path = "quantity">Quantity</form:label>
               <form:input path = "quantity" />
               <form:errors path="quantity" cssStyle="color:red"></form:errors>
           
		Select Category
		<form:select path="category.cid">
		<c:forEach items="${categories}" var="c">
		<form:option value="${c.cid }">${c.categoryname }</form:option>
		
		</c:forEach>
	
		</form:select>
		<form:errors path="category" cssStyle="color:red"></form:errors>
		
		Upload an image
		<form:input type="file" path="image" ></form:input>
		
                  <input type = "submit" class="btn btn-warning" value = "Submit"/>
               
       
      </form:form>
   </body>
   
</html>