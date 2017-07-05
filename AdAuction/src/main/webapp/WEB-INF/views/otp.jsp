
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Activation Page</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link href="<c:url value='/static/css/form.css' />" rel="stylesheet"></link>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
</head>
<body>

	<div class="testbox">
  <h1>Activation</h1>
  
  <c:if test="${message!=null}">
  		<script>
  			alert("${message}");
  		</script>
  </c:if>
  

  <form:form action="activate" modelAttribute="usero" method="post">
    	
	<hr>
  <label id="icon" for="email"><i class="icon-envelope "></i></label>
  <input type="text" name="email" id="email" value="${email}" readonly/>
  <label id="icon" for="otp"><i class="icon-unlock-alt"></i></label>
  <form:input type="text" path="otp" name="otp" id="otp" placeholder="OTP" required="true"/>
  
  <form:input type="hidden"  id="id" path="id" value="${id}" />
  
  <input type="submit" class="button" value="Activate" />
  </form:form>
</div>
</body>
</html>

