<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">



<title>Power Scope</title>
<meta name="description" content="">

<!-- Mobile viewport optimized: h5bp.com/viewport -->
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" media="screen"
	href="resources/html/css/superfish.css" />
<link rel="stylesheet" href="resources/html/css/nivo-slider.css"
	media="all" />
<link rel="stylesheet" href="resources/html/css/tweet.css" media="all" />
<link rel="stylesheet" href="resources/html/css/style.css">
<link rel="stylesheet" media="all"
	href="resources/html/css/lessframework.css" />

<!-- All JavaScript at the bottom, except this Modernizr build.
	   Modernizr enables HTML5 elements & feature detects for optimal performance.
	   Create your own custom Modernizr build: www.modernizr.com/download/ -->
<script src="resources/html/js/modernizr-2.5.3.min.js"></script>
</head>
<body>



	<!-- HEADER -->
	<header> <!-- header wrapper -->
	<div class="wrapper cf">
		<div id="logo">
			<a href="http://10.203.204.13:8080/spring/index"><img
				src="resources/html/img/newlogo.png" alt="" /></a>
		</div>
	</div>
	<!-- ENDS header wrapper --> <!-- nav --> <nav class="cf">
	<div class="wrapper cf">
		<ul id="nav" class="sf-menu">
			<li class="current-menu-item"><a
				href="http://10.203.204.13:8080/spring/index">HOME<i><b></b></i></a></li>
			<li><a
				href="http://10.203.204.13:8080/spring/result?service=voltvalues">DATA<i><b></b></i></a>
				<ul>
					<li><a
						href="http://10.203.204.13:8080/spring/result?service=ocb">OCB</a></li>
					<li><a
						href="http://10.203.204.13:8080/spring/result?service=syrup">Syrup</a></li>
					<li><a
						href="http://10.203.204.13:8080/spring/result?service=sdk">통합SDK</a></li>
					<li><a
						href="http://10.203.204.13:8080/spring/result?service=tmap">Tmap</a></li>
				</ul></li>
			<li><a href="http://10.203.204.13:8080/spring/macro">Macro<i><b></b></i></a></li>

		</ul>
		<div id="combo-holder"></div>
	</div>
	</nav> <!-- ends nav --> </header>
	<!-- ENDS HEADER -->


	<!-- MAIN -->
	<div role="main" id="main">
		<div class="wrapper">

			<!-- SLIDER -->
			
			<!-- ENDS SLIDER -->


			<!-- headline -->
			<div class="headline">choose! Service</div>
			<!-- ENDS headline -->


			<!-- Feature -->
			<ul id="filter-container-feature" class="feature">
				<li><a
					href="http://10.203.204.13:8080/spring/result?service=ocb"
					class="thumb"><img src="resources/html/img/icon/ocb.jpg" alt="" />
						<div class="date">
							<span class="d"></span><span class="m">OCB</span>
						</div> </a>
					<div class="caption">OK CASH BAG</div></li>
				<li><a
					href="http://10.203.204.13:8080/spring/result?service=syrup"
					class="thumb"><img src="resources/html/img/icon/syrup.jpg"
						alt="" />
						<div class="date">
							<span class="d"></span><span class="m">Syrup</span>
						</div> </a>
					<div class="caption">Syrup</div></li>
				<li><a
					href="http://10.203.204.13:8080/spring/result?service=sdk"
					class="thumb"><img
						src="resources/html/img/icon/sdk.jpg" alt="" />
						<div class="date">
							<span class="d"></span><span class="m">SDK</span>
						</div> </a>
					<div class="caption">통합 SDK</div></li>

				<li><a
					href="http://10.203.204.13:8080/spring/result?service=tmap"
					class="thumb"><img
						src="resources/html/img/icon/tmap.jpg" alt="" />
						<div class="date">
							<span class="d"></span><span class="m">TMAP</span>
						</div> </a>
					<div class="caption">T-MAP</div></li>

			</ul>
			<!-- ENDS feature -->


		</div>
	</div>
	<!-- ENDS MAIN -->


	<footer> <!-- wrapper -->
	<div class="wrapper cf">



		<!-- widgets -->
		

			

			

			
		<!-- ENDS widgets -->


		<div id="footer-bottom">
			Power Scope by  <a href="http://10.203.204.13:8080/spring/index">QA Infra Team!</a>
					
		</div>


	</div>
	<!-- ENDS wrapper --> </footer>


	<!-- JavaScript at the bottom for fast page loading -->

	<!-- Grab Google CDN's jQuery, with a protocol relative URL; fall back to local if offline -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="resources/html/js/jquery-1.7.1.min.js"><\/script>')
	</script>

	<!-- scripts concatenated and minified via build script -->
	<script src="resources/html/js/custom.js"></script>

	<!-- superfish -->
	<script src="resources/html/js/superfish-1.4.8/js/hoverIntent.js"></script>
	<script src="resources/html/js/superfish-1.4.8/js/superfish.js"></script>
	<script src="resources/html/js/superfish-1.4.8/js/supersubs.js"></script>
	<!-- ENDS superfish -->

	<script src="resources/html/js/tweet/jquery.tweet.js"></script>
	<script src="resources/html/js/jquery.isotope.min.js"></script>
	<script src="resources/html/js/jquery.nivo.slider.js"></script>
	<script src="resources/html/js/css3-mediaqueries.js"></script>
	<script src="resources/html/js/tabs.js"></script>
	<script src="resources/html/js/poshytip-1.1/src/jquery.poshytip.min.js"></script>
	<!-- end scripts -->

</body>
</html>