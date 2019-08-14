<%-- 
    Document   : buscarpalabra
    Created on : 11/05/2019, 06:15:45 PM
    Author     : drone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="admin.jsp">Inicio</a><br>
        <form action="buscarpalabra" method="POST">
            <h1>Busca una palabra!</h1>
            <input type="number" name="id" placeholder="ID Palabra">
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>