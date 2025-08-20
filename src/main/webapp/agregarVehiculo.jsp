<%--
  Created by IntelliJ IDEA.
  User: heiner
  Date: 19/8/25
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Agregar Vehículo</title></head>
<body>
<h2>Agregar un nuevo vehículo</h2>

<form action="agregar-vehiculo" method="post">
    <label>Placa:</label>
    <input type="text" name="placa" required><br><br>

    <label>Cilindraje:</label>
    <input type="number" name="cilindraje" required><br><br>

    <label>Tipo de Combustible:</label>
    <select name="tipoCombustible" required>
        <option value="1">Gasolina</option>
        <option value="2">Diésel</option>
        <option value="3">Eléctrico</option>
        <option value="4">Híbrido</option>
    </select><br><br>

    <label>Número de Motor:</label>
    <input type="text" name="numeroMotor" required><br><br>

    <label>Marca:</label>
    <input type="text" name="marca" required><br><br>

    <label>Modelo (año):</label>
    <input type="number" name="modelo" required><br><br>

    <label>ID del Conductor:</label>
    <input type="text" name="conductorID" required><br><br>

    <label>Tipo de Identificación del Conductor:</label>
    <select name="tipoIDConductor" required>
        <option value="1">CC</option>
        <option value="2">CE</option>
        <option value="3">NIT</option>
        <option value="4">Pasaporte</option>
    </select><br><br>

    <button type="submit">Guardar Vehículo</button>
</form>

<br>
<form action="menu-de-vehiculos" method="get">
    <button type="submit">Volver</button>
</form>
</body>
</html>

