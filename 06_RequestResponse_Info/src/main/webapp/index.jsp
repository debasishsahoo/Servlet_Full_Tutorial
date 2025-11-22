<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Arrays"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Information</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen">

	<div class="max-w-4xl mx-auto mt-10 bg-white rounded-xl shadow-xl p-10">

		<h1 class="text-3xl font-bold text-center text-blue-700 mb-10">
			Request Information</h1>

		<!-- PARAMETERS -->
		<h2 class="text-2xl font-semibold mb-3">Request Parameters</h2>
		<div
			class="bg-gray-50 p-4 border rounded-lg shadow-inner max-h-64 overflow-y-auto">
			<ul class="list-disc ml-6">

				<%
				Map<String, String[]> params = (Map<String, String[]>) request.getAttribute("params");
				if (params.isEmpty()) {
				%>
				<li class="text-gray-500">No parameters found</li>
				<%
				} else {
				for (String key : params.keySet()) {
					String val = Arrays.toString(params.get(key));
				%>
				<li class="mb-2"><b><%=key%>:</b> <%=val%></li>
				<%}}%>
			</ul>
		</div>


		<!-- ATTRIBUTES -->
		<h2 class="text-2xl font-semibold mt-10 mb-3">Request Attributes</h2>
		<div
			class="bg-gray-50 p-4 border rounded-lg shadow-inner max-h-64 overflow-y-auto">
			<ul class="list-disc ml-6">
				<li class="text-gray-500">No attributes found</li>
			</ul>
		</div>


		<!-- CONNECTION INFO -->
		<h2 class="text-2xl font-semibold mt-10 mb-3">Connection
			Information</h2>
		<div
			class="bg-gray-50 p-4 border rounded-lg shadow-inner max-h-64 overflow-y-auto">
			<ul class="list-disc ml-6">
				<li class="text-gray-500">No Connection Information found</li>
			</ul>
		</div>
	</div>




</body>
</html>