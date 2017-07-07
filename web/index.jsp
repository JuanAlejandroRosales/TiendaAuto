<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Kathy de los Santos Garcia">
        <title>Sistema - Inicio Sesión</title>
        <%@include file="/WEB-INF/jspf/css2.jspf" %>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <br>
                    <img src="./img/img1.png" height="90" width="280"/>
                </div>
                <div class="col-md-9">
                    <div class="bs-docs-cabecera">
                        <div class="row">
                            <div class= "col-md-9 col-md-offset-1" >
                                <center><h1><i>BIENVENIDOS A HANGUL SAC</i></h1></center>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="col-md-3">
                    <br>
                    <br>
                    <br>
                    <br>
                    <img src="./img/img2.jpg" height="180" width="280"/>
                </div>
                <div class="col-md-9">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-lock" aria-hidden="true"></i> ACCESO</h3>
                        </div>
                        <div class="panel-body">
                            <form id="signupForm" method="post" action="./ServletLogin" class="form-horizontal">
                                <div class="row">
                                    <div class="col-md-11">
                                        <center><h3><b>INICIAR SESIÓN</b></h3></center>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-md-2 col-md-offset-3">
                                        <h4><b>Usuario:</b></h4>
                                    </div>
                                    <div class="col-md-4">
                                        <p>
                                            <input type="text" class="form-control" id="usuario" name="txtusuario" placeholder="">
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-md-2 col-md-offset-3">
                                        <h4><b>Contraseña:</b></h4>
                                    </div>
                                    <div class="col-md-4">
                                        <p>
                                            <input type="password" class="form-control" name="txtpassword" placeholder="">
                                        </p>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class= "col-md-2 col-md-offset-4">
                                        <p>
                                            <button class="btn btn-primary" type="submit">
                                            <i class="fa fa-key" aria-hidden="true"></i> Ingresar al Sistema</button>
                                        </p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %> 
        </div>
        <%@include file="/WEB-INF/jspf/js2.jspf" %>
    </body>
</html>
