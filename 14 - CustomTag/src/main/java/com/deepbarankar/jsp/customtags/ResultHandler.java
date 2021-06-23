package com.deepbarankar.jsp.customtags;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport {

	Connection con;
	PreparedStatement stmt;

	public ResultHandler() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "Deepbaran2", "password");
			stmt = con.prepareStatement("select * from user where email=?");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int doStartTag() throws JspException {
		// This will be invoked by the container as soon as it hits the starting element
		// of our tag in the jsp page.
		// So, this method will be invoked right after the constructor.

		// pageContext belongs to the TagSupport class and we can access it directly.
		// pageContext is used to get the request and response of the Servlet class, in
		// the Handler class.
		// pageContext has access to all the environments of a particular Servlet/JSP
		// page
		ServletRequest request = pageContext.getRequest(); // gets the request of the servlet class
		String email = request.getParameter("email");

		try {
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			JspWriter out = pageContext.getOut(); // get access of the out of the servlet, in the Handler class;
			if (rs.next()) {
				out.print("User details are: <br/>First Name: ");
				out.print(rs.getString(1));
				out.print("<br/>Last Name: ");
				out.print(rs.getString(2));
			} else {
				out.print("Invalid email entered");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * The doStartTag has to return a integer value, which tells the container what
		 * it should do next.
		 * 
		 * Here we are saying, skip the body.
		 * 
		 * So the Tag interface has all these constants that we can use if we want.
		 * 
		 * If we want to evaluate the body, then it will return EVAL_BODY.
		 */
		return Tag.SKIP_BODY; // As we do not have a body for this tag, so we are using SKIP_BODY
		// We are simply displaying the details by getting the email.
	}

	@Override
	public void release() {
		// This method indicates the end of a Tag Handler LifeCycle and we are closing
		// it.
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
