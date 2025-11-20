package com.example.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/basic1")
public class Basic1GenericServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		// Fetch user input
		String user = request.getParameter("user");
		if (user == null || user.isEmpty()) {
			user = "Guest";
		}
		
		// Prepare response message
		String message = "Welcome, " + user + "! (from GenericServlet + JSP)";
		
		// Pass data to JSP
		request.setAttribute("msg", message);
		
		// Forward to JSP
		RequestDispatcher rd = request.getRequestDispatcher("/message.jsp");
		rd.forward(request,response);
		
		
		
	}

}
