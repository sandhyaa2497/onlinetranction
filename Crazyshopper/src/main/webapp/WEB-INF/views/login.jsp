<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
      <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${loginError}


 <h2>LOGIN FORM</h2>
 <c:url value='/j_spring_security_check' var="url"></c:url>
 <form method = "POST" action = "${url} ">
 <tr>
				<td>UserName</td>
				<td><input type="text" name="j_username" /></td>
			</tr>
				<tr>
				<td>Password</td>
				<td><input type="password" name="j_password" /></td>
			</tr>
		</table>
		<input type="submit" value="Login" />
</form>

</body>
</html>