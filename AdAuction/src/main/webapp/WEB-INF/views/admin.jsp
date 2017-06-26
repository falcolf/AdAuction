<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin page</title>
</head>
<body>
	
	<p align="right">
	<a href="<c:url value='/logout' />">Logout</a>
	</p>
	<br>
	Welcome to Admin Page.
	<br>
	<br>
	${message}
	<br
	><br>
	<ul>
		<li><a href="admin/new">Start Auction For a website</a></li>
		<li><a href="admin/addAdmin">Add a new Admin account</a></li>
		<li><a href="admin/viewall">View All Progresses</a></li>
	</ul>
	
	
	
	
</body>
</html>