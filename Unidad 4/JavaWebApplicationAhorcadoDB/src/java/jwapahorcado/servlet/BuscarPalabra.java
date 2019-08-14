/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwapahorcado.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import jwapahorcado.controller.PalabraJpaController;
import jwapahorcado.directiva.Directiva;
import jwapahorcado.model.Palabra;
import jwapahorcado.model.Tipo;

/**
 *
 * @author drone
 */
@WebServlet(name = "BuscarPalabra", urlPatterns = {"/BuscarPalabra", "/buscarpalabra"})
public class BuscarPalabra extends HttpServlet {

    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @Resource
    private UserTransaction utx;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            emf = Persistence.createEntityManagerFactory("JavaWebApplicationAhorcadoDBPU");
            PalabraJpaController palabracontroller = new PalabraJpaController(utx, emf);
            int id = Integer.parseInt(request.getParameter("id"));
            Palabra p = palabracontroller.findPalabra(id);
            Directiva d = new Directiva();
            String [] level = d.getDificultad();
            List<Tipo> tipos = d.getTipos();
            
            out.println(
            "<html>\n" +
            "    <head>\n" +
            "        <link href=\"css/main.css\" rel=\"stylesheet\" type=\"text/css\">"+
            "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
            "        <title>JSP Page</title>\n" +
            "    </head>\n" +
            "    <body>\n" +
            "        <a href=\"admin.jsp\">Inicio</a><br>\n" +
            "        <form action=\"eliminareditarpalabra\" method=\"POST\">\n" +
             "        <h1>Eliminar o Editar</h1>\n");
            
            out.println(
            "            <label>ID Palabra: </label><input type=\"text\" name=\"idpalabra\" value=\""+p.getIdPalabra()+"\" readonly><br>\n" +
            "            <label>Palabra: </label><input type=\"text\" name=\"palabra\" value=\""+p.getPalabra()+"\"><br>\n");
            
            
            out.println(
            "            <label>Nivel: </label><select name=\"nivel\">\n"); 
            
            for(int i=0; i<level.length; i++){
                if((i+1) != p.getNivel()){
                    out.println("               <option value=\""+(i+1)+"\">"+level[i]+"</option>\n"); 
                }else{
                    out.println("               <option selected=\"selected\" value=\""+(i+1)+"\">"+level[i]+"</option>\n");
                }
            }
            out.println(
            "            </select><br>\n");
            
            
            out.println(
            "            <label>Tipo: </label><select name=\"tipo\">\n"); 
            
            for(int i=0; i<tipos.size(); i++){
                if(p.getTipo().getIdTipo() != tipos.get(i).getIdTipo()){
                    out.println("               <option value=\""+tipos.get(i).getIdTipo()+"\">"+tipos.get(i).getDescripcion()+"</option>\n"); 
                }else{
                    out.println("               <option value=\""+tipos.get(i).getIdTipo()+"\" selected = \"selected\">"+tipos.get(i).getDescripcion()+"</option>\n");
                }
            }
            out.println(
            "            </select><br>\n");
            
            
            out.println(
            "            <input type=\"submit\" name=\"action\" value=\"ELIMINAR\">\n" +
            "            <input type=\"submit\" name=\"action\" value=\"EDITAR\">\n" +
            "        </form>\n" +
            "    </body>\n" +
            "</html>");
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
