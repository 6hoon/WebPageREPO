<%@page import="jdbc.TempMemberVO"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<form action="" method="post">
		<table style="border: 1px solid black">
			<tr>
				<td>ID</td>
				<td>PASSWD</td>
				<td>NAME</td>
				<td>MEM_NUM1</td>
				<td>MEM_NUM2</td>
				<td>E_MAIL</td>
				<td>PHONE</td>
				<td>ZIPCODE/ADDRESS</td>
				<td>JOB</td>
			</tr>
			<jsp:useBean id="dao" class="jdbc.TempMemberDAO2" scope="page"></jsp:useBean>
			<%
			Vector<TempMemberVO> memberList = dao.getMemberList();
			int counter = memberList.size();
			for (int i = 0; i < counter; i++) {
				TempMemberVO tvo = memberList.get(i);
			%>
			<tr>
				<td><%=tvo.getId()%></td>
				<td><%=tvo.getPasswd()%></td>
				<td><%=tvo.getName()%></td>
				<td><%=tvo.getMem_num1()%></td>
				<td><%=tvo.getMem_num2()%></td>
				<td><%=tvo.getEmail()%></td>
				<td><%=tvo.getPhone()%></td>
				<td><%=tvo.getZipcode()%>/<%=tvo.getAddress()%></td>
				<td><%=tvo.getJob()%></td>
				<%
				} // end for
				%>
			</tr>
			<tr>
				<td style="background-color: blue" colspan="9"></td>
			</tr>
			<tr>
				<td><input type="text" name="id" size="6"></td>
				<td><input type="text" name="passwd" size="6"></td>
				<td><input type="text" name="name" size="6"></td>
				<td><input type="text" name="mem_num1" size="6"></td>
				<td><input type="text" name="mem_num2" size="6"></td>
				<td><input type="text" name="e_mail" size="6"></td>
				<td><input type="text" name="phone" size="6"></td>
				<td><input type="text" name="zipcode" size="6"><input
					name="address" size="6"></td>
				<td><input type="text" name="job" size="6"></td>
			</tr>
		</table>


		<hr>
		total records :
		<%=counter%>
		<input type="submit" value="추가">
	</form>
</body>
</html>
