<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>main</title>
</head>
<body>
<!-- 		<form method="post" action="/www/insert"> -->
	<form method="post" action="/controller/insert">
		<table border="1" align="center">
			<tr>
<!-- 					<tr><a href="http://daearcdo.cafe24.com/www/swipe">메인 페이지 이동</a><tr> -->
				<a href="http://localhost:8080/controller/swipe">메인 페이지 이동</a></br>
				<a href="http://localhost:8080/controller/logout">로그아웃</a>
			<tr>
			<tr align="center">
				<td>번호</td>
				<td>단어</td>
				<td>뜻</td>
				<td></td>
			</tr>

			<tr align="center">
				<td><input type="text" name="num" id="num" value="${count}"></td>
				<td><input type="text" name="email" id="email"></td>
				<td><input type="text" name="phone" id="phone"></td>
				<td colspan="2" align="center"><input type="submit" value="추가">
				</td>
			</tr>
			</form>
			<c:forEach items="${result}" var="member">
<!-- 						<form method="post" action="/www/update"> -->
				<form method="post" action="/controller/update">
				<tr align="center">
						<td><label>${member.num} </label><input type="hidden"
						name="num" value="${member.num}"></td>
					<td><input type="text" name="email" value="${member.email}"></td>
					<td><input type="text" name="phone" value="${member.phone}"></td>
					<%-- 										<td><input type="button" value="수정" onclick="location.href='http://daearcdo.cafe24.com/www/list?num=${member.num}'">  --%>
					<td><input type="submit" value="수정"> 
<%-- 															<input type="button" value="삭제" onclick="location.href='http://daearcdo.cafe24.com/www/delete?num=${member.num}'"></td> --%>
						<input type="button" value="삭제" onclick="location.href='http://localhost:8080/controller/delete?num=${member.num}'"></td>
				</tr>
				</form>
			</c:forEach>
		</table>
		<input type="button" value="테이블 전체 삭제" onclick="location.href='http://localhost:8080/controller/word/tabledrop'">
<!-- 			<input type="button" value="테이블 전체 삭제" onclick="location.href='http://daearcdo.cafe24.com/www/tabledrop'"> -->
</body>




</html>