package com.deepbarankar.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
//@WebServlet(urlPatterns="/addServlet", initParams={
//		@WebInitParam(name="dbUrl",value="jdbc:mysql://localhost/mydb"),
//		@WebInitParam(name="dbUser",value="Deepbaran2"),
//		@WebInitParam(name="dbPassword",value="password")}) 
// This servlet maps to this url and the container knows that this method should be invoked when addUser.html sends request.
// Rather than using init-params in web.xml we can also define them as annotations too as shown here

// context-param are added
@WebServlet("/addServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection; // This can now be used in the init() and doPost()
       
	public void init(ServletConfig config) {
		try {
			ServletContext context = config.getServletContext();
			
			System.out.println("init()");
			// looping through all the names of the context paramets and values
			Enumeration<String> parameterNames = context.getInitParameterNames();
			while(parameterNames.hasMoreElements()) {
				String eachName = parameterNames.nextElement();
				System.out.print("Context Param Name: " + eachName);
				System.out.print(" -> ");
				System.out.print("Context Param Value: " + context.getInitParameter(eachName));
				System.out.println();
			}
			
			Class.forName("com.mysql.cj.jdbc.Driver"); // This is required only when working with Tomcat. This is done due to Tomcat 8 having some memory leak issues. 
			// We are manually loading the Driver class. This is how things used to work before Java 6
			
//			connection = DriverManager.getConnection(config.getInitParameter("dbUrl"), config.getInitParameter("dbUser"), config.getInitParameter("dbPassword")); // context-param are added
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
		if(request.getParameter("firstName") != null && 
				request.getParameter("lastName") != null && 
				request.getParameter("email") != null && 
				request.getParameter("password") != null) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			try {
				Statement statement = connection.createStatement();
				
				int result = statement.executeUpdate("insert into user values('"+firstName+"','"+lastName+"','"+email+"','"+password+"');");
				PrintWriter out = response.getWriter();
				if(result > 0) {
					out.print("<h1>USER CREATED</h1>");
				} else {
					out.print("<h1>ERROR creating the User</h1>");
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
