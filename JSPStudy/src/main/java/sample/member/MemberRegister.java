package sample.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sample.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberRegister extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println("MemberRegister" + id);

		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;

		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				member = new Member();
				member.setNo(rs.getInt("NO"));
				member.setId(rs.getString("ID"));
				member.setPw(rs.getString("PW"));
				member.setName(rs.getString("NAME"));
				member.setNick(rs.getString("NICK"));
				member.setMail(rs.getString("MAIL"));
				member.setPhone(rs.getString("PHONE"));
				member.setRegdate(rs.getString("REGDATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		pw.println("<!DOCTYPE html>");
		pw.println("<html lang=\"en\">");
		pw.println(
				"<head><title>Document</title><link rel=\"stylesheet\" href=\"./member/member-style.css\" /></head>");
		pw.println("<body><h1>회 원 가 입</h1>	<form action=\"/JSPStudy/Register\" method=\"post\">");

		pw.println("<h4>사이트 이용정보 입력</h4>");
		pw.println("<table>");
		pw.println("<tr><td class=\"title\"><label for=\"memberId\"><b>아이디</b></label></td>");
		String vid = String.format(
				"<td class=\"content\"><input class=\"request\" type=\"text\" name=\"id\" id=\"id\" size=\"25\" minlength=\"3\" maxlength=\"12\" value=\"%s\" required readonly/></td></tr>",
				id);
		pw.println(vid);
		pw.println("<tr><td class=\"title\"><label for=\"memberPw\"><b>비밀번호</b></label></td>");
		String vpw = String.format(
				"<td class=\"content\"><input class=\"request\" type=\"password\" name=\"pw\" id=\"pw\" size=\"25\" minlength=\"6\" maxlength=\"12\"  placeholder=\"%s\" /></td>	</tr>",
				member.getPw());
		pw.println(vpw);
		pw.println("<tr><td class=\"title\"><label for=\"pwcheck\"><b>비밀번호 확인</b></label></td>");
		pw.println(
				"<td class=\"content\"><input name=\"pwcheck\" id=\"pwcheck\" class=\"request\" type=\"password\" size=\"25\" minlength=\"6\" maxlength=\"12\"  placeholder=\"PW확인\" /></td></tr>");
		pw.println("</table>");

		pw.println("<h4>개인정보 입력</h4>");
		pw.println("<table>");
		pw.println("<tr><td class=\"title\"><label for=\"userName\"><b>이름</b></label></td>");
		String vname = String.format(
				"<td class=\"content\"><input type=\"text\" class=\"request\" size=\"25\" minlength=\"2\" maxlength=\"5\" required name=\"name\" id=\"name\" value=\"%s\" readonly/></td></tr>",
				member.getName());
		pw.println(vname);
		pw.println("<tr><td class=\"title\"><label for=\"userNick\"><b>닉네임</b></label></td>");
		String vnick = String.format(
				"<td class=\"content\"><input type=\"text\" class=\"request\" size=\"25\" minlength=\"2\" maxlength=\"6\" required name=\"nick\" id=\"nick\" value=\"%s\" readonly/></td></tr>",
				member.getNick());
		pw.println(vnick);
		pw.println("<tr><td class=\"title\"><label for=\"userEmail\"><b>E-mail</b></label></td>");
		String vmail = String.format(
				"<td class=\"content\"><input type=\"text\" class=\"request\" size=\"50\" minlength=\"10\" maxlength=\"25\"  name=\"email\" id=\"email\" placeholder=\"%s\"/></td>",
				member.getMail());
		pw.println(vmail);
		pw.println("</tr><tr><td class=\"title\"><label for=\"userPhone\"><b>휴대폰번호</b></label></td>");
		String vphone = String.format(
				"<td class=\"content\"><input type=\"text\" class=\"request\" size=\"25\" minlength=\"10\" maxlength=\"20\"  name=\"phone\" id=\"phone\" placeholder=\"%s\"/></td></tr>",
				member.getPhone());
		pw.println(vphone);
		pw.println("</table>");

		pw.println("<div class=\"last\">");
		pw.println("<button type=\"submit\" class=\"createAccount\"><b>수정</b></button>");
		pw.println(
				"<button class=\"cancel\"><a style=\"text-decoration: none; color: black; font-weight: 900;\" href=\"http://localhost:8080/JSPStudy/MemberMain\">취소</a></button>");
		pw.println("</div>");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
