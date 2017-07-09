<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="author" content="Kathy de los Santos Garcia">
        <title>Sistema - Nuevo Cliente</title>      
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
                //
                <div class="col-md-10">
                    <div class="row">
                        <div class="col-md-11 col-md-offset-1">
                            <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-car" aria-hidden="true"></i> CLIENTE - NUEVO REGISTRO DE CLIENTE</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div id="tabtipcli">
                                            <ul>
                                                <li><a href="#clinatural"><span>CLIENTE NATURAL</span></a></li>
                                                <li><a href="#clijuridico"><span>CLIENTE JURIDICO</span></a></li>
                                            </ul>
                                            <form action="./ServletClienteGrabarNuevo" method="post" enctype="multipart/form-data">
                                            <div id="clinatural">
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblPriNom">Primer Nombre:</label>
                                                    </div>
                                                    <div class="col-md-3" style="margin-left: 20px">
                                                        <input type="text" class="form-control" id="txtPriNom" name="txtPriNom">
                                                    </div>
                                                    <div class="col-md-3" style="width: 175px; margin-left:20px">
                                                        <label for="lblSegNom">Segundo Nombre:</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input type="text" class="form-control" id="txtSegNom" name="txtSegNom">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblPriApell">Primer Apellido:</label>
                                                    </div>
                                                    <div class="col-md-3" style="margin-left: 20px">
                                                        <input type="text" class="form-control" id="txtPriApell" name="txtPriApell">
                                                    </div>
                                                    <div class="col-md-3" style="width: 175px; margin-left:20px">
                                                        <label for="lblSegApell">Segundo Apellido:</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input type="text" class="form-control" id="txtSegApell" name="txtSegApell">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblTipDoc">Tipo Documento:</label>
                                                    </div>
                                                    <div class="col-md-3" style="margin-left: 20px">
                                                        <select class="form-control" name="ddlMarca">
                                                            <option value="0" selected="selected">SELECCIONAR...</option>
                                                            <option value="1">DNI</option>
                                                            <option value="2">CARNET DE EXTRANJERIA</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3" style="width: 175px; margin-left:20px">
                                                        <label for="lblNumDoc">Número Documento:</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input type="text" class="form-control" id="txtTipDoc" name="txtTipDoc">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblClsCli">Clase Cliente:</label>
                                                    </div>
                                                    <div class="col-md-3" style="margin-left: 20px">
                                                        <select class="form-control" name="ddlClsCli">
                                                            <option value="0" selected="selected">SELECCIONAR...</option>
                                                            <option value="1">NACIONAL</option>
                                                            <option value="2">EXTRANJERO</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3" style="width: 175px; margin-left:20px">
                                                        <label for="lblPais">Pais:</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select class="form-control" name="ddlPais">
                                                            <option value="0" selected="selected">SELECCIONAR...</option>
                                                            <option value="1">PERU</option>
                                                            <option value="2">CHILE</option>
                                                            <option value="2">ARGENTINA</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblDireccion">Dirección:</label>
                                                    </div>
                                                    <div class="col-md-9" style="width: 605px; margin-left: 20px">
                                                        <input type="text" class="form-control" id="txtDireccion" name="txtDireccion">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblDep">Departamento:</label>
                                                    </div>
                                                    <div class="col-md-3"style="margin-left: 20px">
                                                        <select class="form-control" name="ddlClsCli">
                                                            <option value="0" selected="selected">SELECCIONAR...</option>
                                                            <option value="1">LIMA</option>
                                                            <option value="2">AMAZONAS</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3" style="width: 175px; margin-left:20px">
                                                        <label for="lblPais">Provincia:</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select class="form-control" name="ddlPais">
                                                            <option value="0" selected="selected">SELECCIONAR...</option>
                                                            <option value="1">lima</option>
                                                            <option value="2">Barranca</option>
                                                            <option value="2">Cañete</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lbldDis">Distrito:</label>
                                                    </div>
                                                    <div class="col-md-3" style="margin-left: 20px">
                                                        <select class="form-control" name="ddlDistrito">
                                                            <option value="0" selected="selected">SELECCIONAR...</option>
                                                            <option value="1">COMAS</option>
                                                            <option value="2">BREÑA</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblTelefono">Telefono:</label>
                                                    </div>
                                                    <div class="col-md-3" style="margin-left: 20px">
                                                        <input type="text" class="form-control" id="txtTelefono" name="txtTelefono">
                                                    </div>
                                                    <div class="col-md-3" style="width: 175px; margin-left:20px">
                                                        <label for="lblCelular">Celular:</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input type="text" class="form-control" id="txtCelular" name="txtCelular">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblCorreo">Correo:</label>
                                                    </div>
                                                    <div class="col-md-7" style="width: 445px; margin-left: 20px">
                                                        <input type="email" class="form-control" id="txtCorreo" name="Correo">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="margin-left: 30px; width: 182px">
                                                        <label for="lblFecNac">Fecha de Nacimiento:</label>
                                                    </div>
                                                    <div class="col-md-3" style="width: 175px; margin-left: 5px">
                                                        <div class="row">
                                                            <div class="form-group">
                                                                <div class='input-group date' id='datetimepicker1'>
                                                                    <input type='text' class="form-control" />
                                                                    <span class="input-group-addon">
                                                                        <span class="glyphicon glyphicon-calendar"></span>
                                                                    </span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblSexo">Sexo:</label>
                                                    </div>
                                                    <div class="col-md-7" style="width: 445px; margin-left: 20px">
                                                        <fieldset>
                                                            <label for="radio-1">Masculino</label>
                                                            <input type="radio" name="radio-1" id="radio-1" value="M">
                                                            <label for="radio-2">Femenivo</label>
                                                            <input type="radio" name="radio-1" id="radio-2" value="F">
                                                        </fieldset>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-2 col-md-offset-8">
                                                        <button type="submit" class="btn btn-default">
                                                        <span class="glyphicon glyphicon-floppy-disk"></span> Guardar</button>
                                                    </div>

                                                    <div class="col-md-2">
                                                        <a class="btn btn-primary" href="#" role="button" style="color: white">
                                                        <span class="glyphicon glyphicon-home"></span> Salir</a>
                                                    </div>
                                                </div>
                                            </div>    
                                            <div id="clijuridico">
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 170px; margin-left:30px">
                                                        <label for="lblRuc">Ruc:</label>
                                                    </div>
                                                    <div class="col-md-7" style="width: 300px; margin-left: 0px">
                                                        <input type="text" class="form-control" id="txtRuc" name="txtRuc">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 170px; margin-left:30px">
                                                        <label for="lblRazSoc">Razon social:</label>
                                                    </div>
                                                    <div class="col-md-8" style="width: 550px; margin-left: 0px">
                                                        <input type="text" class="form-control" id="txtRazSoc" name="txtRazSoc">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 170px; margin-left:30px">
                                                        <label for="lblNomCom">Nombre Comercial:</label>
                                                    </div>
                                                    <div class="col-md-8" style="width: 550px; margin-left: 0px">
                                                        <input type="text" class="form-control" id="txtNomCom" name="txtNomCom">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblDireccionJ">Dirección:</label>
                                                    </div>
                                                    <div class="col-md-9" style="width: 605px; margin-left: 20px">
                                                        <input type="text" class="form-control" id="txtDireccionJ" name="txtDireccionJ">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblDepJ">Departamento:</label>
                                                    </div>
                                                    <div class="col-md-3"style="margin-left: 20px">
                                                        <select class="form-control" name="ddlDepJ">
                                                            <option value="0" selected="selected">SELECCIONAR...</option>
                                                            <option value="1">LIMA</option>
                                                            <option value="2">AMAZONAS</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-3" style="width: 175px; margin-left:20px">
                                                        <label for="lblPaisJ">Provincia:</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select class="form-control" name="ddlPaisJ">
                                                            <option value="0" selected="selected">SELECCIONAR...</option>
                                                            <option value="1">lima</option>
                                                            <option value="2">Barranca</option>
                                                            <option value="2">Cañete</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lbldDisJ">Distrito:</label>
                                                    </div>
                                                    <div class="col-md-3" style="margin-left: 20px">
                                                        <select class="form-control" name="ddlDistJ">
                                                            <option value="0" selected="selected">SELECCIONAR...</option>
                                                            <option value="1">COMAS</option>
                                                            <option value="2">BREÑA</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblTelefJ">Telefono:</label>
                                                    </div>
                                                    <div class="col-md-3" style="margin-left: 20px">
                                                        <input type="text" class="form-control" id="txtTelefJ" name="txtTelefJ">
                                                    </div>
                                                    <div class="col-md-3" style="width: 175px; margin-left:20px">
                                                        <label for="lblCelJ">Celular:</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input type="text" class="form-control" id="txtCelJ" name="txtCelJ">
                                                    </div>
                                                </div>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-3" style="width: 150px; margin-left:30px">
                                                        <label for="lblCorreo">Correo:</label>
                                                    </div>
                                                    <div class="col-md-7" style="width: 445px; margin-left: 20px">
                                                        <input type="email" class="form-control" id="txtCorreo" name="Correo">
                                                    </div>
                                                </div>
                                                <br>
                                                <br>
                                                <div class="row">
                                                    <div class="col-md-2 col-md-offset-8">
                                                        <button type="submit" class="btn btn-default">
                                                        <span class="glyphicon glyphicon-floppy-disk"></span> Guardar</button>
                                                    </div>

                                                    <div class="col-md-2">
                                                        <a class="btn btn-primary" href="#" role="button" style="color: white">
                                                        <span class="glyphicon glyphicon-home"></span> Salir</a>
                                                    </div>
                                                </div>
                                            </div>
                                            </form>
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
