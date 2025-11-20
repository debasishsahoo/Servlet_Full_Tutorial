<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
	<div class="max-w-md mx-auto mt-20 bg-white shadow-lg p-8 rounded-xl">

		<h2 class="text-3xl font-bold text-gray-800 text-center mb-6">Login</h2>

		<%
         String error=(String) request.getAttribute("errorMsg");
         if(error!= null && !error.isEmpty()){  
         %>
		<div class="bg-red-100 text-red-700 p-3 rounded mb-4 text-center">
			<%= error %>
		</div>
		<%} %>







		<form action="login" method="post">

			<label class="block font-semibold mb-1">Username</label> <input
				type="text" name="username" required
				class="w-full border border-gray-300 rounded-lg p-3 mb-4"
				placeholder="Enter username"> <label
				class="block font-semibold mb-1">Password</label> <input
				type="password" name="password" required
				class="w-full border border-gray-300 rounded-lg p-3 mb-6"
				placeholder="Enter password">

			<button
				class="w-full bg-blue-600 text-white py-3 rounded-lg font-semibold
                       hover:bg-blue-700 transition">
				Login</button>
		</form>
</body>
</html>