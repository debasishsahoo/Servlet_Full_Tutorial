package com.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@WebServlet("/test-db")
public class TestHikariServlet extends HttpServlet {
	private HikariDataSource ds;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
			// Configure HikariCP
			HikariConfig cfg = new HikariConfig();
			cfg.setJdbcUrl("jdbc:postgresql://localhost:5432/hikaridb"); // Change DB name
			cfg.setUsername("admin"); // Change username
			cfg.setPassword("1234"); // Change password
			cfg.setMaximumPoolSize(5);
			cfg.setMinimumIdle(1);
			cfg.setConnectionTimeout(30000);
			cfg.setIdleTimeout(600000);
			cfg.setMaxLifetime(1800000);
			cfg.setConnectionTestQuery("SELECT 1");

			// Create pool
			ds = new HikariDataSource(cfg);
			System.out.println("HikariCP initialized successfully!");

		} catch (Exception e) {
			throw new ServletException("Error initializing HikariCP", e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		boolean connected = false;
		String message;

		try (Connection c = ds.getConnection()) {
			if (c != null && !c.isClosed()) {
				connected = true;
				message = "Connected successfully using HikariCP!";
			} else {
				message = "Connection failed.";
			}
		} catch (SQLException e) {
			connected = false;
			message = "Database connection error: " + e.getMessage();
		}

		// Pass results to JSP
		req.setAttribute("connected", connected);
		req.setAttribute("message", message);
		RequestDispatcher rd = req.getRequestDispatcher("db-result.jsp");
		rd.forward(req, res);

	}

	@Override
	public void destroy() {
		if (ds != null)
			ds.close();
		System.out.println("HikariCP connection pool closed.");
	}
}
