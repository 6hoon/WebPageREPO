package sample;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VisitInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisitInsert() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sql = "INSERT INTO VISIT VALUES(VISIT_SEQ.NEXTVAL, ?, ?, SYSDATE)";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.makeConnection();
			if (con != null) {
				System.out.println("데이터베이스 접속 성공했습니다.");
			} else {
				System.out.println("데이터베이스 접속 실패했습니다.");
			}
			String writer = request.getParameter("writer");
			String memo = request.getParameter("memo");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, memo);
			int value = pstmt.executeUpdate();
			if (value == 1) {
				 response.sendRedirect("VisitList");
			} else {
				// error페이지
				System.out.println("메모삽입실패");
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
