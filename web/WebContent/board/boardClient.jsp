<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
$(function(){
	//목록조회
	function boardlist(){
		$.ajax( "../BoardSelectAllAjaxServ" , {	
				dataType : "json" ,
				success : function(datas){
					for(i=0;i<data.length; i++){
						$("<div>").append(datas[i].no)
								.append(datas[i].poster)
								.append(datas[i].subject)
								.data("no",datas[i].no)
								.append($("<button>").html("삭제").addClass("btnDel"))
								.appendTo($("#list"))
					}	
				}
		})
	}
	//삭제버튼
	$("#list").on("click",".btnDel",function() {
		no = $(this).parent().data("no");
		div = $(this).parent();
		$.ajax("../BoardDeleteAjaxServ", {
			//method :"get",
			dataType:"json" , //서버에서 넘겨주는 데이터 타입
			data : { no : no },
			success : function(data){
				alert(data.no + "삭제완료");
				div.remove();
			}
		})
	});

	
	//저장버튼
	$("#btnSave").on("click", function(){
		$.ajax("../BoardInsertAjaxServ", {
			dataType="json",
			data : $("form").serialize(),
			success : function(data){
				$("<div>").append(data.no)
						.append(datas[i].poster)
						.append(datas[i].subject)
						.data("no",datas[i].no)
						.append($("<button>").html("삭제").addClass("btnDel"))
						.appendTo($("#list"))
			}
		})
	})
	
	boardlist();
});
</script>
</head>
<body>
	<div data-id="4" data-goods="book" data-id="divid">data 연습</div>
	<!-- 목록  -->
	<div id="list"></div>
	<form>
		<input type="text" name="poster" placeholder="작성자" /> <input
			type="text" name="subject" placeholder="제목" />
		<textarea rows="4" cols="50" name="contents" placeholder="내용"></textarea>
		<button type="button" id="btnSave">버튼</button>
	</form>
</body>
</html>