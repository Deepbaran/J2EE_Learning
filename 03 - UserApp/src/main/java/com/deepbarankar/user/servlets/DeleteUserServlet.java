package com.deepbarankar.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/deleteServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection; // This can now be used in the init() and doPost()
       
	public void init() {
		try {
			ServletContext context = getServletContext();
			
			Class.forName("com.mysql.cj.jdbc.Driver"); // This is required only when working with Tomcat. This is done due to Tomcat 8 having some memory leak issues. 
			// We are manually loading the Driver class. This is how things used to work before Java 6
		
//			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "Deepbaran2, "password"); // context-param are added
			connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), context.getInitParameter("dbUser"), context.getInitParameter("dbPassword"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieving all the submitted information with a NullPointer Check
		if(request.getParameter("email") != null) {
			String email = request.getParameter("email");
			
			try {
				Statement statement = connection.createStatement();
				
				int result = statement.executeUpdate("delete from user where email = '"+email+"';");
				PrintWriter out = response.getWriter();
				if(result > 0) {
					out.print("<h1>User Deleted</h1>");
				} else {
					out.print("<h1>ERROR Invalid User</h1>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
	}
	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
