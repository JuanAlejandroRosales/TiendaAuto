<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Kathy de los Santos Garcia">
        <title>Sistema - Inicio</title>      
        <%@include file="/WEB-INF/jspf/css2.jspf" %>    
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/head2.jspf" %>
        <br>
        <br>
        <div class="container">
            <!--Cuerpo-->
            <br>
            <div class="row">
                <div class="col-md-10 col-md-offset-7">
                    <%@include file="/WEB-INF/jspf/botones3.jspf" %>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-2">
                    <%@include file="/WEB-INF/jspf/menu3.jspf" %>
                </div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-11 col-md-offset-1">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><i class="fa fa-car" aria-hidden="true"></i> AUTOMOVIL - MODIFICAR REGISTRO DE AUTOMOVIL</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <form action="./ServletAutoGrabarModificar" method="post" enctype="multipart/form-data">                                    
                                            <div class="col-md-5">
                                                <div class="row">
                                                    <div class="col-md-3 col-md-offset-1">
                                                        <h5><b>Código:</b></h5>
                                                    </div>
                                                    <div class="col-md-5">
                                                        <input type="text" 
                                                               class="form-control" 
                                                               id="txtCodigo" 
                                                               name="txtCodigo"
                                                               value="${requestScope.objeto.ID_AUTOMOVIL}"
                                                               disabled>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <input  type="hidden" 
                                                                id="txtCodigoh" 
                                                                name="txtCodigoh" 
                                                                value="${requestScope.objeto.ID_AUTOMOVIL}">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3 col-md-offset-1">
                                                        <h5><b>Marca:</b></h5>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <select id="marcas" class="form-control" name="ddlMarca">
                                                            <option value="0" >SELECCIONAR...</option>
                                                            <c:forEach var="var" items="${requestScope.listam}">
                                                            <option value="${var.codigo}" >${var.nombre}</option>    
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <input  type="hidden" 
                                                                id="txtIdMarca" 
                                                                name="txtIdMarca" 
                                                                value="${requestScope.objeto.ID_MARCA}">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3 col-md-offset-1">
                                                        <h5><b>Modelo:</b></h5>
                                                     </div>
                                                    <div class="col-md-5">
                                                        <input type="text" 
                                                               class="form-control" 
                                                               id="txtModelo" 
                                                               name="txtModelo"
                                                               value="${requestScope.objeto.MODELO}">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3 col-md-offset-1">
                                                        <h5><b>Color:</b></h5>
                                                     </div>
                                                    <div class="col-md-5">
                                                        <input type="text" 
                                                               class="form-control" 
                                                               id="txtColor" 
                                                               name="txtColor"
                                                               value="${requestScope.objeto.COLOR}">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3 col-md-offset-1">
                                                        <h5><b>Precio:</b></h5>
                                                     </div>
                                                    <div class="col-md-5">
                                                        <input type="text" 
                                                               class="form-control" 
                                                               id="txtPrecio" name="txtPrecio"
                                                               value="${requestScope.objeto.PRECIO}">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3 col-md-offset-1">
                                                        <h5><b>Stock:</b></h5>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input type="text" 
                                                               class="form-control" 
                                                               id="txtStock" 
                                                               name="txtStock"
                                                               value="${requestScope.objeto.STOCK}">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-7">
                                                <div class="row">
                                                    <div class="col-md-7">
                                                        <div>
                                                            <label for="files" class="btn btn-default">
                                                                <span class="glyphicon glyphicon-plus"></span>Agregar Imagen
                                                            </label>
                                                            <input id="files" name="foto" style="visibility:hidden;" type="file">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="panel panel-info">
                                                            <div class="panel-body">
                                                                <div class="imgnodisp">
                                                                    <output id="list" 
                                                                        style="background-image: url('./fotos/COD_${requestScope.objeto.ID_AUTOMOVIL}.jpg');
                                                                                width:450px; 
                                                                                height:320px;
                                                                                background-size: 450px 320px;
                                                                                background-position: center;
                                                                                border: 1px solid #000;"></output> 
                                                                    </div>        
                                                            </div>
                                                            <div class="panel-footer">IMAGEN</div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-md-3">
                                                        <button type="submit" class="btn btn-default">
                                                        <span class="glyphicon glyphicon-floppy-disk"></span> Guardar</button>
                                                    </div>

                                                    <div class="col-md-3">
                                                        <a class="btn btn-primary" href="#" role="button">
                                                        <span class="glyphicon glyphicon-home"></span> Salir</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>                                          
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %> 
        </div>
        <%@include file="/WEB-INF/jspf/js2.jspf" %>
    </body>
</html>
