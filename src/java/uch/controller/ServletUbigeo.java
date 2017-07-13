package uch.controller;

import com.google.gson.Gson;
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
import javax.servlet.http.Part;
import uch.dao.AutoDao;
import uch.dao.MarcaDao;
import uch.dao.UbigeoDao;
import uch.dao.funcAyuda;
import uch.model.AutoBean;
import uch.model.MarcaBean;
import uch.model.UbigeoBean;

@WebServlet(name = "ServletUbigeo", urlPatterns = {"/ServletUbigeoListarTodos", "/ServletUbigeoPaginar",
    "/ServletUbigeoVentanaNuevo", "/ServletUbigeoGrabarNuevo",
    "/ServletUbigeoVentanaModificar","/ServletUbigeoGrabarModificar", "/ServletUbigeoListarTodosdll",
    "/ServletUbigeoListarDepertamentosdll","/ServletUbigeoListarProvinciasdll", "/ServletUbigeoListarDistritosdll"})
@MultipartConfig
public class ServletUbigeo extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (
            PrintWriter out = response.getWriter()) {
            String path = request.getServletPath(); //(urlPatterns) Que patron URL se esta solicitando.
           
            if (path.equals("/ServletUbigeoListarTodos")) {
                listarTodos(request, response);
            } else if (path.equals("/ServletUbigeoPaginar")) {
                paginar(request, response);
            } else if (path.equals("/ServletUbigeoVentanaNuevo")) {
                ventanaNuevo(request, response);
            } else if (path.equals("/ServletUbigeoGrabarNuevo")) {
                grabarNuevo(request, response);
            } else if (path.equals("/ServletUbigeoVentanaModificar")) {
                ventanaModificar(request, response);
            }else if (path.equals("/ServletUbigeoGrabarModificar")) {
                grabarModificar(request, response);
            }else if (path.equals("/ServletUbigeoListarTodosdll")) {
                listartodosdllNuevo(request, response);
            }else if (path.equals("/ServletUbigeoListarDepertamentosdll")) {
                listarDepartamentosdll(request, response);
            }else if (path.equals("/ServletUbigeoListarProvinciasdll")) {
                listarProvinciasdll(request, response);
            }else if (path.equals("/ServletUbigeoListarDistritosdll")) {
                listarDistritosdll(request, response);
            }
        }
    }
    
    private void grabarModificar(HttpServletRequest request, HttpServletResponse response) {
        try {
            String strCodigo = request.getParameter("txtcodigo");
            String strMarca = request.getParameter("ddlMarca");
            String strModelo = request.getParameter("txtModelo");
            String strColor = request.getParameter("txtColor");
            String strPrecio = request.getParameter("txtPrecio");
            String strStock = request.getParameter("txtStock");
            AutoBean auto = new AutoBean();
            auto.setID_AUTOMOVIL(strCodigo);
            auto.setID_MARCA(strMarca);
            auto.setMODELO(strModelo);
            auto.setCOLOR(strColor);
            auto.setPRECIO(Integer.parseInt(strPrecio));
            auto.setSTOCK(Integer.parseInt(strStock));
            AutoDao dao = new AutoDao();
            boolean resultado = dao.Actualizar(auto);
            if (resultado) {
                request.setAttribute("error", "");
                paginar(request, response);
            } else {
                request.setAttribute("error", "El Almacen " + strColor + " no se puede adicionar");
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
            AutoBean auto = new AutoBean();
            AutoDao dao = new AutoDao();
            auto = dao.buscar(strId);
            request.setAttribute("objeto", auto);
            request.getRequestDispatcher("/jsp/AutosModificar.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    private void grabarNuevo(HttpServletRequest request, HttpServletResponse response) {
        try {
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
            auto.setID_AUTOMOVIL(strCodigo);
            auto.setID_MARCA(strMarca);
            auto.setMODELO(strModelo);
            auto.setCOLOR(strColor);
            auto.setPRECIO(Double.parseDouble(strPrecio));
            auto.setSTOCK(Integer.parseInt(strStock));
            auto.setESTADO(strEstado);
            auto.setFECHA_REGISTRO(strFecha_Registro);
            
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

            if(!fileName.isEmpty()){
                String path="E:\\PROYECTO NUEVO\\PROYECTO NUEVO\\webISIII\\web\\fotos";
                File uploads = new File(path); //Carpeta donde se guardan los archivos
                uploads.mkdirs(); //Crea los directorios necesarios
                File file = File.createTempFile("COD"+"_"+codigo+"_","_"+fileName, uploads); //Evita que hayan dos archivos con el mismo nombre

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
            request.getRequestDispatcher("/jsp/AutosNuevo.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    private void listarTodos(HttpServletRequest request, HttpServletResponse response) {
        try {
            AutoDao dao = new AutoDao();
            List<AutoBean> lista = new ArrayList<AutoBean>();
            lista = dao.listar();
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/jsp/AutosListado.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }
    
    private void listartodosdllNuevo(HttpServletRequest request, HttpServletResponse response) {
        try {
            listarDepartamentosdll(request, response);
            request.getRequestDispatcher("/jsp/ClientesNuevo.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }
        
    public void listarTodosdll(HttpServletRequest request, HttpServletResponse response) {
        try {
            MarcaDao dao = new MarcaDao();
            List<MarcaBean> listam = new ArrayList<MarcaBean>();
            listam = dao.listarddl();
            request.setAttribute("listam", listam);
            //request.getRequestDispatcher("/jsp/AutosNuevo.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }
    
    public void listarDepartamentosdll(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            UbigeoDao dao = new UbigeoDao();
            List<UbigeoBean> listaD = new ArrayList<UbigeoBean>();
            listaD = dao.listarDep();
            request.setAttribute("listaD", listaD);
            Gson n = new Gson();
            String respuesta = n.toJson(listaD);
            out.println(respuesta);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }

    public void listarProvinciasdll(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            UbigeoDao dao = new UbigeoDao();
            List<UbigeoBean> listaP = new ArrayList<UbigeoBean>();
            String ID_DEPARTAMENTO = request.getParameter("IDDep");
            String strID_DEPARTAMENTO = ID_DEPARTAMENTO.substring(0, 2);
            listaP = dao.listarProv(strID_DEPARTAMENTO);
            request.setAttribute("listaP", listaP);
            Gson n = new Gson();
            String respuesta = n.toJson(listaP);
            out.println(respuesta);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    
    public void listarDistritosdll(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = response.getWriter();
            UbigeoDao dao = new UbigeoDao();
            List<UbigeoBean> listaDist = new ArrayList<UbigeoBean>();
            String ID_DEPARTAMENTO = request.getParameter("IDDep");
            String ID_PROVINCIA = request.getParameter("IDProv");
            String strID_DEPARTAMENTO = ID_DEPARTAMENTO.substring(0, 2);
            String strID_PROVINCIA = ID_PROVINCIA.substring(2, 4);
            listaDist = dao.listarDist(strID_DEPARTAMENTO,strID_PROVINCIA);
            request.setAttribute("listaDist", listaDist);
            Gson n = new Gson();
            String respuesta = n.toJson(listaDist);
            out.println(respuesta);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            System.out.println(e.getMessage());
        }
    }    
        
    private void paginar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
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
