<%-- 
    Document   : agregartipo
    Created on : 11/05/2019, 06:32:56 PM
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
         <form action="agregartipo" method="POST">
            <h1>Agrega un tipo!</h1>
            <input type="text" name="tipo" placeholder="Tipo"><br>
            <input type="submit" value="Agregar">
        </form>
    </body>
</html>
