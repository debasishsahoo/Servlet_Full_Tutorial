package com.example.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/request-info")
public class RequestResponseServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// Collect request parameters
				Map<String, String[]> params = new HashMap<>();
				Enumeration<String> paramNames = request.getParameterNames();
				while (paramNames.hasMoreElements()) {
					String p = paramNames.nextElement();
					params.put(p, request.getParameterValues(p));
				}

				// Add sample request attributes (FIX)
				request.setAttribute("loggedInUser", "Debasish");
				request.setAttribute("message", "Hello from Servlet!");
				request.setAttribute("sessionStatus", "Active");

				// Collect request attributes
				Map<String, Object> attrs = new HashMap<>();
				Enumeration<String> attrNames = request.getAttributeNames();
				while (attrNames.hasMoreElements()) {
					String a = attrNames.nextElement();
					attrs.put(a, request.getAttribute(a));
				}

				// Connection details
				Map<String, Object> connectionInfo = new LinkedHashMap<>();
				connectionInfo.put("Remote Address", request.getRemoteAddr());
				connectionInfo.put("Remote Host", request.getRemoteHost());
				connectionInfo.put("Protocol", request.getProtocol());
				connectionInfo.put("Content Type", request.getContentType());
				connectionInfo.put("Content Length", request.getContentLength());
				connectionInfo.put("Character Encoding", request.getCharacterEncoding());

				// Store all in request scope
				request.setAttribute("params", params);
				request.setAttribute("attrs", attrs);
				request.setAttribute("info", connectionInfo);

				// Forward to JSP
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
		

	}

}
