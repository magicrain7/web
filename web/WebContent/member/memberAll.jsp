<%@page import="member.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<th>regdate</th>
	</tr>
	</thead>
	
	<c:forEach items="${list}" var="member">
		<td><a href="#">${member.id}</a></td>
		<td>${member.pw }</td>
		<td>${member.getJob()}</td>
		<td>${member.getGender() }</td>
		
		<td>${member.mailyn}<c:if test="${member.mailyn.equals('Y')}">
			<button type="button">메일전송</button></c:if></td>
		</td>	
		<td>${member.reason }</td>
		
		<td>
			<fmt:parseDate value="${member.regdate}" pattern="yyyy-MM-dd HH:mm:ss" var="parseToday"/>
			<fmt:formatDate value="${parseToday}" pattern="MM-dd"/>
		</td>
				
	</c:forEach>
<%-- 		ArrayList<MemberVO> list = 
			(ArrayList<MemberVO>)request.getAttribute("list");
	
		for(MemberVO member : list) {
	
	<tr>
	<td ><a href="memberSelect.jsp"><%=member.getId() %></td>
	<td><%=member.getPw() %></td>
	<td><%=member.getJob() %></td>
	<td><%=member.getGender() %></td>
	<td><%=member.getMailyn() %></td>
	<td><%=member.getReason() %></td> --%>
	</tr>
	<%-- <% } %> --%>

	
</table>
</body>
</html>