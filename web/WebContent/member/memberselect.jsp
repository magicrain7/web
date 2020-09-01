<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member select</title>
</head>
<body>
<h3>내정보조회</h3>
<div><span class="label">아이디</span><span>chichi</span></div>
<div><span class="label">패스워드</span><span>1234</span></div>
<div><span class="label">직업</span><span>프로그래머</span></div>
<div><span class="label">성별</span><span>남</span></div>
<div><span class="label">메일수신여부</span><span>Y</span></div>
<div><span class="label">가입동기</span><span>취업</span></div>
<button type="button" id="btnPage">목록으로</button>
<script>
	btnPage.addEventListener("click",goPage);
	function goPage() {
		//https://goddaehee.tistory.com/121 브라우저 버전체크
		//history.back();
		//location.href="memberAll.jsp"
		//location.assign("memberAll.jsp")
		history.go(-1); //이전페이지로 이동.
	}
</script>
</body>
</html>