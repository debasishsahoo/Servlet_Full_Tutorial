package com.example.service;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/thread-safe")
public class ThreadSafeServlet implements Servlet {

	private ServletConfig config;
	// Thread-safe counters
	private final AtomicInteger totalRequests = new AtomicInteger(0);
	private final ConcurrentHashMap<String, AtomicInteger> userRequests = new ConcurrentHashMap<>();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log(" ThreadSafeServlet initialized successfully");

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// Get user parameter (default: anonymous)
		String user = req.getParameter("user");
		if (user == null || user.trim().isEmpty()) {
			user = "anonymous";
		}

		// Increment global and per-user counters atomically
		int total = totalRequests.incrementAndGet();
		int userCount = userRequests.computeIfAbsent(user, k -> new AtomicInteger(0)).incrementAndGet();

		// Thread info
		String threadName = Thread.currentThread().getName();
		long threadId = Thread.currentThread().getId();

		// Put attributes for JSP
		req.setAttribute("user", user);
		req.setAttribute("userCount", userCount);
		req.setAttribute("totalRequests", total);
		req.setAttribute("threadName", threadName);
		req.setAttribute("threadId", threadId);
		req.setAttribute("activeUsers", userRequests);
		
		 // Log server side
        config.getServletContext().log(
                String.format("User '%s' handled by thread %s (ID: %d) | Total: %d | UserCount: %d",
                        user, threadName, threadId, total, userCount)
        );
		
        RequestDispatcher rd = req.getRequestDispatcher("/views/threadSafe.jsp");
        rd.forward(req, res);

	}

}
