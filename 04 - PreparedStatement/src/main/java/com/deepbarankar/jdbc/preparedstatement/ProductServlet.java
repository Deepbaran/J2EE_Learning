package com.deepbarankar.jdbc.preparedstatement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement stmt;
	
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "Deepbaran2", "password");
			stmt = con.prepareStatement("insert into product values(?,?,?,?)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null && 
				request.getParameter("name") != null && 
				request.getParameter("description") != null && 
				request.getParameter("price") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String desc = request.getParameter("description");
			int price = Integer.parseInt(request.getParameter("price"));
			
			try {
				stmt.setInt(1, id);
				stmt.setString(2, name);
				stmt.setString(3, desc);
				stmt.setInt(4, price);
				
				int result = stmt.executeUpdate();
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<b>"+result+" Products Created</b>");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void destroy() {
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
