<%@page import="com.project.model.Auction"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Bidding Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="AdAuction">
    <meta name="author" content="Parth Agarwal">
    <link rel="icon" href="/AdAuction/static/img/fav.png">
    <link rel="shortcut icon" href="/AdAuction/static/img/fav.png">
<link href="<c:url value='/static/css/home.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/form.css' />" rel="stylesheet"></link>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
</head>
<body>
<%
   response.setIntHeader("Refresh", 10);
%>
  <jsp:directive.include file = "nav.jsp" />
<%
		Auction auc =(Auction) request.getAttribute("auction");
		Calendar c=Calendar.getInstance();
		Date d=c.getTime();
		if(!d.after(auc.getStarttime())){
			request.setAttribute("message","Auction Yet to be started");
			response.sendRedirect("/AdAuction/user");
	}
%>
<div class="testbox">
<h1>Bid</h1>
<form:form name="bidform" action="confBid" modelAttribute="auction" method="post" onsubmit="return validation()">
<hr>
  <label id="icon" for="bid"><i class="icon-money "></i></label>
  <input type="text" name="bid" id="bid" value="${auction.currbid}" readonly/>
  <label id="icon" for="password"><i class="icon-legal"></i></label>
  <form:input type="number" name="currbid" path="currbid" id="currbid" placeholder="Bid" required="true"/>
  <form:input type="hidden"  id="id" path="id" value="${auction.id}"/>
  <input type="submit" class="button" value="Bid" />
  </form:form>
</div>
<script>
function validation() {
   var x = document.forms["bidform"]["currbid"].value;
   var y = document.forms["bidform"]["bid"].value;
    if (x<=y) {
        alert("Bid should be greater Than previous one");
        return false;
    }}
</script>

<br><br><br>
<hr>
${message}

</body>
</html>



