<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 class = "page_title">insert board</h3>
<form id="frm" name="frm" method="post" 
	  enctype ="multipart/form-data"
	  action="boardInsert.do" >
<!-- 	   <div>
	  	<label for="no">NO</label>
	  	<input type="text" id="no" name="no">
	  </div>
	   -->
	  <div>
	  	<label for="poster">poster</label>
	  </div>
	  	<input type="text" id="poster" name="poster">
	  
	  <div>
	  	<label for="subject">subject</label>
	  	<input type="text" id="subject" name="subject">
	  </div>
	  
	  <div>
	  	<label for="contents">contents</label>
	  	<input type="text" id="contents" name="contents">
	  </div>
	  
	  <div>
	  	<label for="filename">file</label>
	  	<input type="file" id="filename" name="filename">
	  </div>
	  
	  <div>
	  	<button>등록</button>
	  	<button type="reset">초기화</button>
	  </div>
		  
</form>
</body>
</html>