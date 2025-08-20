<%--
  Created by IntelliJ IDEA.
  User: heiner
  Date: 19/8/25
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscar Vehículo</title>
</head>
<body>
<h2>Buscar Vehículo por Placa</h2>
<form action="buscar-vehiculo" method="post">
    <label for="placa">Placa:</label>
    <input type="text" id="placa" name="placa" required>
    <button type="submit">Buscar</button>
</form>
<br>
<form action="menu-de-vehiculos" method="get">
    <button type="submit">Volver</button>
</form>
</body>
</html>

