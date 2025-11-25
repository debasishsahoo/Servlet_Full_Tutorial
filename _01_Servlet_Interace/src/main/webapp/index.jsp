<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body style="font-family: Arial; text-align: center; margin-top: 50px;">
    <h1>Welcome to My JSP + Servlet App</h1>
	<p>This is the entry page (index.jsp)</p>
	
	<hr />

	<!-- Option 1: Simple link to servlet -->
	<p>
		<a href="servletinterface">Click here to call Servlet interface</a>
	</p>
	
	<hr />

	<!-- Option 2: Form submission to servlet -->
	<form action="servletinterface" method="GET">
		<label for="name">Enter your name:</label>
		
		<input type="text" id="name" name="username" required>
		<button type="submit">Submit</button>
	</form>
	
	
	
</body>
</html>