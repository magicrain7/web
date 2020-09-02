<%@page import="member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member All</title>
<style>
/* table,th,td {
	border: 1px solid black;
} */
</style>
</head>
<body>
<%@include file="/common/header.jsp" %>
<h3>회원 전체조회</h3>
<ul class="search">
	<li>메일수신여부</li>
	<li>성별<li>
	<li><button type="button">검색</button>
</ul>
	

<table id = "member" border="1">
	<thead>
	<tr>
		<th>id</th>
		<th>pw</th>
		<th>job</th>
		<th>gender</th>
		<th>mail</th>
		<th>reason</th>
	</tr>
	</thead>
	<%
		ArrayList<MemberVO> list = 
			(ArrayList<MemberVO>)request.getAttribute("list");
	
		for(MemberVO member : list) {
	%>
	<tr>
	<td ><a href="memberSelect.jsp"><%=member.getId() %></td>
	<td><%=member.getPw() %></td>
	<td><%=member.getJob() %></td>
	<td><%=member.getGender() %></td>
	<td><%=member.getMailyn() %></td>
	<td><%=member.getReason() %></td>
	</tr>
	<% } %>

	
</table>
</body>
</html>