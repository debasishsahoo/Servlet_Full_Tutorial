<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Servlet Destroy Lifecycle Demonstration</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
</head>
<body>
  <div class="container">
    <h1>Destroy Lifecycle Demonstration</h1>
    <ul class="nav-list">
      <li><a href="${pageContext.request.contextPath}/cleanup">Proper Cleanup Servlet</a></li>
      <li><a href="${pageContext.request.contextPath}/graceful">Graceful Shutdown Servlet</a></li>
      <li><a href="${pageContext.request.contextPath}/views/destroyBestPractices.jsp">Destroy Best Practices</a></li>
    </ul>
  </div>
</body>
</html>