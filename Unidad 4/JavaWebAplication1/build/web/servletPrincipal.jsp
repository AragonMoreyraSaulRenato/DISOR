<%-- 
    Document   : servletPrincipal
    Created on : 4/05/2019, 08:51:06 PM
    Author     : drone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //se declara la variable sesionActual de tipo HttpSession
    HttpSession sesionActual = request.getSession(true);
    //se carga en sessionActual la variable de sesión nomUsuario
    String usuario = (String) request.getParameter("nomUsuario");
    String pass = (String) request.getParameter("pass");
    if(usuario == null && (!usuario.equals("Saul") || !pass.equasl("12345"))) {
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
        <h4>Bienvenido: <%=usuario%></h4>
        <% //Se Se crea un menú mendiante una lista de elementos%>
        <div id="menu">
            <% 
                //en el # de href ponemos el nombre 
                //de una pagina JSP creada y que
                //contenga la funcionalidad requerida
            %>
            <ul>
            <li><a href="#">Mantenimiento</a></li> 
            <li><a href="#">Consultas</a></li> 
            <li><a href="#">Informes</a></li> 
            <li><a href="#">Acerca de...</a></li> 
            </ul>
        </div>
    </body>
</html> 
