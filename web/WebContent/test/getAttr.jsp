<%@page import="test.ShareObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>request : ${data.str } ${data.count }</h4>
<%
	ShareObject obj1 = (ShareObject)request.getAttribute("data");
	if(obj1 != null){
		out.print(obj1.getStr());
		out.print(obj1.getCount());
	}
%>

<h4>session : ${sessionScope.data.str } ${data.count }</h4>
<%
	ShareObject obj2 = (ShareObject)session.getAttribute("data");
	if(obj2 != null){
		out.print(obj2.getStr());
		out.print(obj2.getCount());
	}
%>

<h4>파라미터 : ${param.name } ${param["name"]} ${paramValues.name[0]}</h4>
<%= request.getParameter("name") %>
<%= request.getParameterValues("name")[0] %>

<h4>헤더 : ${header["user-Agent"] }</h4>
<%=request.getHeader("user-Agent") %>

<h4>컨텍스트패스 ${pageContext.request.contextPath }</h4>
<%= request.getContextPath() %>
</body>
</html>