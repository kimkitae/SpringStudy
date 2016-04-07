<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.test.account.*"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-Cache");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, user-scalable=no">
<style>
tr {
	width: 100%;
}

td {
	width: 20%
}

table {
	width: 100%
}
</style>
<title>Login</title>
<script>

setTimeout("location.href='http://localhost:8080/controller/swipe'",1000);
</script>

</script>
</head>
<body>
<!-- 		<form method="post" action="/www/signupinsert"> -->
		<table border="1" align="center">
			<tr>
<!-- 					<tr><a href="http://daearcdo.cafe24.com/www/swipe">메인 페이지 이동</a><tr> -->
				<a href="http://localhost:8080/controller/word/swipe">메인 페이지 이동</a></tr></table></br></br>
				
				
				<p>${message1}</p>
				<p>${message2}</p>
				
	</body>
<script>


</script>
</html>