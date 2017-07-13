$(document).ready(function () {
    $('#txtFacBol').attr('disabled', 'disabled');
    $('#txtModelo').attr('disabled', 'disabled');
    $('#txtPrecio').attr('disabled', 'disabled');
    
    $('#ddltipDoc').change(function(){
        if ($("#ddltipDoc").val() == '1'){
            $("#txtFacBol").val('FACTURA DE VENTA'); 
        }else if($("#ddltipDoc").val()== '2'){
            $("#txtFacBol").val('BOLETA DE VENTA'); 
        };  
    });
    
    $('#ddlMarca').change(function(){
        $('#txtModelo').removeAttr('disabled');
        alert($('#ddlMarca').val());
    });     

    FiltrarNombresRazSoc();
    function FiltrarNombresRazSoc(){
        $("#txtcli").autocomplete({
                source : function(request, response) {
                    $.ajax({
                        url : '../ServletClienteListarNombresRazSoc',
                        type : 'POST',
                        datatype: 'JSON',
                        data: {Nombres_RazSoc: $('#txtcli').val()},
                        success: function(data) {
                        //alert(data);
                        //alert(JSON.stringify(data));
                        //console.log(data);
                        var json = eval('('+data+')');
                        //alert(json);
                        response($.map(json, function (item) {
                                return {
                                        label: item.NOMBRES_RAZSOC,
                                        value: item.ID_CLIENTE,
                                        DniRuc: item.DNIRUC,
                                        Direc: item.DIRECCION
                                };
			}));
                        },
                        error: function(jqXHR, textStatus, errorThrown){
                        alert("error ==>" + jqXHR.statusText); 
                        alert(textStatus);
                        alert("excepcion ==>" + errorThrown);     
                        console.log( textStatus);
                        }
                    });
                },
                minLength: 1,
                scroll: true,
                highlight: false,
                focus: function(event, ui) {
                    // prevent autocomplete from updating the textbox
                    event.preventDefault();
                    // manually update the textbox
                    $('#txtcli').val(ui.item.label);
                    return false;
                },
                // Once a value in the drop down list is selected, do the following:
                select: function(event, ui) {
                    // prevent autocomplete from updating the textbox
                    event.preventDefault();
                    // place the person.given_name value into the textfield called 'select_origin'...
                    $('#txtcli').val(ui.item.label);
                    // and place the person.id into the hidden textfield called 'link_origin_id'. 
                    $('#txtCodigo').val(ui.item.value);
                    $('#txtDniRuc').val(ui.item.DniRuc);
                    $('#txtDireccion').val(ui.item.Direc);
                    return false;
                },
                open: function() {
                    $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
                },
                close: function() {
                    $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
                }
        });    
    }
    
    LlenarComboMarcas();
    function LlenarComboMarcas(){
        $.ajax({
            url: '../ServletMarcaListarTodosdll',
            type: 'POST',
            datatype: 'JSON',
            error: function(jqXHR, textStatus, errorThrown){ 
                //alert("error ==>" + jqXHR.statusText); 
                //alert(textStatus);
                //alert("excepcion ==>" + errorThrown); 
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
            var combo = document.getElementById("ddlMarca");
            combo.options[0] = new Option('Selecciona un item', '');
                for(var i=0;i<json.length;i++){
                        combo.options[combo.length] = new Option(json[i].NOMBRE, json[i].ID_MARCA);
                    }
                }
        });
        
    }
    
});

function addAutomovil(e) {
    e.preventDefault();
    const row = createRow({
        MARCA: $('#ddlMarca option:selected').text(),
        MODELO: $('#txtModelo').val(),
        PRECIO: $('#txtPrecio').val(),
        CANTIDAD: $('#txtCantidad').val(),
        IGV: 0.18*$('#txtPrecio').val(),
        IMPORTE: parseInt($('#txtPrecio').val())+ parseInt(0.18*$('#txtPrecio').val()),
        OPCIONES: "<a class='btn btn-primary btn-sm' href='#' role='button'><span class='glyphicon glyphicon-plus'></span></a>"+
                " "+"<a class='btn btn-primary btn-sm' href='#' role='button'><span class='glyphicon glyphicon-minus'></span></a>"+
                " "+"<a class='btn btn-primary btn-sm borrar' href='#' role='button' id='btnBorrar'><span class='glyphicon glyphicon-trash'></span></a>"
    });
    $('#tblventas tbody').append(row);
    clean();
}

function createRow(data) {
    //alert(data);
  return (
    `<tr>` +
      `<td>${$('tbody tr').length + 1}</td>` +
      `<td>${data.MARCA}</td>` +
      `<td>${data.MODELO}</td>` +
      `<td>${data.PRECIO}</td>` +
      `<td>${data.CANTIDAD}</td>` +
      `<td>${data.IGV}</td>` +
      `<td>${data.IMPORTE}</td>` +
      `<td>${data.OPCIONES}</td>` +
    `</tr>`
  );
}

function clean() {
  $('#txtCodAutom').val('');
  $('#txtModelo').val('');
  $('#txtPrecio').val('');
  $('#txtCantidad').val('');
  $("#ddlMarca option[value=2]").attr("selected", "selected");
  //$('#txtCantidad').focus();
}

$(function () {
    $(document).on('click', '.borrar', function (event) {
        event.preventDefault();
        $(this).closest('tr').remove();
    });
});
