package uch.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uch.dao.VendedorDao;
import uch.model.VendedorBean;
@WebServlet(name = "VendedorServlet", urlPatterns = {"/VendedorServletListado"})
public class VendedorServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Recuperar el alias que ha sido invocado
            String path = request.getServletPath();
            if (path.equals("/VendedorServletListado")){
                listarTodos(request,response);
            }            
        }
    }
    private void listarTodos(HttpServletRequest request, 
                             HttpServletResponse response) {
        try {
            VendedorDao dao = new VendedorDao();
            List<VendedorBean> lista = new ArrayList<VendedorBean>();            
            lista = dao.listar();
            
            
            
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("AutosListado.jsp").
                    forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
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
