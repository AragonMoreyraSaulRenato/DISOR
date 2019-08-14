<%-- 
    Document   : documentindex
    Created on : 3/05/2019, 09:36:19 AM
    Author     : drone
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%// Comentario en Java de una sola línea %> 
        <% /** Comentario en Java de varias líneas…. **/%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>Probando expresiones</h1>
        <h2>
            <li>La fecha y hora actual es: <%= new java.util.Date()%></li>
            <li>Fecha y Hora local: <%= new java.util.Date().toLocaleString() %></li>
            <li>La potencia de 16 es <%= Math.pow(16, 2)%></li>
            <li>La raíz cuadrada de 16 es <%= Math.sqrt(16)%></li>
        </h2>
    </body>
</html> 
