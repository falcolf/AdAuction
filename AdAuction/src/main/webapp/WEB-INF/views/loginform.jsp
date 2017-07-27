
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="AdAuction">
    <meta name="author" content="Parth Agarwal">
    <link rel="icon" href="/AdAuction/static/img/fav.png">
    <link rel="shortcut icon" href="/AdAuction/static/img/fav.png">
<link href="<c:url value='/static/css/form.css' />" rel="stylesheet"></link>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
</head>
<body>



	<div class="testbox">
  <h1>Log In</h1>
  
  

  <form action="login" method="post">
    	
							  
   <hr>
  <label id="icon" for="email"><i class="icon-envelope "></i></label>
  <input type="text" name="email" id="email" placeholder="Email" required/>
  <label id="icon" for="password"><i class="icon-shield"></i></label>
  <input type="password" name="password" id="password" placeholder="Password" required/>
  <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
	
   <p> Not A Member Yet? <a href="signup">Register Here</a>.</p>
  <input type="submit" class="button" value="Log in" />
  </form>
</div>

<br><br><br>
<hr>

<c:if test="${param.error != null}">
								Invalid Credentials or account inactive
		</c:if>
		<c:if test="${param.logout != null}">
								Logged out successfully
	</c:if>
${message }

</body>
</html>



