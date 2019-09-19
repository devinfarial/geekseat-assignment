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
		<h1>Add/Edit User</h1>
		<f:form action="save" method="post" modelAttribute="user">
			<table>
			<f:hidden path="id"/>
			<tr>
				<td>Name: </td>
				<td><f:input path="name"/></td>
			</tr>
			<tr>
				<td>Email: </td>
				<td><f:input path="email"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><f:input path="password" type="password"/></td>
			</tr>
			<tr>
				<td>Role: </td>
				<td>
					<f:select path="role">
            		<f:option value="Admin" />
            		<f:option value="Marketing" />
            		<f:option value="IT Staff" />
        			</f:select>
   				</td>
			</tr>
			<tr>
				<td>Status: </td>
				<td>
					<f:select path="status">
            		<f:option value="Active" />
            		<f:option value="Inactive" />
        			</f:select>
   				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="save"></td>
			</tr>
			</table>
			
		</f:form>
	
	</div>

</body>
</html>