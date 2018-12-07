<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.ibatis.common.resources.Resources" %>
    <%@ page import="com.ibatis.sqlmap.client.SqlMapClient" %>
    <%@ page import="com.ibatis.sqlmap.client.SqlMapClientBuilder" %>
    <%@ page import="com.example.vo.Employee" %>
    <%@ page import="java.io.Reader" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	int id = Integer.parseInt(request.getParameter("id")); //이전 페이지에서 받는 값
    	Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
    	SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
    	Employee emp = (Employee)smc.queryForObject("Employee.getOne",id);//한개만 가져오기,네임스페이스.태그id
    	pageContext.setAttribute("myemp",emp);
    	out.print(emp);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update title here</title>
</head>
<body>
	<form action="update_ok.jsp" method="post">
		<input type="hidden" name="id" value="${mymep.id}"><!-- 누구의 id인지 값 넘기기 -->
		<ul>
			<li> First Name : <input type="text" name="first_name" value="${myemp.first_name}"></li>
			<li> Last Name : <input type="text" name="last_name" value="${myemp.last_name}"></li>
			<li> Salary : <input type="text" name="salary" value="${myemp.salary}"></li>
			<li> <input type="submit" value="수정하기"></li>
		</ul>
	</form>
</body>
</html>