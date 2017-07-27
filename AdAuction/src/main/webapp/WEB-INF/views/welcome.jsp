<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="AdAuction">
    <meta name="author" content="Parth Agarwal">
    <link rel="icon" href="/AdAuction/static/img/fav.png">
    <link rel="shortcut icon" href="/AdAuction/static/img/fav.png">

    <title>AdAuction</title>

    <!-- CSS -->
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/font-awesome/css/font-awesome.min.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/nivo-lightbox.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/nivo-lightbox-theme/default/default.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/owl.carousel.css' />" rel="stylesheet" media="screen"></link>
    <link href="<c:url value='/static/css/owl.theme.css' />" rel="stylesheet" media="screen"></link>
    <link href="<c:url value='/static/css/animate.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/style.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/color/default.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/team.css' />" rel="stylesheet"></link>
    
    
    
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">

  
	<!-- Preloader -->
	<div id="preloader">
	  <div id="load"></div>
	</div>

	<!-- Section: intro -->
    <section id="intro" class="intro">
		<div class="slogan">
			<a href="welcome.jsp"><img src="/AdAuction/static/img/logo.png" alt="logo"	 /></a>
		</div>
		<div class="page-scroll">
			<a href="#about">
				<i class="fa fa-angle-down fa-5x animated"></i>
				

				<div class="col-md-12">
									<a href="login" class="btn btn-skin btn-lg btn-scroll" style="width: 100px ; height: 50px">Login</a>
									<a href="signup" class="btn btn-skin btn-lg btn-scroll" style="width: 120px; height: 50px">Register</a>
				</div>

			</a>
		</div>
    </section>
	<!-- /Section: intro -->
	
    <!-- Navigation -->
    <div id="navigation">
        <nav class="navbar navbar-custom" role="navigation">
                              <div class="container">
                                    <div class="row">
                                          <div class="col-md-12">
                         					<!-- Brand and toggle get grouped for better mobile display -->
                                       		<div class="navbar-header">
                                            	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
                                                	<i class="fa fa-bars"></i>
                                                </button>
                                          	</div>
                                            <!-- Collect the nav links, forms, and other content for toggling -->
                                            <div class="collapse navbar-collapse" id="menu">
                                            	<ul class="nav navbar-nav">
                                                	<li class="active"><a href="#intro">Home</a></li>
                                                    <li><a href="#about">About Us</a></li>
													<li><a href="#team">Team</a></li>                                
													<li><a href="#contact">Contact</a></li>
                                                </ul>
                                            </div>
                             			</div>
                                    </div>
                              </div>
                              <!-- /.container -->
           </nav>
    </div> 
    <!-- /Navigation -->  

	<!-- Section: about -->
    <section id="about" class="home-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
						<div class="section-heading text-center">
						<div class="wow bounceInDown" data-wow-delay="0.2s">
							<h2>We are AdAuctioners</h2>
						</div>
						<p class="wow bounceInUp" data-wow-delay="0.3s">We Help people get their Ads on popular websites...</p>
						</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<img src="/AdAuction/static/img/img1.jpg" class="img-responsive img-rounded" alt="" />
				</div>		
				<div class="col-md-6">
					<p><strong>How?</strong></p>
					<p>
					Need Avertisements? , contact us and we get them for you for the best price...OR...need to get you product to WORLD? We are there to bring you the best websites offering to put your ads on...
					</p>
					<a href="signup" class="btn btn-skin btn-lg btn-scroll">Wanna Bid?</a>
					<a href="#contact" class="btn btn-skin btn-lg btn-scroll">Get Ads</a>
				</div>
			</div>		
		</div>
	</section>
	<!-- Section: Team -->
    <section id="team" class="home-section text-center bg-gray">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
						<div class="section-heading">
							<h2>Team</h2>
								<p>Minds behind AdAuction...</p>
						</div>
					</div>
				</div>
			</div>
		</div>
			
		<div class="container"  >
			<div class="wow bounceInUp" data-wow-delay="0.4s">
            	<div id="owl-works" class="owl-carousel" >
                	<div class="container">
                    	<div class="row">
                        	<div class="heading-title text-center">
                            	<div class="col-md-8 col-sm-8 col-xs-12">
                            		<div class="team-member">
                                		<div class="team-img" align="center">
                                    		<img src="/AdAuction/static/img/gallery/1.jpg" class="img-responsive img-circle" alt="Parth Agarwal" width="30%">
                                		</div>
                                		<div class="team-hover">
                                    		<div class="desk">
                                        		<h4>Hey..!</h4>
                                        		<p>I Designed The Web-App..!</p>
                                    		</div>
                                    		<div class="s-link">
                                    			<a href="/AdAuction/static/img/gallery/1.jpg" title="Parth Agarwal : Web-Developer" data-lightbox-gallery="gallery1"><i class="fa fa-camera"></i></a>
                                        	</div>
                                		</div>
                            		</div>
                            		<div class="team-title">
                               			<h5>Parth Agarwal</h5>
                                		<span>Web Developer</span>
                            		</div>
                        		</div>
                       			<div class="col-md-8 col-sm-8 col-xs-12">
                            		<div class="team-member">
                                			<div class="team-img" align="center">
                                    			<img src="/AdAuction/static/img/gallery/2.jpg"  class="img-responsive img-circle" alt="Dhruve Moudgil" width="30%"> 
                                			</div>
                                			<div class="team-hover">
                                    			<div class="desk">
                                        			<h4>Hey..!</h4>
                                        			<p>I Designed the Android App..! </p>
                                    			</div>
                                    			<div class="s-link">
                                        			<a href="/AdAuction/static/img/gallery/2.jpg" title="Dhruve Moudgil : App-Developer" data-lightbox-gallery="gallery1"><i class="fa fa-camera"></i></a>
                                        		</div>
                                			</div>
                            			</div>
                           				<div class="team-title">
                                			<h5>Dhruve Moudgil</h5>
                                			<span>Android Developer</span>
                            			</div>
                        			</div>
                       			</div>
                        	</div>
						</div>
					</div>
				</div>
			</div>
           
	
	

	</section>
	<!-- /Section: services -->
	

	

	<!-- Section: contact -->
    <section id="contact" class="home-section text-center">
		<div class="heading-contact">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-md-offset-2">
						<div class="section-heading">
							<div class="wow bounceInDown" data-wow-delay="0.4s">
								<h2>Emails are always welcome</h2>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="row">
        		<div class="col-lg-8 col-md-offset-2">
            		<div class="form-wrapper marginbot-50">
            			<div class="text-center">
							<p class="lead"><i class="fa fa-envelope"></i> Email us at adauction@gmail.com</p>
						</div>
					</div>
				</div>	
			</div>
		</div>
	</section>
	
	<!-- /Section: contact -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<p>AdAuction</p>
				</div>
                <!-- 
                    All links in the footer should remain intact. 
                    Licenseing information is available at: http://bootstraptaste.com/license/
                    You can buy this theme without footer links online at: http://bootstraptaste.com/buy/?theme=Lonely
                -->
			</div>	
		</div>
	</footer>


 <!-- Core JavaScript Files -->
    <script src="/AdAuction/static/js/jquery.min.js"></script>
    <script src="/AdAuction/static/js/bootstrap.min.js"></script>
    <script src="/AdAuction/static/js/jquery.easing.min.js"></script>	
	<script src="/AdAuction/static/js/jquery.sticky.js"></script>
	<script src="/AdAuction/static/js/jquery.scrollTo.js"></script>
	<script src="/AdAuction/static/js/stellar.js"></script>
	<script src="/AdAuction/static/js/wow.min.js"></script>
	<script src="/AdAuction/static/js/owl.carousel.min.js"></script>
	<script src="/AdAuction/static/js/nivo-lightbox.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="/AdAuction/static/js/custom.js"></script>
   

</body>

</html>
