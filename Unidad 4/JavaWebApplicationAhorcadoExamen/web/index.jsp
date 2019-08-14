<%-- 
    Document   : servelet
    Created on : 4/05/2019, 08:44:57 PM
    Author     : drone
--%>

<%@page import="jwapahorcado.model.Jugadas"%>
<%@page import="java.util.List"%>
<%@page import="jwapahorcado.model.Tipo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jwapahorcado.directiva.Directiva" %>
<%
    Directiva d = new Directiva();
    String [] nivel = d.getDificultad();
    List<Tipo> tipos = d.getTipos();
    List<Jugadas> usuarios = d.getUsuariosDesc();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="autenticacion" action="intermedio.jsp" method="post"> 
            <table align="center" width="350">
                <thead>
                    <tr>
                        <th colspan="2">Acceso</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Usuario:</td>
                        <td> 
                            <input type="text" name="nombreUsuario" value=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>Intentos:</td>
                        <td>
                            <input type="number" name="intentos" value="5" max="15" min="5"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Dificultad:</td>
                        <td>
                            <select name="nivel">

                                <%for(int i=0; i<nivel.length; i++){
                                    out.println("                   <option value=\""+(i+1)+"\">"+nivel[i]+"</option>");
                                }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Tipo:</td>
                        <td>
                            <select name="tipo">
                                <%for(int i=0; i<tipos.size(); i++){
                                    out.println("                   <option value=\""+tipos.get(i).getIdTipo()+"\">"+tipos.get(i).getDescripcion()+"</option>");
                                }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type ="submit" value="Aceptar"/>
                        </td>
                    </tr>
                    
                </tbody>
            </table>     
        </form>
        <br><br>
        <div align="center" width="350">
            <h3>MEJORES RACHAS</h3>
        <table cellpadding='5' border='1'>
            <thead>
                <th>Nombre</th>
                <th>Palabra</th>
                <th>Gano</th>
            </thead>
            <tbody>
                <% for(int i=0; i<usuarios.size(); i++){%>
                    <tr>
                        <td><%out.print(usuarios.get(i).getJugador());%></td>
                        <td><%out.print(usuarios.get(i).getPalabra().getPalabra());%></td>
                        <td><%out.print(usuarios.get(i).getGano());%></td>
                    </tr>
                <%}%>
            </tbody>
        </table>
            <br><br>
         <a href ="admin.jsp">Administrador</a>
        </div>
    </body> 
</html>
