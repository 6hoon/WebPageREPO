<%@page import="jdbc.TempMemberDAO"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<jsp:useBean id="dao" class="jdbc.TempMemberDAO" scope="page"></jsp:useBean>
	
	<h1>추가 완료</h1>
	<button type="button">
		<a href="http://localhost:8080/JSPStudy/jdbc/usingBean.jsp">리스트 보기</a>
	</button>
</body>
</html>