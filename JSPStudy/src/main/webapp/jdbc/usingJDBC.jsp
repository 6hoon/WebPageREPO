<%@page import="java.sql.PreparedStatement"%>
<%@page import="sample.DBUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String sql = "select * from tempmember";
String id = "", passwd = "", name = "", mem_num1 = "", mem_num2 = "", e_mail = "", phone = "", zipcode = "",
		address = "", job = "";
int counter = 0;

try {
	con = DBUtil.makeConnection();
	pstmt = con.prepareStatement(sql);
	rs = pstmt.executeQuery();
%>
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

			<%
			if (rs != null) {
				while (rs.next()) {
					id = rs.getString("id");
					passwd = rs.getString("passwd");
					name = rs.getString("name");
					mem_num1 = rs.getString("mem_num1");
					mem_num2 = rs.getString("mem_num2");
					e_mail = rs.getString("e_mail");
					phone = rs.getString("phone");
					zipcode = rs.getString("zipcode");
					address = rs.getString("address");
					job = rs.getString("job");
			%>
			<tr>
				<td><%=id%></td>
				<td><%=passwd%></td>
				<td><%=name%></td>
				<td><%=mem_num1%></td>
				<td><%=mem_num2%></td>
				<td><%=e_mail%></td>
				<td><%=phone%></td>
				<td><%=zipcode%>/<%=address%></td>
				<td><%=job%></td>
				<%
				counter++;
				} // while
				} //if
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
		<%
		} catch (Exception e) {
		System.out.println("에러");
		} finally {
		DBUtil.closeResources(rs, pstmt, con);
		} // resources
		%>
	</form>
</body>
</html>
