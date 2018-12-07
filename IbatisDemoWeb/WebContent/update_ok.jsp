<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ibatis.common.resources.Resources"%>
<%@ page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page import="com.ibatis.sqlmap.client.SqlMapClientBuilder"%>
<%@ page import="com.example.vo.Employee"%>
<%@ page import="java.io.Reader"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8" />
<jsp:useBean id="emp" class="com.example.vo.Employee">
	<jsp:setProperty name="emp" property="*" />
</jsp:useBean>
<!-- 이전페이지 tagname과 bean의 property이름이 같을 때 "*"-->

<%
	Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
	SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
	smc.update("Employee.update", emp);//xml == parameterClass="emp"
%>
<h1>Update Success</h1>