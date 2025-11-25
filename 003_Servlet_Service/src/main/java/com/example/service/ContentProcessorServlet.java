package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/content-processor")
public class ContentProcessorServlet implements Servlet {

	private ServletConfig config;

	@Override
    public void destroy() {
        config.getServletContext().log(" ContentProcessorServlet destroyed.");
    }

    @Override
    public ServletConfig getServletConfig() { return config; }

    @Override
    public String getServletInfo() { return "ContentProcessorServlet - Demonstrates handling of JSON, text, and form data"; }

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log(" ContentProcessorServlet initialized successfully");

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String contentType = req.getContentType();
		StringBuilder data = new StringBuilder();
		String message;
		String contentCategory = "none";

		if (contentType == null) {
			message = " No Content Type provided. Please submit data from the form below.";
		} else if (contentType.contains("application/json")) {
			contentCategory = "JSON";
			data.append(req.getReader().lines().collect(Collectors.joining()));
			message = " JSON payload received successfully.";
			
			
			
			
		} else if (contentType.contains("text/plain")) {
			contentCategory = "Plain Text";
			BufferedReader reader = req.getReader();
			data.append(reader.lines().collect(Collectors.joining(" ")));
			message = " Plain text received successfully.";
			
			
		} else if (contentType.contains("application/x-www-form-urlencoded")) {
			contentCategory = "Form Data";
			req.getParameterMap()
					.forEach((k, v) -> data.append(k).append(" = ").append(String.join(", ", v)).append("; "));
			message = " Form data processed successfully.";
		} else {
			message = " Unsupported Content Type: " + contentType;
		}
		
		// Add diagnostic attributes
        req.setAttribute("contentType", contentType != null ? contentType : "N/A");
        req.setAttribute("message", message);
        req.setAttribute("contentCategory", contentCategory);
        req.setAttribute("rawData", data.toString().isEmpty() ? "No body data found." : data.toString());

        config.getServletContext().log("Processed content type: " + contentType);

        RequestDispatcher rd = req.getRequestDispatcher("/views/contentProcessor.jsp");
        rd.forward(req, res);
		

	}

}
