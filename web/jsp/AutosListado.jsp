<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Kathy de los Santos Garcia">
        <title>Sistema - Listado Automóviles</title>      
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
                                <a href="./ServletMarcaListarTodosdll">
                                    <button class="btn btn-default" >
                                        <span class="glyphicon glyphicon-plus"></span>
                                    Nuevo Auto
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
                        <div class="col-md-1">
                            <select class="form-control" style="width:70px" name="ddlTamPag" id="ddlTamPag" 
                                    onchange="location = this.value;">
                                <option value="./ServletAutoPaginardll?CantReg=10" onclick="hideOther();">10</option>
                                <option value="./ServletAutoPaginardll?CantReg=10" onclick="hideOther();">10</option>
                                <option value="./ServletAutoPaginardll?CantReg=20" onclick="hideOther();">20</option>
                                <option value="./ServletAutoPaginardll?CantReg=30" onclick="hideOther();">30</option>
                                <option value="./ServletAutoPaginardll?CantReg=40" onclick="hideOther();">40</option>
                                <option value="./ServletAutoPaginardll?CantReg=50" onclick="hideOther();">50</option>
                                <option value="./ServletAutoListarTodos">Todo</option>
                            </select>
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
                        <input  type="hidden" 
                                id="txtvalue" 
                                name="txtvalue" 
                                value="${requestScope.value}">
                    </div>
                    <div class="row">
                        <div class="col-md-10 col-md-offset-1">
                            <%@include file="/WEB-INF/jspf/newjsp.jspf" %>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-md-offset-1" style="width:128px">
                            <h5><b>Mostrando de</b></h5>
                        </div>
                        <div class="col-md-1" style="width:65px">
                            <input class="form-control" id="campoDeshabilitado" type="text" placeholder="1" disabled >
                        </div>
                        <div class="col-md-1" style="width:2px">
                            <h5><b>a</b></h5>
                        </div>
                        <div class="col-md-1" style="width:65px">
                            <input class="form-control" id="campoDeshabilitado" type="text" placeholder="3" disabled>
                        </div>
                        <div class="col-md-1" style="width:100px">
                            <h5><b>elementos</b></h5>
                        </div>
                        
                        <div class="col-md-1 col-md-offset-1" style="width:60px">
                            <br>
                            <p> 
                                <a href="./ServletAutoPaginar?paginaActual=${paginaInicial}">
                                    <button type="submit" class="btn btn-default" title="PÁGINA PRINCIPAL">
                                        <span class="glyphicon glyphicon-open"></span>
                                    </button>
                                </a>
                            </p>
                        </div>
                        <div class="col-md-1 " style="width:128px">
                            <ul class="pager">
                                <li type="submit" class="previous"><a href="./ServletAutoPaginar?paginaActual=${paginaPrevius}">&larr; Anterior</a></li>
                            </ul>
                        </div>
                        <div class="col-md-1" style="width:65px">
                            <br>
                            <center><input class="form-control" id="campoDeshabilitado" value="${requestScope.paginaActual}" type="text" placeholder="1" disabled ></center>
                        </div>
                        <div class="col-md-1" style="width:140px">
                            <ul class="pager">
                                <li type="submit" class="next"><a href="./ServletAutoPaginar?paginaActual=${paginaNext}">Siguiente &rarr;</a></li>
                            </ul>
                        </div>
                        <div class="col-md-1" style="width:10px">
                            <br>
                            <p> 
                                <a href="./ServletAutoPaginar?paginaActual=${paginaFinal}">
                                    <button type="submit" class="btn btn-default" title="úLTIMA PÁGINA">
                                        <span class="glyphicon glyphicon-save"></span>
                                    </button>
                                </a>
                            </p>
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

