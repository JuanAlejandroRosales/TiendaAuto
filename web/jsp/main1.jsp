<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema - Inicio</title>      
        <%@include file="/WEB-INF/jspf/css2.jspf" %>
        <%@include file="/WEB-INF/jspf/img.jspf" %>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/head1.jspf" %>
        <div class="container">
            <!--Cuerpo-->
            <div class="row">
                <%@include file="/WEB-INF/jspf/menu1.jspf" %>
                <div class="span9">
                    <div class= "span5 offset5" >
                        <%@include file="/WEB-INF/jspf/buttonset.jspf" %>
                    </div>
                </br>
                </br>
                <div class="row">    
                    <!--Body content-->               
                    <div class="bs-docs-main">
                        <div class="container">
                            <div class="row">
                                <div class= "span7 offset1" >
                                    <h1><center>HANGUL SAC</center></h1>
                                </div>
                            </div>
                            </br>
                            <div class="row">
                                <div class= "span11 offset1" >
                                    <img src="./img/img3.jpg" width="230px" height="60px"/>
                                    <img src="./img/img2.jpg" width="230px" height="60px"/>
                                    <img src="./img/img4.jpg" width="230px" height="60px"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class= "span5 offset2" >
                                    <h4><center>VEN A CONOCER LA MAYOR OFERTA</center></h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class= "span7 offset1" >
                                    <h3><center>EN AUTOMOVILES DE DIFERENTES MODELOS Y MARCAS</center></h3>
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
    <%@include file="/WEB-INF/jspf/js.jspf" %>
    </body>
</html>

