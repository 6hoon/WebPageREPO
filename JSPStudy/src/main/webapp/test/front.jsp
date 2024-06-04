<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="sample.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>insert_pro 테스트</h1>
	<form action="/JSPStudy/Proctest" method="post">
		<input class="request" type="text" name="id" id="id" size="25"
			minlength="3" maxlength="12" required placeholder="ID입력" /><br>
		<input class="request" type="password" name="pw" id="pw" size="25"
			minlength="6" maxlength="12" required placeholder="PW입력" /><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>
