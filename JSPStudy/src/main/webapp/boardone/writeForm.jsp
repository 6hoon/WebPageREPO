<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="view/color.jsp"%>
<html>
<head>
<title>My Board</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="script.js">
	
</script>
</head>
<%
/* 게시판 답글을 작성할때 사용
(num : db의 seq 값, ref : 첫 원글참조, step : 답글의 몇번째 step, depth : 참조글 + 1)
1. ref 기준 정렬
2. step 기준 정렬
3. 찍을때 depth 값으로 간격폭 찍어줌

- 새료운 step 1의 답글을 달 때 -> 이전 참조 되던 것들을 ++ 하여 step을 뒤로 밀어버림
ref 가 같고 step >= 1 인 것들은 ++ 해서 저장
*/
int num = 0, ref = 1, step = 0, depth = 0;
try {
	if (request.getParameter("num") != null) {
		// 누르고 들어온 원글의 데이터 값
		num = Integer.parseInt(request.getParameter("num"));
		ref = Integer.parseInt(request.getParameter("ref"));
		step = Integer.parseInt(request.getParameter("step"));
		depth = Integer.parseInt(request.getParameter("depth"));
	}
%>
<body bgcolor="<%=bodyback_c%>">
	<center>
		<h2>글쓰기</h2>
	</center>
	<br>
	<form method="post" name="writeForm" action="writeProc.jsp"
		onsubmit="return writeSave()">

		<input type="hidden" name="num" value="<%=num%>"> <input
			type="hidden" name="ref" value="<%=ref%>"> <input
			type="hidden" name="step" value="<%=step%>"> <input
			type="hidden" name="depth" value="<%=depth%>">

		<table width="400" border="1" cellpadding="0" cellspacing="0"
			align="center" bgcolor="<%=bodyback_c%>">
			<tr>
				<td align="right" colspan="2" bgcolor="<%=value_c%>"><a
					href="list.jsp">글목록</a></td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">이름</td>
				<td width="330"><input type="text" size="12" maxlength="12"
					name="writer" /></td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">이메일</td>
				<td width="330"><input type="email" size="30" maxlength="30"
					name="email" /></td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">제목</td>
				<td width="330">
					<%
					if (request.getParameter("num") != null) {
					%> <input type="text" size="50" maxlength="50" name="subject"
					value="[답변]" /> <%
 } else {
 %> <input type="text" size="50" maxlength="50" name="subject" /> <%
 }
 %>
				</td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">내용</td>
				<td width="330"><textarea name="content" rows="13" cols="50"></textarea>
				</td>
			</tr>
			<tr>
				<td width="70" bgcolor="<%=value_c%>" align="center">비밀번호</td>
				<td width="330"><input type="password" size="10" maxlength="10"
					name="pass" /></td>
			</tr>
			<tr>
				<td colspan="2" bgcolor="<%=value_c%>" align="center"><input
					type="submit" value="글쓰기" /> <input type="reset" value="다시작성" />
					<input type="button" value="목록"
					onClick="window.location='list.jsp'"></td>
			</tr>
		</table>
	</form>
	<%
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
</body>
</html>