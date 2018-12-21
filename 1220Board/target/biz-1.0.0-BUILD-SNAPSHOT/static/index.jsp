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
</head>
<body>
	<div style="text-align:center;"><img src="static/images/bulletin-board.jpg"  /></div>
	<div style="margin-left: 100px; margin-right: 100px;">
		<table border="0" class="table table-hover">
			<tr>
				<td>[<a href="write">새 글쓰기</a>]
				</td>
				<td style="text-align:right;">[<span id="count"></span>]
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
			<tbody id="result"></tbody>
		</table>
	</div>
	<p></p>
	<div id="paging"></div>
</body>
</html>