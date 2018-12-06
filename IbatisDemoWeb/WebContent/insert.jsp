<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ibatis.common.resources.Resources" %>
    <%@ page import="com.ibatis.sqlmap.client.SqlMapClient" %>
    <%@ page import="com.ibatis.sqlmap.client.SqlMapClientBuilder" %>
    <%@ page import="com.example.vo.Employee" %>
    <%@ page import="java.io.Reader" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>

<jsp:useBean id="emp" class="com.example.vo.Employee">
	<jsp:setProperty name="emp" property="*"/>
</jsp:useBean>

<%
	Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
	SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
	smc.insert("Employee.insert",emp);//useBean 객체 = emp
	out.println("<h1> Insert Success </h1>");
%>