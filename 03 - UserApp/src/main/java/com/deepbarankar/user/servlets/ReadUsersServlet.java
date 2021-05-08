package com.deepbarankar.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
//@WebServlet("/readServlet") // This servlet maps to this url <- This annotation will be overwritten by the web.xml
public class ReadUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection; // This can now be used in the init() and doPost()
       
	public void init(ServletConfig config) {
		try {
			ServletContext context = config.getServletContext();
			
			Class.forName("com.mysql.cj.jdbc.Driver"); // This is required only when working with Tomcat. This is done due to Tomcat 8 having some memory leak issues. 
			// We are manually loading the Driver class. This is how things used to work before Java 6
			
//			connection = DriverManager.getConnection(config.getInitParameter("dbUrl"), config.getInitParameter("dbUser"), config.getInitParameter("dbPassword")); // init-params are replaced by context-params
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieving all the submitted information with a NullPointer Check
		System.out.println("doGet()");
			
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user;");
			
			PrintWriter out = response.getWriter();
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>");
			out.println("First Name");
			out.println("</th>");
			out.println("<th>");
			out.println("Last Name");
			out.println("</th>");
			out.println("<th>");
			out.println("Email");
			out.println("</th>");
			out.println("</tr>");
			while(resultSet.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(resultSet.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.println(resultSet.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.println(resultSet.getString(3));
				out.println("</td>");
				out.println("</tr>");
			}
			out.print("</table>");
			
		} catch (SQLException e) {
			e.printStackTrace();
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
