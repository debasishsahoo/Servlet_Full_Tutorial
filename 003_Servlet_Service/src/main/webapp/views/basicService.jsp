<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Basic Service Information</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/styles.css">
</head>
<body>
<body>
	<div class="container">
		<h1>Basic Service Request Details</h1>
		<table>
			<tr>
				<th>Property</th>
				<th>Value</th>
			</tr>
			<tr>
				<td>Request Number</td>
				<td>${requestNumber}</td>
			</tr>
			<tr>
				<td>Thread Name</td>
				<td>${threadName}</td>
			</tr>
			<tr>
				<td>Protocol</td>
				<td>${protocol}</td>
			</tr>
			<tr>
				<td>Scheme</td>
				<td>${scheme}</td>
			</tr>
			<tr>
				<td>Server Name</td>
				<td>${serverName}</td>
			</tr>
			<tr>
				<td>Server Port</td>
				<td>${serverPort}</td>
			</tr>
			<tr>
				<td>Remote Address</td>
				<td>${remoteAddr}</td>
			</tr>
			<tr>
				<td>Remote Host</td>
				<td>${remoteHost}</td>
			</tr>
		</table>

		<h2>Parameters</h2>
		<c:choose>
			<c:when test="${empty parameters}">
				<p>No parameters available</p>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<th>Name</th>
						<th>Value</th>
					</tr>
					<c:forEach var="entry" items="${parameters}">
						<tr>
							<td>${entry.key}</td>
							<td>${entry.value[0]}</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
		
		<h2>Request Attributes</h2>
		<c:choose>
			<c:when test="${empty attributes}">
				<p>No attributes available</p>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<th>Name</th>
						<th>Value</th>
					</tr>
					<c:forEach var="attr" items="${attributes}">
						<tr>
							<td>${attr}</td>
							<td>${requestScope[attr]}</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>





	</div>
</body>
</html>