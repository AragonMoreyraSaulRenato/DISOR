/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author drone
 */
@WebServlet(name = "Servlet1", urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta)
        throws ServletException, IOException {
    // Obtenemos un objeto Print Writer para enviar respuesta
        respuesta.setContentType("text/html");
        try {
            String nombreUsuario = solicitud.getParameter("nombreUsuario");
            String clave = solicitud.getParameter("clave");
            if (nombreUsuario.equals("saul") && clave.equals("12345")) {
                //se crea una variable de tipo session para guardar el nombre de usuario
                HttpSession sesionActual = solicitud.getSession(true);
                //se almacena el nombre de usuario en la variable de sesión
                sesionActual.setAttribute("nomUsuario", nombreUsuario);
                //se direcciona hacia paginaPrincipal.jsp
                respuesta.sendRedirect("servletPrincipal.jsp");
            }
            else{
                //se mantiene en la página actual, refrescándose.
                respuesta.sendRedirect("servletIndex.jsp");
            } 
        }catch(HTTPException e){
            System.err.println("Servlet1: Error");
        }
    }
    //permite procesar tanto la solicitud del usuario como la respuesta del servidor
    @Override
    public void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta)
        throws ServletException, IOException {
        doGet(solicitud,respuesta); 
    }
}
