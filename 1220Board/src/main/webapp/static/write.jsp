<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css"	type="text/css" />
<script src="static/js/jquery.min.js"></script>
 <script>
	 $(function(){
		 $("#btnList").bind("click",function(){
			 history.back();	 //location.href="/";
		 });
		 
		 $("#btnSend").bind("click",function(){
			 $.ajax({
				 url : "board/write",
				 dataType : "json",  //받는 type
				 method : "POST",
				 contentType : "application/json; charset=UTF-8",	//보내는 Type
				 data : JSON.stringify({
					 "name" :  $("#txtName").val(),
					 "email" : $("#txtEmail").val(),
					 "title" : $("#txtTitle").val(),
					 "contents" : $("#Contents").val()
				 }),
				 success : function(data){
					 alert(data.code);
					 location.href="/"; // index.html   || welcome 파일 경로
				 },
				 error : function(err){
					 console.log("err 발생 : " + err);
				 }
			 });
		 })
	 });
 </script>
</head>
<body>
	<h1 class="text-center">게시판 글 쓰기</h1>
	<form class="form-horizontal">
		<div class="form-group">
			<label for="txtName" class="col-sm-3 control-label">작성자</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="txtName"	placeholder="Writer">
			</div>
		</div>
		<div class="form-group">
			<label for="txtEmail" class="col-sm-3 control-label">Email</label>
			<div class="col-sm-6">
				<input type="email" class="form-control" id="txtEmail"	placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<label for="txtTitle" class="col-sm-3 control-label">제목</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="txtTitle"  placeholder="Title">
			</div>
		</div>
		<div class="form-group">
			<label for="txtTitle" class="col-sm-3 control-label">내용</label>
			<div class="col-sm-6">
				<textarea class="form-control" rows="5" id="Contents" placeholder="Contents"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="text-center">
				<button type="button" id="btnSend" class="btn btn-primary">글 쓰기</button>
				<button type="button" id="btnList" class="btn btn-info">목록으로</button>
			</div>
		</div>
	</form>
</body>
</html>