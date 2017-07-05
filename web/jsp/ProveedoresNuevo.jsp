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
                                <h3 class="panel-title"><span class="glyphicon glyphicon-briefcase"></span> PROVEEDORES</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="row">
                                            <div class="col-md-2 col-md-offset-1">
                                                <h5><b>RUC:</b></h5>
                                            </div>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control" placeholder="">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-md-2 col-md-offset-1">
                                                <h5><b>Razón Social:</b></h5>
                                            </div>
                                            <div class="col-md-4">
                                                <input type="text" class="form-control" placeholder="">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-md-2 col-md-offset-1">
                                                <h5><b>Dirección:</b></h5>
                                            </div>
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" placeholder="">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-md-2 col-md-offset-1">
                                                <h5><b>Teléfono:</b></h5>
                                            </div>
                                            <div class="col-md-3">
                                                <input type="text" class="form-control" placeholder="">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-md-2 col-md-offset-1">
                                                <h5><b>Email:</b></h5>
                                            </div>
                                            <div class="col-md-5">
                                                <input type="email" class="form-control" placeholder="">
                                            </div>
                                        </div>
                                        <br>
                                        <br>
                                        <div class="row">
                                            <div class="col-md-2 col-md-offset-8">
                                                <button class="btn btn-primary" type="submit">
                                                <span class="glyphicon glyphicon-floppy-disk"></span> Guardar</button>
                                            </div>
                                            <div class="col-md-2">
                                                <a class="btn btn-primary" href="#" role="button">
                                                <span class="glyphicon glyphicon-home"></span> Salir</a>
                                            </div>
                                        </div>
                                    </div>
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

