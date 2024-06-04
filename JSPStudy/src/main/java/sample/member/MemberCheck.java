package sample.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sample.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Member> memberList = null;
		HttpSession session = request.getSession();

		String sql = "SELECT * FROM MEMBER";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("로그인 입력" + id);
		System.out.println("로그인 입력" + pw);
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			memberList = new ArrayList<Member>();

			while (rs.next()) {
				Member member = new Member();
				member.setNo(rs.getInt("NO"));
				member.setId(rs.getString("ID"));
				member.setPw(rs.getString("PW"));
				member.setName(rs.getString("NAME"));
				member.setNick(rs.getString("NICK"));
				member.setMail(rs.getString("MAIL"));
				member.setPhone(rs.getString("PHONE"));
				member.setRegdate(rs.getString("REGDATE"));
				memberList.add(member);
			}
			memberList.forEach(t -> System.out.println(t));

			boolean isMember = memberList.stream().filter(t -> t.getId().equals(id) && t.getPw().equals(pw)).toList()
					.isEmpty();
			if (!isMember) {
				session.setAttribute("id", id);
			} else {
				session.invalidate();
			}
			response.sendRedirect("MemberMain");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResources(rs, pstmt, con);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
