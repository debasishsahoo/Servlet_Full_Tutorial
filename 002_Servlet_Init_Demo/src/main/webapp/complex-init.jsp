<!DOCTYPE html>
<html>
<head>
    <title>Complex Initialization Details</title>
    <style>
        body { font-family: Arial; margin: 40px; }
        table { border-collapse: collapse; width: 60%; }
        th, td { border: 1px solid #aaa; padding: 8px; text-align: left; }
        th { background: #ddd; }
    </style>
</head>
<body>
    <h2>Complex Resource Initialization Details</h2>
    <table>
        <tr><th>Parameter</th><th>Value</th></tr>
        <tr><td>Thread Pool Size</td><td><%= request.getAttribute("threadPoolSize") %></td></tr>
        <tr><td>Cache Max Size</td><td><%= request.getAttribute("cacheMaxSize") %></td></tr>
        <tr><td>Cache TTL (ms)</td><td><%= request.getAttribute("cacheTTL") %></td></tr>
        <tr><td>Current Cache Entries</td><td><%= request.getAttribute("cacheSize") %></td></tr>
    </table>
    <p><a href="index.jsp">Back to Home</a></p>
</body>
</html>
