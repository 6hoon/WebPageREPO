<%@page import="memberone.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="vo" class="memberone.StudentVO" scope="page">
	<jsp:setProperty name="vo" property="*" />
</jsp:useBean>
<%
StudentDAO dao = StudentDAO.getInstance();
String loginID = (String) session.getAttribute("loginID");
vo.setId(loginID);
int count = dao.updateMember(vo);
%>
<%
if (count != -1) {
%>
<html>
<head>
<title>Update Process</title>
</head>
<meta http-equiv="Refresh" content="3;url=login.jsp">
<body>
	<center>
		<font size="5" face="바탕체"> 입력하신 내용대로 <b>회원정보가 수정 되었습니다.</b><br></br>
			3초후에 Logon Page로 이동합니다
		</font>
	</center>
</body>
</html>
<%
} else {
%>
<script>
	alert("수정이 완료되지 않았습니다");
	history.go(-1);
</script>
<%
}
%>
