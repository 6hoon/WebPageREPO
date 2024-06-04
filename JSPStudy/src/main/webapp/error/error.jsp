<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isErrorPage="true"%>
<%
response.setStatus(HttpServletResponse.SC_OK);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외발생</title>
</head>
<body>
	<h1>에러페이지</h1>
	<hr>
	요청 처리과정에서 예외처리가 발생하였습니다
	<br> 에러타입:
	<%=exception.getClass().getName()%>
	<br> 에러메세지:
	<%=exception.getMessage()%>

</body>
</html>