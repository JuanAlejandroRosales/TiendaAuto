
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema - Inicio</title>      
        <%@include file="/WEB-INF/jspf/css.jspf" %>
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
                    <div class="bs-docs-example">
                        <div class="container">
                            <div class="span5">
                                <div class="row">
                                    <div class= "span1 offset1">
                                        <label for="Name"><b>Marca:</b></label>
                                    </div>
                                    <div class= "span2">
                                        <select name="marca" id="marca">
                                            <option>Toyota</option>
                                            <option>Nissan</option>
                                            <option selected="selected">Hyundai</option>
                                            <option>Volvo</option>
                                            <option>Kia</option>
                                        </select>
                                    </div>
                                </div>
                            
                                <div class="row">
                                    <div class= "span1 offset1">
                                        <label for="Name"><b>Modelo:</b></label>
                                    </div>
                                    <div class= "span2">
                                        <p><input type="text" name="login" value="" placeholder=""></p>
                                    </div>
                                </div>
                            
                                <div class="row">
                                    <div class= "span1 offset1">
                                        <label for="Name"><b>Color:</b></label>
                                    </div>
                                    <div class= "span2">
                                        <p><input type="text" name="login" value="" placeholder=""></p>
                                    </div>
                                </div>
                            
                                <div class="row">
                                    <div class= "span1 offset1">
                                        <label for="Name"><b>Precio:</b></label>
                                    </div>
                                    <div class= "span2">
                                        <p><input type="text" name="login" value="" placeholder=""></p>
                                    </div>
                                </div>
                            
                                <div class="row">
                                    <div class= "span1 offset1">
                                        <label for="Name"><b>Stock:</b></label>
                                    </div>
                                    <div class= "span2">
                                        <p><input type="text" name="login" value="" placeholder=""></p>
                                    </div>
                                </div>
                            </div>
                            <div class="span4">
                                <div class="row">
                                    <input type="file" id="files" name="files[]" />
                                    <output id="list"></output>    
                                </div>
                                <div class="row">
                                    <div class="bs-docs-imagen">
                                        <br><br><br><br><br><br><br><br>
                                        <output id="list"></output>
                                    </div>
                                </div>
                            </div>
                        </div>                        
                    </div>
                <!--Body content Fin-->
                </div>
            </div>
            <%@include file="/WEB-INF/jspf/foot.jspf" %>        
        </div> 
        <%@include file="/WEB-INF/jspf/js.jspf" %>
    </body>
</html>

