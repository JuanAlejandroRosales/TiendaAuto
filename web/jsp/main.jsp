<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema - Inicio</title>      
        <%@include file="/WEB-INF/jspf/estilos.jspf" %>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/head1.jspf" %>
        <div class="container">
        <!--Cuerpo-->
        <div class="row">
            <%@include file="/WEB-INF/jspf/menu1.jspf" %>
            <div class="span9">
                <%@include file="/WEB-INF/jspf/barra.jspf" %>
            </div>
        </div>
            <%@include file="/WEB-INF/jspf/foot.jspf" %>
        </div>
    </body>
</html>
