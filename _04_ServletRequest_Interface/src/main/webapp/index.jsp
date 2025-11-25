<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Request API Demo</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100">

	<div class="max-w-2xl mx-auto mt-16 bg-white p-10 rounded-xl shadow-xl">
		<h1 class="text-3xl font-bold text-gray-800 text-center">Request
			API Demo</h1>
		<p class="text-center text-gray-600 mt-2 mb-8">Demonstrating
			Parameters, Metadata, InputStream, Locale & Forwarding</p>

		<form action="request" method="GET">

			<!-- Username -->
			<div class="mb-4">
				<label class="block text-gray-700 font-semibold mb-2">Username</label>
				<input type="text" name="username" required
					class="w-full border border-gray-300 p-3 rounded-lg"
					placeholder="Enter your username">
			</div>

			<!-- Email -->
			<div class="mb-4">
				<label class="block text-gray-700 font-semibold mb-2">Email</label>
				<input type="email" name="email" required
					class="w-full border border-gray-300 p-3 rounded-lg"
					placeholder="you@example.com">
			</div>
			
			<div class="mb-4">
				<label class="block text-gray-700 font-semibold mb-2">Password</label>
				<input type="password" name="password" required
					class="w-full border border-gray-300 p-3 rounded-lg"
					placeholder="******">
			</div>

			<!-- Hobbies -->
			<div class="mb-4">
				<label class="block text-gray-700 font-semibold mb-2">Select
					Hobbies</label>
				<div class="flex flex-col space-y-2">
					<label><input type="checkbox" name="hobby" value="Music">
						Music</label> <label><input type="checkbox" name="hobby"
						value="Coding"> Coding</label> <label><input
						type="checkbox" name="hobby" value="Travel"> Travel</label>
				</div>
			</div>

			<!-- Raw Body -->
			<div class="mb-6">
				<label class="block text-gray-700 font-semibold mb-2">Raw
					Body Input</label>
				<textarea name="rawData" rows="4"
					class="w-full border border-gray-300 p-3 rounded-lg"
					placeholder="Type any raw text..."></textarea>
			</div>

			<button
				class="w-full bg-blue-600 text-white py-3 rounded-lg font-semibold text-lg hover:bg-blue-700">
				Submit Request</button>
		</form>
	</div>

</body>
</html>
