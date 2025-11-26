<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Proper Cleanup Results</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
  <style>
    .stats-table { width: 100%; border-collapse: collapse; margin-top: 15px; }
    .stats-table th, .stats-table td { padding: 10px; border: 1px solid #ddd; text-align: left; }
    .stats-table th { background-color: #007bff; color: white; }
    .highlight { color: #007bff; font-weight: bold; }
  </style>
</head>
<body>
  <div class="container">
    <h1>Proper Cleanup Servlet Result</h1>
    <p class="highlight">${message}</p>

    <table class="stats-table">
      <tr><th>Property</th><th>Value</th></tr>
      <tr><td>Total Requests</td><td>${requestCount}</td></tr>
      <tr><td>Active Connections</td><td>${activeConnections}</td></tr>
      <tr><td>Idle Connections</td><td>${idleConnections}</td></tr>
      <tr><td>Connection Pool</td><td>${poolName}</td></tr>
      <tr><td>Server Uptime (s)</td><td>${uptime}</td></tr>
      <tr><td>Processing Thread</td><td>${threadName}</td></tr>
    </table>

    <div class="actions" style="margin-top:20px;">
      <form action="${pageContext.request.contextPath}/cleanup" method="get">
        <button type="submit" class="btn-primary">Simulate Another Request</button>
      </form>
      <p style="margin-top:15px;"><a href="${pageContext.request.contextPath}/index.jsp">← Back to Home</a></p>
    </div>
  </div>
</body>
</html>
