<%@ page session="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="user" value="${userVO}" />
<!-- 객체를 EL식 표현 할 때 -->
<html>
<head>
<title>회원가입확인 창</title>
</head>
<body>
	<h1>User Information : confirm3.jsp</h1>
	<ul>
		<li>성명 : ${user.username}</li>
		<li>나이 : ${user.userage}</li>
		<li>성별 : ${user.gender}</li>
		<li>거주지 : ${user.city}</li>
	</ul>
</body>
</html>
