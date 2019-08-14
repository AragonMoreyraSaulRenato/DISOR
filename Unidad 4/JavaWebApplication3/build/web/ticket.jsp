<%-- 
    Document   : ticket
    Created on : 5/05/2019, 03:54:06 PM
    Author     : drone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="ticket.directiva.Directiva" %>
<%@page import="java.util.Date" %>
<%@page import="ticket.directiva.Directiva" %>
<%@page import="java.text.ParseException;" %>

<%! boolean fech = true;%>
<%! 
    String fecha = "";
    String origen ="";
    String destino = "";
    String adultos = "";
    String ninos = "";
    String hora = "";
    String compra = "";
    String user = "";
%>
<% 
    Directiva d = new Directiva(); 
    HttpSession sesionActual = request.getSession(true);
    if(sesionActual == null){
        response.sendRedirect("index.jsp");
    }
    origen = (String)  request.getParameter("origen");
    destino = (String)  request.getParameter("destino");
    adultos = (String) request.getParameter("adultos");
    ninos = (String)  request.getParameter("ninos");
    fecha = (String)  request.getParameter("fecha");
    hora = (String)  request.getParameter("hora");
    compra = (String)  request.getParameter("nocompra");
    user = (String)  request.getParameter("user");
%>

<%!
    public void validarFecha(String fecha) throws ParseException{
        Directiva d = new Directiva();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(d.currentDate());
        Date date2 = sdf.parse(fecha);
        fech =  date1.before(date2) || date1.equals(date2);
    };
%>
<%
    if(!(!origen.equals("Salida de...") &&
           !destino.equals("Llegada a...") &&
           !hora.equals("Hora de salida...") &&
           Integer.parseInt(adultos) > 0 &&
           fech)){
            response.sendRedirect("index.jsp");
        }
    
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
        <%for (int i=0;i<(Integer.parseInt(ninos) + Integer.parseInt(adultos));i++){%>
            <div class="ticket">
                <div class="stub">
                    <div class="top">
                        <span class="admit">
                            <%if(i>= Integer.parseInt(adultos)){%> NIÑO 
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




