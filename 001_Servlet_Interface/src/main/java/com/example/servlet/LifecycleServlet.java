package com.example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Date;

@WebServlet(name = "LifecycleServlet", urlPatterns = "/lifecycle", loadOnStartup = 1)
public class LifecycleServlet implements Servlet {

	private ServletConfig config;
	private AtomicInteger requestCount = new AtomicInteger(0);
	private long initTime;

	// === PHASE 1: INIT ===
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		this.initTime = System.currentTimeMillis();
		System.out.println("=== INIT() CALLED ===");
		System.out.println("Servlet initialized at: " + new Date(initTime));
	}

	// === PHASE 2: SERVICE ===
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		int currentRequest = requestCount.incrementAndGet();// at first +1 and the get the value
		long uptime = System.currentTimeMillis() - initTime;

		// Add data to request scope
		request.setAttribute("servletName", config.getServletName());
		request.setAttribute("requestNumber", currentRequest);
		request.setAttribute("initTime", new Date(initTime));
		request.setAttribute("currentTime", new Date());
		request.setAttribute("uptime", uptime);
		request.setAttribute("threadName", Thread.currentThread().getName());
		request.setAttribute("threadId", Thread.currentThread().getId());

		// Forward to JSP for display
		RequestDispatcher rd = request.getRequestDispatcher("lifecycle.jsp");
		rd.forward(request, response);

	}

	// === PHASE 3: DESTROY ===
	@Override
	public void destroy() {
		System.out.println("=== DESTROY() CALLED ===");
        System.out.println("Total requests handled: " + requestCount.get());
        System.out.println("Servlet destroyed at: " + new Date());
	}

	public ServletConfig getServletConfig() {
		return config;
    }

	public String getServletInfo() {
		return "LifecycleServlet v3.0 - Simple Servlet Lifecycle Example";
	}

}
