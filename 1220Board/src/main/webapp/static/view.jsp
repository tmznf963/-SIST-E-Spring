<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="board" value="${data}" />
<c:set var="currentPage" value="${page}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 확인</title>
<link rel="stylesheet" href="../static/css/bootstrap.min.css"
	type="text/css" />
<script src="../static/js/jquery.min.js"></script>
<script>
	var idx = null;
	$(document).ready(function() {
		var idx = ${board.idx};
		
		$("#txtIdx").val("${board.idx}");
		$("#txtWritedate").val("${board.writedate}");
		$("#txtName").val("${board.name}");
		$("#txtEmail").val("${board.email}");
		$("#txtReadnum").val("${board.readnum}");
		$("#txtTitle").val("${board.title}");
		var rs = "${board.contents}".replace("\r\n", "");
			var contents = rs;
			contents += contents.replace("<br />", "\r\n");
			contents  = contents.replace("''", "'"); 
			contents = contents.replace("&lt;", "<");
			contents = contents.replace("&gt;", ">");
		$("#txtContents").val(contents);
		
		replyView();//댓글보여줘
		
		$("#btnCancel").bind("click",function(){
			location.href="/board/";
		});
		
		$("#btnDelete").bind("click",function(){
			$.ajax({
				url : "/board/"+idx,
				//dataType: "json", RequestBody로 받을거 아니면 안적어두 된다.
				method : "DELETE",
				success : function(data){
					alert("${board.name}님의 게시글이 삭제되었습니다.");
					location.href="/board/";
				},
				error : function(err){
					console.log("err 발생 : " + err);
				}
			});
		})
		
		$("#btnUpdate").bind("click",function(){
			$.ajax({
				url : "/board/"+idx,
				dataType : "json",  // Controller - RequestBody 가 받는 type
				method : "PUT",
				contentType : "application/json; charset=UTF-8",	//보내는 Type
				data : JSON.stringify({
					 "email" : $("#txtEmail").val(),
					 "title" : $("#txtTitle").val(),
					 "contents" : $("#txtContents").val()
				 }),
				success : function(data){
					alert("${board.name}님의 게시글이 수정되었습니다.");
					location.href="/board/";
				},
				error : function(err){
					console.log("err 발생 : " + err);
				}
			});
		});
		
		$("#btnAnswer").click(function(){//page가 따라 붙으니깐 자신 위로 ../
			location.href="../answer/${currentPage}/" + idx;   //--> /board/answer/1/1234
		});
		
		$("#replyWrite").click(function(){
			$.ajax({
				url : "/board/reply",
				method : "POST",
				dataType :"json" ,
				contentType : "application/json; charset=utf-8",  //json방식 POST 하려면 필요.
				data : JSON.stringify({
					"parent" :  parseInt(idx),						//정수로 넘기기위해
					"writer" :  $("#newReplyWriter").val(),
					"text" :  $("#newReplyText").val()
				}),
				success : function(data){
// 					if(data.code){// == true
// 						alert("Reply Insert Success");
// 					}
					replyView();
					$("#newReplyWriter").val("");//댓글이 성공적으로 insert되면 내용 초기화
					$("#newReplyText").val("");
				},
				error : function(err){
					console.log("err : "+err);
				}
			});
		});
		
										
	});//function()
	
	function replyView(){ //댓글 모두 보기
						// url , data , function()
		$.getJSON("/board/reply/all/"+parseInt(${board.idx}),function(data){
			//console.log(data);
			var data = data.data;
			str = "";
			$(data).each(function(){//data가 array라서 반복문
				str +="<li id='"+this.idx+"' class='replyLi'>" +
						  "<p class='replyText'>"+this.text+"</p>" +
						  "<p class='replyWriter'>"+this.writer+"</p>" +
						  "<p><button type='button' class='btn btn-warning btnReplyUpdate'>수정하기</button>&nbsp;&nbsp;"+
						  "<button type='button' class='btn btn-danger btnReplyDelete'>삭제하기</button></p>" +
						  "</li>";
				str+="</hr>";
			});
			$("#replyList").html(str);
		});
	
		//댓글 삭제                  event , selecter , handler
		$("#replyList").on("click",".replyLi .btnReplyDelete", function(){
			var id = $(this).parent().parent().attr("id");// this = button, 부모 = p , 부모 = li 의 속성id값
			//console.log(id);
			$.ajax({
				url : "/board/reply/"+parseInt(id),
				dataType: "json", 	//오는 data
				method : "DELETE",
				success : function(data){
					if(data.code) replyView();
				}
			});
		});//댓글 삭제
		
		//댓글 수정                  event , selecter , handler
		var flag = true;
		var replyLi = null;
		$("#replyList").on("click",".replyLi .btnReplyUpdate", function(){
			if(flag){//label에서 textarea 로 변경
				var id = $(this).parent().parent().attr("id");// this = button, 부모 = p , 부모 = li 의 속성id값
				replyLi = $(this).parent().parent();
				var text = replyLi.find(".replyText").text(); //reply의 텍스트값 가져오기
				var newTag = "<textarea rows='3' cols='30' id='replyUpdateText' class='replyText'>"+ text + "</textarea>";
				replyLi.find(".replyText").replaceWith(newTag);
				$(this).text("수정완료");//button
				$(this).attr("class","btn btn-success btnReplyUpdate");
				flag = false;
			}else{//textarea에서 label로 변경
				replyLi = $(this).parent().parent();
				var id = $(this).parent().parent().attr("id");
				$.ajax({
					url : "/board/reply",
					dataType : "json",
					method : "PUT",
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify({
						"idx" : parseInt(id),
						"text" : replyLi.find(".replyText").val()
					}),
					success : function(data){
						if(data.code){
							replyView();
							flag = false;
						}
					},
					error : function(err){
						console.log("err :" +err);
					}
				});
				
			}
		});//댓글 수정
	}//replyView()
	
