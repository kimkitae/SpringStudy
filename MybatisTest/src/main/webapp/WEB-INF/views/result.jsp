<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="java.util.*,com.test.mybatis.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���â</title>
</head>
<body>

<table border="1">
	 <tr>
		 <td width="50px" align="center">��ȣ</td>
		 <td align="center">�ܾ�</td>
		 <td align="center">��</td>
	 </tr>
	 <!-- result�� contoller�� addObject�� ���� �����´�. -->
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