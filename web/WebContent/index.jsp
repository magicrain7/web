<%@page import="test.ShareObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <% ShareObject obj1 = (ShareObject)application.getAttribute("data1"); 
	if(obj1 == null) {
	obj1.setCount(obj1.getCount()+1);
%>
<br>application: <%= obj1.getStr() %> :<%= obj1.getCount() %>

<% ShareObject obj2 = (ShareObject)session.getAttribute("data"); 
	obj2.setCount(obj2.getCount()+1);
%>
<br>session:  <%= obj2.getStr() %> :<%= obj2.getCount() %>
<% } %> --%>

<%@include file="/common/header.jsp" %>
메인페이지.

</body>
</html>