$(document).ready(function () {
 
    $('#bt0').removeClass('active');
    $('#bt1').removeClass('active');
    $('#bt2').removeClass('active');
    $('#bt3').removeClass('active');
    $('#bt4').removeClass('active');
    $('#bt5').removeClass('active');
    $('#bt6').removeClass('active');
    $('#bt7').removeClass('active');
    $('#bt8').removeClass('active');
    
    $('#datetimepicker1').datetimepicker({
        format: 'DD/MM/YYYY',
        locale: 'es'
    });
    
    $("#grid").jqGrid({
        datatype: function () {
            $.ajax({
                url: 'ServletGrid',
                dataType: "json",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                complete: function (jsondata, stat) {
                    if (stat == "success")
                        jQuery("#grid")[0].addJSONData(JSON.parse(jsondata.responseText));
                    else
                        alert(JSON.parse(jsondata.responseText).Message);
                }
            });
        },
        jsonReader: {
            root: "rows",
            page: "page",
            total: "total",
            records: "records",
            repeatitems: true,
            cell: "cell",
            id: "id"
           /* subgrid: {
                root: "Items",
                repeatitems: true,
                cell: "Row"
            }*/
        },
        colNames: ['Departamentos'],
        colModel: [{ index: 'deps', width: 300, align: 'Center', name: 'Departamentos', editable: true, editoptions: { readonly: false, size: 20 },
        formoptions: { label: "Departamentos", elmprefix: "(*)" }, editrules: { required: true } }],
            pager: "#pager", 
            loadtext: 'Cargando datos...',
            recordtext: "{0} - {1} de {2} elementos",
            emptyrecords: 'No hay resultados',
            pgtext: 'Pág: {0} de {1}', 
            rowNum: "10", // PageSize.
            rowList: [10, 20, 30], //Variable PageSize DropDownList.
            viewrecords: true, //Show the RecordCount in the pager.
            multiselect: true,
            sortname: "Name", //Default SortColumn
            sortorder: "asc", //Default SortOrder.
            width: "750",
            height: "300",
            loadonce: true,
            caption: "Administrar Departamentos"
    });

    jQuery("#grid").jqGrid('navGrid', '#pager', { edit: true, add: true, search: false, del: true }, null, { url: '../Handlers/ManejadorDeEstados.ashx', mtype: 'get' },
    { width: 500, url: 'Handler1.ashx', mtype: 'get' });
    
    $('.nav li a').click(function (e) {
        var $parent = $(this).parent();
        document.cookie = eraseCookie("bt");
        document.cookie = createCookie("bt", $parent.attr('id'),0);
    });

    $().ready(function () {
        var $activeBt = readCookie("bt");
        $('#'+$activeBt).removeClass('active');
        if (!$activeBt=="") {
            $('#bt0').removeClass('active');
            $('#bt1').removeClass('active');
            $('#bt2').removeClass('active');
            $('#bt3').removeClass('active');
            $('#bt4').removeClass('active');
            $('#bt5').removeClass('active');
            $('#bt6').removeClass('active');
            $('#bt7').removeClass('active');
            $('#bt8').removeClass('active');
        }
        //alert($activeBt.toString());
       
        $('#'+$activeBt).addClass('active');
    });
    
    var value = $('#txtvalue').val();
    $('#ddlTamPag').removeClass('selected');
    $("#ddlTamPag option[value="+ value +"]").attr("selected", "selected");

  
    var marca = $('#txtIdMarca').val();
    $("#marcas option[value="+ marca +"]").attr("selected",true);
    
    LlenarComboMarcas();
    function LlenarComboMarcas(){
        $.ajax({
            url: 'ServletMarcaListarTodosdll',
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

    FiltrarModelos();
    function FiltrarModelos(){
        $("#txtModelo").autocomplete({
                source : function(request, response) {
                    $.ajax({
                        url : '../ServletClienteListarModelos',
                        type : 'POST',
                        datatype: 'JSON',
                        data: { ID_MARCA: $('#ddlMarca').val(),
                                MODELO: $('#txtModelo').val()
                        },
                        success: function(data) {
                        //alert(data);
                        //alert(JSON.stringify(data));
                        //console.log(data);
                        var json = eval('('+data+')');
                        //alert(json);
                        response($.map(json, function (item) {
                                return {
                                        label: item.MODELO,
                                        value: item.ID_AUTOMOVIL,
                                        ID_AUTOMOVIL: item.ID_AUTOMOVIL,
                                        PRECIO: item.PRECIO
                                };
			}));
                        },
                        error: function(jqXHR, textStatus, errorThrown){
                        //alert("error ==>" + jqXHR.statusText); 
                        //alert(textStatus);
                        //alert("excepcion ==>" + errorThrown);     
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
                    $('#txtModelo').val(ui.item.label);
                    return false;
                },
                // Once a value in the drop down list is selected, do the following:
                select: function(event, ui) {
                    // prevent autocomplete from updating the textbox
                    event.preventDefault();
                    // place the person.given_name value into the textfield called 'select_origin'...
                    $('#txtcli').val(ui.item.label);
                    // and place the person.id into the hidden textfield called 'link_origin_id'. 
                    $('#txtCodAutom').val(ui.item.value);
                    $('#txtPrecio').val(ui.item.PRECIO);
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
  
});
//]]>
    
function hideOther() {
}


function archivo(evt) {
    var files = evt.target.files; // FileList object
		
    // Obtenemos la imagen del campo "file".
    for (var i = 0, f; f = files[i]; i++) {
        //Solo admitimos imágenes.
        if (!f.type.match('image.*')) {
            continue;
        }
		
    var reader = new FileReader();
		
    reader.onload = (function(theFile) {
    return function(e) {
    // Insertamos la imagen
        document.getElementById("list").innerHTML = ['<img class="thumb" src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
    };
    })(f);
		
    reader.readAsDataURL(f);
    }
}
document.getElementById('files').addEventListener('change', archivo, false);

function createCookie(name, value, days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        var expires = "; expires=" + date.toGMTString();
    }
    else var expires = "";

    document.cookie = name + "=" + value + expires + "; path=/";
}

function readCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') c = c.substring(1, c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
    }
    return null;
}

function eraseCookie(name) {
    createCookie(name, "", -1);
}