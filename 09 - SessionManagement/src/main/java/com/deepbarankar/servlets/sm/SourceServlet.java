package com.deepbarankar.servlets.sm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SourceServlet
 */
@WebServlet("/sourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue());
			}
		}
		response.addCookie(new Cookie("securityToken", "12345"));

		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		session.setAttribute("user", userName); // Key, Value
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// out.print("<a href='targetServlet'>Click here to get the user name</a>");
		String url = "targetServlet?sessionId=123"; // url re-writing. It is helpful if cookies are disabled
		out.print("<a href='" + url + "'>Click here to get the user name</a>");
	}

}