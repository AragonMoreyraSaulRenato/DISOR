<%-- 
    Document   : agregarpalabra
    Created on : 11/05/2019, 06:23:54 PM
    Author     : drone
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jwapahorcado.directiva.Directiva" %>
<%@page import="java.util.List"%>
<%@page import="jwapahorcado.model.Tipo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="admin.jsp">Inicio</a><br>
        <%
            Directiva d = new Directiva();
            List<Tipo> tipos = d.getTipos();
            String [] nivel = d.getDificultad();
        %>
        <form align="center" action="agregarpalabra" method="POST">
            <h1>Agrega una palabra!</h1>
            <input type="text" name="palabra" placeholder="Palabra"><br>
            <select name="tipo">
                <%
                for(Tipo t : tipos){
                    out.println("<option value=\""+t.getIdTipo()+"\">"+t.getDescripcion()+"</option>");
                }
                %>
            </select> <br>
            <select name="nivel">
                <%
                for(int i=0; i<nivel.length; i++){
                    out.println("<option value=\""+(i+1)+"\">"+nivel[i]+"</option>");
                }
                %>
            </select> <br>
            <input type="submit" value="Agregar"><br>
        </form>
    </body>
</html>
