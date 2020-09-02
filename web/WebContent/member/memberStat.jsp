<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/common/header.jsp" %>
<h3>회원통계</h3>
<h3>남여비율</h3>
<% List<HashMap<String, Object>> list = 
		(List<HashMap<String, Object>>)request.getAttribute("genderCnt");
	for( HashMap<String, Object> temp : list) {
		out.print(temp.get("gender"));
%>
	<span><%=temp.get("gender") %></span>
	<span><%=temp.get("cnt") %></span><br>
<%
	}
%>
<h5>직업별 회원수</h5>
<h5>메일수신 회원수: </h5>
<%=request.getAttribute("mailCnt") %>
</body>
</html>