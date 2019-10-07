<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : ${member.name }<br>
아이디 : ${member.userid }<br>
이메일 : ${member.email }<br>
폰번호 : ${member.phone }<br>
<input type="button" value="메인으로" 
onclick="location.href='member.do?action=main'">
</body>
</html>