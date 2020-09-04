<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsList.jsp</title>
</head>
<body>
<form action="cartAdd" method="post">
	<select size="10" name="goods">
		<option>노트북
		<option>TV
		<option>자동차
		<option>과자
	</select>
	<button>장바구니 등록</button>
</form>
<a href="cart.jsp">장바구니보기</a>
</body>
</html>