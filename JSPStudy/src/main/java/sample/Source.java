package sample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Source extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = "Marcus_Lim";
		System.out.println("source start");
		request.setAttribute("name", "marcus");
		// 1. remove page (forward)
		// RequestDispatcher view = request.getRequestDispatcher("Destination");
		// view.forward(request, response);
		// 2. remove page (redirect)
		response.sendRedirect("Destination");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
