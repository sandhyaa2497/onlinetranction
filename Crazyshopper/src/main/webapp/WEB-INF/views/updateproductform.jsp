<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<c:url value='/updateproduct' var="url"></c:url>
<form:form modelAttribute="product" action="updateproduct" method="post" enctype="multipart/form-data">
<table>
	   <tr>
	   <td></td>
	   <td><form:hidden path="id"></form:hidden></td>
	   </tr>
		<tr>
			<td>Enter Product Name</td>
			<td>
			<form:input path="prodname"/>
			<form:errors path="prodname" cssStyle="color:red"></form:errors>

			</td>
		</tr>
        <tr>
			<td>Enter Product Description</td>
			<td>
			<form:textarea path="prodetails"/>
			<form:errors path="prodetails" cssStyle="color:red"></form:errors>
			</td>
		</tr>
        <tr>
			<td>Enter Product Price</td>
			<td>
			<form:input path="prize"/>
			<form:errors path="prize" cssStyle="color:red"></form:errors>
			</td>
		</tr>
		
		<tr>
			<td>Enter Product Quantity</td>
			<td>
			<form:input path="quantity"/>
			<form:errors path="quantity" cssStyle="color:red"></form:errors>
			</td>
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
		<td><form:input type="file" path="image"></form:input></td>
		</tr>
		
		<tr><td>
		<input type="submit" value="Edit Product">  </td>
		<td></td>
		</tr>
		
	</table>



</form:form>
</div>
</body>
</html>