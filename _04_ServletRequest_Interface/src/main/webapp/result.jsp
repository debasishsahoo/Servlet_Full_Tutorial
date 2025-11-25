<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Request Result</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-100">

<div class="max-w-3xl mx-auto mt-16 bg-white p-10 rounded-xl shadow-xl">

    <h1 class="text-3xl font-bold text-gray-800 text-center">Request Processing Result</h1>
    <p class="text-center text-gray-600 mb-8">Servlet successfully processed the request</p>

    <table class="min-w-full bg-white border rounded-lg overflow-hidden">
        <tbody>

            <tr><td class="border px-4 py-2 font-semibold">Username</td>
                <td class="border px-4 py-2">${username}</td></tr>

            <tr><td class="border px-4 py-2 font-semibold">Email</td>
                <td class="border px-4 py-2">${email}</td></tr>
                
                <tr><td class="border px-4 py-2 font-semibold">Password</td>
                <td class="border px-4 py-2">${password}</td></tr>

            <tr><td class="border px-4 py-2 font-semibold">Hobbies</td>
                <td class="border px-4 py-2">
                    <%
                        String[] hobbies = (String[]) request.getAttribute("hobbies");
                        if (hobbies != null) {
                            for (String h : hobbies) { out.println(h + "<br>"); }
                        }
                    %>
                </td>
            </tr>

            <tr><td class="border px-4 py-2 font-semibold">Raw Body Text</td>
                <td class="border px-4 py-2"><pre>${rawBody}</pre></td></tr>

            <tr><td class="border px-4 py-2 font-semibold">Client IP</td>
                <td class="border px-4 py-2">${clientIP}</td></tr>

            <tr><td class="border px-4 py-2 font-semibold">Server Name</td>
                <td class="border px-4 py-2">${serverName}</td></tr>

            <tr><td class="border px-4 py-2 font-semibold">Server Port</td>
                <td class="border px-4 py-2">${serverPort}</td></tr>

            <tr><td class="border px-4 py-2 font-semibold">Protocol</td>
                <td class="border px-4 py-2">${protocol}</td></tr>

            <tr><td class="border px-4 py-2 font-semibold">Locale</td>
                <td class="border px-4 py-2">${locale}</td></tr>

            <tr><td class="border px-4 py-2 font-semibold">Request Attribute</td>
                <td class="border px-4 py-2">${userAttribute}</td></tr>

        </tbody>
    </table>

    <a href="index.jsp"
       class="block mt-6 bg-blue-600 text-white py-3 text-center rounded-lg font-semibold hover:bg-blue-700">
       ← Go Back
    </a>
</div>

</body>
</html>
