<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width: 100%">
		총 갯수 ${members.size()} 건
		<tr>
			<th>번호</th>
			<th>서비스명</th>
			<th>단말기명</th>
			<th>TC명</th>
			<th>회차</th>
			<th>로그캣</th>
			<th>덤프시스</th>
			<th>총 평균</th>
		</tr>
		<c:set var="size" value="${members.size()}" />
		<c:choose>
		<c:when test="${size eq 0}">
		<tr>
			<td colspan="5">등록된 데이터가 존재 하지 않습니다.</td>	
				</tr>
		</c:when>
		
		<c:otherwise>
		<c:forEach var="cal" items="${members}">
			<tr>
				<td>${cal.getNum()}</td>
				<td>${cal.getService()}</td>
				<td>${cal.getDevice()}</td>
				<td>${cal.getTc()}</td>
				<td>${cal.getRound()}</td>
				<td>${cal.getLogcat()}</td>
				<td>${cal.getDump()}</td>
				<td>${cal.getAverage()}</td>
			</tr>
			</c:forEach>
			
	</table>
</c:otherwise>
</c:choose>

</body>
</html>

</body>
</html>