<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Servlet Output</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow p-4">

        <h2 class="text-center mb-4">Servlet Output</h2>

        <table class="table table-bordered">
            <tr><th>Application Name</th><td>${appName}</td></tr>
            <tr><th>Environment</th><td>${environment}</td></tr>
            <tr><th>Servlet Name</th><td>${servletName}</td></tr>
            <tr><th>User Name</th><td>${username}</td></tr>
            <tr><th>Email</th><td>${email}</td></tr>
        </table>

        <a href="index.jsp" class="btn btn-secondary w-100 mt-3">Go Back</a>

    </div>
</div>
</body>
</html>
