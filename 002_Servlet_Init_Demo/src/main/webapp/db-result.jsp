<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Database Connection Result</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f8f8f8; margin: 50px; }
        .container { background: white; padding: 30px; border-radius: 10px; width: 500px; margin: auto; text-align: center; box-shadow: 0 0 10px #aaa; }
        .success { color: green; font-weight: bold; }
        .error { color: red; font-weight: bold; }
        a { display: inline-block; margin-top: 20px; background: #007bff; color: white; padding: 10px 20px; border-radius: 5px; text-decoration: none; }
        a:hover { background: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Database Connection Result</h2>
        <% boolean connected = (Boolean) request.getAttribute("connected"); %>
        <% String message = (String) request.getAttribute("message"); %>

        <p class="<%= connected ? "success" : "error" %>">
            <%= message %>
        </p>

        <a href="index.jsp">Back to Home</a>
    </div>
</body>
</html>
