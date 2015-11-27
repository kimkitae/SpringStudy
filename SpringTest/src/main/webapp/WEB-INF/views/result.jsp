
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">



<title>Service Table</title>
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
</head>
<script src="resources/html/js/modernizr-2.5.3.min.js"></script>
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

			<!-- headline -->
			<div class="headline">
				${service1} </br>
				총 TC : ${service.size()} 건
			</div>
			<!-- ENDS headline -->


			<!-- 	<form name="macrosend" method="get" action="macroexe"> -->
			<!-- 	</form> -->

			<table
				style="border: 2px solid gray; width: 60%; height: 100px; margin: auto; text-align: center;">
				
				<tr>
					<th style="border: 1px solid gray;">번호</th>
<!-- 					<th style="border: 1px solid gray;">서비스명</th> -->
					<th style="border: 1px solid gray;">TC명</th>
					<th style="border: 1px solid gray;">평균 소모 값</th>
					<th style="border: 1px solid gray;">생성시간</th>
				</tr>
				<c:set var="size" value="${service.size()}" />
				<c:choose>
					<c:when test="${size eq 0}">
						<tr>
							<td colspan="5">등록된 데이터가 존재 하지 않습니다.</td>
						</tr>
					</c:when>

					<c:otherwise>
						<c:forEach var="cal" items="${service}">
							<tr>
								<td style="border: 1px solid gray;">${cal.getNum()}</td>
<%-- 								<td style="border: 1px solid gray;">${cal.getService()}</td> --%>
								<td style="border: 1px solid gray;"><a
									href="http://10.203.204.13:8080/spring/value?tc=${cal.getName()}&service=${cal.getService()}"
									target="_blank">${cal.getName()}</td>
								<td style="border: 1px solid gray;"><fmt:formatNumber
										value="${cal.getResult()}" pattern="0.00" /></td>
								<td style="border: 1px solid gray;">${cal.getTime()}</td>

							</tr>
						</c:forEach>
			</table>
			</c:otherwise>
			</c:choose>
			<!-- ENDS feature -->


		</div>
	</div>
	<!-- ENDS MAIN -->
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