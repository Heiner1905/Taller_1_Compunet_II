<%--
  Created by IntelliJ IDEA.
  User: heiner
  Date: 18/8/25
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar conductor</title>
</head>
<body>
<h2>Agregar un nuevo conductor</h2>

<form action="agregar-conductor" method="post">
    Nombre: <input type="text" name="nombre" required><br>
    Cargo:
    <select name="cargo">
        <option value="1">Supervisor</option>
        <option value="2">Conductor</option>
        <option value="3">Ayudante</option>
    </select><br>
    Tipo de identificación:
    <select name="tipoDeIdentificacion">
        <option value="1">CC</option>
        <option value="2">CE</option>
        <option value="3">NIT</option>
        <option value="4">Pasaporte</option>
    </select><br>
    Número de identificación: <input type="text" name="numeroDeIdentificacion" required><br>
    <button type="submit">Agregar</button>
</form>

</body>
</html>
