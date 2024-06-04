<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="boardone.BoardDAO"%>
<%@ page import="java.sql.Timestamp"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="article" class="boardone.BoardVO" scope="page">
	<jsp:setProperty name="article" property="*" /></jsp:useBean>
<%
article.setRegdate(new Timestamp(System.currentTimeMillis()));
article.setIp(request.getRemoteAddr());
// 싱글톤
BoardDAO dpPro = BoardDAO.getInstance();
boolean flag = dpPro.insertArticle(article);
if (flag == true) {
	response.sendRedirect("list.jsp");
} else {
	String message = "입력 실패";
%>
<script>
 alert("<%=message%>
	");
	history.go(-1);
</script>
<%
}
%>
