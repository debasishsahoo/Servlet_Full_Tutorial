package com.example.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@WebServlet("/ResponseDemoServlet")
public class ResponseDemoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type == null)
			type = "menu";// default UI

		switch (type) {

		case "html": {
			request.setAttribute("message", "This is an HTML response generated using getWriter().");
			RequestDispatcher rd = request.getRequestDispatcher("htmlView.jsp");
			rd.forward(request, response);
			break;
		}

		case "json": {
			request.setAttribute("jsonText", "{\"message\":\"JSON OK\",\"status\":\"success\"}");
			RequestDispatcher rd = request.getRequestDispatcher("jsonView.jsp");
			rd.forward(request, response);
			break;
		}

		case "binary": {
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\"sample.bin\"");
			
			byte[] data = "This is binary content".getBytes(StandardCharsets.UTF_8);
			ServletOutputStream out = response.getOutputStream();
			out.write(data);
			out.flush();
			break;
		}

		case "locale": {
			response.setLocale(Locale.FRANCE);
			request.setAttribute("localeMsg", "Locale set to: " + response.getLocale());
			RequestDispatcher rd = request.getRequestDispatcher("localeView.jsp");
			rd.forward(request, response);
			break;
		}

		case "buffer": {
			response.setContentType("text/plain;charset=UTF-8");
			response.setBufferSize(2048);
			PrintWriter out = response.getWriter();
			out.println("Initial output...");
			
			if (!response.isCommitted()) {
				response.resetBuffer();
				out.println("Buffer was reset before commit.");
			}

			out.flush();
			break;
		}

		default: {
			RequestDispatcher rd = request.getRequestDispatcher("responseMenu.jsp");
			rd.forward(request, response);
		}

		}

	}

}
