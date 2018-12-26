<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Board</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="static/css/style.css" type="text/css">
<script src="static/js/jquery.min.js"></script>
<script>
var page = null;
$(function(){
	$.ajax({
		url :  "/board/1",
		dataType : "json",
		method : "POST",
		success : function(result){
				display(result);
		},
		error : function(err){
			console.log("err : " +err);
		}
	});
});

function goPage(pge) { //page 이동
	page = pge;
	$.ajax({
		url : "/board/"+ page,
		dataType : "json",
		method : "POST",
		success : function(result) {
			display(result);
		}
	});
}

function display(result) {
	var startPage = result.startPage;
	var endPage = result.endPage;
	var totalPage = result.totalPage;
	var pageSize = result.pageSize;
	page = result.page; //current Page
	var data = result.data;
	var count = data.length;
	$("#count").text(count);
	var str = null;
	if (count == 0) {
		str = "<tr>";
		str += "<td colspan='5' align='center'>";
		str += "글이 없습니다.</td>";
		str += "</tr>";
	} else if (count > 0) {
		for (var i = 0; i < count; i++) {
			var board = data[i];
			var email = board.email;
			var lev = board.lev;
			var writedate = board.writedate.substr(0, 10);
			var grp = null;
			var reimg = "";
			if(lev > 0) {
				for(var j = 0 ; j < lev ; j++){
					reimg += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				}
				reimg += "<img src='static/images/re.png' style='width:20px;height:20px'/>";
			}
			else reimg = "&nbsp;";
			str += "<tr>";
			if(lev>0) {grp="";}
			else {grp = board.grp;}
			str += "<td style='text-align:center'>" + grp + "</td>" +
							"<td style='text-align:center'><a href='mailto:" + email + "'>" + board.name + "</a></td>" +
							"<td>&nbsp;" + reimg + " <a href='/board/" + page + "/" + board.idx +"'>" + board.title + "</a></td>" +
							"<td style='text-align:center'>" + writedate + "</td>" +
							"<td style='text-align:center'>" + board.readnum + "</td>";
							str += "</tr>";
			}
	}
	$("#ListAll").html(str);
	$("#paging").empty();
	$("#paging").attr("style", "text-align:center");

	var pageStr = null;
	// <<  <
	if (page == 1) {
		pageStr = "&lt;&lt;&nbsp;&nbsp;";
		pageStr += "&lt;&nbsp;&nbsp;";
	} else if (page != 1) {
		pageStr = "<a href='javascript:goPage(1)'>&lt;&lt;</a>&nbsp;&nbsp;";
		if((startPage - pageSize) <= 0){
			pageStr += "<a href='javascript:goPage(" + 1	+ ")'>&lt;</a>&nbsp;&nbsp;";
		}else{
			pageStr += "<a href='javascript:goPage(" + (startPage - pageSize) 	+ ")'>&lt;</a>&nbsp;&nbsp;";
		}
	}
	// 1 2 3 4 5 6 7 8 9 10
	for (var k = startPage; k <= endPage; k++) {
		if (page == k)
			pageStr += "<span style='color:red;font-weight:bold'>" + k + "</span>&nbsp;&nbsp;&nbsp;";
		else
			pageStr += "<a href='javascript:goPage(" + k + ")'>" + k + "</a>&nbsp;&nbsp;&nbsp;";
	}
	// >  >>
	if (page == totalPage) {
		pageStr += "&gt;</a>&nbsp;&nbsp;";
		pageStr += "&gt;&gt;";
	} else if (page != totalPage) {
		pageStr += "<a href='javascript:goPage(" + (startPage + pageSize) + ")'>&gt;</a>&nbsp;&nbsp;";
		pageStr += "<a href='javascript:goPage(" + totalPage + ")'>&gt;&gt;</a>";
	}
	$("#paging").html(pageStr);
}
</script>
</head>
<body>
	<div style="text-align:center;"><img src="static/images/bulletin-board.jpg"  /></div>
	<div style="margin-left: 100px; margin-right: 100px;">
		<table border="0" class="table table-hover">
			<tr>
				<td>
					[ <a href="write">새 글쓰기</a> ]
				</td>
				<td style="text-align:right;">
					[ <span id="count"></span> ]
				</td>
			</tr>
		</table>
	</div>
	<div style="margin-left: 100px; margin-right: 100px;">
		<table border="1" class="table table-hover" >
			<colgroup>
				<col width="10%" />
				<col width="10%" />
				<col width="60%" />
				<col width="10%" />
				<col width="10%" />
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody id="ListAll"></tbody>
		</table>
	</div>
	<p></p>
	<div id="paging"></div>
</body>
</html>