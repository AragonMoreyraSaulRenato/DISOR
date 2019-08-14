<%-- 
    Document   : servletPrincipal
    Created on : 4/05/2019, 08:51:06 PM
    Author     : drone
--%>

<%@page import="jwapahorcado.directiva.Directiva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesionActual = request.getSession(true);
    String usuario = (String) request.getParameter("nombreUsuario");
    String intentos = (String) request.getParameter("intentos");
    String nivel = (String) request.getParameter("nivel");
    String tipo = (String) request.getParameter("tipo");
    String resp = "";
    try{
        if(usuario == null || usuario.equals("") ) {
            response.sendRedirect("index.jsp");
        }
        /*else{
            Directiva d = new Directiva();
            if(d.existUsuario(usuario)){
                resp = "<h1>Usuario existente "+usuario+"</h1>";
            }
            else{
                resp = "<h1>Se ha creado el usuario: "+usuario+"</h1>";
            }
        }*/
    }catch(Exception e){
        
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--Se muestra en el titulo de la pagina el nombre del usuario--%>
        <title>Bienvenido <%=usuario%> </title>
    </head>
    <body>
    <div align="center" width="350">
        <%
            out.println(resp);
        %>
        <table>
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
                            <input type="hidden" name="intentosa" value="<%=intentos%>"/>
                            <input type="hidden" name="usuario" value="<%=usuario%>"/>
                            <input type="hidden" name="nivel" value="<%=nivel%>"/>
                            <input type="hidden" name="tipo" value="<%=tipo%>"/>
                            <input type="submit" value="SI" />
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
        </div>
    </body>
</html> 
