<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Sistema - Listado Almacén</title>      
        <%@include file="/WEB-INF/jspf/estilos.jspf" %>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/head.jspf" %>
        <!--Cuerpo-->
        <div class="container-fluid">
            <div class="row-fluid">
                <%@include file="/WEB-INF/jspf/menu.jspf" %>
                <div class="span9">
                    <!--Body content-->               
                    <div style="text-align: right;width: 60%">
                        <ul id="icons" class="ui-widget ui-helper-clearfix">
                            <li class="ui-state-default ui-corner-all" title="Nuevo Almacen">
                                <a id="tool0" href="ServletAlmacenVentanaNuevo"> &nbsp Nuevo Almacen &nbsp </a>
                            </li>
                            <li class="ui-state-default ui-corner-all" title="Primera página">
                                <a id="tool1" class="ui-icon ui-icon-circle-triangle-n" href="ServletAlmacenPaginar?paginaActual=${paginaInicial}">  </a>                
                            </li>
                            <li class="ui-state-default ui-corner-all" title="Anterior página">
                                <a id="tool2" class="ui-icon ui-icon-circle-triangle-w" href="ServletAlmacenPaginar?paginaActual=${paginaPrevius}">  </a>
                            </li>
                            <li class="ui-state-default ui-corner-all" title="Siguiente página">
                                <a id="tool3" class="ui-icon ui-icon-circle-triangle-e" href="ServletAlmacenPaginar?paginaActual=${paginaNext}">  </a>
                            </li>
                            <li class="ui-state-default ui-corner-all" title="Última página">
                                <a id="tool4" class="ui-icon ui-icon-circle-triangle-s" href="ServletAlmacenPaginar?paginaActual=${paginaFinal}"> </a> 
                            </li>
                        </ul> 
                    </div>                    
                    <div class="bs-docs-example">        
                        <table class="table table-hover">
                            <thead>                                    
                                <tr>
                                    <th>Acción</th>
                                    <th>Código</th>
                                    <th>Descripción</th>                                       
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="var" items="${requestScope.lista}">
                                    <tr>
                                        <td><a href="ServletAlmacenVentanaModificar?id=${var.identificador}">Modificar</a></td>
                                        <td>${var.codigo}</td>
                                        <td>${var.descripcion}</td>                                    
                                    </tr>
                                </c:forEach>                                
                            </tbody>
                        </table>

                    </div>
                    <!--Body content Fin-->
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %>
    </body>
</html>