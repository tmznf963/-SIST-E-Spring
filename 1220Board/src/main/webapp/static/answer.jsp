<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="board" value="${data}" />
<c:set var="currentPage" value="${page}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../static/css/bootstrap.min.css"	type="text/css" />
<script src="../../static/js/jquery.min.js"></script>
 <script>
/*  $(document).ready(function(){
		$.ajax({
			url : "answer",
			dataType : "json",
			method : "GET",
			success : function(data){
				var data = data.data;
				var title = "Re : " + data.title;
				var contents = "\r\n>\r\n>\r\n>\r\n>---------------------------\n";
						contents += data.contents;
				$("#txtTitle").val(title);
				$("#txtContents").val(contents);
			},
			error : function(err){
				console.log("Error 발생 : " + err);
			}
		});
		$("#btnCancel").bind("click", function(){
			history.back();
		});
	}); */
	$(function(){
		var Rcontents = "${board.contents}";
		$("#txtTitle").val("Re : "+ "${board.title}");
		var contents = "\r\n\r\n\r\n-----------------------------";
		contents += "\r\n>";
		contents += Rcontents.replace("<br>","\r\n");
		contents = contents.replace("''","'");	//홑홑 -> 홑
		contents = contents.replace("&lt;","<");
		contents = contents.replace("&gt;",">");
		$("#Contents").val(contents);
		
		$("#btnCancle").bind("click",function(){
			history.back();
		});
		
		$("#btnWrite").bind("click",function(){
			$.ajax({
				url : "../",
				dataType : "json",
				method : "POST",
				data : JSON.stringify({
					"name" : $("#txtName").val(),
					"email" : $("#txtEmail").val(),
					"title" : $("#txtTitle").val(),
					"contents" : $("#Contents").val(),
					"grp" : ${board.grp},
					"lev" : ${board.lev},
					"step" : ${board.step}
				}),
				contentType : "application/json; charset=utf-8",
				success : function(data){
					if(data.code){
						alert("Answer insert Success");
						//location.href = "../../"+${currentPage}+"/"+${board.idx};
						location.href="../../";
					}
				},
				error : function(err){
					console.log("err : " + err);
				}
			});
		});
	});
 </script>
</head>
<body>
	<h1 class="text-center">게시판 답글 쓰기</h1>
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
				<input type="text" class="form-control" id="txtTitle"   placeholder="Title">
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
				<button type="button" id="btnWrite" class="btn btn-primary">답글 쓰기</button>
				<button type="button" id="btnCancle" class="btn btn-danger">취소하기</button>
			</div>
		</div>
	</form>
</body>
</html>