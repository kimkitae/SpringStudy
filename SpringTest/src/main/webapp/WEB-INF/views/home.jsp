<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<form name="tablesend" action="/result" method="get">
<h1>소모 전류 측정 값</h1>
<table border="1" style="width: 100%">
<tr>
<th>Service </th>
</tr>
<c:forEach var="table" items="${tables}"> 
<tr>

<!-- <td><a href="http://localhost:8080/spring/result?service=${table}" target="_blank">${table}</td> -->
<td><a href="http://10.203.204.13:8080/spring/result?service=${table}" target="_blank">${table}</td>

</tr>
</c:forEach>
</table>
<input type="submit" value="전송"/>
</form>
</body>
</html>
