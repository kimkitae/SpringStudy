<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Macro Page</title>
</head>
<body>


</form>
<form action="macroexe" method="get">

<input type="submit" value="매크로 생성">

<table border="1" style="width: 100%">
		총 갯수 ${macros.size()} 건
		<tr>
			<th>회차</th>
			<th>동작여부</th>
			<th>성공여부</th>
			<th>실행시간</th>
		</tr>
		<c:set var="size" value="${macros.size()}" />
		<c:choose>
		<c:when test="${size eq 0}">
		<tr>
			<td colspan="5">매크로 실행 관련 이력이 존재 하지 않습니다.</td>	
				</tr>
		</c:when>
		
		<c:otherwise>
		<c:forEach var="cal" items="${macros}">
			<tr>
				<td>${cal.getNum()}</td>
				<td>${cal.getStats()}</td>
				<td>${cal.getResult()}</td>
				<td>${cal.getTime()}</td>
			</tr>
			</c:forEach>
			
			
	</table>
</c:otherwise>
</c:choose>
</body>
</html>