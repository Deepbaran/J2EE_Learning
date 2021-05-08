package com.deepbarankar.servlets.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class DemoFilter
 */
@WebFilter("/FilterDemoServlet") // filter should have the same urlPattern as the corresponding Servlet.
// If we apply * then this filter will be applied to all the servlets
public class DemoFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		out.println("Pre Servlet"); // Before going to the Servlet
		chain.doFilter(request, response); // Going to the Servlet
		out.println("Post Servlet"); // Coming Back from the Servlet
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
