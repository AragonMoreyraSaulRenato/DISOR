/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwapahorcado.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import jwapahorcado.controller.PalabraJpaController;
import jwapahorcado.controller.UsuarioJpaController;
import jwapahorcado.controller.exceptions.RollbackFailureException;
import jwapahorcado.directiva.Directiva;
import jwapahorcado.model.Palabra;
import jwapahorcado.model.Usuario;

/**
 *
 * @author drone
 */
@WebServlet(name = "Juego", urlPatterns = {"/Juego"})
public class Juego extends HttpServlet {
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @Resource
    private UserTransaction utx;
    
    String [] palabras;
    int intent = 0;
    String palabra = "";
    String palabraOculta = "";
    String abcedario = "";
    String pista = "";
    String usuario = "";
    
    public String [] getPalabas(int nivel, int tipo){
        System.out.println("N: "+nivel +"  T:"+tipo);
        emf = Persistence.createEntityManagerFactory("JavaWebApplicationAhorcadoDBPU");
        PalabraJpaController palabracontroller = new PalabraJpaController(utx, emf);
        List<Palabra> palabras = palabracontroller.findPalabraEntities();
        String [] pal = new String[palabras.size()];
        
        int cont = 0;
        for(int i=0; i<palabras.size(); i++){
            if(palabras.get(i).getTipo().getIdTipo() == tipo &&  palabras.get(i).getNivel() == nivel){
                pal[cont] = palabras.get(i).getPalabra();
                System.out.println("PALABRA: "+ pal[cont]);
                cont++;
            }
        }
        String [] pal2 = new String[cont];
        for(int i=0; i<cont; i++){
            pal2[i] = pal[i];
        }
        return pal2;
        
    }
    
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
            throws ServletException, IOException, RollbackFailureException, Exception {
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession sesionActual = request.getSession();
            String intentosA = request.getParameter("intentosa");
            String nivel = request.getParameter("nivel");
            String tipo = request.getParameter("tipo");
            
            Directiva d = new Directiva();
            
            if(intentosA != null){
                palabras = getPalabas(Integer.parseInt(nivel), Integer.parseInt(tipo));
                palabra = getRandowmWord().toUpperCase();
                palabraOculta = getSpaces(palabra.length());
                abcedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
                intent = Integer.parseInt(intentosA);
                usuario = request.getParameter("usuario");
                pista = d.getTipos().get(Integer.parseInt(tipo)-1).getDescripcion();
                
            }else{
                String letra = (String)request.getParameter("letra");
                System.err.println("LETRA: "+letra);
                abcedario = deleteFromABC(abcedario, letra);
                if(palabra.contains(letra)){
                    palabraOculta = replaceHiddenWord(palabra,palabraOculta,letra);
                }else{
                    intent--;
                }
            }
                
            System.out.println("PALABROTA "+palabra );
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
            out.println("<tr><th>Pista: "+pista+"</th></tr>");
            out.println("<tr><th class=\"espaciado\">"+palabraOculta+"</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");
            out.println("<tr><td>Selecciona una letra:</td></tr>");
           
            if(palabra.equals(palabraOculta)){
                sesionActual.invalidate();
                UsuarioJpaController usuarioscontroller = new UsuarioJpaController(utx,emf);
                Usuario u = usuarioscontroller.getUsuarioPorNombre(usuario);
                
                if(u != null){
                    u.setGanados(u.getGanados()+1);
                    u.setRacha(u.getGanados() - u.getPerdidos());
                    usuarioscontroller.edit(u);
                }
                else{
                    u = new Usuario();
                    u.setNombre(usuario);
                    u.setGanados(1);
                    u.setPerdidos(0);
                    u.setRacha(1);
                    usuarioscontroller.create(u);
                }
                
                out.println("<tr><td><h1>"+usuario+" haz ganado! :D</h1></td></tr>");
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
                UsuarioJpaController usuarioscontroller = new UsuarioJpaController(utx,emf);
                Usuario u = usuarioscontroller.getUsuarioPorNombre(usuario);
                if(u != null){
                    u.setPerdidos(u.getPerdidos()+1);
                    u.setRacha(u.getGanados() - u.getPerdidos());
                    usuarioscontroller.edit(u);
                }
                else{
                    u = new Usuario();
                    u.setNombre(usuario);
                    u.setGanados(1);
                    u.setPerdidos(0);
                    u.setRacha(1);
                    usuarioscontroller.create(u);
                
                }
                
                out.println("<tr><td><h1>"+usuario+" haz perdido! :c</h1></td></tr>");
                out.println("<tr><td><h1>La palabra era: "+palabra+"</h1></td></tr>");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
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
