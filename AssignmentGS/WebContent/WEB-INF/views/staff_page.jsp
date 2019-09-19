<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment Geekseat</title>
</head>
<body>
	<div align="center">
		<h1>User List</h1>
		<h2><a href="edit?id=${Id}">edit  my data</a></h2>
			<table border="1">
			<tr>
				<th>No</th>
				<th>Name</th>
				<th>Email</th>
				<th>Role</th>
				<th>Status</th>
				
			</tr>
			<c:forEach items="${listUser}" var="user" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>${user.role}</td>
				<td>${user.status}</td>

			</tr>
				
			</c:forEach>
			</table>
			<h3><a href="logout">logout</a></h3>
	</div>
</body>
</html>