package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginCheck extends HttpServlet {
	public static final String SID = "admin";
	public static final String SPASSWORD = "123456";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 데이터베이스와 연결하여 확인할것
		if (id.equals(SID) && password.equals(SPASSWORD)) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		}
		response.sendRedirect("Login");	// 로그인 성공시 여기로	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
