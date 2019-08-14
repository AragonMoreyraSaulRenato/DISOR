<%-- 
    Document   : usovaribales
    Created on : 4/05/2019, 05:59:04 PM
    Author     : drone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%// Declaraciones en JSP %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP / NetBeans</title>
    </head>
    <body>
        <h1> Probando declaraciones en JSP</h1>
        <h2>
            <%! double x=4;%>
            <%! double y=2;%>
            <%! 
                public double Potencia(double x,double y){
                    return Math.pow(x, y);
                };
            %>
            <%! 
                public double Raiz(double x){ 
                    return Math.sqrt(x);
                };
            %>
            <li>Potencia de <%=x%> elevado a <%=y%> es : <%=Potencia(x,y)%></li>
            <li>Raíz Cuadrada del número <%=x%> es: <%=Raiz(x)%></li>
        </h2>
    </body>
</html>