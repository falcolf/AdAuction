<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="now" class="java.util.Date" />
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Registration Page</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link href="<c:url value='/static/css/regform.css' />" rel="stylesheet"></link>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
</head>
<body>
<div class="testbox">
  <h1>Registration</h1>

  <form:form action="register" modelAttribute="user" method="post">
      <hr>
  <label id="icon" for="email"><i class="icon-envelope "></i></label>
  <form:input type="text" path="email" name="email" id="email" placeholder="Email" required="true" />
  <label id="icon" for="adhaarno"><i class="icon-credit-card"></i></label>
    <form:input type="text" path="adhaarno" name="adhaarno" id="adhaarno" placeholder="Adhaar Number" required="true" />
   <label id="icon" for="name"><i class="icon-user"></i></label>
  <form:input type="text" name="name" path="name" id="name" placeholder="Name" required="true"/>
  <label id="icon" for="password"><i class="icon-shield"></i></label>
  <form:input type="password" name="password" path="password" id="password"  placeholder="Password" required="true"/>
    
    <br>
   <p> Already A Member? <a href="login">Login Here</a>.</p>
  <input type="submit" class="button" value="Register" />
  </form:form>
</div>
<br><br><br>
<hr>
${message }
	

</body>
</html>


