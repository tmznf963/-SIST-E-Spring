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
 <img src="images/user.png"/>
 <h1>MemberList</h1>
 <div><a href="join.do">[Join]</a></div>
 <table border="1">
 	<thead>
 		<tr>
 			<th>ID</th><th>Name</th><th>Age</th><th>Gender</th><th>City</th>
 		</tr>
 	</thead>
 	<tbody>
 		<c:forEach items="${list}" var="member">
 			<tr>
 				<td><a href="view.do?userid=${member.userid}">${member.userid}</a></td>
 				<td>${member.name}</td>
 				<td>${member.age}</td>
 				<td>${member.gender}</td>
 				<td>${member.city}</td>
 			</tr>
 		</c:forEach>
 	</tbody>
 </table>
</body>
</html>