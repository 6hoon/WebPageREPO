package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisitList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		List<Visit> visitList = null;

		String sql = "SELECT * FROM VISIT";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.makeConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			visitList = new ArrayList<Visit>();

			while (rs.next()) {
				Visit visit = new Visit();
				visit.setNo(rs.getInt("NO"));
				visit.setWriter(rs.getString("WRITER"));
				visit.setMemo(rs.getString("MEMO"));
				visit.setRegdate(rs.getString("REGDATE"));
				visitList.add(visit);
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
		// 출력
		pw.println("<html>");
		pw.println(" <head>");
		pw.println("<title>방명록 리스트</title>");
		pw.println("</head>");
		pw.println(" <body>");
		pw.println(" <table align=\"center\" width=\"500\" border=\"1\">");
		for (Visit data : visitList) {
			pw.println("<tr>");
			pw.println("<th width=\"70\">번호</th>");
			pw.println("<td width=\"430\">" + data.getNo() + "</td>");
			pw.println("</tr>");

			pw.println("<tr>");
			pw.println("<th width=\"70\">작성자</th>");
			pw.println("<td width=\"430\">" + data.getWriter() + "</td>");
			pw.println("</tr>");

			pw.println("<tr>");
			pw.println("<th width=\"70\">메모</th>");
			pw.println("<td width=\"430\">" + data.getMemo() + "</td>");
			pw.println("</tr>");

			pw.println("<tr>");
			pw.println("<th width=\"70\">날짜</th>");
			pw.println("<td width=\"430\">" + data.getRegdate() + "</td>");
			pw.println("</tr>");
			
			pw.println("<tr>");
			pw.println("<td colspan= \"2\" style=\" background-color:grey;\">&nbsp;</td>");
			pw.println("</tr>");
		}
		pw.println(" </table>");
		pw.println("<p align = center><a href=/JSPStudy/bbs/write.html>글쓰기</a></p>");
		pw.println(" </body>");
		pw.println("</html>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
