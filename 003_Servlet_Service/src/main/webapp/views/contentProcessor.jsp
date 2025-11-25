<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Content Processor Result</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
    <style>
        .status-box {
            margin: 10px 0;
            padding: 10px;
            border-left: 5px solid #007bff;
            background-color: #f8f9fa;
        }
        .highlight {
            background-color: #eef;
            padding: 10px;
            border-radius: 4px;
            word-break: break-all;
        }
        form {
            background-color: #f9f9f9;
            padding: 15px;
            margin-top: 25px;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        form textarea, input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        button {
            background-color: #007bff;
            border: none;
            color: white;
            padding: 8px 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover { background-color: #0056b3; }
    </style>
</head>
<body>
<div class="container">
    <h1>Content Processing Result</h1>

    <div class="status-box">
        <strong>${message}</strong>
    </div>

    <table border="1" width="100%" style="margin-top: 15px;">
        <tr><th>Property</th><th>Value</th></tr>
        <tr><td>Content Type</td><td>${contentType}</td></tr>
        <tr><td>Detected Category</td><td>${contentCategory}</td></tr>
    </table>

    <h3>Received Raw Data:</h3>
    <div class="highlight">${rawData}</div>

    <h2>Try It Yourself</h2>
    <form action="${pageContext.request.contextPath}/content-processor" method="post">
        <label>Form Example:</label>
        <input type="text" name="username" placeholder="Enter username">
        <input type="text" name="role" placeholder="Enter role">
        <button type="submit">Submit Form Data</button>
    </form>

    <form action="${pageContext.request.contextPath}/content-processor" method="post" enctype="text/plain">
        <label>Plain Text Example:</label>
        <textarea name="data" rows="3">This is plain text input.</textarea>
        <button type="submit">Submit Plain Text</button>
    </form>

    <form action="${pageContext.request.contextPath}/content-processor" method="post" enctype="application/json">
        <label>JSON Example:</label>
        <textarea name="data" rows="3">{ "user": "admin", "role": "tester" }</textarea>
        <button type="submit">Submit JSON</button>
    </form>

    <p style="margin-top:20px;">
        <a href="${pageContext.request.contextPath}/index.jsp">← Back to Home</a>
    </p>
</div>
</body>
</html>
