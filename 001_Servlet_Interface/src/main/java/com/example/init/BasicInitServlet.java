package com.example.init;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebInitParam;

@WebServlet(name = "BasicInitServlet", urlPatterns = "/basic-init", initParams = {
		@WebInitParam(name = "configFile", value = "/WEB-INF/app.properties"),
		@WebInitParam(name = "cacheSize", value = "1000"),
		@WebInitParam(name = "timeout", value = "30"), }, loadOnStartup = 1)
public class BasicInitServlet implements Servlet {
	private ServletConfig config;
	private Properties appProperties;
	private int cacheSize;
	private int timeout;
	private String configFile;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		try {
			// 1️ Read init parameters
			configFile = config.getInitParameter("configFile");
			cacheSize = Integer.parseInt(config.getInitParameter("cacheSize"));
			timeout = Integer.parseInt(config.getInitParameter("timeout"));

			// 2️ Load properties file
			appProperties = new Properties();
			String realPath = config.getServletContext().getRealPath(configFile);
			try (FileInputStream fis = new FileInputStream(realPath)) {
				appProperties.load(fis);
			}

			// 3️ Validate configuration
			if (cacheSize <= 0 || timeout <= 0)
				throw new ServletException("Invalid init parameters: must be positive values");

			System.out.println("=== BasicInitServlet initialized ===");
			System.out.println("Config file: " + configFile);
			System.out.println("Cache size: " + cacheSize);
			System.out.println("Timeout: " + timeout);
			System.out.println("Properties loaded: " + appProperties.size());

		} catch (IOException e) {
			throw new ServletException("Error reading configuration file", e);
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// Add data to request scope
		req.setAttribute("cacheSize", cacheSize);
		req.setAttribute("timeout", timeout);
		req.setAttribute("configFile", configFile);
		req.setAttribute("properties", appProperties);
		req.setAttribute("propertiesCount", appProperties.size());

		// Forward to JSP
		RequestDispatcher dispatcher = req.getRequestDispatcher("init-details.jsp");
		dispatcher.forward(req, res);

	}
	
	@Override
	public void destroy() {
		System.out.println("BasicInitServlet destroyed.");
		appProperties = null;
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "BasicInitServlet - Demonstrates servlet initialization using initParams";
	}

}
