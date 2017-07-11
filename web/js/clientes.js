$(document).ready(function () {
    
    $( "#tabtipcli" ).tabs();
    $( "input[type='radio']" ).checkboxradio();

    LlenarComboDepartamentos();
    
    $('#ddlDep').change(function(){
        SeleccionandoDepartamento(this, "ddlProv");  
    });
    
    $('#ddlProv').change(function(){
        SeleccionandoProvincia(this, "ddlDist", "ddlDep");
    });    
    
    $('#ddlPais').change(function(){
        //alert($('#ddlPais').val());  
    });
    
    
    
    function LlenarComboDepartamentos(){
        $.ajax({
            url: 'ServletUbigeoListarDepertamentosdll',
            type: 'POST',
            datatype: 'JSON',
            error: function(jqXHR, textStatus, errorThrown){ 
                alert("error ==>" + jqXHR.statusText); 
                alert(textStatus);
                alert("excepcion ==>" + errorThrown); 
            }, 
            statusCode: {
                404: function() {
                    console.log('Pagina NO encontrada');
                },
                500: function(){
                    console.log('Error en el servidor');
                }
            },
            success:function(r){
            //alert(JSON.stringify(r));
            var json = eval('('+r+')');
            var combo = document.getElementById("ddlDep");
            combo.options[0] = new Option('Selecciona un item', '');
                for(var i=0;i<json.length;i++){
                        combo.options[combo.length] = new Option(json[i].DEPARTAMENTO, json[i].ID_UBIGEO);
                    }
                }
        });
        
    }
    
    function LimpiarCombo(combo){
        while(combo.length > 0){
            combo.remove(combo.length-1);
        }
    }
    
    function LlenarCombo(json, combo){
        combo.options[0] = new Option('Selecciona un item', '');
        for(var i=0;i<json.length;i++){
            combo.options[combo.length] = new Option(json[i].PROVINCIA, json[i].ID_UBIGEO);
        }
    
    }
    
    function LlenarComboDist(json, combo){
        combo.options[0] = new Option('Selecciona un item', '');
        for(var i=0;i<json.length;i++){
            combo.options[combo.length] = new Option(json[i].DISTRITO, json[i].ID_UBIGEO);
        }
    
    }    
    
    function SeleccionandoDepartamento(combo1, combo2){
        combo2 = document.getElementById(combo2); 
        LimpiarCombo(combo2);
        if(combo1.options[combo1.selectedIndex].value != ""){
                combo1.disabled = true;
                combo2.disabled = true;
                $.ajax({
                        type: 'POST',
                        dataType: 'JSON',
                        url: 'ServletUbigeoListarProvinciasdll',
                        data: {IDDep: combo1.options[combo1.selectedIndex].value},
                        error: function(jqXHR, textStatus, errorThrown){ 
                            alert("error ==>" + jqXHR.statusText); 
                            alert(textStatus);
                            alert("excepcion ==>" + errorThrown); 
                        }, 
                        statusCode: {
                            404: function() {
                                console.log('Pagina NO encontrada');
                            },
                            500: function(){
                                console.log('Error en el servidor');
                            }
                        },
                        success: function(r){
                                console.log(r);
                                //alert(JSON.stringify(r));
                                //var json = eval('('+r+')');
                                LlenarCombo(r, combo2);
                                combo1.disabled = false;
                                combo2.disabled = false;
                        }
                });
        }
    }
    
    function SeleccionandoProvincia(comboProv, comboDist, comboDep){
        comboDep = document.getElementById(comboDep);
        comboDist = document.getElementById(comboDist);
        LimpiarCombo(comboDist);
        if(comboDep.options[comboDep.selectedIndex].value != "" && 
            comboProv.options[comboProv.selectedIndex].value != ""){
                comboDep.disabled = true;
                comboProv.disabled = true;
                comboDist.disabled = true;
                $.ajax({
                        type: 'POST',
                        dataType: 'JSON',
                        url: 'ServletUbigeoListarDistritosdll',
                        data: { IDDep: comboDep.options[comboDep.selectedIndex].value,
                                IDProv: comboProv.options[comboProv.selectedIndex].value},
                        error: function(jqXHR, textStatus, errorThrown){ 
                            alert("error ==>" + jqXHR.statusText); 
                            alert(textStatus);
                            alert("excepcion ==>" + errorThrown); 
                        }, 
                        statusCode: {
                            404: function() {
                                console.log('Pagina NO encontrada');
                            },
                            500: function(){
                                console.log('Error en el servidor');
                            }
                        },
                        success: function(r){
                                console.log(r);
                                //alert(JSON.stringify(r));
                                //var json = eval('('+r+')');
                                LlenarComboDist(r, comboDist);
                                comboDep.disabled = false;
                                comboProv.disabled = false;
                                comboDist.disabled = false;
                        }
                });
        }
    }     
});
