<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100">

<div class="max-w-xl mx-auto mt-20 bg-white shadow-lg p-10 rounded-xl">

    <h2 class="text-3xl font-bold text-gray-800 text-center mb-4">
        Welcome
    </h2>

    <p class="text-center text-gray-600 text-xl">
        Hello, <span class="font-bold text-blue-600">
            <%= request.getAttribute("username") %>
        </span>! You are successfully logged in.
    </p>

    <div class="text-center mt-8">
        <a href="login.jsp"
           class="bg-gray-700 text-white px-6 py-3 rounded-lg font-semibold hover:bg-gray-800">
            Logout
        </a>
    </div>

</div>

</body>
</html>
