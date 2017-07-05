<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema - Modificar Almacen</title>      
        <%@include file="/WEB-INF/jspf/estilos.jspf" %>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/head.jspf" %>
        <!--Cuerpo-->
        <div class="container-fluid">
            <div class="row-fluid">
                <%@include file="/WEB-INF/jspf/menu1.jspf" %>
                <div class="span9">
                    <!--Body content-->          
                    <h4>MODIFICAR REGISTRO DE ALMACEN</h4>
                    <div class="bs-docs-example">                         
                        <form action="ServletAlmacenGrabarModificar" method="POST">
                            <input type="hidden" 
                                   id="txtIdAlmacen" 
                                   name="txtIdAlmacen" 
                                   value="${requestScope.objeto.identificador}">
                            
                            <div class="form-group">
                                <label for="txtCodigo">Código</label>
                                <input type="text" class="form-control" 
                                       id="txtCodigo" name="txtCodigo" 
                                       placeholder="Código" 
                                       value="${requestScope.objeto.codigo}">
                            </div>
                            <div class="form-group">
                                <label for="txtDescripcion">Descripción</label>
                                <input type="text" class="form-control" 
                                       id="txtDescripcion" name="txtDescripcion" 
                                       placeholder="Descripción" 
                                       value="${requestScope.objeto.descripcion}">
                            </div>
                            <br>
                            <button type="submit" class="btn btn-default">Modifcar Registro</button>
                        </form>  
                        <div class="ui-widget">
                           <c:if test="${requestScope.error!=null}">
                            <div class="ui-state-error ui-corner-all">
                                <p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
                                    <strong>Alert:</strong> ${requestScope.error}</p>
                            </div>
                             </c:if>      
                        </div>
                    </div>
                    <!--Body content Fin-->
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %>
    </body>
</html>
