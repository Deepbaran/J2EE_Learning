package com.deepbarankar.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		/*
		 * Here, the ServletRequest object, request has the input from the browser as name-value pair object
		 */
		// Always do a null check for inputs before proceeding further
		if(request.getParameter("number1") != null && request.getParameter("number2") != null) {
			Long num1 = Long.parseLong(request.getParameter("number1")); // getParameter() takes the name of the HTML element whose name-value pair it will take.
			Long num2 = Long.parseLong(request.getParameter("number2"));
			
			response.getWriter().println("The Result is: " + (num1 + num2));
		}
	}

}
