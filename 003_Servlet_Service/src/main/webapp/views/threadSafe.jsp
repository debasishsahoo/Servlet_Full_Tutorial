<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page
	import="java.util.Map, java.util.concurrent.atomic.AtomicInteger"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thread Safety Demo</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/style.css">
<style>
.summary-box {
	background-color: #f0f9ff;
	border-left: 5px solid #007bff;
	padding: 10px;
	margin: 15px 0;
}

table {
	border-collapse: collapse;
	width: 100%;
	margin-top: 15px;
}

th, td {
	padding: 8px;
	border: 1px solid #ddd;
}

th {
	background-color: #007bff;
	color: white;
}

form {
	margin-top: 20px;
	background: #f9f9f9;
	padding: 15px;
	border: 1px solid #ddd;
	border-radius: 5px;
}

input[type="text"] {
	padding: 6px;
	border-radius: 4px;
	border: 1px solid #ccc;
}

button {
	background-color: #007bff;
	border: none;
	color: white;
	padding: 6px 12px;
	border-radius: 4px;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Thread Safety Demonstration</h1>

		<div class="summary-box">
			<p>
				<strong>Current User:</strong> ${user}
			</p>
			<p>
				<strong>User Request Count:</strong> ${userCount}
			</p>
			<p>
				<strong>Total Requests:</strong> ${totalRequests}
			</p>
			<p>
				<strong>Thread Name:</strong> ${threadName} (ID: ${threadId})
			</p>
		</div>

		<h2>Active Users and Request Counts</h2>
		<table>
			<tr>
				<th>User</th>
				<th>Request Count</th>
			</tr>
			<%
            Map<String, AtomicInteger> activeUsers = (Map<String, AtomicInteger>) request.getAttribute("activeUsers");
            if (activeUsers != null && !activeUsers.isEmpty()) {
                for (Map.Entry<String, AtomicInteger> entry : activeUsers.entrySet()) {
        %>
			<tr>
				<td><%= entry.getKey() %></td>
				<td><%= entry.getValue().get() %></td>
			</tr>
			<%
                }
            } else {
        %>
			<tr>
				<td colspan="2">No active users yet</td>
			</tr>
			<%
            }
        %>
		</table>

		<h2>Simulate a New Request</h2>
		<form action="${pageContext.request.contextPath}/thread-safe"
			method="get">
			<label>Enter User Name:</label> <input type="text" name="user"
				placeholder="e.g., admin or guest">
			<button type="submit">Send Request</button>
		</form>

		<p style="margin-top: 20px;">
			<a href="${pageContext.request.contextPath}/index.jsp">← Back to
				Home</a>
		</p>
	</div>
</body>
</html>
