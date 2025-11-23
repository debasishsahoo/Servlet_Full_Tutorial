<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Initialization Details</title>
</head>
<body style="font-family: Arial, sans-serif; margin: 40px;">
	<h2>Servlet Initialization Details</h2>

	<table border="1" cellpadding="8" cellspacing="0">
		<tr>
			<th>Parameter</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>Config File</td>
			<td><%= request.getAttribute("configFile") %></td>
		</tr>
		<tr>
			<td>Cache Size</td>
			<td><%= request.getAttribute("cacheSize") %></td>
		</tr>
		<tr>
			<td>Timeout</td>
			<td><%= request.getAttribute("timeout") %></td>
		</tr>
		<tr>
			<td>Properties Loaded</td>
			<td><%= request.getAttribute("propertiesCount") %></td>
		</tr>
	</table>

	<h3>Loaded Properties</h3>
	<table border="1" cellpadding="8" cellspacing="0">
		<tr>
			<th>Key</th>
			<th>Value</th>
		</tr>
		<%
            java.util.Properties props = (java.util.Properties) request.getAttribute("properties");
            for (String key : props.stringPropertyNames()) {
        %>
		<tr>
			<td><%= key %></td>
			<td><%= props.getProperty(key) %></td>
		</tr>
		<% } %>
	</table>

	<p>
		<a href="index.jsp">Back to Home</a>
	</p>
</body>
</html>
