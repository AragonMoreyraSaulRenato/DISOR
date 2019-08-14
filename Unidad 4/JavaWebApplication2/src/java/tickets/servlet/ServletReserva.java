/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.servlet;

import java.io.IOException;
import static java.lang.System.out;
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
@WebServlet(name = "reservacion", urlPatterns = {"/reservacion"})
public class ServletReserva extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta)
            throws ServletException, IOException {
        respuesta.setContentType("text/html");
        try {
            String user = solicitud.getParameter("user");
            String pass = solicitud.getParameter("pass");
            
            if ( "Saul21".equals(user) && "12345".equals(pass)) {
                HttpSession sesionActual = solicitud.getSession(true);
                sesionActual.setAttribute("user", user);
                respuesta.sendRedirect("reserv.jsp");
            }
            else{
                respuesta.sendRedirect("index.jsp");
            } 
            
        }catch(HTTPException e){
            out.print("Servlet1: Error");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
}
