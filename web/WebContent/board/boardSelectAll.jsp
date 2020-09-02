<%@page import="board.BoardVO"%>
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
<h3 class="page_title">조회</h3>
<table border="1">
	<thead>
		<tr>
			<th>NO</th>
			<th>poster</th>
			<th>subject</th>
			<th>contents</th>
			<th>lastpost</th>
			<th>views</th>
			<th>file</th>
		</tr>
	</thead>
	<%
		ArrayList<BoardVO> list = 
			(ArrayList<BoardVO>)request.getAttribute("list");
	
		for(BoardVO board : list) {
	%>
	<tr>
	<td ><a href="boardSelectAll.jsp=<%=board.getNo() %>"><%=board.getNo() %></td>
	<td><%=board.getPoster() %></td>
	<td><%=board.getSubject() %></td>
	<td><%=board.getContents() %></td>
	<td><%=board.getLastpost() %></td>
	<td><%=board.getViews() %></td>
	<td><%=board.getFilename() %></td>
	</tr>
	<% } %>
	
</table>

</body>
</html>