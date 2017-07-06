package uch.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import uch.dao.AutoDao;
import uch.dao.funcAyuda;
import uch.model.AutoBean;

@WebServlet(name = "ServletAuto", urlPatterns = {"/ServletAutoListarTodos", "/ServletAutoPaginar",
    "/ServletAutoVentanaNuevo", "/ServletAutoGrabarNuevo",
    "/ServletAutoVentanaModificar","/ServletAutoGrabarModificar","/ServletAutoPaginardll",
    "/ServletAutoEliminar","/ServletAutoHome"})
@MultipartConfig
public class ServletAuto extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String path = request.getServletPath(); //(urlPatterns) Que patron URL se esta solicitando.
            if (path.equals("/ServletAutoListarTodos")) {
                listarTodos(request, response);
            } else if (path.equals("/ServletAutoPaginar")) {
                paginar(request, response);
            } else if (path.equals("/ServletAutoPaginardll")) {
                paginardll(request, response);
            }else if (path.equals("/ServletAutoVentanaNuevo")) {
                ventanaNuevo(request, response);
            } else if (path.equals("/ServletAutoGrabarNuevo")) {
                grabarNuevo(request, response);
            } else if (path.equals("/ServletAutoVentanaModificar")) {
                ventanaModificar(request, response);
            }else if (path.equals("/ServletAutoGrabarModificar")) {
                grabarModificar(request, response);
            } else if (path.equals("/ServletAutoEliminar")) {
                Eliminar(request, response);
            } else if (path.equals("/ServletAutoHome")) {
                ventanaHome(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    private void grabarModificar(HttpServletRequest request, HttpServletResponse response) {
        try {
            validar(request, response);
            String strCodigo = request.getParameter("txtCodigoh");
            String strMarca = request.getParameter("ddlMarca");
            String strModelo = request.getParameter("txtModelo");
            String strColor = request.getParameter("txtColor");
            String strPrecio = request.getParameter("txtPrecio");
            String strStock = request.getParameter("txtStock");
            AutoBean auto = new AutoBean();
            auto.setCodigo(strCodigo);
            auto.setMarca(strMarca);
            auto.setModelo(strModelo);
            auto.setColor(strColor);
            auto.setPrecio(Double.parseDouble(strPrecio));
            auto.setStock(Integer.parseInt(strStock));
            AutoDao dao = new AutoDao();
            boolean resultado = dao.Actualizar(auto);
            if (resultado) {
                request.setAttribute("error", "");
                subirarchivo(request, response, strCodigo);
                paginar(request, response);
            } else {
                request.setAttribute("error", "El Auto " + strColor + " no se puede adicionar");
                ventanaModificar(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            ventanaModificar(request, response);
        }
    }

    private void ventanaModificar(HttpServletRequest request, HttpServletResponse response) {
        try {
            validar(request, response);
            String strId = request.getParameter("id");
            AutoBean auto = new AutoBean();
            AutoDao dao = new AutoDao();
            auto = dao.buscar(strId);
            request.setAttribute("objeto", auto);
            ServletMarca ServletMarca = new ServletMarca();
            ServletMarca.listarTodosdll(request, response);
            request.getRequestDispatcher("/jsp/AutosModificar.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }
    
    private void Eliminar(HttpServletRequest request, HttpServletResponse response) {
        try {
            validar(request, response);
            String strId = request.getParameter("id");
            AutoBean auto = new AutoBean();
            auto.setCodigo(strId);
            AutoDao dao = new AutoDao();
            boolean resultado = dao.Eliminar(auto);
            if (resultado) {
                request.setAttribute("error", "");
                paginar(request, response);
            } else {
                request.setAttribute("error", "El Auto " + strId + " no se puede eliminar");
                paginar(request, response);
            }
            request.getRequestDispatcher("/jsp/AutosListado.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    private void grabarNuevo(HttpServletRequest request, HttpServletResponse response) {
        try {
            validar(request, response);
            Calendar c = Calendar.getInstance();
            AutoDao dao = new AutoDao();
            String codigo = null;
            codigo = dao.generarcodigo();
            String strCodigo = codigo.toString();
            String strMarca = request.getParameter("ddlMarca");
            String strModelo = request.getParameter("txtModelo");
            String strColor = request.getParameter("txtColor");
            String strPrecio = request.getParameter("txtPrecio");
            String strStock = request.getParameter("txtStock");
            String strEstado = "A";
            String strFecha_Registro = Integer.toString(c.get(Calendar.DATE))+"/"+
                                       Integer.toString(c.get(Calendar.MONTH)+1)+"/"+
                                       Integer.toString(c.get(Calendar.YEAR));
            AutoBean auto = new AutoBean();
            auto.setCodigo(strCodigo);
            auto.setMarca(strMarca);
            auto.setModelo(strModelo);
            auto.setColor(strColor);
            auto.setPrecio(Double.parseDouble(strPrecio));
            auto.setStock(Integer.parseInt(strStock));
            auto.setEstado(strEstado);
            auto.setFecha_registro(strFecha_Registro);
            
            boolean resultado = dao.Insertar(auto);
            if (resultado) {
                request.setAttribute("error", "");
                subirarchivo(request, response, strCodigo);
                paginar(request, response);
                
            } else {
                request.setAttribute("error", "El Auto " + strCodigo + " no se puede adicionar");
               
                ventanaNuevo(request, response);
                
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            ventanaNuevo(request, response);
        }
        
    }
    
    private void subirarchivo(HttpServletRequest request, HttpServletResponse response, String codigo) {
        try {
            Part filePart = request.getPart("foto"); // Obtiene el archivo
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            String extension = fileName.substring(fileName.length()-4,fileName.length());    
            if(!fileName.isEmpty()){
                String path="E:\\PROYECTO NUEVO\\PROYECTO NUEVO\\webISIII\\web\\fotos";
                File uploads = new File(path); //Carpeta donde se guardan los archivos
                uploads.mkdirs(); //Crea los directorios necesarios
                //File file = File.createTempFile("COD"+"_"+codigo+"_","_"+fileName, uploads); //Evita que hayan dos archivos con el mismo nombre
                File file = new File(uploads, "COD"+"_"+codigo+extension);

                try (
                    InputStream input = filePart.getInputStream()){
                    Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }catch (Exception e) {
                request.setAttribute("error", e.getMessage());
                }
            }

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }    

    private void ventanaNuevo(HttpServletRequest request, HttpServletResponse response) {
        try {
            validar(request, response);
            request.getRequestDispatcher("/jsp/AutosNuevo.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }
    
    private void ventanaHome(HttpServletRequest request, HttpServletResponse response) {
        try {
            validar(request, response);
            request.getRequestDispatcher("/jsp/main3.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }
    
    private void validar(HttpServletRequest request, HttpServletResponse response) {
        try {
            String strUsuario = "";
            HttpSession sesionOk = request.getSession();

            if (sesionOk.isNew())
            {
                request.getRequestDispatcher("../index.jsp").forward(request, response);
                return;
            }
    
            if (sesionOk == null)
            {
                request.getRequestDispatcher("../index.jsp").forward(request, response);
                // response.sendRedirect("login.jsp");
            }
            else
            {
                if (sesionOk.getAttribute("strUsuario") == null)
                {
                    request.getRequestDispatcher("./index.jsp").forward(request, response);
                    //response.sendRedirect("login.jsp");
                }else {
                    strUsuario = (String)sesionOk.getAttribute("strUsuario");
                }
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }    

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) {
        try {
            validar(request, response);
            AutoDao dao = new AutoDao();
            List<AutoBean> lista = new ArrayList<AutoBean>();
            lista = dao.listar();
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/jsp/AutosListado.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }
    
    private void paginar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            validar(request, response);
            //Variable para el acceso a la base de datos
            AutoDao dao = new AutoDao();

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
            List<AutoBean> lista = new ArrayList<AutoBean>();
            lista = dao.listar(paginaActual, funcAyuda.getTamanoPagina());
            request.setAttribute("paginaActual", paginaActual);
            request.setAttribute("paginaInicial", paginaInicial);
            request.setAttribute("paginaPrevius", paginaPrevia);
            request.setAttribute("paginaNext", paginaSiguiente);
            request.setAttribute("paginaFinal", paginaFinal);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/jsp/AutosListado.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }
    
    private void paginardll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            validar(request, response);
            //Variable para el acceso a la base de datos
            AutoDao dao = new AutoDao();

            //Obtenemos la pagina actual
            int paginaActual;
            String strPage = request.getParameter("paginaActual");
            paginaActual = (strPage == null) ? 1 : Integer.parseInt(strPage);
            
            int CantReg;
            String strCantReg = request.getParameter("CantReg");
            CantReg = Integer.parseInt(strCantReg);
            
            String value=null;
            if (CantReg==10) {
               value="./ServletAutoPaginardll?CantReg=10";  
            }else if (CantReg==20) {
               value="./ServletAutoPaginardll?CantReg=20";
            }else if (CantReg==30) {
               value="./ServletAutoPaginardll?CantReg=30";
            }else if (CantReg==40) {
               value="./ServletAutoPaginardll?CantReg=40";
            }else if (CantReg==50) {
               value="./ServletAutoPaginardll?CantReg=50";
            }   
            
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
            List<AutoBean> lista = new ArrayList<AutoBean>();
            lista = dao.listar(CantReg);
            request.setAttribute("paginaActual", paginaActual);
            request.setAttribute("paginaInicial", paginaInicial);
            request.setAttribute("paginaPrevius", paginaPrevia);
            request.setAttribute("paginaNext", paginaSiguiente);
            request.setAttribute("paginaFinal", paginaFinal);
            request.setAttribute("value", value);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/jsp/AutosListado.jsp").forward(request, response);
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
