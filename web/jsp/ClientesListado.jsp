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
                    <br>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-1">
                            <p>
                                <a href="./ServletClienteVentanaNuevo">
                                    <button class="btn btn-default" id="btnNuevoCli">
                                        <span class="glyphicon glyphicon-plus"></span>
                                    Nuevo Cliente
                                    </button>
                                </a>
                            </p>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-1 col-md-offset-1">
                            <h5><b>Mostrar</b></h5>
                        </div>
                        <div class="col-md-3">
                            <select class="form-control" style="width:70px">
                                <option value="10">10</option>
                                <option>20</option>
                                <option>30</option>
                                <option>40</option>
                                <option>50</option>
                            </select>
                            <!-- Split button -->
                            <div class="btn-group">
                              <button type="button" class="btn btn-default">10</button>
                              <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="caret"></span>
                                <span class="sr-only">Toggle Dropdown</span>
                              </button>
                              <ul class="dropdown-menu">
                                <li><a href="#">20</a></li>
                                <li><a href="#">30</a></li>
                                <li><a href="#">40</a></li>
                                <li><a href="#">50</a></li>
                              </ul>
                            </div>
                        </div>
                        <div class="col-md-1">
                            <h5><b>Elementos</b></h5>
                        </div>
                        <div class="col-md-2 col-md-offset-3" style="width:110px">
                            <label class="control-label">Buscar por</label>
                        </div>
                        <div class="form-group col-md-3">
                            <div class="inner-addon left-addon">
                                <i class="glyphicon glyphicon-search"></i>
                                <input type="text" class="form-control" placeholder="Search" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <%@include file="/WEB-INF/jspf/clientes.jspf" %>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-1" style="width:125px">
                            <h5><b>Mostrando de</b></h5>
                        </div>
                        <div class="col-md-1">
                            <input class="form-control" id="campoDeshabilitado" type="text" placeholder="1" disabled>
                        </div>
                        <div class="col-md-1" style="width:20px">
                            <h5><b>a</b></h5>
                        </div>
                        <div class="col-md-1">
                            <input class="form-control" id="campoDeshabilitado" type="text" placeholder="3" disabled>
                        </div>
                        <div class="col-md-1">
                            <h5><b>elementos</b></h5>
                        </div>
                        
                        <div class="col-md-2 col-md-offset-1" style="width:128px">
                            <ul class="pager">
                                <li class="previous disabled"><a href="#">&larr; Anterior</a></li>
                            </ul>
                        </div>
                        <div class="col-md-1">
                            <br>
                            <center><input class="form-control" id="campoDeshabilitado" type="text" placeholder="1" disabled style="width:40px"></center>
                        </div>
                        <div class="col-md-2">
                            <ul class="pager">
                                <li class="next"><a href="#">Siguiente &rarr;</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-5">
                            <a class="btn btn-primary btn-lg" href="#" role="button">
                            <span class="glyphicon glyphicon-home"></span> Inicio</a>
                        </div>
                    </div>
                </div>
            </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %> 
        </div>
        <%@include file="/WEB-INF/jspf/js2.jspf" %>
    </body>
</html>

