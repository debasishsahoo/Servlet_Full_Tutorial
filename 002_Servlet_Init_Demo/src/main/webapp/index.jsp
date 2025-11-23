<!DOCTYPE html>
<html>
<head>
<title>Servlet Initialization Demos & HikariCP Demo</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #f8f8f8;
	margin: 50px;
}

.container {
	background: white;
	padding: 30px;
	border-radius: 10px;
	width: 500px;
	margin: auto;
	text-align: center;
	box-shadow: 0 0 10px #aaa;
}

a {
	display: inline-block;
	margin-top: 20px;
	background: #007bff;
	color: white;
	padding: 10px 20px;
	border-radius: 5px;
	text-decoration: none;
}

a:hover {
	background: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h1>HikariCP Database Connection Test</h1>
		<p>Click the button below to test your PostgreSQL database
			connection using HikariCP.</p>
		<a href="test-db">Test Database Connection</a>
	</div>
	<hr />
	<div>
		<h1>Servlet Initialization Demonstrations</h1>
		<p>Select an example to view details:</p>
		<a href="db-init">Database Connection Pool Initialization</a> <a
			href="complex-init">Complex Resource Initialization</a> <a
			href="init-best">Initialization Best Practices</a>
	</div>
</body>
</html>






