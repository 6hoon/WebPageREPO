<%@page import="memberone.StudentDAO"%>
<%@page import="memberone.ZipCodeVO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- 빈객체 생성 -->
<%
StudentDAO dao = StudentDAO.getInstance();
request.setCharacterEncoding("utf-8");

/* 1. check = y : 회원가입에서 우편번호 찾기할 때 - js의 function zipCheck '첫 실행때 y 값'
 -> dong = null */

/* 2. check = null , dong = '입력한 값' */

String check = request.getParameter("check");
String dong = request.getParameter("dong");
Vector<ZipCodeVO> zipcodeList = null;
int totalList = 0; // NPE 막을 수 있음
if (dong != null && !dong.trim().isEmpty()) {
	zipcodeList = dao.zipcodeRead(dong);
	totalList = zipcodeList.size();
}
%>
<html>
<head>
<title>우편번호검색</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
<!-- ② -->
</head>
<body bgcolor="#FFFFCC">
	<center>
		<b>우편번호 찾기</b>
		<!-- form 자기가 자신을 부름 -->
		<form name="zipForm" method="post" action="zipCheck.jsp">
			<table>
				<tr>
					<td>동이름 입력 : <input name="dong" type="text"> <input
						type="button" value="검색" onclick="dongCheck()" />
					</td>
				</tr>
			</table>
		</form>
		<table>
			<%
			// if (check.equals("n")) {
			if (check == null) {
				if (zipcodeList.isEmpty()) {
			%>
			<tr>
				<td align="center"><br />검색된 결과가 없습니다.</td>
			</tr>
			<%
			} else {
			%>
			<tr>
				<td align="center"><br /> ※검색 후, 아래 우편번호를 클릭하면 자동으로 입력됩니다.</td>
			</tr>
			<%
			for (int i = 0; i < totalList; i++) {
				ZipCodeVO vo = zipcodeList.elementAt(i);
				String tempZipcode = vo.getZipcode();
				String tempSido = vo.getSido();
				String tempGugun = vo.getGugun();
				String tempDong = vo.getDong();
				String tempBunji = vo.getBunji();
				if (tempBunji == null)
					tempBunji = " ";
				String zipData = String.format("%s %s %s %s %s", tempZipcode, tempSido, tempGugun, tempDong, tempBunji);
			%>
			<tr>
				<td><a
					href="javascript:sendAddress('<%=tempZipcode%>','<%=tempSido%>'
,'<%=tempGugun%>','<%=tempDong%>','<%=tempBunji%>')">
						<%=zipData%></a><br> <%
 } //end for
 } //end else
 } // if (check.equals("n"))
 %></td>
			</tr>

			<tr>
				<td align="center"><a href="javascript:this.close();">닫기</a></td>
			</tr>
		</table>
	</center>
</body>
</html>