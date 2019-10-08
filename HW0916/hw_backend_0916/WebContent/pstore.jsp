<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    String pname;
    String pprice;
    String pdes;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int isbn = (Integer)request.getAttribute("isbn");
		String pname = (String)request.getAttribute("pname");
		String pprice = (String)request.getAttribute("pprice");
		String pdes = (String)request.getAttribute("pdes");
	%>
	<h1>상품이 저장되었습니다.</h1>
	<table>
	<tr>
	<td style="text-align:center"><b>상품 번호</b> &nbsp;&nbsp; </td>
	<td><%=isbn %>
	</tr>
	<tr>
	<tr>
	<td style="text-align:center"><b>상 품 명</b>  &nbsp;&nbsp;</td>
	<td><%=pname %>
	</tr>
	<tr>
	<td style="text-align:center"><b>상품 가격</b>  &nbsp;&nbsp;</td>
	<td><%=pprice %>
	</tr>
	<tr>
	<td style="text-align:center"><b>상품 설명</b> &nbsp;&nbsp; </td>
	<td><%=pdes %>
	</tr>
	</table>
	<a href = "#">상품 목록</a>

</body>
</html>