package com.example.destroy;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "GracefulShutdownServlet", urlPatterns = "/graceful", loadOnStartup = 1)
public class GracefulShutdownServlet implements Servlet {

    private ServletConfig config;
    private AtomicBoolean shutdownInProgress = new AtomicBoolean(false);
    private ConcurrentHashMap<Long, Thread> activeRequests = new ConcurrentHashMap<>();
    private AtomicInteger requestCount = new AtomicInteger(0);
    private long startTime;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        this.startTime = System.currentTimeMillis();
        config.getServletContext().log(" GracefulShutdownServlet initialized.");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        long uptime = (System.currentTimeMillis() - startTime) / 1000;

        if (shutdownInProgress.get()) {
            req.setAttribute("message", " Server is shutting down. Request rejected.");
            req.setAttribute("isShutdown", true);
            req.setAttribute("totalRequests", requestCount.get());
            req.setAttribute("activeRequests", activeRequests.size());
            req.setAttribute("uptime", uptime);
            req.setAttribute("threadName", "N/A");
            forward(req, res);
            return;
        }

        long requestId = requestCount.incrementAndGet();
        Thread thread = Thread.currentThread();
        activeRequests.put(requestId, thread);

        try {
            Thread.sleep(2000); // simulate request
            req.setAttribute("message", " Request #" + requestId + " completed successfully.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            req.setAttribute("message", " Request #" + requestId + " was interrupted.");
        } finally {
            activeRequests.remove(requestId);
        }

        req.setAttribute("isShutdown", shutdownInProgress.get());
        req.setAttribute("totalRequests", requestCount.get());
        req.setAttribute("activeRequests", activeRequests.size());
        req.setAttribute("uptime", uptime);
        req.setAttribute("threadName", thread.getName());

        forward(req, res);
    }

    private void forward(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/graceful.jsp");
        rd.forward(req, res);
    }

    @Override
    public void destroy() {
        shutdownInProgress.set(true);
        config.getServletContext().log("🧹 Graceful shutdown started...");

        try {
            for (int i = 0; i < 5 && !activeRequests.isEmpty(); i++) {
                config.getServletContext().log("Waiting for " + activeRequests.size() + " active requests...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (!activeRequests.isEmpty()) {
            config.getServletContext().log(" Forcing shutdown of active requests...");
            activeRequests.values().forEach(Thread::interrupt);
        }

        saveState();
        config.getServletContext().log(" Graceful shutdown complete.");
    }

    private void saveState() {
        try {
            String path = config.getServletContext().getRealPath("/WEB-INF/state.txt");
            if (path != null) {
                try (FileWriter writer = new FileWriter(path, true)) {
                    writer.write("\n=== Graceful Shutdown Report ===\n");
                    writer.write("Time: " + new Date() + "\n");
                    writer.write("Total requests: " + requestCount.get() + "\n");
                    writer.write("Active requests at shutdown: " + activeRequests.size() + "\n");
                    writer.write("===============================\n");
                }
            }
        } catch (IOException e) {
            config.getServletContext().log("Error saving state: " + e.getMessage());
        }
    }

    @Override
    public ServletConfig getServletConfig() { return config; }

    @Override
    public String getServletInfo() { return "GracefulShutdownServlet - Enhanced Display Version"; }
}
