
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>New Entry Page</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link href="<c:url value='/static/css/home.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/regform.css' />" rel="stylesheet"></link>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
</head>
<body>
<jsp:directive.include file = "adminnav.jsp" />
<div class="testbox">
  <h1>New Entry</h1>
  <form:form action="add" modelAttribute="data" method="post">
      <hr>
  <label id="icon" for="name"><i class="icon-asterisk "></i></label>
  <form:input type="text" path="name" name="name" id="name" placeholder="Website Name" required="true" />
  <label id="icon" for="url"><i class="icon-globe"></i></label>
  <form:input type="text" path="url" name="url" id="url" placeholder="Website URL" required="true" />
  <label id="icon" for="type"><i class="icon-collapse"></i></label>
  <form:select path="type" id="type" items="${adtypes}" multiple="false" required="true"/>
  <label id="icon" for="currbid"><i class="icon-money"></i></label>
  <form:input type="number" path="currbid" id="currbid" required="true"/>
  <label id="icon" for="starttime"><i class="icon-time"></i></label>
  <form:input type="datetime-local" path="starttime" id="starttime" required="true"/>
  <label id="icon" for="endtime"><i class="icon-time"></i></label>
  <form:input type="datetime-local" path="endtime" id="endtime" required="true"/>
  
    
    <br>
  
  <input type="submit" class="button" value="Add" />
  </form:form>
</div>
<br><br><br>
<hr>
${message }
	

</body>
</html>


