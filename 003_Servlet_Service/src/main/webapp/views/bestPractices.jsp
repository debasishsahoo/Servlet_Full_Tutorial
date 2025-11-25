<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Servlet Best Practices Result</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
    <style>
        .status-success {
            background-color: #e6ffe6;
            border-left: 5px solid #28a745;
            color: #155724;
            padding: 10px;
        }
        .status-error {
            background-color: #ffe6e6;
            border-left: 5px solid #dc3545;
            color: #721c24;
            padding: 10px;
        }
        table {
            margin-top: 15px;
        }
        th, td {
            text-align: left;
            padding: 8px;
        }
        .details {
            background-color: #f9f9f9;
            border-radius: 5px;
            padding: 15px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Service Best Practices Output</h1>

    <div class="${status == 'success' ? 'status-success' : 'status-error'}">
        <strong>${message}</strong>
    </div>

    <div class="details">
        <h3>Request Summary</h3>
        <table border="1" width="100%">
            <tr><th>Parameter</th><th>Value</th></tr>
            <tr><td>User ID</td><td>${userId != null ? userId : 'N/A'}</td></tr>
            <tr><td>Status</td><td>${status}</td></tr>
            <tr><td>Processed At</td><td>${timestamp}</td></tr>
            <tr><td>Processing Time</td><td>${duration} ms</td></tr>
        </table>
    </div>

    <p style="margin-top:20px;">
        <a href="${pageContext.request.contextPath}/index.jsp">← Back to Home</a>
    </p>
</div>
</body>
</html>
