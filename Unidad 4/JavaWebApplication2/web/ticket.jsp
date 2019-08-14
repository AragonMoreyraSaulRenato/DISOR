<%-- 
    Document   : ticket
    Created on : 5/05/2019, 03:54:06 PM
    Author     : drone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ticket.directiva.Directiva" %>
<% 
    Directiva d = new Directiva(); 
    HttpSession sesionActual = request.getSession(true);
    if(sesionActual == null){
        response.sendRedirect("index.jsp");
    }
    String origen = (String) sesionActual.getAttribute("origen");
    String destino = (String) sesionActual.getAttribute("destino");
    int adultos = Integer.parseInt((String) sesionActual.getAttribute("adultos"));
    int ninos = Integer.parseInt((String) sesionActual.getAttribute("ninos"));
    String fecha = (String) sesionActual.getAttribute("fecha");
    String hora = (String) sesionActual.getAttribute("hora");
    String compra = (String) sesionActual.getAttribute("nocompra");
    String user = (String) sesionActual.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tickets</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" id="bootstrap-css">
        <link href="css/main_ticket.css" rel="stylesheet" type="text/css">
    </head>
    <body>        
        <div class="contenedor">
        <%for (int i=0;i<(ninos + adultos);i++){%>
            <div class="ticket">
                <div class="stub">
                    <div class="top">
                        <span class="admit">
                            <%if(i>= adultos){%> NIÑO 
                            <%}else{ %>
                                ADULTO
                            <%}%></span>
                        <span class="line"></span>
                        <span class="num">
                            Compra <br><span> <%=compra %> </span>
                        </span>
                    </div>
                    <div class="number"><%=i+1%></div>
                        <div class="invite">
                            ASIENTO
                        </div>
                </div>
                <div class="check">
                    <div class="big">
                      De: <%=origen%> <br> A: <%=destino%>
                    </div>
                    <!--div class="number">#1</div-->
                    <div class="info">
                        <section>
                            <div class="title">Responsable</div>
                            <div><%=user%></div>
                        </section>
                        <section>
                            <div class="title">Fecha Salida</div>
                            <div><%=fecha%></div>
                        </section>
                        <section>
                            <div class="title">Hora Salida</div>
                            <div><%=hora%></div>
                        </section>
                    </div>
                </div>
            </div>
                    
        <% } %>  
        </div>
    </body>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.min.js"></script>
</html>




