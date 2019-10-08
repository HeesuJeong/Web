<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <%!
    	String msg1;
    	String msg2;
    %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg1 = (String) request.getAttribute("msg1");
		String msg2 = (String) request.getAttribute("msg2");
	%>
	<h1 style="text-align:center"><%= msg1%></h1>
	<p style="text-align:center"> <%= msg2%></p>
	
</body>
</html>