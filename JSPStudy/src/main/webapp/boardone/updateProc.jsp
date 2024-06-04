<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="boardone.BoardDAO"%>
<%@ page import="java.sql.Timestamp"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="article" scope="page" class="boardone.BoardVO">
	<jsp:setProperty name="article" property="*" />
</jsp:useBean>
<%
// 빈에서 못받는 데이터 값을 지역변수로 받는다
String pageNum = request.getParameter("pageNum");
BoardDAO dbPro = BoardDAO.getInstance();
int check = dbPro.updateArticle(article);
// 1: 수정성공, 0: 암호불일치, -1: DB오류 
if (check == 1) {
%><meta http-equiv="Refresh"
	content="0;url=list.jsp?pageNum=<%=pageNum%>">
<%
} else if (check == 0) {
%>
<script language="JavaScript">
	alert("비밀번호가 맞지 않습니다");
	history.go(-1);
</script>
<%
} else {
%>
<script language="JavaScript">
	alert("DB 오류발생");
	history.go(-1);
</script>
<%
}
%>
