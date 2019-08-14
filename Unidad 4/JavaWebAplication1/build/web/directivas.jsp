<%-- 
    Document   : directivas
    Created on : 4/05/2019, 08:40:59 PM
    Author     : drone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ejemplo.Ejemplo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Probando Directivas!</h1>
        <%
            Ejemplo eje = new Ejemplo();
            out.print(eje.mostrar());
        %>
    </body>
</html>
