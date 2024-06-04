package test;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sample.DBUtil;

public class Proctest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		CallableStatement cstmt = null;

		try {
			con = DBUtil.makeConnection();
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			cstmt = con.prepareCall("{call insert_pro(?, ?)}");
			cstmt.setString(1, id);
			cstmt.setString(2, pw);
			cstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("에러");
		} finally {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
