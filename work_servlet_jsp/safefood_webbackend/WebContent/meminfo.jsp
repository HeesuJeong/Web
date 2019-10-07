<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function updatemem() {
		rform.submit();
	}
	
</script>
</head>
<body>
<div align="center">
		<h1>회 원 정 보</h1>
		<form action="main.do?action=updatemem" method="post" id="rform">
			<table>
				<table>
<!-- //(String id, String pw, String name, String addr, String email, String tel, String alinfo) -->
			<tr>
				<td>아이디: </td>
				<td><input type="text" name="pid" id="pid"> </td>
			</tr>
			<tr>	
				<td>비밀번호: </td>
				<td><input type="text" name="ppw" id="ppw"> </td>
			</tr>
			<tr>
				<td>이름: </td>
				<td><input type="text" name="pname" id=""pname""> </td>
			</tr>
			<tr>
				<td>주소: </td>
				<td><input type="text" name="paddr" id="paddr"> </td>
			</tr>
			<tr>
				<td>이메일: </td>
				<td><input type="text" name="pemail" id="pemail"> </td>
			</tr>
			<tr>
				<td>전화번호: </td>
				<td><input type="text" name="ptel" id="ptel"> </td>
			</tr>
			

				<tr>
					<td colspan="1">
						<input type="button" value="수정" onclick="updatemem()">
					</td>
				</tr>

			</table>

		</form>
		<a href="main.html">초기화면</a>
	</div>
</body>
</html>