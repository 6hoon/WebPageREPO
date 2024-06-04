<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
String name = "Marcus_Lim";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello jsp</h2>
	<h3>
		Time and Date<%=new java.util.Date()%></h3>
	<h3>
		너의 이름은｡
		<%=name%></h3>
</body>
</html>