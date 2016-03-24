<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.test.mybatis.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>detail</title>
</head
>
<body>
<!-- <form  method="post" action="http://daearcdo.cafe24.com/www/update"> -->
<form  method="post" action="http://localhost:8080/controller/update">
	<table border="1">
		<tr>
			<td>번호</td>
			<td>단어</td>
			<td>뜻</td>
			<td></td>
		</tr>

		
		<c:forEach items="${result}" var="member">
			<tr>
			<td><label>${member.num} </label><input type="hidden"  name="num" value="${member.num}" ></td>
				<td><input type="text" name="email" value="${member.email}" > </td>
				<td><input type="text" name="phone" value="${member.phone}"></td>
				<td><input type="submit" value="수정" > 
<%-- 				<input type="button" value="삭제" onclick="location.href='http://daearcdo.cafe24.com/www/delete?num=${member.num}'"></td> --%>
				<input type="button" value="삭제" onclick="location.href='http://localhost:8080/controller/delete?num=${member.num}'"></td>
			</tr>
		</c:forEach>
	</table>

</form>

</body>
</html>