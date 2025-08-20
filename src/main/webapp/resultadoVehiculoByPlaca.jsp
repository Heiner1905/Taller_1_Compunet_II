<%--
  Created by IntelliJ IDEA.
  User: heiner
  Date: 19/8/25
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Vehiculo" %>
<html>
<head>
    <title>Resultado de búsqueda</title>
</head>
<body>
<%
    Vehiculo vehiculo = (Vehiculo) request.getAttribute("vehiculo");
    if (vehiculo != null) {
%>
<h2>Vehículo encontrado</h2>
<p><b>Placa:</b> <%= vehiculo.getPlaca() %></p>
<p><b>Marca:</b> <%= vehiculo.getMarca() %></p>
<p><b>Modelo:</b> <%= vehiculo.getModelo() %></p>
<p><b>Cilindraje:</b> <%= vehiculo.getCilindraje() %></p>
<p><b>Tipo de Combustible:</b> <%= vehiculo.getTipoDeCombustible() %></p>
<p><b>Conductor:</b> <%= vehiculo.getConductor().getNombre() %></p>
<%
    }
%>
<br>
<form action="menu-de-vehiculos" method="get">
    <button type="submit">Volver</button>
</form>
</body>
</html>
