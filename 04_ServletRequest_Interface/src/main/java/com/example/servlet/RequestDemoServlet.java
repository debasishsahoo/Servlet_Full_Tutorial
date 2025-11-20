package com.example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/request")
public class RequestDemoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1️ Request Parameters
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String[] hobbies = request.getParameterValues("hobby");
		String rawBody = request.getParameter("rawData");

		// 2 Metadata
		String clientIP = request.getRemoteAddr();
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		String protocol = request.getProtocol();

		// 3 Attributes
		request.setAttribute("userAttribute", "ProcessedByServlet");

		// Passing everything to result JSP
		request.setAttribute("username", username);
		request.setAttribute("email", email);
		request.setAttribute("hobbies", hobbies);
		request.setAttribute("rawBody", rawBody);
		request.setAttribute("clientIP", clientIP);
		request.setAttribute("serverName", serverName);
		request.setAttribute("serverPort", serverPort);
		request.setAttribute("protocol", protocol);

		// 5 Localization
		Locale locale = request.getLocale();
		request.setAttribute("locale", locale.toString());

		// 6️ Forward to JSP
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);

	}
}
