<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <br>
            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <center><h3 class="panel-title"><i class="fa fa-database" aria-hidden="true"></i> COPIA DE SEGURIDAD</h3></center>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-3 col-md-offset-2">
                                    <img src="../img/img5.jpg" width="270" height="220"/>
                                </div>
                                <div class="col-md-7">
                                    <br>
                                    <div class="row">
                                        <div class="col-md-2 col-md-offset-1">
                                            <h4><b>BDName</b></h4>
                                        </div>
                                        <div class="col-md-2">
                                            <h4>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" id="checkboxEnLinea1" value="opcion_1"> Productos
                                                </label>
                                                </h4>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-md-2 col-md-offset-2">
                                            <h4>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" id="checkboxEnLinea1" value="opcion_1"> Clientes
                                                </label>
                                            </h4>
                                        </div>
                                        <div class="col-md-2">
                                            <h4>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" id="checkboxEnLinea1" value="opcion_1"> Proveedores
                                                </label>
                                            </h4>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-md-2 col-md-offset-2">
                                            <h4>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" id="checkboxEnLinea1" value="opcion_1"> Ventas
                                                </label>
                                            </h4>
                                        </div>
                                        <div class="col-md-2">
                                            <h4>
                                                <label class="checkbox-inline">
                                                    <input type="checkbox" id="checkboxEnLinea1" value="opcion_1"> Compras
                                                </label>
                                            </h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-md-2 col-md-offset-5">
                                    <h4><b>Usuario:</b></h4>
                                </div>
                                <div class="col-md-3">
                                    <p>
                                        <input type="text" class="form-control" placeholder="">
                                    </p>
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="col-md-2 col-md-offset-5">
                                    <h4><b>Contraseña:</b></h4>
                                </div>
                                <div class="col-md-3">
                                    <p>
                                        <input type="password" class="form-control" placeholder="">
                                    </p>
                                </div>
                            </div>
                            <br>
                            <br>
                            <div class="row">
                                <div class="col-md-2 col-md-offset-4">
                                    <button class="btn btn-primary" type="submit">
                                    <i class="fa fa-database" aria-hidden="true"></i> Backup</button>
                                </div>
                                <div class="col-md-2">
                                    <a class="btn btn-primary" href="#" role="button">
                                    <span class="glyphicon glyphicon-home"></span> Salir</a>
                                </div>
                                <div class="col-md-2">
                                    <a class="btn btn-primary" href="#" role="button">
                                    <i class="fa fa-times" aria-hidden="true"></i> Cancelar</a>
                                </div>
                            </div>
                            <br>
                            <br>
                        </div>
                    </div>
                </div>
            </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %>     
        </div>
        <%@include file="/WEB-INF/jspf/js2.jspf" %>
    </body>
</html>
