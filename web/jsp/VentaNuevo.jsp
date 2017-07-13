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
                        <div class="col-md-12">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title"><span class="glyphicon glyphicon-briefcase"></span> VENTA - NUEVO REGISTRO DE VENTA</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-7">
                                            <div class="row">
                                                <div class="col-md-2 col-md-offset-1" style="width: 100px">
                                                    <label for="lblDniRuc">DNI / RUC:</label>
                                                </div>
                                                <div class="col-md-4">
                                                    <input type="text" class="form-control" placeholder="" name="txtDniRuc" id="txtDniRuc"/>
                                                </div>
                                                <div class="col-md-2" style="width: 80px">
                                                    <label for="lblCodigo">CÓDIGO:</label>
                                                </div>
                                                <div class="col-md-3">
                                                    <input type="text" class="form-control" placeholder="" name="txtCodigo" id="txtCodigo"/>
                                                </div>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-md-2 col-md-offset-1" style="width: 100px">
                                                    <label for="lblCliente">CLIENTE:</label>
                                                </div>
                                                <div class="form-group col-md-7">
                                                    <div class="inner-addon left-addon">
                                                        <i class="glyphicon glyphicon-search"></i>
                                                        <input type="text" class="form-control" placeholder="Buscar Cliente" name="txtcli" id="txtcli"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-2 col-md-offset-1" style="width: 100px">
                                                    <label for="lblCliente">DIRECCIÓN:</label>
                                                </div>
                                                <div class="col-md-7">
                                                    <input type="text" class="form-control" placeholder="" name="txtDireccion" id="txtDireccion">
                                                </div>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-md-4 col-md-offset-1" style="width: 180px; background-position: center">
                                                    <label for="lbltipDoc">TIPO DOCUMENTO:</label>
                                                </div>
                                                <div class="col-md-5" style="margin-left: 10px">
                                                    <select class="form-control" name="ddltipDoc" id="ddltipDoc">
                                                        <option value="0" selected="selected">Selecciona un item</option>
                                                        <option value="1">FACTURA DE VENTA</option>
                                                        <option value="2">BOLETA DE VENTA</option>
                                                    </select>
                                                </div>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-md-2 col-md-offset-1" style="width:100px">
                                                    <label for="lblFecha">FECHA:</label>
                                                </div>
                                                <div class="col-md-4">
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
                                        <div class="col-md-5">
                                            <div class="panel panel-primary">
                                                <div class="panel-body">
                                                    <div class="row">
                                                        <div class="col-md-7 col-md-offset-3">
                                                            <h4><b>RUC 20395834584</b></h4>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-7 col-md-offset-1">
                                                            <input type="text" placeholder="" name="txtFacBol" id="txtFacBol" style="font-size: 2em; text-align: center" value=""/>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-2 col-md-offset-2">
                                                            <h4><b>Serie</b></h4>
                                                        </div>
                                                        <div class="col-md-6 col-md-offset-1">
                                                            <h4><b>N Comprobante</b></h4>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-md-3 col-md-offset-2">
                                                            <input type="text" class="form-control" placeholder="">
                                                        </div>
                                                        <div class="col-md-6">
                                                            <input type="text" class="form-control" placeholder="">
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
                    
                    <div class="row">
                        <form onsubmit="addAutomovil(event)">
                            <div class="col-md-12">
                                <div class="panel panel-primary">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-md-2" style="width: 80px ;margin-left: 80px">
                                                <label for="lblCodAutom">CÓDIGO:</label>
                                            </div>
                                            <div class="col-md-2">
                                                <input type="text" class="form-control" placeholder="" name="txtCodAutom" id="txtCodAutom"/>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-md-1" style="margin-left: 80px">
                                                <label for="lblMarca">MARCA:</label>
                                            </div>
                                            <div class="col-md-3" style="width: 200px">
                                                <select class="form-control" name="ddlMarca" id="ddlMarca">

                                                </select>
                                            </div>
                                            <div class="col-md-1">
                                                <label for="lblModelo">MODELO:</label>
                                            </div>
                                            <div class="col-md-6" style="margin-left: 20px">
                                                <input type="text" class="form-control" placeholder="" name="txtModelo" id="txtModelo">
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <div class="col-md-1 col-md-offset-1">
                                                <label for="lblPrecio">PRECIO:</label>
                                            </div>
                                            <div class="col-md-2">
                                                <input type="text" class="form-control" placeholder="" name="txtPrecio" id="txtPrecio">
                                            </div>
                                            <div class="col-md-1" style="margin-left: 42px">
                                                <label for="lblCantidad">CANTIDAD:</label>
                                            </div>
                                            <div class="col-md-2" style="margin-left: 22px">
                                                <input type="text" class="form-control" placeholder="" name="txtCantidad" id="txtCantidad">
                                            </div>
                                            <div class="col-md-2 col-md-offset-1">
                                                <button class="btn btn-primary" type="submit" id="btnCarrito" name="btnCarrito">
                                                <span class="glyphicon glyphicon-shopping-cart"></span> Agregar al Carrito</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>    
                    </div>
                    
                    <div class="row">
                        <div class="col-md-12">
                            <%@include file="/WEB-INF/jspf/ventas.jspf" %>
                        </div>
                    </div>
                        
                    <div class="row">
                        <div class="col-md-4">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-12 col-md-offset-3">
                                            <h4><b>SUBTOTAL</b></h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-12 col-md-offset-4">
                                            <h4><b>IGV</b></h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>  
                        <div class="col-md-4">
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-12 col-md-offset-4">
                                            <h4><b>TOTAL</b></h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <input type="text" class="form-control" placeholder="">
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" placeholder="">
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" placeholder="">
                        </div>
                    </div>
                    <br>    
                    <div class="row">
                        <div class= "col-md-2 col-md-offset-9">
                            <p>
                                <button class="btn btn-primary btn-lg" type="submit">
                                <span class="glyphicon glyphicon-floppy-saved"></span>> Registrar Venta</button>
                            </p>
                        </div>
                    </div>    
                </div> 
            </div>
        <%@include file="/WEB-INF/jspf/foot.jspf" %> 
        </div>
        <%@include file="/WEB-INF/jspf/js2.jspf" %>
        <script src="../js/venta.js" type="text/javascript"></script>
    </body>
</html>
