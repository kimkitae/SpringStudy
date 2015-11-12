<%@page import="java.util.ArrayList"%>
<%@page import="Datebase.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	DAO dao = new DAO();
	ArrayList<DTO> list = dao.select();
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" width="100%"
		class="select_tb">

		<tr>
			<th width="80px" style="border-right: 1px solid #ebebeb">번호</th>
			<th>내용</th>
			<th width="100px" style="border-right: 1px solid #ebebeb">작성일자</th>





		</tr>

		<%
			for (DTO dto : list) {
				int num = dto.getNum();
				String device = dto.getDevice();
				String model = dto.getModel();
		%>

		<!-- todaydiary -->
		<tr>
			<td><h1>
					<a href="retrieve.jsp?num=<%=num%>"><%=num%></a>
				</h1></td>
			<td><%=device%></td>
			<td><%=model%></td>
		</tr>
		<%
			}
		%>
	</table>

	<a href="insert.jsp">작성하기</a>
	<a href="index.jsp">처음으로 </a>
	</br>
</body>
</html>