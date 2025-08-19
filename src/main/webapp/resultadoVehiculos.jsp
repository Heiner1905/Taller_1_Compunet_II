<%--
  Created by IntelliJ IDEA.
  User: heiner
  Date: 18/8/25
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Vehiculo" %>
<%@ page import="model.Conductor" %>
<html>
<head><title>Vehículos del Conductor</title></head>
<body>
<h2>Vehículos del Conductor</h2>

<%
    Conductor conductor = (Conductor) request.getAttribute("conductor");
    List<Vehiculo> vehiculos = (List<Vehiculo>) request.getAttribute("vehiculos");
%>

<p><strong>Nombre:</strong> <%= conductor.getNombre() %></p>
<p><strong>Identificación:</strong> <%= conductor.getNumeroDeIdentificacion() %></p>

<h3>Lista de Vehículos</h3>
<ul>
    <%
        if (vehiculos != null) {
            for (Vehiculo v : vehiculos) {
    %>
    <li><%= v.getPlaca() %> - <%= v.getMarca() %> - <%= v.getModelo() %></li>
    <%
        }
    } else {
    %>
    <li>No hay vehículos registrados para este conductor.</li>
    <%
        }
    %>
</ul>

<br>
<!-- Botón para volver al formulario -->
<form action="buscar-conductor" method="get">
    <button type="submit">Volver a buscar otro conductor</button>
</form>

<br>
<!-- Botón para volver al menú principal -->
<form action="index.jsp" method="get">
    <button type="submit">Volver al menú principal</button>
</form>
</body>
</html>
