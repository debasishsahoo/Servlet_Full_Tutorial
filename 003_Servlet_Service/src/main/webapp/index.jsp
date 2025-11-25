<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>AI Servlet Examples Index</title>
    <link rel="stylesheet" href="assets/style.css">
    <style>
        .container {
            max-width: 800px;
            margin: 60px auto;
            text-align: center;
        }
        h1 {
            color: #007bff;
            margin-bottom: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ddd;
        }
        th {
            background: #007bff;
            color: white;
        }
        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
        footer {
            margin-top: 40px;
            color: #555;
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Servlet Demonstration Project</h1>
    <p>Select a module below to view how different servlets process requests.</p>

    <table>
        <tr>
            <th>Example</th>
            <th>Description</th>
            <th>Launch</th>
        </tr>
        <tr>
            <td><b>BasicServiceServlet</b></td>
            <td>Displays request information, parameters, and attributes.</td>
            <td><a href="basic_service?name=Debasish&course=Servlet" target="_blank">Open</a></td>
        </tr>
        <tr>
            <td><b>ContentProcessorServlet</b></td>
            <td>Processes JSON, text, or form data requests dynamically.</td>
            <td><a href="content-processor" target="_blank">Open</a></td>
        </tr>
        <tr>
            <td><b>ThreadSafeServlet</b></td>
            <td>Demonstrates thread-safe request handling using Atomic variables.</td>
            <td><a href="thread-safe" target="_blank">Open</a></td>
        </tr>
        <tr>
            <td><b>ServiceBestPracticesServlet</b></td>
            <td>Implements best practices like validation and structured response.</td>
            <td><a href="best-practices" target="_blank">Open</a></td>
        </tr>
        <tr>
            <td><b>ServiceBestPracticesServlet</b></td>
            <td>Implements best practices like validation and structured response.</td>
            <td><a href="best-practices?userId=Debasish_123" target="_blank">Open</a></td>
        </tr>
        <tr>
            <td><b>ServiceBestPracticesServlet</b></td>
            <td>Implements best practices like validation and structured response.</td>
            <td><a href="best-practices?userId=@@@" target="_blank">Open</a></td>
        </tr>
    </table>

    <footer>
        <p>Developed as a Servlet MVC Demonstration | © 2025 Example Project</p>
    </footer>
</div>
</body>
</html>
