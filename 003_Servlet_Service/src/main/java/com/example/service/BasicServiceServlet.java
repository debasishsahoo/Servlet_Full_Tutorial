package com.example.service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Collections;


@WebServlet("/basic_service")
public class BasicServiceServlet  implements Servlet {
	  private ServletConfig config;
	  private long counter = 0;
	
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		counter++;
		req.setAttribute("requestNumber", counter);
        req.setAttribute("threadName", Thread.currentThread().getName());
        req.setAttribute("protocol", req.getProtocol());
        req.setAttribute("scheme", req.getScheme());
        req.setAttribute("serverName", req.getServerName());
        req.setAttribute("serverPort", req.getServerPort());
        req.setAttribute("remoteAddr", req.getRemoteAddr());
        req.setAttribute("remoteHost", req.getRemoteHost());
        req.setAttribute("parameters", req.getParameterMap());
        req.setAttribute("attributes", Collections.list(req.getAttributeNames()));
        RequestDispatcher rd = req.getRequestDispatcher("/views/basicService.jsp");
        rd.forward(req, res);
		
	}


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

}
