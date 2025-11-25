package com.example.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/basic2")
public class Basic2GenericServlet extends GenericServlet {

	public void init() throws ServletException {
		log("Basic 2 GenericServlet initialized");
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// Read init parameters
		String appName = getServletConfig().getInitParameter("appName");

		// Read context parameters
		String environment = getServletContext().getInitParameter("environment");

		// Read form input
		String username = request.getParameter("username");
		String email = request.getParameter("email");

		// Set attributes for JSP
		request.setAttribute("appName", appName);
		request.setAttribute("environment", environment);
		request.setAttribute("servletName", getServletName());
		request.setAttribute("username", username);
		request.setAttribute("email", email);

		// Forward to JSP
		RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
		rd.forward(request, response);

	}

}
