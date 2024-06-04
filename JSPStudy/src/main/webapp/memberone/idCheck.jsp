<%@page import="memberone.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
StudentDAO dao = StudentDAO.getInstance();
String id = request.getParameter("id");
boolean check = dao.idCheck(id);
%>
<html>
<head>
<title>ID중복체크</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
</head>
<body bgcolor="#FFFFCC">
	<br>
	<center>
		<b><%=id%></b>
		<%
		int flag = 1;
		if (check) {
			out.println("는 이미 존재하는 ID입니다.<br></br>");
		} else {
			out.println("는 사용 가능 합니다.<br></br>");
			flag = 2;
		}
		%>
		<a href="#" onClick="closeWin(<%=flag%>);">닫기</a>
	</center>
</body>
</html>