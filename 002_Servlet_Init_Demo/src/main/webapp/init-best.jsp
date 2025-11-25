<!DOCTYPE html>
<html>
<head>
    <title>Initialization Best Practices</title>
    <style>
        body { font-family: Arial; margin: 40px; }
        table { border-collapse: collapse; width: 50%; }
        th, td { border: 1px solid #aaa; padding: 8px; text-align: left; }
        th { background: #ddd; }
    </style>
</head>
<body>
    <h2>Initialization Best Practices</h2>
    <table>
        <tr><th>Servlet Name</th><td><%= request.getAttribute("servletName") %></td></tr>
        <tr><th>Required Parameter</th><td><%= request.getAttribute("requiredParam") %></td></tr>
    </table>
    <p><a href="index.jsp">Back to Home</a></p>
</body>
</html>
