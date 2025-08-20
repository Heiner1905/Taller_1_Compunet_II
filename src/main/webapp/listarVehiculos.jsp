<%@ page import="java.util.List" %>
<%@ page import="model.Vehiculo" %><%--
  Created by IntelliJ IDEA.
  User: heiner
  Date: 19/8/25
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listar Vehiculos</title>
</head>
<body>
<h2>Lista de Vehiculos</h2>

<%
    List<Vehiculo> vehiculos = (List<model.Vehiculo>) request.getAttribute("vehiculos");
    for (int i = 0; i < vehiculos.size(); i++) {

%>
<h3>Vehiculo #<%=(i+1)%></h3>
<ul>
    <li>Placa: <%= vehiculos.get(i).getPlaca() %></li>
    <li>Marca: <%= vehiculos.get(i).getMarca() %></li>
    <li>Modelo: <%= vehiculos.get(i).getModelo() %></li>
    <li>Conductor: <%= vehiculos.get(i).getConductor().getNombre() %> - <%= vehiculos.get(i).getConductor().getNumeroDeIdentificacion() %></li>
</ul>
<%
    }
%>
<form action="menu-de-vehiculos" method="get">
    <button type="submit">Volver</button>
</form>
</body>
</html>



</body>
</html>
