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
                //
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-11 col-md-offset-1">
                            <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-car" aria-hidden="true"></i> AUTOMOVIL - NUEVO REGISTRO DE AUTOMOVIL</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <form action="./ServletAutoGrabarNuevo" method="post" enctype="multipart/form-data">                                    
                                    <div class="col-md-5">
                                        <div class="row">
                                            <div class="col-md-3 col-md-offset-1">
                                                <h5><b>Marca:</b></h5>
                                            </div>
                                            <div class="col-md-6">
                                                <select class="form-control" name="ddlMarca">
                                                    <option value="0" selected="selected">SELECCIONAR...</option>
                                                    <c:forEach var="var" items="${requestScope.listam}">
                                                    <option value="${var.codigo}">${var.nombre}</option>    
                                                    </c:forEach>
                                                </select>
                                                
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-md-3 col-md-offset-1">
                                                <label for="txtModelo">Modelo:</label>
                                             </div>
                                            <div class="col-md-5">
                                                <input type="text" class="form-control" id="txtModelo" name="txtModelo">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-md-3 col-md-offset-1">
                                                <label for="txtColor">Color:</label>
                                             </div>
                                            <div class="col-md-5">
                                                <input type="text" class="form-control" id="txtColor" name="txtColor">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-md-3 col-md-offset-1">
                                                <label for="txtPrecio">Precio:</label>
                                             </div>
                                            <div class="col-md-5">
                                                <input type="text" class="form-control" id="txtPrecio" name="txtPrecio">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-md-3 col-md-offset-1">
                                                <label for="txtStock">Stock:</label>
                                            </div>
                                            <div class="col-md-3">
                                                <input type="text" class="form-control" id="txtStock" name="txtStock">
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
                                                        <output id="list" class="imgnodisp"></output>                                                        
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

