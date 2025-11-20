<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello from JSP!</h2>
	<p>
		Message from Servlet:
		<%=request.getAttribute("message")%></p>


	<hr />
	<a href="index.jsp">Go back to Home</a>

</body>
</html>