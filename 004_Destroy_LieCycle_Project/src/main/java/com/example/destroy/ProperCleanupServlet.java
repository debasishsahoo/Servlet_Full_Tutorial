package com.example.destroy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "CleanupServlet", urlPatterns = "/cleanup", loadOnStartup = 1)
public class ProperCleanupServlet implements Servlet {

	private ServletConfig config;
	private HikariDataSource dataSource;
	private ExecutorService executorService;
	private long startTime;
	private AtomicInteger requestCount = new AtomicInteger(0);

	@Override
	public void destroy() {
		config.getServletContext().log(" Initiating servlet cleanup...");
		shutdownThreadPool();
		closeDatabasePool();
		config.getServletContext().log(" Cleanup complete. Servlet destroyed.");

	}

	private void closeDatabasePool() {
		if (dataSource != null && !dataSource.isClosed()) {
			dataSource.close();
		}

	}

	private void shutdownThreadPool() {
		if (executorService != null) {
			executorService.shutdown();
			try {
				if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
					executorService.shutdownNow();
				}
			} catch (InterruptedException e) {
				executorService.shutdownNow();
				Thread.currentThread().interrupt();
			}
		}

	}

	 @Override public ServletConfig getServletConfig() { return config; }
	 @Override public String getServletInfo() { return "ProperCleanupServlet - Enhanced Version"; }

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		this.startTime = System.currentTimeMillis();
		try {
			// Ensure the H2 driver is available
			Class.forName("org.h2.Driver");

			// Initialize the database connection pool
			dataSource = new HikariDataSource();
			dataSource.setJdbcUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
			dataSource.setUsername("sa");
			dataSource.setPassword("");
			dataSource.setMaximumPoolSize(10);
			dataSource.setPoolName("DemoPool");

			// Initialize thread pool for async tasks
			executorService = Executors.newFixedThreadPool(5);

		} catch (Exception e) {
			throw new ServletException("Initialization failed", e);
		}

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int currentRequest = requestCount.incrementAndGet();
		long requestStart = System.currentTimeMillis();

		try (Connection conn = dataSource.getConnection()) {
			executorService.submit(() -> {
				try {
					Thread.sleep(500);
					config.getServletContext().log("Background task completed for request #" + currentRequest);
				} catch (InterruptedException ignored) {
				}
			});

			// Collect system stats
			long uptime = System.currentTimeMillis() - startTime;
			int activeConnections = dataSource.getHikariPoolMXBean().getActiveConnections();
			int idleConnections = dataSource.getHikariPoolMXBean().getIdleConnections();

			// Prepare request attributes for JSP
			req.setAttribute("message", " Database connection successful");
			req.setAttribute("requestCount", currentRequest);
			req.setAttribute("activeConnections", activeConnections);
			req.setAttribute("idleConnections", idleConnections);
			req.setAttribute("poolName", dataSource.getPoolName());
			req.setAttribute("uptime", uptime / 1000);
			req.setAttribute("threadName", Thread.currentThread().getName());

			RequestDispatcher rd = req.getRequestDispatcher("/views/cleanup.jsp");
			rd.forward(req, res);

		} catch (SQLException e) {
			throw new ServletException("Database error", e);
		} finally {
			long duration = System.currentTimeMillis() - requestStart;
			config.getServletContext().log("Request #" + currentRequest + " completed in " + duration + " ms");
		}

	}

}
