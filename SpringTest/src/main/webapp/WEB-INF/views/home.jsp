<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%
String dev = "http://localhost:8080/spring/";
String prod = "http://daearcdo.cafe24.com/www/";
String url = dev;
%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href="http://daearcdo.cafe24.com/www/macro">매크로 관리</a><br>
<form name="tablesend" action="/result" method="get">

<h1>소모 전류 측정 값</h1><br>
<%-- <a href="http://10.203.204.13:8080/spring/result?service=${table}" target="_blank">${table} --%>

<table border="1" style="width: 100%">
<tr>
<th>Service </th>
</tr>
<c:forEach var="table" items="${tables}"> 
<tr>

<!-- <td><a href="http://localhost:8080/spring/result?service=${table}" target="_blank">${table}</td> -->
<td><a href="http://daearcdo.cafe24.com/www/result?service=${table}" target="_blank">${table}</td>

</tr>
</c:forEach>
</table>

<!-- </form> -->
</body>
</html>
