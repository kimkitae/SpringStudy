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
<script src="resources/js/jquery-2.1.4.min.js"></script>

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
<title>Login in</title>
<script>



</script>
</head>
<body>
<!-- 		<form method="post" action="/www/signupinsert"> -->
	<form method="post" action="/controller/login">
		<table border="1" align="center">
			<tr>
<!-- 					<tr><a href="http://daearcdo.cafe24.com/www/swipe">메인 페이지 이동</a><tr> -->
				<a href="http://localhost:8080/controller/swipe">메인 페이지 이동</a></br>
				<a href="http://localhost:8080/controller/signup">회원 가입 페이지 이동</a>
				
			<tr>
			<tr align="center">
				<td>계정</td>
				<td>비밀번호</td>
			</tr>

			<tr align="center">
				<td><input type="text" name="id" onkeyup="this.value=this.value.replace(/[^a-zA-Z]/g,'');" id="id" ></td> 
<!-- 				<td><input type ="text" name="id" id="id"> </td> -->
				<td><input type="text" name="pwd" id="pwd"></td>
				<td colspan="2" align="center"><input type="submit" value="로그인하기"></td>
			</tr>
			</form>
			
		</table>
	</body>
<script>


</script>
</html>