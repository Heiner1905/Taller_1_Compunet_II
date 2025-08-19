<%@ page import="model.Conductor" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: heiner
  Date: 18/8/25
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de conductores</title>
</head>
<body>
<h2>Lista de Conductores con sus Vehículos</h2>

<%
    List<model.Conductor> conductores = (List<model.Conductor>) request.getAttribute("conductores");
    for (model.Conductor c : conductores) {
%>
<h3><%= c.getNombre() %> - <%= c.getNumeroDeIdentificacion() %></h3>
<ul>
    <%
        for (model.Vehiculo v : c.getVehiculos()) {
    %>
    <li>
        Placa: <%= v.getPlaca() %>,
        Marca: <%= v.getMarca() %>,
        Modelo: <%= v.getModelo() %>
    </li>
    <%
        }
    %>
</ul>
<%
    }
%>


</body>
</html>
