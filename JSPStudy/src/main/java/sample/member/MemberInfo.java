package sample.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sample.DBUtil;
import sample.Visit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberInfo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();

//		HttpSession session = request.getSession(false);
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println(id);

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
		pw.println("<html>");
		pw.println(" <head>");
		pw.println("<title>Document</title>");
		pw.println("<link rel=\"stylesheet\" href=\"./member/member-main-style.css\" />");
		pw.println("</head>");
		pw.println(" <body>");
		pw.println(" <table align=\"center\" width=\"500\" border=\"1\">");

		pw.println("<tr>");
		pw.println("<th width=\"70\">번호</th>");
		pw.println("<td width=\"430\">" + member.getNo() + "</td>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<th width=\"70\">ID</th>");
		pw.println("<td width=\"430\">" + member.getId() + "</td>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<th width=\"70\">PW</th>");
		pw.println("<td width=\"430\">" + member.getName() + "</td>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<th width=\"70\">NAME</th>");
		pw.println("<td width=\"430\">" + member.getNick() + "</td>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<th width=\"70\">E-MAIL</th>");
		pw.println("<td width=\"430\">" + member.getMail() + "</td>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<th width=\"70\">PHONE</th>");
		pw.println("<td width=\"430\">" + member.getPhone() + "</td>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<th width=\"70\">DATE</th>");
		pw.println("<td width=\"430\">" + member.getRegdate() + "</td>");
		pw.println("</tr>");

		pw.println("<tr>");
		pw.println("<td colspan= \"2\" style=\" background-color:grey;\">&nbsp;</td>");
		pw.println("</tr>");

		pw.println(" </table>");
		
		pw.println("<div class=\"last\">");
		pw.println("<button><a href=\"MemberRegister\">정보수정</a></button>");
		pw.println("<button><a href=\"MemberLogout\">로그아웃</a></button>");
		pw.println("</div>");
		
		pw.println(" </body>");
		pw.println("</html>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
