package com.example.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebInitParam;

@WebServlet(name = "DatabaseInitServlet", urlPatterns = "/db-init", initParams = {
		@WebInitParam(name = "jdbcUrl", value = "jdbc:postgresql://localhost:5432/hikaridb"),
		@WebInitParam(name = "username", value = "admin"), @WebInitParam(name = "password", value = "1234"),
		@WebInitParam(name = "maxPoolSize", value = "20"),
		@WebInitParam(name = "minIdle", value = "5") }, loadOnStartup = 1)
public class DatabaseInitServlet implements Servlet {
	private ServletConfig config;
	private DataSource dataSource;
	private int maxPoolSize;
	private int minIdle;

	@Override
	public void destroy() {
		if (dataSource instanceof HikariDataSource)
			((HikariDataSource) dataSource).close();
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "DatabaseInitServlet";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		try {
			String jdbcUrl = config.getInitParameter("jdbcUrl");
			String username = config.getInitParameter("username");
			String password = config.getInitParameter("password");
			maxPoolSize = Integer.parseInt(config.getInitParameter("maxPoolSize"));
			minIdle = Integer.parseInt(config.getInitParameter("minIdle"));

			HikariConfig hikariConfig = new HikariConfig();
			hikariConfig.setJdbcUrl(jdbcUrl);
			hikariConfig.setUsername(username);
			hikariConfig.setPassword(password);
			hikariConfig.setMaximumPoolSize(maxPoolSize);
			hikariConfig.setMinimumIdle(minIdle);
			hikariConfig.setConnectionTestQuery("SELECT 1");
			dataSource = new HikariDataSource(hikariConfig);
			testConnection();
			config.getServletContext().setAttribute("dataSource", dataSource);

		} catch (Exception e) {
			throw new ServletException("Failed to initialize database", e);
		}

	}

	private void testConnection() throws ServletException {
		try (Connection conn = dataSource.getConnection()) {
			if (conn == null || conn.isClosed())
				throw new ServletException("Connection failed");
		} catch (SQLException e) {
			throw new ServletException("Database connection test failed", e);
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		req.setAttribute("maxPoolSize", maxPoolSize);
		req.setAttribute("minIdle", minIdle);
		req.setAttribute("dataSourceClass", dataSource.getClass().getName());
		RequestDispatcher dispatcher = req.getRequestDispatcher("db-init.jsp");
		dispatcher.forward(req, res);

	}

}
