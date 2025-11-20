<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP Page</title>

<style>
body {
	background: #f7f9fc;
	font-family: "Segoe UI", Arial, sans-serif;
	display: flex;
	justify-content: center;
	align-items: start;
	padding-top: 60px;
}

.card {
	background: #ffffff;
	padding: 30px 40px;
	border-radius: 12px;
	width: 420px;
	text-align: center;
	box-shadow: 0 4px 16px rgba(0, 0, 0, 0.08);
	border: 1px solid #e7e7e7;
}

h2 {
	margin-bottom: 15px;
	color: #333;
	font-weight: 700;
}

.message {
	font-size: 16px;
	color: #555;
	margin-bottom: 25px;
}

input[type=text] {
	width: 100%;
	padding: 12px;
	font-size: 15px;
	border-radius: 8px;
	border: 1px solid #ccc;
	margin-top: 8px;
	margin-bottom: 20px;
}

button {
	background: #4a90e2;
	padding: 12px 0;
	width: 100%;
	border: none;
	color: white;
	font-size: 16px;
	border-radius: 8px;
	font-weight: 600;
	cursor: pointer;
	transition: 0.3s ease;
}

button:hover {
	background: #3578d4;
}

label {
	font-size: 14px;
	color: #444;
	font-weight: 600;
}
</style>

</head>
<body>

	<div class="card">

		<h2>Hello from JSP!</h2>

		<p class="message">
			<strong>Message:</strong>
			<%= request.getAttribute("msg") == null ? "No message yet." : request.getAttribute("msg") %>
		</p>

		<form action="basic" method="GET">
			<label for="user">Enter your name:</label> 
			<input type="text" id="user" name="user" placeholder="Type your name..." required />

			<button type="submit">Submit</button>
		</form>
		<a href="index.jsp" class="btn btn-secondary w-100 mt-3">Go Back</a>
	</div>

</body>
</html>
