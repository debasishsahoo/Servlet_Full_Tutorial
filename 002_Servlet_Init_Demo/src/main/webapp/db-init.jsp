<!DOCTYPE html>
<html>
<head>
    <title>Database Initialization Details</title>
    <style>
        body { font-family: Arial; margin: 40px; }
        table { border-collapse: collapse; width: 60%; }
        th, td { border: 1px solid #aaa; padding: 8px; text-align: left; }
        th { background: #ddd; }
    </style>
</head>
<body>
    <h2>Database Connection Pool Details</h2>
    <table>
        <tr><th>Parameter</th><th>Value</th></tr>
        <tr><td>Max Pool Size</td><td><%= request.getAttribute("maxPoolSize") %></td></tr>
        <tr><td>Min Idle</td><td><%= request.getAttribute("minIdle") %></td></tr>
        <tr><td>DataSource Class</td><td><%= request.getAttribute("dataSourceClass") %></td></tr>
    </table>
    <p><a href="index.jsp">Back to Home</a></p>
</body>
</html>