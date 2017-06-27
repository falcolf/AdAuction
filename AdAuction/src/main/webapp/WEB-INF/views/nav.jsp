<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Done</title>
</head>
<body>
		${message}
		<br>
		<p align="right">
			<a href="<c:url value="/logout" />">Logout</a>
		</p>
		
		<ul>
			<li><a href="welcome">Welcome Page</a></li>
			<li><a href="user">User Page</a></li>
			<li><a href="admin">Admin Page</a></li>
		</ul>
</body>
</html>