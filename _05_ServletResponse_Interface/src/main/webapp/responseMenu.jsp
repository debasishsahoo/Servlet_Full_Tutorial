<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Response Demo</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
<div class="max-w-xl mx-auto mt-16 bg-white shadow-lg rounded-xl p-10">

    <h1 class="text-3xl font-bold text-gray-800 text-center mb-4">
        Response Demo Servlet
    </h1>

    <p class="text-center text-gray-600 mb-8">
        Select a response type to test Servlet Output
    </p>

    <div class="grid grid-cols-1 gap-4">

        <a href="ResponseDemoServlet?type=html"
           class="bg-blue-600 text-white py-3 rounded-lg text-center font-semibold hover:bg-blue-700">
            HTML Response
        </a>

        <a href="ResponseDemoServlet?type=json"
           class="bg-green-600 text-white py-3 rounded-lg text-center font-semibold hover:bg-green-700">
            JSON Response
        </a>

        <a href="ResponseDemoServlet?type=binary"
           class="bg-gray-700 text-white py-3 rounded-lg text-center font-semibold hover:bg-gray-800">
            Download Binary File
        </a>

        <a href="ResponseDemoServlet?type=locale"
           class="bg-indigo-600 text-white py-3 rounded-lg text-center font-semibold hover:bg-indigo-700">
            Locale Output
        </a>

        <a href="ResponseDemoServlet?type=buffer"
           class="bg-orange-500 text-white py-3 rounded-lg text-center font-semibold hover:bg-orange-600">
            Buffer Demo
        </a>

    </div>
</div>
</body>
</html>