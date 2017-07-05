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
                                    <h3 class="panel-title"><span class="glyphicon glyphicon-briefcase"></span> REALIZAR VENTAS</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-7">
                                            <div class="row">
                                                <div class="col-md-1 col-md-offset-1">
                                                    <h5><b>Dni:</b></h5>
                                                </div>
                                                <div class="col-md-4">
                                                    <input type="text" class="form-control" placeholder="">
                                                </div>
                                                <div class="form-group col-md-5">
                                                    <div class="inner-addon left-addon">
                                                        <i class="glyphicon glyphicon-search"></i>
                                                        <input type="text" class="form-control" placeholder="Buscar Cliente" />
                                                    </div>
                                                </div>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-md-2 col-md-offset-1">
                                                    <h5><b>Cliente:</b></h5>
                                                </div>
                                                <div class="col-md-6">
                                                    <input type="text" class="form-control" placeholder="">
                                                </div>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-md-2 col-md-offset-1">
                                                    <h5><b>Dirección:</b></h5>
                                                </div>
                                                <div class="col-md-7">
                                                    <input type="text" class="form-control" placeholder="">
                                                </div>
                                            </div>
                                            <br>
                                            <div class="row">
                                                <div class="col-md-1 col-md-offset-1">
                                                    <h5><b>Tipo:</b></h5>
                                                </div>
                                                <div class="col-md-3">
                                                    <select class="form-control">
                                                        <option>Natural</option>
                                                        <option>Juridica</option>
                                                    </select>
                                                </div>
                                                <div class="col-md-2" style="width:80px">
                                                    <h5><b>Fecha:</b></h5>
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
                                                        <div class="col-md-7 col-md-offset-3">
                                                            <h4><b>BOLETA DE VENTA</b></h4>
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
                        <div class="col-md-12">
                            <div class="panel panel-primary">
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-1 col-md-offset-1">
                                            <h5><b>Marca:</b></h5>
                                        </div>
                                        <div class="col-md-2">
                                            <select class="form-control">
                                                <option>Seleccione</option>
                                                <option>Toyota</option>
                                            </select>
                                        </div>
                                        <div class="col-md-1 col-md-offset-1">
                                            <h5><b>Modelo:</b></h5>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" placeholder="">
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-md-1 col-md-offset-1">
                                            <h5><b>Precio:</b></h5>
                                        </div>
                                        <div class="col-md-2">
                                            <input type="text" class="form-control" placeholder="">
                                        </div>
                                        <div class="col-md-1 col-md-offset-1">
                                            <h5><b>Cantidad:</b></h5>
                                        </div>
                                        <div class="col-md-2">
                                            <input type="text" class="form-control" placeholder="">
                                        </div>
                                        <div class="col-md-2 col-md-offset-1">
                                            <button class="btn btn-primary" type="submit">
                                            <span class="glyphicon glyphicon-shopping-cart"></span> Agregar al Carrito</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
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
    </body>
</html>
