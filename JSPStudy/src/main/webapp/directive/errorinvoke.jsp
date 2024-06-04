<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="/error/error.jsp"%>
<%
String name = "";
try {
	name = request.getParameter("name");
	if (request.getParameter("name").equals("")) {
		name = "blank";
	}
} catch (NullPointerException e) {
	name = "null";
} catch (Exception e) {
	name = "error";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		name 파라미터값
		<%=name%>
	</h1>
</body>
</html>