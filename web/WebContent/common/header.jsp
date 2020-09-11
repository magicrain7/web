<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul>
	<c:if test="${empty sessionScope.id }">
		<li><a href="/web/member/login.jsp">로그인</a>
	</c:if>	
	<c:if test="${not empty sessionScope.id }">
		<li>${sessionScope.id}님 <a href="<%=application.getContextPath() %>/member/logout">로그아웃</a>
		<li><a href="<%=application.getContextPath() %>/member/memberUpdate">정보수정</a>
	</c:if>
		<li><a href ="<%=application.getContextPath() %>/dept/DeptInsert">부서등록품</a> 
		<li><a href ="<%=application.getContextPath() %>/dept/deptSelectAll">부서전체조회</a>
		<li><a href ="<%=application.getContextPath() %>/member/memberInsert">회원가입</a> <!--절대경로 -->
		<li><a href ="<%=application.getContextPath() %>/member/memberSelectAll">회원전체조회</a>
		<li><a href ="<%=application.getContextPath() %>/board/boardSelectAll.do">boardAll</a>
</ul>