</script>
</head>
<body>
	<h1 class="text-center">게시판 글 확인</h1>
	<form class="form-horizontal">
		<div class="form-group">
			<label  class="col-sm-3 control-label">글번호</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="txtIdx" readonly>
			</div>
			<label  class="col-sm-2 control-label">조회수</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="txtReadnum" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">작성날짜</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="txtWritedate" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="txtName" class="col-sm-3 control-label">작성자</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="txtName"
					placeholder="Writer" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="txtEmail" class="col-sm-3 control-label">Email</label>
			<div class="col-sm-6">
				<input type="email" class="form-control" id="txtEmail"
					placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<label for="txtTitle" class="col-sm-3 control-label">제목</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="txtTitle"
					placeholder="Title">
			</div>
		</div>
		<div class="form-group">
			<label for="txtContents" class="col-sm-3 control-label">내용</label>
			<div class="col-sm-6">
				<textarea class="form-control" rows="5" id="txtContents"
					placeholder="Contents"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="text-center">
				<button type="button" class="btn btn-warning" id="btnUpdate">
					<span class="glyphicon glyphicon-cog" aria-hidden="true"></span> 수정하기
				</button>
				<button type="button" class="btn btn-danger" id="btnDelete">
					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 삭제하기
				</button>
				<button type="button" class="btn btn-info" id="btnAnswer">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 답변하기
				</button>
				<button type="button" class="btn btn-success" id="btnCancel">
					<span class="glyphicon glyphicon-list" aria-hidden="true"></span> 목록으로
				</button>
			</div>
		</div>
	</form>
	<hr />
	<div style="text-align:center;">
		<img src="<c:url value='../static/images/memo.png'/>" width="40" height="40" />
		<span style='font-size: 2em'>댓글 작성</span>
	</div>
	<form>
		<table style="margin-left: auto; margin-right: auto; width: 50%;">
			<tr>
				<td rowspan="2"><textarea id="newReplyText" name="text" rows="3" cols="50" placeholder="댓글 내용을 입력해주세요"></textarea></td>
				<td><input type="text" id="newReplyWriter" name="writer"	placeholder="댓글작성자..." size="10"></td>
			</tr>
			<tr>
				<td><input type="button" id="replyWrite" value="저장"	style="width: 100px; background-color: skyblue; color: white; font-weight: 700" />
				</td>
			</tr>
		</table>
	</form>
	<div>
		<div style="text-align:center;">
			<ul  id="replyList" style="list-style:none;"></ul>
		</div>
	</div>
</body>
</html>