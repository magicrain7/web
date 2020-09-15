<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 전체조회</h3>
	<table border="1" id="board">
		<thead>
			<tr>
				<th>게시글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성일자</th>
				<th>조회수</th>
				<th>첨부파일</th>
				<th>이미지</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board">
				<tr>
					<td><a href="BoardSelectAllAjaxServ?no=${board.getNo()}">${board.getNo()}</td>
					<td>${board.getPoster()}</a></td>
					<td>${board.getSubject()}</td>
					<td>${board.getContents()}</td>
					<td>${board.getLastpost()}</td>
					<td>${board.getViews()}</td>
					<td><a href="download.do?filename=${board.filename}">${board.getFilename()}</a></td>
					<td><c:if test="${not empty board.filename}">
							<img src="../images/${board.filename}" style="width: 50px">
						</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>