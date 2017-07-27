<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="AdAuction">
    <meta name="author" content="Parth Agarwal">
    <link rel="icon" href="/AdAuction/static/img/fav.png">
    <link rel="shortcut icon" href="/AdAuction/static/img/fav.png">
	<title>AccessDenied page</title>
</head>
<body>
	<h1 style="color: red">Error</h1>
	<h6>Access Denied</h6>
	<strong>${user}</strong>, <br>You are not authorized to access this page<br>
	<ol>
		<li><a href="/welcome">Welcome Page</a></li>
		<li><a href="/login">Login Page</a></li>
	</ol>
</body>
</html>