<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="user" value="${member}" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="/biz/static/js/jquery.min.js"></script>
	<script>
		$(function(){
			$("#btnList").bind("click", function(){
				location.href = "/biz/list";
			});
			$("#btnDelete").bind("click", function(){
				location.href = "/biz/delete/${user.userid}";
			});
		});
	</script>
</head>
<body>
	<h1>${user.username}의정보</h1>
	<form action="/biz/update" method="post">
		<input type="hidden" name="userid" value = "${user.userid}" />
		<ul>
			<li>아이디 : ${user.userid }</li>
			<li>나이 : <input type='number' name="userage" value='${user.userage}' /></li>
			<li>성별 : <c:if test='${user.gender eq "남성"}'>
					<input type="radio" name="gender" value="남성" checked />남성&nbsp;&nbsp;
				    <input type="radio" name="gender" value="여성" />여성
					</c:if> 
					<c:if test='${user.gender eq "여성"}'>
					<input type="radio" name="gender" value="남성" />남성&nbsp;&nbsp;
				<input type="radio" name="gender" value="여성" checked />여성
			</c:if>
			</li>
			<li>거주지 : <input type="text" name="city" value="${user.city }" /></li>
			<li><input type='submit' value='수정하기' /></li>
			<li><input type='button' value='삭제하기'  id="btnDelete"/></li>
			<li><input type='button' value='목록으로'  id="btnList"/></li>
		</ul>
	</form>
</body>
</html>