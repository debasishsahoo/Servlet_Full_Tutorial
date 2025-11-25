<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>HTML Response</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 p-10">

<div class="max-w-xl mx-auto bg-white p-8 shadow-lg rounded-xl">
    <h2 class="text-2xl font-bold text-gray-800">HTML Response</h2>
    <p class="text-gray-600 mt-4">${message}</p>

    <a href="responseMenu.jsp"
       class="mt-6 inline-block bg-blue-600 text-white px-5 py-2 rounded-lg hover:bg-blue-700">
        ← Back
    </a>
</div>

</body>
</html>
