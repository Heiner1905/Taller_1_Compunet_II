<%--
  Created by IntelliJ IDEA.
  User: heiner
  Date: 19/8/25
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Eliminar Vehículo</title>
</head>
<body>
<h2>Eliminar Vehículo por Placa</h2>
<form action="eliminar-vehiculo" method="post">
    <label for="placa">Placa:</label>
    <input type="text" id="placa" name="placa" required>
    <button type="submit">Eliminar</button>
</form>
<br>
<form action="menu-de-vehiculos" method="get">
    <button type="submit">Volver</button>
</form>
</body>
</html>

