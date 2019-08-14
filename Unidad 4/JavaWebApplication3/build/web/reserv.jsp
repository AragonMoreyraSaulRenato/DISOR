<%-- 
    Document   : index
    Created on : 5/05/2019, 03:41:16 PM
    Author     : drone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ticket.directiva.Directiva" %>
<% Directiva d = new Directiva(); %>
<%
    HttpSession sesionActual = request.getSession(true);
    String user = (String) request.getParameter("user");
    String pass = (String) request.getParameter("pass");
    if(sesionActual == null || !user.equals("Saul") || !pass.equals("12345")){
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Rservacion</title>

        <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-grid.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-reboot.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/main_reserv.css" type="text/css"/>
        </head>
    <body>
        <form name="compra" action="ticket.jsp" method="post" class="form-group w-50"> 
            
            <div id="container" class="cabecera p-4">
                Reservacion JSP
            </div>
            <% 
                String today = d.currentDate();
                String nocompra = d.getNumberClient(); 
            %>
            <div id="container" class="info p-2">
                <div class="column  w-25">
                    <input  name="user" type="hidden" value="<%=user%>"/>
                    <label>Bienvenido: <%=user%></label>
                </div>
                <div class="column  w-25">
                    <label name="today" value="<%=today%>" >FECHA: <%=today%></label>
                </div>
                <div class="column  w-25">
                    <input  name="nocompra" type="hidden" value="<%=nocompra%>"/>
                    <label>NUMERO DE COMPRA: <%=nocompra%></label>
                </div>
            </div>
            
            <div id = "container" class="p-3">
                <div class="column  w-50">
                    <label>ORIGEN</label>
                    <select class="custom-select form-control" name="origen">
                        <option selected>Llegada a...</option>
                        <option value="Oaxaca">Oaxaca</option>
                        <option value="Puebla">Puebla</option>
                        <option value="CDMX">CDMX</option>
                        <option value="Queretaro">Queretaro</option>
                        <option value="Veracruz">Veracruz</option>
                        <option value="Sonora">Sonora</option>
                    </select>
                </div>

                <div class="column w-50">
                    <label>DESTINO</label>
                    <select class="custom-select form-control" name="destino">
                        <option selected>Llegada a...</option>
                        <option value="Oaxaca">Oaxaca</option>
                        <option value="Puebla">Puebla</option>
                        <option value="CDMX">CDMX</option>
                        <option value="Queretaro">Queretaro</option>
                        <option value="Veracruz">Veracruz</option>
                        <option value="Sonora">Sonora</option>
                    </select>
                </div>

            </div>

            <div id = "container" class="p-3">

                <div class="column w-25">
                    <label>ADULTOS</label>
                    <input class="form-control" name="adultos" value="0" type="number" min="0" max="10" id="example-number-input">
                </div>

                <div class="column w-25">
                    <label>NIÑOS</label>
                    <input class="form-control" name="ninos" value="0" type="number" min="0" max="10" id="example-number-input">
                </div>

                <div class="column w-25">
                    <label>FECHA</label>
                    <input class="form-control" name="fecha" type="date"  id="example-number-input" value="<%out.print(d.currentDate());%>">
                </div>

                <div class="column w-25">
                    <label>HORA</label>
                    <select class="custom-select form-control" name="hora">
                        <option selected>Hora de salida...</option>
                        <option value="06:00">06:00 HRS</option>
                        <option value="10:00">10:00 HRS</option>
                        <option value="14:00">14:00 HRS</option>
                        <option value="18:00">18:00 HRS</option>
                        <option value="20:00">20:00 HRS</option>
                    </select>
                </div>
            </div>
            <div id = "container" class="p-3">
                <div class="column w-25"></div>
                <div class="column w-25"></div>
                <div class="column w-25"></div>
                <div class="column w-25">
                    <input type ="submit" name ="comprar" value="Comprar" class="btn-light form-control"/>
                </div>
            </div>
        </form>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>