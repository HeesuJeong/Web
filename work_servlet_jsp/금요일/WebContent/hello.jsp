<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%String greeting=(String)request.getAttribute("greeting"); %>
	서버가 준 인사는 <%=greeting %> --%>
	
	서버가 준 인사는 ${greeting }
	
<!-- 	EL문법>>attribute의 키값을 적어주면 값을 꺼내서 갖다놔줍니다 -->


</body>
</html>