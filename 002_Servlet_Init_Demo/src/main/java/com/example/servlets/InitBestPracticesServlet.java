package com.example.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebInitParam;

@WebServlet(name = "InitBestPracticesServlet", urlPatterns = "/init-best", initParams = {
		@WebInitParam(name = "requiredParam", value = "5") }, loadOnStartup = 1)
public class InitBestPracticesServlet implements Servlet {

	private ServletConfig config;

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "InitBestPracticesServlet";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		String param = config.getInitParameter("requiredParam");
		if (param == null || Integer.parseInt(param) <= 0) {
			throw new ServletException("Invalid or missing requiredParam");
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		req.setAttribute("servletName", config.getServletName());
		req.setAttribute("requiredParam", config.getInitParameter("requiredParam"));
		RequestDispatcher rd = req.getRequestDispatcher("init-best.jsp");
		rd.forward(req, res);

	}

}
