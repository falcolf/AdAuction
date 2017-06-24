<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Login and Registration Form with HTML5 and CSS3</title>
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
		<link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
		<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
    	<link href="<c:url value='/static/css/form.css' />" rel="stylesheet"></link>
    </head>
    <body>
        <div class="container">
           
            <header>
                <h1>Login and Registration Form</h1>
				
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form:form  action="login" method="post" modelAttribute="user" autocomplete="on"> 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="email" > E-Mail </label>
                                    <form:input path="email"  type="email" placeholder="eg:admin@adauction.gmail.com"/>
                                </p>
                                <p> 
                                    <label for="password"> Password </label>
                                    <form:input path="password" type="password" placeholder="eg. X8df!90EO" /> 
                                </p>
                               
                                <p> 
                                   <input type="submit" value="Login" />
								</p>
                                <p class="change_link">
									Not a member yet ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                            </form:form>
                        </div>

                        <div id="register" class="animate form">
                            <form:form  action="register" method="post" modelAttribute="user" autocomplete="on"> 
                                <h1> Sign up </h1> 
                                <p> 
                                    <label for="name" > Name </label>
                                    <form:input path="name" type="text" placeholder="Ad Auction" />
                                </p>
                                <p> 
                                    <label for="email"> E-Mail </label>
                                    <form:input path="email" type="email" placeholder="eg:admin@adauction.com"/> 
                                </p>
                                <p> 
                                    <label for="password"> Password </label>
                                    <form:input path="password" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                    <label for="adhaarno"> Adhaar Number </label>
                                    <form:input path="adhaarno" placeholder="eg. PA1102007"/>
                                </p>
                                <p > 
									<input type="submit" value="Sign Up">
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register"> Go and log in </a>
								</p>
                            </form:form>
                        </div>
						
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>