<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage = "error.jsp" import="java.util.ArrayList" %>
    <%!

    	String msg;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
	%>
	<h1> <%= msg  +" 님 로그인 되었습니다.!!!"%></h1>
	<a href="book.html">도서 등록</a><br>
	<a href="Login.html">로그아웃</a>
</body>
</html>