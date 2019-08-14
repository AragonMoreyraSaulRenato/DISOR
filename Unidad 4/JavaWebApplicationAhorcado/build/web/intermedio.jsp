<%-- 
    Document   : servletPrincipal
    Created on : 4/05/2019, 08:51:06 PM
    Author     : drone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesionActual = request.getSession(true);
    String usuario = (String) request.getParameter("nombreUsuario");
    String intentos = (String) request.getParameter("intentos");
    if(usuario == null && !usuario.equals("") || usuario==null ) {
        response.sendRedirect("servletIndex.jsp");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--Se muestra en el titulo de la pagina el nombre del usuario--%>
        <title>Bienvenido <%=usuario%> </title>
    </head>
    <body>
        
        <table align="center" width="350">
            <thead>
                <tr>
                    <th><h4>Bienvenido: <%=usuario%></h4></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Quieres iniciar el juego?:</td>
                    <td>
                        <form action="Juego" method="POST">
                            <input type="submit" value="SI" />
                            <input type="hidden" name="intentosa" value="<%=intentos%>"/>
                            <input type="hidden" name="usuario" value="<%=usuario%>"/>
                        </form>
                    </td>
                    <td>
                        <form action="index.jsp">
                            <input type="submit" value="NO" />
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html> 
