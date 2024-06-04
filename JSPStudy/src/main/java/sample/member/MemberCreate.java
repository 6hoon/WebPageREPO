package sample.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sample.DBUtil;

public class MemberCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberCreate() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter pwr = response.getWriter();
		String sql = "insert into member values(member_seq.nextval, ?, ?, ?, ?, ?, ?,sysdate)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.makeConnection();
			if (con != null) {
				System.out.println("데이터베이스 접속 성공했습니다.");
			} else {
				System.out.println("데이터베이스 접속 실패했습니다.");
			}
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String pwCheck = request.getParameter("pwcheck");
			String name = request.getParameter("name");
			String nick = request.getParameter("nick");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			if (!pw.equals(pwCheck)) {
				response.sendRedirect("MemberMain");
				System.out.println("비밀번호 확인");
				return;
			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, nick);
			pstmt.setString(5, email);
			pstmt.setString(6, phone);

			int value = pstmt.executeUpdate();
			if (value == 1) {
				response.sendRedirect("MemberMain");
				System.out.println("회원가입 성공");
			} else {
				System.out.println("회원가입 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
