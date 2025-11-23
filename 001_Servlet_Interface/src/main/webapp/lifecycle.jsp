<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Lifecycle Details</title>
</head>
<body style="font-family: Arial; margin: 40px;">
	<h2>Servlet Lifecycle Details</h2>
	<table border="1" cellpadding="8" cellspacing="0">
		<tr>
			<th>Property</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>Servlet Name</td>
			<td><%=request.getAttribute("servletName")%></td>
		</tr>
		<tr>
			<td>Request Number</td>
			<td><%=request.getAttribute("requestNumber")%></td>
		</tr>
		<tr>
			<td>Initialization Time</td>
			<td><%=request.getAttribute("initTime")%></td>
		</tr>
		<tr>
			<td>Current Time</td>
			<td><%=request.getAttribute("currentTime")%></td>
		</tr>
		<tr>
			<td>Uptime (ms)</td>
			<td><%=request.getAttribute("uptime")%></td>
		</tr>
		<tr>
			<td>Thread Name</td>
			<td><%=request.getAttribute("threadName")%></td>
		</tr>
		<tr>
			<td>Thread ID</td>
			<td><%=request.getAttribute("threadId")%></td>
		</tr>
	</table>

	<h3>Lifecycle Phases:</h3>
	<ol>
		<li><b>init()</b> - Called once when servlet loads</li>
		<li><b>service()</b> - Called for each client request</li>
		<li><b>destroy()</b> - Called once before servlet is removed</li>
	</ol>

	<p>
		<a href="lifecycle">Refresh (New Request)</a>
	</p>
	<p>
		<a href="index.jsp">Back to Home</a>
	</p>
</body>
</html>
