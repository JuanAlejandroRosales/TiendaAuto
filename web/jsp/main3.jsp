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
                <div class="col-md-3">
                    <%@include file="/WEB-INF/jspf/menu3.jspf" %>
                </div>
                <div class="col-md-9">
                    <div class="row">    
                    <!--Body content-->               
                        <div class="bs-docs-main">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-7 col-md-offset-1" >
                                        <center><h1>HANGUL SAC</h1></center>
                                    </div>
                                </div>
                                </br>
                                <div class="row">
                                    <div class="col-md-10" >
                                        <img src="./img/img3.jpg" width="270" height="220"/>
                                        <img src="./img/img2.jpg" width="270" height="220"/>
                                        <img src="./img/img4.jpg" width="270" height="220"/>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-md-6 col-md-offset-1">
                                        <center><h4><b>VEN A CONOCER LA MAYOR OFERTA</b></h4></center>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-9">
                                        <center><h3><b>EN AUTOMOVILES DE DIFERENTES MODELOS Y MARCAS</b></h3></center>
                                    </div>
                                </div>
                            </div>                        
                        </div>
                <!--Body content Fin-->
                    </div>
                </div>
            </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %> 
        </div>
        <%@include file="/WEB-INF/jspf/js2.jspf" %>
    </body>
</html>

