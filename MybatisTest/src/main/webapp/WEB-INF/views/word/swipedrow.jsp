<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.test.word.*"%>
<%
 response.setHeader("Pragma", "No-cache"); 
 response.setDateHeader("Expires", 0); 
 response.setHeader("Cache-Control", "no-Cache"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영단어 뒤집기</title>
<link href="http://fonts.googleapis.com/css?family=Rock+Salt"
	rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script src="resources/js/jquery-2.1.4.min.js"></script>
<script src="resources/js/jquery.flip.min.js"></script>
<style>
.card {
	height: 10em;
	text-align: center;
	vertical-align: middle;
	line-height: 10em;
	font-family: 'Rock Salt', cursive;
	font-size: 1.5em;
	margin: 2em 1em;
}

.front, .back {
	margin: 0;
	padding: 0;
	background: #FFF;
}

.front {
	color: #403F31;
	background: #A3C6BE;
}

.back {

	background: #87A18E;

	color: #000;

}

body {
	padding-top: 40px;
}

header {
	background: #f5b335;
	height: 40px;
	position: fixed;
	top: 0;
	z-index: 9999;
	transition: top 0.2s ease-in-out;
	width: 100%;
}

.nav-up {
	top: -40px;
}

</style>
<script>
	var didScroll;
	var lastScrollTop = 0;
	var delta = 5;
	var navbarHeight = $('header').outerHeight();

	$(window).scroll(function(event) {
		didScroll = true;
	});

	setInterval(function() {
		if (didScroll) {
			hasScrolled();
			didScroll = false;
		}
	}, 250);

	function hasScrolled() {
		var st = $(this).scrollTop();

		if (Math.abs(lastScrollTop - st) <= delta)
			return;

		if (st > lastScrollTop && st > navbarHeight) {
			$('header').removeClass('nav-down').addClass('nav-up');
		} else {
			if (st + $(window).height() < $(document).height()) {
				$('header').removeClass('nav-up').addClass('nav-down');
			}
		}

		lastScrollTop = st;
	}
</script>

</head>

<header class="nav-down"> 
	<p><a href="http://localhost:8080/controller/main">단어 관리 페이지 이동</a> // <a href="http://localhost:8080/controller/signup">회원 가입 페이지 이동</a> // <a href="http://localhost:8080/controller/signin">로그인 페이지 이동</a>  // <a href="http://localhost:8080/controller/logout">로그아웃</a></p>
<!-- 	<p><a href="http://daearcdo.cafe24.com/www/main">단어 관리 페이지 이동</a> // <a href="http://daearcdo.cafe24.com/www/signupmain">회원 가입 페이지 이동</a></p> -->
	
	</header>
<body>

	



	<div id="wrapper">
		<c:forEach items="${result}" var="member">
			<div id="card-1" class="card">
				<div class="front">${member.num}/${member.email}</div>
				<div class="back">${member.phone}</div>
			</div>

	</c:forEach>
	</div>






</body>
<script>
	$(function() {
		// $(".card").flip();

		$(".card").flip({
			axis : "y", // y or x
			reverse : false, // true and false
			trigger : "click", // click or hover
			speed : 1000
		});

	});
</script>

</html>
