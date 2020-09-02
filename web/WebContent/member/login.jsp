<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getAttribute("errormsg") %>
	
	<form method="post" name="frm" 
		  id="frm" action="login">
		<div>
		<label for="id">id</label>
			<input id="id" name="id">
		</div>
		
		<div>	
		<label for="pw">password</label>
			<input  id="pw" name="pw">
		</div>
		<button>로그인</button>
	</form>
</body>
</html>