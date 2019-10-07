<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, edu.ssafy.model.MemVO"%>

<!-- 임포트는 페이지 directory에서!! -->
<!-- 클래스도 import해줘야해 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- <%
	ArrayList<MemVO> list = (ArrayList<MemVO>) request.getAttribute("list");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<script>
function logout(){
	location.href="main.do?action=logOut";
}
</script>
<style type="text/css">
body{
height:1000px;
width:500px;
}
</style>
</head>
<body>
<jsp:include page="logout.jsp"></jsp:include>
	<div align="center">
		<h1>회원 목록</h1>
		<table border="1">
		<tr>
		<td colspan="4"><input type="text" name="findname" id="findname"></td>
		<td><input type="submit" value="검색"></td>
		</tr>
			<tr>
				
				<th>아이디</th>
				<th>이름</th>
				<th>주소</th>
				<th>나이</th>
				<th>번호</th>
				<!-- scriplet을 사용해서 리스트 내용 반복해 -->

				<%-- <%
					for (int i = 0; i < list.size(); i++) {
				%> --%>
				
				<!-- requestScope은 생략가능 -->
			<c:forEach items="${requestScope.list}" var="memvo">
			<tr>
				<%-- <td><%=list.get(i).getId()%></td> --%>
				<td>${memvo.id} </td>
				<!-- 아이디 클릭할 때 아이디 넘겨준다/ 키값 uid로 해보쟈 -->
				<td><a href="main.do?action=meminfo&uid=${memvo.id} ">${memvo.name}</a></td>
				<td>${memvo.addr} </td>
				<td>${memvo.age} </td>
				<td>${memvo.tel} </td>
			</tr>
			</c:forEach>
			<%-- <%
				}
			%> --%>
			</tr>
		</table>
		<a href="index.html">초기화면</a>
	</div>
</body>
</html>