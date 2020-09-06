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
<h3>전체사원</h3>
<table border="1">
	<tr>
		<th>사원 번호</th>
		<th>이름</th>
		<th>부서번호</th>
	</tr>
	
	<c:forEach items="${empList }" var ="empList">
		<tr>
			<td><a href="empUpdate?employee_id=${empList.employee_id }">${empList.employee_id }</a></td>
			<td>${empList.last_name }</td>
			<td>${empList.department_id }</td>
		</tr>
	</c:forEach>
</table>
</body>

</html>