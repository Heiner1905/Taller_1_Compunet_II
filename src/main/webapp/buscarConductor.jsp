<%--
  Created by IntelliJ IDEA.
  User: heiner
  Date: 18/8/25
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Buscar vehículos de un conductor</title></head>
<body>
<h2>Buscar vehículos de un conductor</h2>
<form action="buscar-conductor" method="post">
    <label for="tipoDeIdentificacion">Tipo de identificación:</label>
    <select name="tipoDeIdentificacion" id="tipoDeIdentificacion">
        <option value="1">CC</option>
        <option value="2">CE</option>
        <option value="3">NIT</option>
        <option value="4">Pasaporte</option>
    </select>
    <br/><br/>
    <label for="numeroDeIdentificacion">Número de Identificación:</label>
    <input type="text" name="numeroDeIdentificacion" id="numeroDeIdentificacion" required>
    <br/><br/>
    <input type="submit" value="Buscar">
</form>

<br>
<!-- Botón para volver -->
<form action="menu-de-conductores" method="get">
    <button type="submit">Volver</button>
</form>
</body>
</html>
