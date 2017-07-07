package uch.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uch.dao.UsuarioDao;

@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String path = request.getServletPath(); //(urlPatterns) Que patron URL se esta solicitando.
            if (path.equals("/ServletLogin")) {
                login(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        try {
            String strUsuario = request.getParameter("txtusuario");
            String strPassword = request.getParameter("txtpassword");
            UsuarioDao dao = new UsuarioDao();
            String resultado = dao.login(strUsuario, strPassword);
            HttpSession sessionOk = request.getSession();
            if((resultado=="validado") && (sessionOk.getAttribute("usuario") == null)){
                sessionOk.setAttribute("strUsuario", strUsuario);
                request.getRequestDispatcher("jsp/main3.jsp").forward(request, response);
            }else if(resultado=="novalidado"){
                ventanaIndex(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        
    } 
    
  private void ventanaIndex(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
