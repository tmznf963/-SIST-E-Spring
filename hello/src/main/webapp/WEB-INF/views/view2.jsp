<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>맛있는 과일 순서</h1>
<ol>
	<c:forEach items="${fruits}" var="fruit">
		<li>${fruit}</li>
	</c:forEach>
</ol>
</body>
</html>