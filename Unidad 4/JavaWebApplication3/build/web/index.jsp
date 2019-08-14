<%-- 
    Document   : login
    Created on : 6/05/2019, 01:33:54 PM
    Author     : drone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ticket.directiva.Directiva" %>
<% Directiva d = new Directiva(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de sesión</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="css/main_login.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <form name="reserv" action="reserv.jsp" method="post">
        <div class="container">
            <div class="row login_box">
                <div class="col-md-12 col-xs-12" align="center">
                    <div class="line text"><h3><%out.println(d.currentTime());%></h3></div>
                    <div class="outter"><img src="img/user.png" class="image-circle"/></div>   
                    <h1 class="text">Bienvenido JSP</h1>
                </div>
                <div class="col-md-12 col-xs-12 follow line" align="center">
                    <h3 class="text"> <% d.VISITAS++; %>
                         <% out.print(d.VISITAS); %> <br/> <span>VISITAS</span>
                    </h3>
                </div>

                <div class="col-md-12 col-xs-12 login_control">

                    <div class="control">
                        <div class="label">Usuario</div>
                        <input name="user" type="text" class="form-control" placeholder="usuario_1"/>
                    </div>

                    <div class="control">
                         <div class="label">Contraseña</div>
                        <input name="pass" type="password" class="form-control" placeholder="*******"/>
                    </div>
                    <div align="center">
                            <input class="btn-orange form-control" type ="submit" name ="comprar" value="Ingresar" />
                    </div>
                </div>
            </div>
        </div>
        </form>
    </body>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.min.js"></script>
</html>