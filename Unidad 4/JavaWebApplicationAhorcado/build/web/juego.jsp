<%-- 
    Document   : juego
    Created on : 7/05/2019, 10:31:07 PM
    Author     : drone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String url = "./Juego?letra="; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" id="bootstrap-css">
        <title>JSP Page</title>
    </head>
    <body>
            <table class="tabla" align="center" width="350">
                <thead>
                    <tr><th class="espaciado">_____________</th></tr>
                </thead>
                <tbody>
                    <tr><td>Selecciona una letra:</td></tr>
                    <tr>
                        <td>
                            <a href="<%=url%>A">A</a>
                            <a href="<%=url%>B">B</a>
                            <a href="<%=url%>C">C</a>
                        </td>
                    </tr>
                    <tr><td>Numero de Intentos</td></tr>
                </tbody>
            </table>
    </body>
</html>
