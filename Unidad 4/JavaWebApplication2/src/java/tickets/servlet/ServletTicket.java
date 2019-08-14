/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickets.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;
import ticket.directiva.Directiva;

/**
 *
 * @author drone
 */
@WebServlet(name = "ticket", urlPatterns = {"/ticket"})
public class ServletTicket extends HttpServlet {
    
    String origen;
    String destino;
    String adultos;
    String ninos;
    String fecha;
    String hora;
    
    @Override
    public void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta)
        throws ServletException, IOException {
        respuesta.setContentType("text/html");
        try {
            origen = solicitud.getParameter("origen");
            destino = solicitud.getParameter("destino");
            adultos = solicitud.getParameter("adultos");
            ninos = solicitud.getParameter("ninos");
            fecha = solicitud.getParameter("fecha");
            hora = solicitud.getParameter("hora");
            String user = solicitud.getParameter("user");
            String compra = solicitud.getParameter("nocompra");
            
            if ( validar() ) {
                HttpSession sesionActual = solicitud.getSession(true);
                sesionActual.setAttribute("origen", origen);
                sesionActual.setAttribute("destino", destino);
                sesionActual.setAttribute("adultos", adultos);
                sesionActual.setAttribute("ninos", ninos);
                sesionActual.setAttribute("fecha", fecha);
                sesionActual.setAttribute("hora", hora);
                sesionActual.setAttribute("nocompra", compra);
                sesionActual.setAttribute("user", user);
                respuesta.sendRedirect("ticket.jsp");
            }
            else{
                respuesta.sendRedirect("reserv.jsp");
            } 
            
        }catch(HTTPException e){
            respuesta.sendRedirect("index.jsp");
        }
    }
    
    @Override
    public void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta)
        throws ServletException, IOException {
        doGet(solicitud,respuesta); 
    }
    
    public boolean validar(){
        try{
        if(!origen.equals("Salida de...") &&
           !destino.equals("Llegada a...") &&
           !hora.equals("Hora de salida...") &&
           Integer.parseInt(adultos) > 0 &&
           validarFecha()){
            return true;
        }
            
        }catch(ParseException e){
            return false;
        }
        return false;
    }
    
    public boolean validarFecha() throws ParseException{
        Directiva d = new Directiva();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(d.currentDate());
        Date date2 = sdf.parse(fecha);
        return date1.before(date2) || date1.equals(date2);
    }
}
