<%--
  Created by IntelliJ IDEA.
  User: heiner
  Date: 19/8/25
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultado</title>
</head>
<body>
<h2><%= request.getAttribute("mensaje") %></h2>
<br>
<form action="index.jsp" method="get">
    <button type="submit">Volver al menu principal</button>
</form>
</body>
</html>

