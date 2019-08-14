/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwapahorcado.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.transaction.UserTransaction;
import jwapahorcado.controller.PalabraJpaController;
import jwapahorcado.controller.exceptions.RollbackFailureException;
import jwapahorcado.model.Palabra;
import jwapahorcado.model.Tipo;
/**
 *
 * @author drone
 */
@WebServlet(name = "EliminarEditarPalabra", urlPatterns = {"/EliminarEditarPalabra", "/eliminareditarpalabra"})
public class EliminarEditarPalabra extends HttpServlet {

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
            throws ServletException, IOException, RollbackFailureException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            emf = Persistence.createEntityManagerFactory("JavaWebApplicationAhorcadoDBPU");
            PalabraJpaController palabracontroller = new PalabraJpaController(utx, emf);
            
            String action = request.getParameter("action");
            int idpalabra = Integer.parseInt(request.getParameter("idpalabra"));
            
            if(action.equals("ELIMINAR")){
                palabracontroller.destroy(idpalabra);
                response.sendRedirect("listarpalabra.jsp");
            }
            else{
                Palabra palabra = palabracontroller.findPalabra(idpalabra);
                if(palabra != null){
                    String pal = request.getParameter("palabra");
                    int nivel = Integer.parseInt(request.getParameter("nivel"));
                    int tipo = Integer.parseInt(request.getParameter("tipo"));
                    palabra.setPalabra(pal);
                    palabra.setNivel(nivel);
                    palabra.setTipo(new Tipo(tipo));
                    palabracontroller.edit(palabra);
                }
                response.sendRedirect("listarpalabra.jsp");
            }
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
            Logger.getLogger(EliminarEditarPalabra.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EliminarEditarPalabra.class.getName()).log(Level.SEVERE, null, ex);
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
