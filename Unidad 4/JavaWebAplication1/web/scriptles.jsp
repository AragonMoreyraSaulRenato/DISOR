<%-- 
    Document   : scriptles
    Created on : 4/05/2019, 06:07:44 PM
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
        <h1> Probando Scriptlet en JSP</h1>
        <h2>
        <%
            String colores[]={"orange","red","blue","green","black"};
            int j = 5;
            int vector[]= new int[5];
            for (int i=0;i<j;i++){
            vector[i]=i;
        %> 
            <font color=<%=colores[i]%>size="<%=5%>">
                <i><%=vector[i]%></i>
            </font>
            <br>
            <%}%>
        </h2>
    </body>
</html> 