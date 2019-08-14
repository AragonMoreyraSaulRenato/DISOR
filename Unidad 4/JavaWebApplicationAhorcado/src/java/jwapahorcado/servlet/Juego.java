/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwapahorcado.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author drone
 */
@WebServlet(name = "Juego", urlPatterns = {"/Juego"})
public class Juego extends HttpServlet {
    String [] palabras = {"MUNDO","TECNOLOGICO","ESCUELA","COMPUTADORA","SALONES","CAMION","PERRITO"};
    int intent = 0;
    String palabra = "";
    String palabraOculta = "";
    String abcedario = "";
    
    public String getRandowmWord(){
        return palabras[new Random().nextInt(palabras.length)];
    }
    
    public String getSpaces(int s){
        String acum = "";
        for(int i=0; i<s; i++)
            acum += "_";
        
        return acum;
    }
    
    public String deleteFromABC(String abc, String letra){
        String acum = "";
        for(int i=0; i<abc.length(); i++){
            if(letra.charAt(0) != abc.charAt(i)){
                acum += abc.charAt(i) +"";
            }
        }
        System.out.println(acum);
        return acum;
    }
    
    private String replaceHiddenWord(String palabra, String palabraOculta, String letra) {
        String acum = "";
        for(int i=0; i<palabra.length(); i++){
            if(palabra.charAt(i) == letra.charAt(0)){
                acum += letra;
            }
            else{
                acum += palabraOculta.charAt(i)+"";
            }
        }
        return acum;
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //String letrasAcum = "";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesionActual = request.getSession();
            String intentosA = request.getParameter("intentosa");
            
            if(intentosA != null){
                palabra = getRandowmWord();
                palabraOculta = getSpaces(palabra.length());
                abcedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
                intent = Integer.parseInt(intentosA);                
            }else{
                String letra = (String)request.getParameter("letra");
                abcedario = deleteFromABC(abcedario, letra);
                if(palabra.contains(letra)){
                    palabraOculta = replaceHiddenWord(palabra,palabraOculta,letra);
                }else{
                    intent--;
                }
            }
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Juego</title>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<link href=\"css/main.css\" rel=\"stylesheet\" id=\"bootstrap-css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<table class=\"tabla\" align=\"center\" width=\"450\">");
            out.println("<thead>");
            out.println("<tr><th class=\"espaciado\">"+palabraOculta+"</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<tr><td>Selecciona una letra:</td></tr>");
           
            if(palabra.equals(palabraOculta)){
                sesionActual.invalidate();
                out.println("<tr><td><h1>HAZ GANADO! :D</h1></td></tr>");
                out.println("<tr><td>");
                out.println("<form action=\"index.jsp\">");
                out.println("<input type=\"submit\" value=\"INICIO\" />");
                out.println("</form>");
                out.println("</td></tr>");
            }
            else if(intent > 0){
                out.println("<tr>");
                out.println("<td>");
                for(int i=0; i<abcedario.length(); i++){
                    out.println("<a href=\"Juego?letra="+abcedario.charAt(i)+"\">"+abcedario.charAt(i)+"</a>");
                }
                out.println("</td>");
                out.println("</tr>");
            }else if(intent == 0){
                sesionActual.invalidate();
                out.println("<tr><td><h1>HAZ PERDIDO! :c</h1></td></tr>");
                out.println("<tr><td>");
                out.println("<form action=\"./index.jsp\">");
                out.println("<input type=\"submit\" value=\"SALIR\" />");
                out.println("</form>");
                out.println("</td></tr>");
            }
            out.println("<tr><td>Intentos Restantes: "+intent+"</td></tr>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   

}
