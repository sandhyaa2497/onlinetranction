<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
User Details \
${username}
${email}
 <br/><br/>

<table border="1">
<tr>
<th>User Name</th>
<th>Phone Number</th>
<th>Email</th>
<th>Password</th>
<th>Address</th>
<th>Action</th>

</tr>

<c:forEach var="j" items="${users}">
<tr>
<td>${j.username}</td>
<td>${j.phno}</td>
<td>${j.email}</td>
<td>${j.password}</td>
<td>${j.address}</td>
<td>
<a href="<c:url value='/admin/deleteuser?id=${j.email }'></c:url>"><span class="glyphicon glyphicon-trash"></span></a>
					<a href="<c:url value='/admin/getupdateuser?id=${j.email }'></c:url>"><span class="glyphicon glyphicon-pencil"></span></a>
					</td>
</tr>
</c:forEach>
</table>
</body>
</html>