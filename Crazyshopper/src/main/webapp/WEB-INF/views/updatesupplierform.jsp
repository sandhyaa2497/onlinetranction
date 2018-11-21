<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp" /> 
<div class="container">
 <c:url value='/admin/updatesupplier' var="url"></c:url>
<form:form modelAttribute="supplier" action="${url}" method="post" >
<form:hidden path="supid"></form:hidden>
		EnterSupplier Name
			
			<form:input path="supname" value="${supname}"/>
			<form:errors path="supname" cssStyle="color:red"></form:errors>

			
		<input type="submit" class="btn btn-warning" value="Edit Supplier"> 
		


</form:form>
</div>

</body>
</html>