<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!private int number = 0; // 멤버변수

	public void jspInit() {
		System.out.println("_jspInit() 호출");
	}

	public void jspDestroy() {
		System.out.println("_jspDestroy() 호출");
	}%>

<%
int localNumber = 0; // 서비스의 지역변수
number++;
localNumber++;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>멤버변수 number = <%=number%></li>
		<li>지역변수(Service 함수) localNumber = <%=localNumber%></li>
	</ul>
</body>
</html>