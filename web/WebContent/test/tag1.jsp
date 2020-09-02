<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    autoFlush="false" buffer="1kb"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>jsp, 스크립트 테스트</h3>
<!-- html 주석 -->
<%-- jsp 주석 --%>
<% //자바 주석 
	for(int i = 0; i<1024; i++) {
		out.print(1);
	}
	//버퍼지우기
	//out.clearBuffer(); //버퍼 내용을 지움
	//out.flush(); // 버퍼를 비운다 = 클라이언트 전송
%>
<hr>
버퍼 남은 크기: <%= out.getRemaining() %>	
</body>
</html>