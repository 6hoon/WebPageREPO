package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession(false); // 세션값이 있으면 값을 주고, 없으면 null 을 줌

		pw.println("<!DOCTYPE html>");
		pw.println("<html lang=\"en\">");
		pw.println("<head>");
		pw.println("<title>Document</title>");
		pw.println("</head>");
		pw.println("<body>");

		if (session != null) {
			String id = (String)session.getAttribute("id");
			pw.println("<table border=\"1 width=300\">");
			pw.println("<tr>");
			String data = String.format("<td width=\"300\" align=\"center\"> %s </td>", id);
			pw.println(data);
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td align=\"center\">");
			pw.println("<a href=\"#\">회원정보</a> <a href=\"Logout\">로그아웃</a>");
			pw.println("</td>");
			pw.println("</tr>");
			pw.println("</table>");
		} else {
			pw.println("<form action=\"LoginCheck\" method=\"post\">");
			pw.println("<table border=\"1 width=300\">");
			pw.println("<tr>");
			pw.println("<th width=\"100\">아이디</th>");
			pw.println("<td width=\"200\" align=\"center\">");
			pw.println("<input type=\"text\" name=\"id\" />");
			pw.println("</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<th width=\"100\">비밀번호</th>");
			pw.println("<td width=\"200\" align=\"center\">");
			pw.println("<input type=\"password\" name=\"password\" />");
			pw.println("</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td colspan=\"2\" align=\"center\">");
			pw.println("<input type=\"button\" value=\"회원가입\" />");
			pw.println("<input type=\"submit\" value=\"로그인\" />");
			pw.println("</td>");
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		
		pw.println("</body>");
		pw.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
