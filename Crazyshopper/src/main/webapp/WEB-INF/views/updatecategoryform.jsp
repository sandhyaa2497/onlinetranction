<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

<form:form action="updatecategory" method="post">
<table>
	   <tr>
	   <td></td>
	   <td><form:hidden path="cid"></form:hidden></td>
	   </tr>
		<tr>
			<td>Enter Category Name</td>
			<td>
			<form:input path="categoryname" value="${categoryname}"/>
			<form:errors path="categoryname" cssStyle="color:red"></form:errors>

			</td>
		</tr>
       
		
		<form:errors path="category" cssStyle="color:red"></form:errors>
		
			
		<tr><td>
		<input type="submit" value="Edit Category">  </td>
		<td></td>
		</tr>
		
	</table>



</form:form>
</div>

</body>
</html>