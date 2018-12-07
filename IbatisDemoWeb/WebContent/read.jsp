<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ibatis.common.resources.Resources" %>
    <%@ page import="com.ibatis.sqlmap.client.SqlMapClient" %>
    <%@ page import="com.ibatis.sqlmap.client.SqlMapClientBuilder" %>
   <%@ page import="com.example.vo.Employee" %>
    <%@ page import="java.io.Reader,java.util.List" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
  	  Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
   	 SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
   	 List<Employee>list = smc.queryForList("Employee.getAll");
   	 pageContext.setAttribute("mylist",list);//pageContext에 넣어서 아래 forEach문에
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>
</head>
<body>
	<h1>Employee List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th><th>First Name</th><th>Last Name</th><th>Salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${mylist}" var="row">
			<tr>
				<td>${row.id}</td><td>${row.first_name}</td><td>${row.last_name}</td><td>${row.salary}</td>
				<!-- items는 돌릴 대상 , ${row.id}는 getId()에서 get빼고 소문자 -->
			</tr>
			</c:forEach>
		</tbody>
	
	</table>
	<hr>
	<form action="delete_ok.jsp" method="post">
		삭제할 회원 번호 : <input type="number" name="id"/>
		<button type="submit">삭제하기</button>
	</form>
</body>
</html>