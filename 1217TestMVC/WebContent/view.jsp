<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${member}" var="member"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<div>
<h1>Join</h1>
	<form action="update.do" method="post">
		<ul>
			<li>ID : <input type="text" name="userid"  value="${member.userid}"/></li>
			<li>이름 : <input type="text" name="name" value="${member.name}"/></li>
			<li>나이 : <input type="number" name="age" value="${member.age}"/></li>
			<li>성별 : 
			<c:if test="${member.gender eq '남성' }">
					<input type="radio" name="gender" value="남성" checked="checked"/>남성
			        <input type="radio" name="gender" value="여성"/>여성</li>
			</c:if>
			<c:if test="${member.gender ne '남성' }">
					<input type="radio" name="gender" value="남성" />남성
			        <input type="radio" name="gender" value="여성" checked="checked"/>여성</li>
			</c:if>
			<li>거주지 : <input type="text" name="city" value="${member.city}"/></li>
			<li><input type="submit" value="수정하기" /></li>
		</ul>
	</form>
</div>
</body>
</html>