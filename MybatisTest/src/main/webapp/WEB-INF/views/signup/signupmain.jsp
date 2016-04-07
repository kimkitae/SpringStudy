<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.test.account.*"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-Cache");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/js/jquery-2.1.4.min.js"></script>

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


<script>



	function openBlankFrame(frameName, width, height) {
		var winprops = "";
		var left = (screen.width - winWidth) / 2;
		var top = (screen.height - winHeight) / 2;

		winprops += "toolbar=no,menubar=no,scrollbars=yes,statusbar=no,resizable=yes";
		winprops += ",top=" + top + ",left=" + left + ",width=" + width
				+ ",height=" + height;

		window.open("", frameName, winprops);
	}

	function sendbutton(f) {

		var theForm = document.frm;
	    
	    

		if (f === "signup") {
			theForm.method = "POST";
			theForm.action = "/controller/signupinsert";
			theForm.submit();

		}
		if (f === "idCheck") {

	
			var oNewWin = window.open("", "NewWin",
					"scrollbars=1, menubar=1, resizable=1");
			theForm.target = "NewWin";

			theForm.action = "/controller/idcheck";

			theForm.method = "post";
			theForm.submit();

		}

	}
</script>

</head>
<body>
	<form name="frm">
		<table border="1" align="center">
			<tr>
				<!-- 					<tr><a href="http://daearcdo.cafe24.com/www/swipe">메인 페이지 이동</a><tr> -->
				<a href="http://localhost:8080/controller/swipe">메인 페이지 이동</a>
				</br>
				<a href="http://localhost:8080/controller/signin">로그인 페이지 이동</a>
			<tr>
			<tr align="center">
				<td>계정</td>
				<td>비밀번호</td>
				<td>권한</td>
				<td></td>
			</tr>

			<tr align="center">
				<td><input type="text" name="id"
					onkeyup="this.value=this.value.replace(/[^a-zA-Z]/g,'');" id="id">
					<input type="button" value="계정 중복체크하기"
					onclick="sendbutton('idCheck')"></td>

				<!-- 				<td><input type ="text" name="id" id="id"> </td> -->
				<td><input type="text" name="pwd" id="pwd"></td>
				<td><input type="radio" name="permission" value="teacher">선생님
					<input type="radio" name="permission" value="student"
					checked="checked">학생
				<td colspan="2" align="center"><input type="button"
					value="회원가입" onclick="sendbutton('signup')"> <!-- 				<input type="submit" value="회원가입"></td> -->
			</tr>
			</form>
			<c:forEach items="${result}" var="account">
				<!-- 						<form method="post" action="/www/signupupdate"> -->
				<form method="POST" action="/controller/signupupdate">
					<tr align="center">
						<td><label>${account.id} </label><input type="hidden"
							name="id" id="idz" value="${account.id}"></td>
						<td><input type="text" name="pwd" id="pwdz"
							value="${account.pwd}">${account.pwd}</td>
						<td><input type="text" name="permission"
							value="${account.permission}">${account.permission}</td>

						<td><input type="submit" value="수정"> <input
							type="button" value="삭제"
							onclick="location.href='http://localhost:8080/controller/signupdelete?id=${account.id}'"></td>
						<%-- 					<input type="button" value="삭제" onclick="location.href='http://daearcdo.cafe24.com/www/signupdelete?id=${account.id}'"></td> --%>

					</tr>
				</form>
			</c:forEach>
		</table>
		<input type="button" value="테이블 전체 삭제"
			onclick="location.href='http://localhost:8080/controller/signuptabledrop'">
		<!-- 			<input type="button" value="테이블 전체 삭제" onclick="location.href='http://daearcdo.cafe24.com/www/singuptabledrop'"> -->
		<!-- 	</form> -->
</body>

</html>