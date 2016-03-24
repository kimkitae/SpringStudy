<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="java.util.*,com.test.mybatis.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>결과창</title>
</head>
<body>

<table border="1">
	 <tr>
		 <td width="50px" align="center">번호</td>
		 <td align="center">단어</td>
		 <td align="center">뜻</td>
	 </tr>
	 <!-- result는 contoller의 addObject로 부터 가져온다. -->
	 <c:forEach items="${result}" var="member">
		 <tr>
			 <td>${member.num}</td>
			 <td>${member.email}</td>
			 <td>${member.phone}</td>	
		 </tr>
	 </c:forEach>

</table>

</body>
</html>