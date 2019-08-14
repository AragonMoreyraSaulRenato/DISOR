<%-- 
    Document   : servelet
    Created on : 4/05/2019, 08:44:57 PM
    Author     : drone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <td>
                        <input type ="submit" value="Aceptar"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
</body> 
</html>
