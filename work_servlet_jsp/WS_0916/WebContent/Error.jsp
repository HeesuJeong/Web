<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String msg1=(String)request.getAttribute("msg1");
String msg2=(String)request.getAttribute("msg2");
%>
<h1><%= msg1 %></h1>
</br>
<%= msg2 %>
</body>
</html>