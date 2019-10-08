<%@page import="java.util.ArrayList"%>
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
		String title = (String)request.getAttribute("title");
		String isbn = (String)request.getAttribute("isbn");
		String catalogue = (String)request.getAttribute("catalogue");
		String publisher = (String)request.getAttribute("publisher");
		String nation = (String)request.getAttribute("nation");
		String publisheDate = (String)request.getAttribute("publisheDate");
		String author = (String)request.getAttribute("author");
		String price = (String)request.getAttribute("price");
		String currency = (String)request.getAttribute("currency");
		String description = (String)request.getAttribute("description");
	%>
	
	<table border='1' width='1000' height='500' align='center'>

		<tr align='center' bgcolor='lightgray'>
			<p>
			<td colspan='2'><b>등록된 정보는 다음과 같습니다.</b></td>
			</p>
		</tr>

		<tr align='center'>
			<td bgcolor='lightgray'><b>도서명</b></td>
			<td><%=title%></td>
		</tr>

		<tr align='center'>
			<td width='300' bgcolor='lightgray'><b>도서번호</b></td>
			<td><%=isbn%></td>
		</tr>

		<tr align='center'>
			<td width='300' bgcolor='lightgray'><b>도서분류</b></td>
			<td>
			<%=catalogue%>
			</td>
		</tr>
		


		<tr align='center'>
			<td width='300' bgcolor='lightgray'><b>도서국가</b></td>
			<td><%=nation%></td>
		</tr>

		<tr align='center'>
			<td width='300' bgcolor='lightgray'><b>출판일</b></td>
			<td><%=publisheDate%></td>
		</tr>

		<tr align='center'>
			<td width='300' bgcolor='lightgray'><b>출판사</b></td>
			<td>
			 <%=publisher %>
			</td>
		</tr>
		



		<tr align='center'>
			<td width='300' bgcolor='lightgray'><b>저자</b></td>
			<td><%=author%></td>
		</tr>

		<tr align='center'>
			<td width='300' bgcolor='lightgray'><b>도서가격</b></td>
			<td><%=price + " " + currency%></td>
		</tr>

		<tr align='center'>
			<td width='300' bgcolor='lightgray'><b>도서설명</b></td>
			<td><%=description%></td>
		</tr>


	</table>
	<p align='center'>
		<a href='book.html'>도서 등록</a>
	</p>
</body>
</html>