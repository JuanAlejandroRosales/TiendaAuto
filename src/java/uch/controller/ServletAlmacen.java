package uch.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uch.dao.AlmacenDao;
import uch.dao.funcAyuda;
import uch.model.AlmacenBean;

@WebServlet(name = "ServletAlmacen", urlPatterns = {"/ServletAlmacenListarTodos", "/ServletAlmacenPaginar",
    "/ServletAlmacenVentanaNuevo", "/ServletAlmacenGrabarNuevo",
    "/ServletAlmacenVentanaModificar","/ServletAlmacenGrabarModificar"})
public class ServletAlmacen extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String path = request.getServletPath(); //(urlPatterns) Que patron URL se esta solicitando.
            if (path.equals("/ServletAlmacenListarTodos")) {
                listarTodos(request, response);
            } else if (path.equals("/ServletAlmacenPaginar")) {
                paginar(request, response);
            } else if (path.equals("/ServletAlmacenVentanaNuevo")) {
                ventanaNuevo(request, response);
            } else if (path.equals("/ServletAlmacenGrabarNuevo")) {
                grabarNuevo(request, response);
            } else if (path.equals("/ServletAlmacenVentanaModificar")) {
                ventanaModificar(request, response);
            }else if (path.equals("/ServletAlmacenGrabarModificar")) {
                grabarModificar(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    private void grabarModificar(HttpServletRequest request, HttpServletResponse response) {
        try {
            String strId = request.getParameter("txtIdAlmacen");
            String strCodigo = request.getParameter("txtCodigo");
            String strDescripcion = request.getParameter("txtDescripcion");
            AlmacenBean alm = new AlmacenBean();
            alm.setIdentificador(Integer.parseInt(strId));
            alm.setCodigo(strCodigo);
            alm.setDescripcion(strDescripcion);
            
            AlmacenDao dao = new AlmacenDao();
            boolean resultado = dao.Actualizar(alm);
            if (resultado) {
                request.setAttribute("error", "");
                paginar(request, response);
            } else {
                request.setAttribute("error", "El Almacen " + strDescripcion + " no se puede adicionar");
                ventanaNuevo(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            ventanaNuevo(request, response);
        }
    }

    private void ventanaModificar(HttpServletRequest request, HttpServletResponse response) {
        try {
            String strId = request.getParameter("id");
            AlmacenBean alm = new AlmacenBean();
            AlmacenDao dao = new AlmacenDao();
            alm = dao.buscar(Integer.parseInt(strId));
            request.setAttribute("objeto", alm);
            request.getRequestDispatcher("almacenModificar.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    private void grabarNuevo(HttpServletRequest request, HttpServletResponse response) {
        try {
            String strCodigo = request.getParameter("txtCodigo");
            String strDescripcion = request.getParameter("txtDescripcion");
            AlmacenBean alm = new AlmacenBean();
            alm.setCodigo(strCodigo);
            alm.setDescripcion(strDescripcion);
            AlmacenDao dao = new AlmacenDao();
            boolean resultado = dao.Insertar(alm);
            if (resultado) {
                request.setAttribute("error", "");
                paginar(request, response);
            } else {
                request.setAttribute("error", "El Almacen " + strDescripcion + " no se puede adicionar");
                ventanaNuevo(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            ventanaNuevo(request, response);
        }
    }

    private void ventanaNuevo(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("almacenNuevo.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) {
        try {
            AlmacenDao dao = new AlmacenDao();
            List<AlmacenBean> lista = new ArrayList<AlmacenBean>();
            lista = dao.listar();
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("almacenListado.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    private void paginar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //Variable para el acceso a la base de datos
            AlmacenDao dao = new AlmacenDao();

            //Obtenemos la pagina actual
            int paginaActual;
            String strPage = request.getParameter("paginaActual");
            paginaActual = (strPage == null) ? 1 : Integer.parseInt(strPage);

            //Obtenemos la primera pagina /Por defecto siempre va ser 1
            int paginaInicial;
            paginaInicial = 1;

            //Obtenemos la pagina previa, en base a la pagina actual
            int paginaPrevia;
            paginaPrevia = funcAyuda.ObtenerPaginaAnterior(paginaActual);

            //Obtenemos la cantidad Total de paginas desde la base de datos
            int paginaFinal;
            paginaFinal = dao.getCantPaginas(funcAyuda.getTamanoPagina());

            //Obtenemos la pagina posterior
            int paginaSiguiente;
            paginaSiguiente = funcAyuda.ObtenerPaginaSiguiente(paginaFinal, paginaActual);

            //Array de objetos Bean donde se almacenara los registros de la base de datos            
            List<AlmacenBean> lista = new ArrayList<AlmacenBean>();
            lista = dao.listar(paginaActual, funcAyuda.getTamanoPagina());
            request.setAttribute("paginaActual", paginaActual);
            request.setAttribute("paginaInicial", paginaInicial);
            request.setAttribute("paginaPrevius", paginaPrevia);
            request.setAttribute("paginaNext", paginaSiguiente);
            request.setAttribute("paginaFinal", paginaFinal);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("almacenListado.jsp").forward(request, response);
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
