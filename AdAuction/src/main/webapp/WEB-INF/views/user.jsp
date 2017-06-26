<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Auction Page</title>
</head>
<body>
	<p>
	
	Logged in as : <strong>${user}</strong> 
	
	</p>
	<p align="right">
	<a href="<c:url value="/logout" />">Logout</a>
	</p>
	<br>
	Welcome to User Page.
	
	
	<table border="dashed">
	
	
		<tr>
			<th>ID</th>
			<th>Website</th>
			<th>URL</th>
			<th>Ad Type</th>
			<th>Start Time</th>
			<th>End Time</th>
			<th>Current Bid</th>
			<th>Bid?</th>
		</tr>
		
		
		<c:forEach items="${aucs}" var="auc">    
    		
    		<tr>
				<td><c:out value="${auc.id}"/></td>
				<td><c:out value="${auc.name}"/></td>
				<td><c:out value="${auc.url}"/></td>
				<td><c:out value="${auc.type}"/></td>
				<td><c:out value="${auc.starttime}"/></td>
				<td><c:out value="${auc.endtime}"/></td>
				<td><c:out value="${auc.currbid}"/></td>
				<td><c:out value="hello "/></td>
		
			</tr>
		
    		
    		
    		
		</c:forEach>
		
		
	</table>
	
</body>
</html>