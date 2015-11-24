<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Macro Page</title>


<script type="text/javascript" language=javascript">
	function btn() {
// 	      document.location.href = "macroexe"; 
      window.open("macroexe", "_blank", "width="+300+",height="+300+",resizable=1,scrollbars=1") ; 
		document.getElementById("btn1").disabled = true;
		window.location.reload();
	}

	function init() {

		var laststats = "${laststats}";
		var laststatssize = "${macros.size()}"

		if (laststatssize >= 1) {

			if (laststats == "START") {

				document.getElementById("btn1").disabled = true;
				alert("현재 매크로 파일 생성 작업이 실행 중인 상태 입니다");
			} else if (laststats == "STOP") {

				document.getElementById("btn1").disabled = false;
				alert("현재 매크로 파일 생성 작업이 대기 중인 상태 입니다");
			} else {

				document.getElementById("btn1").disabled = false;
				alert("매크로 작업이 정상 종료가 되지 않았습니다.");
			}

		} else {
			alert("매크로 작업 이력이 존재하지 않습니다.");

		}
	}
</script>


</head>
<body onload="init()">





<!-- 	<form name="macrosend" method="get" action="macroexe"> -->
		<input type="submit" id="btn1" value="매크로 생성" onclick="btn()">
<!-- 	</form> -->


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