<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
 	<title>Start An Auction</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="form-container">
     
    <h1>Form ${mess}</h1>
     
    <form:form method="GET" action="add" modelAttribute="data" class="form-horizontal">
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">Website Name</label>
                <div class="col-md-7">
                    <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                    
                </div>
            </div>
        </div>
 
 		
 		<div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="url">Url</label>
                <div class="col-md-7">
                    <form:input type="text" path="url" id="url" class="form-control input-sm"/>
                    
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="type">Type</label>
                <div class="col-md-7">
                    <form:select path="type" id="type" items="${adtypes}" multiple="false" class="form-control input-sm"/>
                    
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="currbid">Starting Bid</label>
                <div class="col-md-7">
                    <form:input type="number" path="currbid" id="currbid" class="form-control input-sm"/>
                    
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="starttime">Starting Time</label>
                <div class="col-md-7">
                    <form:input type="datetime-local" path="starttime" id="starttime" class="form-control input-sm"/>
                    
                </div>
            </div>
        </div>
        
        
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="endtime">Ending Time</label>
                <div class="col-md-7">
                    <form:input type="datetime-local" path="endtime" id="endtime" class="form-control input-sm"/>
                    
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Register" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form:form>
    </div>
</body>
</html>