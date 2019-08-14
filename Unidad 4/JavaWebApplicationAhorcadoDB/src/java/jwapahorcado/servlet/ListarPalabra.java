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
import jwapahorcado.model.Palabra;

/**
 *
 * @author drone
 */
@WebServlet(name = "ListarPalabra", urlPatterns = {"/ListarPalabras", "/listarpalabras"})
public class ListarPalabra extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            emf = Persistence.createEntityManagerFactory("JavaWebApplicationAhorcadoDBPU");
            PalabraJpaController palabracontroller = new PalabraJpaController(utx, emf);
            List<Palabra> palabras = palabracontroller.findPalabraEntities();
            out.println("<html>\n" +
                    "    <head>\n" +
                    "        <link href=\"css/main.css\" rel=\"stylesheet\" type=\"text/css\">"+
                    "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                    "        <title>JSP Page</title>\n" +
                    "    </head>\n" +
                    "    <body>");
            out.println("       <a href=\"admin.jsp\">Inicio</a><br>");
            out.println("           <form>");
            out.println("               <h1>Lista de Palabras</h1>");
            out.println("               <table CELLPADING='20' BORDER='1'>");
            out.println("                   <tr>");
            out.println("                   <th>ID Palabra</th>");
            out.println("                   <th>Palabra</th>");
            out.println("                   <th>Tipo</th>");
            out.println("                   <th>Nivel</th>");
            out.println("                   </tr>");
            for(Palabra p : palabras){
            out.println("                   <tr>");
            out.println("                   <td>"+p.getIdPalabra()+"</td>");
            out.println("                   <td>"+p.getPalabra()+"</td>");
            out.println("                   <td>"+p.getTipo().getDescripcion()+"</td>");
            out.println("                   <td>"+p.getNivel()+"</td>");
            out.println("                    </tr>");
            }       
            out.println("               </table>");
            out.println("           </form>");
            out.println("    </body>\n" +
                        "</html>");
            emf.close();
            
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
