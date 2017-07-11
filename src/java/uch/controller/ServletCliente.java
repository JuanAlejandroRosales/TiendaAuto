
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
import uch.dao.ClienteDao;
import uch.dao.funcAyuda;
import uch.model.AutoBean;
import uch.model.ClienteBean;

@WebServlet(name = "ServletCliente", urlPatterns = {"/ServletClienteListarTodos", "/ServletClientePaginar",
    "/ServletClienteVentanaNuevo", "/ServletClienteGrabarNuevo",
    "/ServletClienteVentanaModificar","/ServletClienteGrabarModificar","/ServletClientePaginardll",
    "/ServletClienteEliminar","/ServletClienteHome"})
@MultipartConfig
public class ServletCliente extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (
            PrintWriter out = response.getWriter()) {
            String path = request.getServletPath(); //(urlPatterns) Que patron URL se esta solicitando.
            if (path.equals("/ServletClienteListarTodos")) {
                listarTodos(request, response);
            } else if (path.equals("/ServletClientePaginar")) {
                paginar(request, response);
            } else if (path.equals("/ServletClientePaginardll")) {
                paginardll(request, response);
            }else if (path.equals("/ServletClienteVentanaNuevo")) {
                ventanaNuevo(request, response);
            } else if (path.equals("/ServletClienteGrabarNuevo")) {
                grabarNuevo(request, response);
            } else if (path.equals("/ServletClienteVentanaModificar")) {
                ventanaModificar(request, response);
            }else if (path.equals("/ServletClienteGrabarModificar")) {
                grabarModificar(request, response);
            } else if (path.equals("/ServletClienteEliminar")) {
                Eliminar(request, response);
            } else if (path.equals("/ServletClienteHome")) {
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
            ClienteDao dao = new ClienteDao();
            String codigo = null;
            codigo = dao.generarcodigo();
            String strID_CLIENTE = codigo.toString();
            String strPRI_NOMBRE = request.getParameter("txtPriNom");
            String strSEG_NOMBRE = request.getParameter("txtSegNom");
            String strPRI_APELLIDO = request.getParameter("txtPriApell");
            String strSEG_APELLIDO = request.getParameter("txtSegApell");
            String strRAZON_SOCIAL = request.getParameter("");
            String strNOMBRE_COMERCIAL = request.getParameter("");
            String strTIPO_DOCUMENTO = request.getParameter("ddlTipDoc");
            String strNUMERO_DOCUMENTO = request.getParameter("txtNumDoc");
            String strNUMERO_RUC = request.getParameter("");
            String strFECHA_NACIMIENTO = request.getParameter("txtfecnac");
            String strTIPO_CLIENTE = request.getParameter("");
            String strCLASE_CLIENTE = request.getParameter("ddlClsCli");
            String strID_UBIGEO = request.getParameter("");
            String strDIRECCION = request.getParameter("txtDireccion");
            String strID_PAIS = request.getParameter("ddlPais");
            String strTELEFONO_FIJO = request.getParameter("txtTelefono");
            String strCELULAR = request.getParameter("txtCelular");
            String strEMAIL = request.getParameter("txtCorreo");
            String strSEXO = request.getParameter("radio-1");
            String strESTADO = "A";
            String strFECHA_REGISTRO = Integer.toString(c.get(Calendar.DATE))+"/"+
                                       Integer.toString(c.get(Calendar.MONTH)+1)+"/"+
                                       Integer.toString(c.get(Calendar.YEAR));
            String strUSUARIO_REGISTRO = request.getParameter("txtStock");
            ClienteBean CLIENTE = new ClienteBean();
            CLIENTE.setID_CLIENTE(strID_CLIENTE);
            CLIENTE.setPRI_NOMBRE(strPRI_NOMBRE);
            CLIENTE.setSEG_NOMBRE(strSEG_NOMBRE);
            CLIENTE.setPRI_APELLIDO(strPRI_APELLIDO);
            CLIENTE.setSEG_APELLIDO(strSEG_APELLIDO);
            CLIENTE.setRAZON_SOCIAL(strRAZON_SOCIAL);
            CLIENTE.setNOMBRE_COMERCIAL(strNOMBRE_COMERCIAL);
            CLIENTE.setTIPO_DOCUMENTO(strTIPO_DOCUMENTO);
            CLIENTE.setNUMERO_DOCUMENTO(strNUMERO_DOCUMENTO);
            CLIENTE.setNUMERO_RUC(strNUMERO_RUC);
            CLIENTE.setFECHA_NACIMIENTO(strFECHA_NACIMIENTO);
            CLIENTE.setTIPO_CLIENTE(strTIPO_CLIENTE);
            CLIENTE.setCLASE_CLIENTE(strCLASE_CLIENTE);
            CLIENTE.setID_UBIGEO(strID_UBIGEO);
            CLIENTE.setDIRECCION(strDIRECCION);
            CLIENTE.setID_PAIS(strID_PAIS);
            CLIENTE.setTELEFONO_FIJO(strTELEFONO_FIJO);
            CLIENTE.setCELULAR(strCELULAR);
            CLIENTE.setEMAIL(strEMAIL);
            CLIENTE.setSEXO(strSEXO);
            CLIENTE.setESTADO(strESTADO);
            CLIENTE.setFECHA_REGISTRO(strFECHA_REGISTRO);
            CLIENTE.setUSUARIO_REGISTRO(strUSUARIO_REGISTRO);
            
            
            boolean resultado = dao.Insertar(CLIENTE);
            if (resultado) {
                request.setAttribute("error", "");
                paginar(request, response);
                
            } else {
                request.setAttribute("error", "EL CLIENTE " + strID_CLIENTE + " NO SE PUEDE ADICIONAR");
               
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
            request.getRequestDispatcher("/jsp/ClientesNuevo.jsp").forward(request, response);
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
            request.getRequestDispatcher("/jsp/ClientesListado.jsp").forward(request, response);
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
               value="'./ServletAutoPaginardll?CantReg=10'";  
            }else if (CantReg==20) {
               value="'./ServletAutoPaginardll?CantReg=20'";
            }else if (CantReg==30) {
               value="'./ServletAutoPaginardll?CantReg=30'";
            }else if (CantReg==40) {
               value="'./ServletAutoPaginardll?CantReg=40'";
            }else if (CantReg==50) {
               value="'./ServletAutoPaginardll?CantReg=50'";
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
