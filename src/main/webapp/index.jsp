<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Menu principal</title>
</head>
<body>
<h1><%= "Menu principal del almacén de automoviles" %>
</h1>
<br/>
<h3>Que desea hacer?</h3>
<a href="menu-de-conductores">Menu de conductores</a>
<br/>
<a href="menu-de-automoviles">Menu de automoviles</a>
</body>
</html>