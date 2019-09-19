<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Login</h1>
		<f:form action="login" method="post" modelAttribute="user">
			<table>
			<tr>
				<td>Email: </td>
				<td><f:input path="email"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><f:input path="password" type="password"/></td>
			</tr>
			<tr>
				<td><p align="center" style="color:#FF0000">${message}</p></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="login"></td>
			</tr>
		</table>
		</f:form>
	</div>
</body>
</html>