<%@page import="memberone.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
StudentDAO dao = StudentDAO.getInstance();
String id = request.getParameter("id");
String pass = request.getParameter("pass");
int check = dao.loginCheck(id, pass);
String message = "";

if (check == 1) {//로그인 성공 -> 세션에 등록
	session.setAttribute("loginID", id); // 이미 세션을 가져왔기에 request.getSession 안해도 서비스가 들고옴
	response.sendRedirect("login.jsp"); // redirect 방식으로 다시 login.jsp 호출
} else if (check == 0) {//아이디는 있는데 비밀번호 오류
	message = "비밀번호가 틀렸습니다";
} else {
	message = "아이디가 존재하지 않습니다";
}
%>
<script>
 alert("<%=message%>");
	history.go(-1);
</script>
