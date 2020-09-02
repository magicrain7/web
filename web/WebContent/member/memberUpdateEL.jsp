<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdateEL  </title>
<script>
function inputCheck(){
	//id,pw 필수입력 체크
	if(frm.id.value =="") {
		window.alert("id 입력");
		frm.id.focus();
		return false;
	}
	if(frm.pw.value =="") {
		alert("pw 입력");
		frm.pw.focus();
		return false;
	}
	//job(select 태그) 선택되었는지 확인
	if(frm.job.value ==""){
	/* if(frm.job.selectedIndex>0) */
		alert("job선택");
		frm.job.focus();
		return flase;
	}
	
	//radio, checkbox
	var gender=
		document.querySelectorAll("[name='gender']:checked").length;
	if(gender==0){
		alter("성별 적어도 하나는 선택");
		return false;
	}
	// 회원가입폼 제출
	/* frm.submit(); */
	return true;
}
</script>
</head>
<body>
<%@include file="/common/header.jsp" %>

<h3 class ="page_title">회원등록</h3>
<form method="post" name="frm" 
	  id="frm" action="memberUpdate"
	  onsubmit="return inputCheck()">
	<div>
	<label for="id">id</label>
		<input id="id" name="id" value="${login.id }" readonly="readonly">
	</div>
	
	<div>	
	<label for="pw">password</label>
		<input type="password" id="pw" name="pw" value="${login.pw }">
	</div>
	
	<div>
	<label>성별</label>
		<input type="radio" id="male" name="gender" value="male"
			<c:if test="${login.gender=='male' }">checked="checked"</c:if>>남
		<label for="male" class="label2"></label>
		<input type="radio" id="female" name="gender" value="female" 
			<c:if test="${login.gender=='female' }">checked="checked"</c:if>>여 
		<label for="female" class="label2"></label>
	</div>
	
	<div >
	<label for="job">직업</label>
	<select name="job" id="job" >
		<option value="">선택</option>
		<option value="program">프로그래머</option>
		<option value="degin">디자이너</option>
	</select>
	</div>
	
	<div>
	<label for="reason">가입</label>
	<textarea id="reason" name="reason">${login.reason }</textarea>
	</div>
		
	<div class="regist">
		<label for="mailyn">메일수신</label>
		<input type="checkbox" name="mailyn">
	</div>
	
	<div>
	<%
		String hobby = member.getHobby();
		if( hobby == null){
			hobby = "";
		}
	%>
		<label for="hobby">취미</label>
		<input type="checkbox" name="hobby" value="read">독서
		<input type="checkbox" name="hobby" value="game">게임
		<input type="checkbox" name="hobby" value="ski">스키
		
	</div>
	
	<div >
		<button type="reset">초기화</button>
		<button>등록</button>
	</div>
</form>
</body>
</html>