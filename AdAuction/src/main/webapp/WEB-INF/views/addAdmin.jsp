<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
 	<title>New Admin</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>
<body>
	
	<div class="form-container">
     
    <h1>Add Admin Form</h1>
    
    
    ${message}
    
     Enter Email for the User to make ADMIN type
     
    <form:form method="GET" action="assignAdmin" modelAttribute="user" class="form-horizontal">
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">E-Mail</label>
                <div class="col-md-7">
                    <form:input type="email" path="email" id="email" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        
        
 		
 		
        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Assign" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form:form>
    </div>
</body>
</html>