package com.example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet implementation class Servlet_Interface
 */
@WebServlet("/servletinterface")
public class Servlet_Interface implements Servlet {

	private ServletConfig config;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println(config);
		System.out.println("Servlet initialized.");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Servlet destroyed.");
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		return config;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		return "MyFirstServlet - JSP Enabled v1.1";
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// Get form data from index.jsp (if available)
		String name = request.getParameter("username");
		if (name == null || name.isEmpty()) {
			name = "Guest";
		}

		// Business logic or data preparation
		// What is My Response
		String message = "Hello," + name + "  Welcome to JSP Integration Example!";
		// Bind Response to Specific Request
		request.setAttribute("message", message);

		// Forward the request to JSP page
		// Where i Send the response
		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");
		// How I send Response
		rd.forward(request, response);

	}

}
