package com.example.servlets;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.WebInitParam;

@WebServlet(name = "ComplexInitServlet", urlPatterns = "/complex-init", initParams = {
		@WebInitParam(name = "threadPoolSize", value = "10"), // Number of threads for concurrent request handling
		@WebInitParam(name = "cacheMaxSize", value = "10000"), // Maximum number of items that can be cached
		@WebInitParam(name = "cacheTTL", value = "3600")// Cache time-to-live in seconds
}, loadOnStartup = 1 // (only when first requested).
)
public class ComplexInitServlet implements Servlet {

	private static final Logger LOGGER = Logger.getLogger(ComplexInitServlet.class.getName());

	private ServletConfig config;
	private ExecutorService executorService;
	private ConcurrentHashMap<String, String> cache;
	private int threadPoolSize;
	private int cacheMaxSize;
	private long cacheTTL;

	@Override
	public void destroy() {
		executorService.shutdown();
        cache.clear();

	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public String getServletInfo() {
		return "ComplexInitServlet";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		try {
			threadPoolSize = Integer.parseInt(config.getInitParameter("threadPoolSize"));
			cacheMaxSize = Integer.parseInt(config.getInitParameter("cacheMaxSize"));
			cacheTTL = Long.parseLong(config.getInitParameter("cacheTTL")) * 1000;

			executorService = Executors.newFixedThreadPool(threadPoolSize);
			cache = new ConcurrentHashMap<>(cacheMaxSize);

			for (int i = 0; i < 10; i++)
				cache.put("warmup-" + i, "Data " + i);

		} catch (Exception e) {
			throw new ServletException("Complex initialization failed", e);
		}

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		req.setAttribute("cacheSize", cache.size());
		req.setAttribute("threadPoolSize", threadPoolSize);
		req.setAttribute("cacheMaxSize", cacheMaxSize);
		req.setAttribute("cacheTTL", cacheTTL);
		RequestDispatcher dispatcher = req.getRequestDispatcher("complex-init.jsp");
		dispatcher.forward(req, res);

	}

}
