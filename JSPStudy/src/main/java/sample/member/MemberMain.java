package sample.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class MemberMain extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();

		HttpSession session = request.getSession(false);

		pw.println("<!DOCTYPE html>");
		pw.println("<html lang=\"en\">");
		pw.println("<head>");
		pw.println("<title>Document</title>");
		pw.println("<link rel=\"stylesheet\" href=\"./member/member-main-style.css\" />");
		pw.println("</head>");
		pw.println("<body>");

		pw.println("<fieldset style=\"margin: 0 auto; width: 330px\">");
		pw.println("<legend style=\"margin: 0 auto; text-align: center\">");

		if (session != null) {
			String id = (String) session.getAttribute("id");
			pw.println("<h1>로그인 성공</h1>");
			pw.println("</legend>");
			pw.println("<div class=\"con\">");
			String data = String.format("<p align=\"center\"> %s 님 로그인 되셨습니다</p>", id);
			pw.println(data);
			pw.println("</div>");
			pw.println("<div class=\"last\">");
			pw.println("<button><a href=\"MemberInfo\">회원정보</a></button>");
			pw.println("<button><a href=\"MemberLogout\">로그아웃</a></button>");
			pw.println("</div>");
			pw.println("</div>");

		} else {
			pw.println("<h1>로그인</h1>");
			pw.println("</legend>");
			pw.println("<form action=\"MemberCheck\" method=\"post\">");
			pw.println("<div class=\"con\">");
			pw.println("<div class=\"login\">");
			pw.println("<div>");
			pw.println("<input type=\"text\" name=\"id\" id=\"id\" placeholder=\"ID\" size=\"30\"/><br />");
			pw.println("<input type=\"password\" name=\"pw\" id=\"pw\" placeholder=\"PW\" size=\"30\"/>");
			pw.println("</div>");
			pw.println("<input class=\"loginLogo\" type=\"submit\" name=\"login\" id=\"login\" value=\"로그인\"/>");
			pw.println("</div>");
			pw.println("<div class=\"last\">");
			pw.println(
					"<button><a style=\"text-decoration: none; color: black\" href=\"./member/member.html\">회원가입</a></button>");
			pw.println("</div>");
			pw.println("</div>");
			pw.println("</form>");
		}
		pw.println("</fieldset>");
		pw.println("</body>");
		pw.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
