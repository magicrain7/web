<%@page import="board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 class="page_title">조회</h3>
	<table border="1">
		<thead>
			<tr>
				<th>poster</th>
				<th>subject</th>
				<th>contents</th>
				<th>file</th>
			</tr>
		</thead>
		<c:forEach items="${list }" var="board">
			<tr>
				<td>${board.no }</td>
				<td>${board.poster}</td>
				<td>${board.subject}</td>
				<td>${board.contents }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>