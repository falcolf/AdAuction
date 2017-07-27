<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
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
	<jsp:directive.include file = "nav.jsp" />
	<base href="/AdAuction/user/" />
	<%
       response.setIntHeader("Refresh", 10);
	%>
	<hr>
	<br>
	${message}
	<br>
	<br>
	TIME IN <b>UTC</b> FORMAT
	<br>
	<br>
	<hr>
	<table >
		<tr>
			<th>ID</th>
			<th>Website</th>
			<th>URL</th>
			<th>Ad Type</th>
			<th>Start Time (<b>UTC</b>)</th>
			<th>End Time(<b>UTC</b>)</th>
			<th>Current Bid</th>
			<th>Bid?</th>
		</tr>
		<c:forEach items="${aucs}" var="auc">    
    		<tr>
				<td><c:out value="${auc.id}"/></td>
				<td><c:out value="${auc.name}"/></td>
				<td><a href='<c:out value="${auc.url}"/>'><c:out value="${auc.url}"/></a></td>
				<td><c:out value="${auc.type}"/></td>
				<td><c:out value="${auc.starttime}"/></td>
				<td><c:out value="${auc.endtime}"/></td>
				<td><c:out value="${auc.currbid}"/></td>
				<td><a href='bid=<c:out value="${auc.id}"/> '>CLICK HERE</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>