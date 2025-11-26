<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Graceful Shutdown</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f6f8;
}

.container {
	max-width: 800px;
	margin: 50px auto;
	background: white;
	padding: 25px;
	border-radius: 10px;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #007bff;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #007bff;
	color: white;
}

.message {
	font-weight: bold;
	margin-bottom: 15px;
}

.shutdown {
	color: red;
	font-weight: bold;
}

button {
	background-color: #007bff;
	color: white;
	border: none;
	padding: 10px 15px;
	border-radius: 6px;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}

.footer {
	margin-top: 20px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Graceful Shutdown Servlet</h1>
		<p class="message <c:if test='${isShutdown}'>shutdown</c:if>">${message}</p>

		<h3>Server Status</h3>
		<table>
			<tr>
				<th>Property</th>
				<th>Value</th>
			</tr>
			<tr>
				<td>Total Requests Processed</td>
				<td>${totalRequests}</td>
			</tr>
			<tr>
				<td>Active Requests</td>
				<td>${activeRequests}</td>
			</tr>
			<tr>
				<td>Uptime (seconds)</td>
				<td>${uptime}</td>
			</tr>
			<tr>
				<td>Thread Handling Request</td>
				<td>${threadName}</td>
			</tr>
			<tr>
				<td>Shutdown in Progress</td>
				<td><c:choose>
						<c:when test='${isShutdown}'>Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
			</tr>
		</table>

		<div class="footer">
			<form action="${pageContext.request.contextPath}/graceful"
				method="get">
				<button type="submit">Simulate Another Request</button>
			</form>
			<p>
				<a href="${pageContext.request.contextPath}/index.jsp">← Back to
					Home</a>
			</p>
		</div>
	</div>
</body>
</html>
