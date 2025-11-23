package com.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
			
			
		} catch (Exception e) {
			throw new ServletException("Error initializing HikariCP", e);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
