<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="AdAuction">
    <meta name="author" content="Parth Agarwal">
    <link rel="icon" href="/AdAuction/static/img/fav.png">
    <link rel="shortcut icon" href="/AdAuction/static/img/fav.png">
<link href="<c:url value='/static/css/home.css' />" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auction Page</title>
</head>
<body>
	<jsp:directive.include file = "adminnav.jsp" />
	<base href="/AdAuction/admin/" />
	<hr>
	<br>
	${message}
	<br>
	<hr>
	<ul>
		<li><a href="new" style="color:white">Start Auction For a website</a></li>
		<li><a href="addAdmin" style="color:white">Add a new Admin account</a></li>
		<li><a href="auctions" style="color:white">View All Progresses</a></li>
	</ul>
</body>
</html>