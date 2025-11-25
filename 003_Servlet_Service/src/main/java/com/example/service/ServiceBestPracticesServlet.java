package com.example.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/best-practices")
public class ServiceBestPracticesServlet implements Servlet {

	private ServletConfig config;

	@Override
	public void destroy() {
		 config.getServletContext().log("ServiceBestPracticesServlet destroyed.");
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "ServiceBestPracticesServlet - Demonstrates safe and efficient request handling.";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log(" ServiceBestPracticesServlet initialized successfully");

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// Capture start time
		long startTime = System.currentTimeMillis();

		// Retrieve and validate userId
		String userId = req.getParameter("userId");
		String message;
		String status;

		if (userId == null || userId.trim().isEmpty()) {
			message = " Missing userId parameter. Please provide a valid user ID.";
			status = "error";
		} else if (!userId.matches("^[a-zA-Z0-9_-]{3,20}$")) {
			message = " Invalid userId format. Only letters, digits, underscore, and hyphen allowed (3–20 chars).";
			status = "error";
		} else {
			message = " Request processed successfully for user: " + userId;
			status = "success";
		}

		// Calculate processing duration
		long duration = System.currentTimeMillis() - startTime;
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		// Set request attributes for JSP
		req.setAttribute("userId", userId);
		req.setAttribute("status", status);
		req.setAttribute("message", message);
		req.setAttribute("timestamp", timestamp);
		req.setAttribute("duration", duration);

		// Log server-side
		config.getServletContext().log("Processed request for userId=" + userId + " in " + duration + " ms");

		// Forward to JSP
		RequestDispatcher rd = req.getRequestDispatcher("/views/bestPractices.jsp");
		rd.forward(req, res);

	}

}
