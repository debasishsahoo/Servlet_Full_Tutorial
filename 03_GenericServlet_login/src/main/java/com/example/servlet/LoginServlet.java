package com.example.servlet;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/login")
public class LoginServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// Read form input
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		// Check login
		if ("admin".equals(user) && "1234".equals(pass)) {
			// SUCCESS → forward to dashboard.jsp with username
			request.setAttribute("username", user);
			RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);

		} else {
			// FAILED → send back to login.jsp with error message
			request.setAttribute("errorMsg", "Invalid username or password!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

		
		
		
		
		
		
		
	}
	

}
