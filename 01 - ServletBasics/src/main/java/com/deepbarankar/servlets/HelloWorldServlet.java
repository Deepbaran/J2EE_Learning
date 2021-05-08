package com.deepbarankar.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorldServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		/*
		 * ServletRequest: It has everything that comes from the browser. Apache Tomcat takes all the input from the browser and stores it in the ServletRequest object and gives it to the service() method.
		 * 
		 */
		response.setContentType("text/html"); // We are telling the browser, what type of content is coming back
		PrintWriter out = response.getWriter(); // ctrl+1 gives the option to assign to local variable and assigns it automatically
		out.println("<html>");
		out.println("<body>");
		out.println("<h>Hello Servlets World!</h1>");
		out.println("</body>");
		out.println("</html>");
		// response object gives us access to the web browser. The servlet container puts all the information about the web browser in the response object.
		// Any data written to the getWriter() method goes back to the web browser.
		// We assign the getWriter() to a local variable.
		// Whatever we write in the println() will be displayed in the browser.
	}

}
