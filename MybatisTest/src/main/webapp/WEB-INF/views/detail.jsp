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
<form  method="post" action="/controller/insert">
	<table border="1">
		<tr>
			<td>�̸�</td>
			<td>�̸���</td>
			<td>��ȭ��ȣ</td>
			<td></td>
		</tr>

		
		<c:forEach items="${result}" var="member">
			<tr>
				<td><a href="http://daearcdo.cafe24.com/controller/list?num=${member.num}">${member.num}</a></td>
				<td>${member.email}</td>
				<td>${member.phone}</td>
				<td><input type="button" value="����" onclick=""> <input
					type="button" value="����"></td>
			</tr>
		</c:forEach>
	</table>

</form>
</body>
</html>