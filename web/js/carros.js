//<![CDATA[
/*global $ */
/*jslint browser: true */
$(function () {
    
    $('#bt1').removeClass('active');
    $('#bt2').removeClass('active');
    $('#bt3').removeClass('active');
    $('#bt4').removeClass('active');
    
    $('#datetimepicker1').datetimepicker({
        format: 'DD/MM/YYYY',
        locale: 'es'
    });
    
    $.jgrid = $.jgrid || {};
    $.jgrid.no_legacy_api = true;
        
    "use strict";
    var mydata = [
            { id: "A001",  Marca: "Hyundai", Modelo: "Corolla",Color: "blanco", Precio: "$20 000", Stock: "54", Estado: "Activo"},
            { id: "A002",  Marca: "Toyota",  Modelo: "Yaris",  Color: "plomo",  Precio: "$50 000", Stock: "45", Estado: "Activo"},
            { id: "A003",  Marca: "Nissan",  Modelo: "RAV 4",  Color: "rojo",   Precio: "$45 000", Stock: "50", Estado: "Activo"}
                
    ],
    $grid = $("#listar"),
    initDateEdit = function (elem) {
        $(elem).datepicker({
            dateFormat: "dd-M-yy",
            autoSize: true,
            changeYear: true,
            changeMonth: true,
            showButtonPanel: true,
            showWeek: true
        });
    },
    initDateSearch = function (elem) {
        setTimeout(function () {
            initDateEdit(elem);
        }, 100);
    };

    $grid.jqGrid({
        data: mydata,
        colNames: ["Código", "Marca", "Modelo", "Color", "Precio", "Stock", "Estado", "Opciones"],
        colModel: [
            { name: "id", align: "center", width: 92, editrules: {required: true} },
            { name: "Marca", align: "center", width: 92, editrules: {required: true} },
            { name: "Modelo", align: "center", width: 92, editrules: {required: true} },
            { name: "Color", align: "center", width: 92, editrules: {required: true} },
            { name: "Precio", align: "center", width: 92,editrules: {required: true} },
            { name: "Stock", align: "center", width: 92, template: "number", editrules: {required: true} },
            { name: "Estado", align: "center", width: 92, editrules: {required: true} },
            { name: "act", template: "actions", align: "left", width: 65 },
        ],
        cmTemplate: { editable: true, autoResizable: true },
        iconSet: "fontAwesome",
        rowNum: 10,
        autoResizing: { compact: true },
        rowList: [5, 10, 20, "10000:All"],
        viewrecords: true,
        pager: true,
        toppager: true,
        inlineEditing: { keys: true, position: "afterSelected" },
        rownumbers: true,
        sortname: "invdate",
        sortorder: "desc",
        caption: "Lista de Automoviles"
            
    }).jqGrid("gridResize");
        
    $('.nav li a').click(function (e) {
  
        var $parent = $(this).parent();
        document.cookie = eraseCookie("bt");
        document.cookie = createCookie("bt", $parent.attr('id'),0);
    });
     
    $().ready(function () {
        var $activeBt = readCookie("bt");
        if (!$activeBt =="") {
        $('#bt1').removeClass('active');
        }
        //alert($activeBt.toString());
       
        $('#'+$activeBt).addClass('active');
    });
    
    var marca = $('#txtIdMarca').val();
    $("#marcas option[value="+ marca +"]").attr("selected",true);
    
    var value = $('#txtvalue').val();
    $("#ddlTamPag option[value="+ value +"]").attr("selected",true);
    //alert(value);
    
});
//]]>
    
function hideOther() {
  var selectBox = document.getElementById("ddlTamPag");
  var selectedValue = selectBox.options[selectBox.selectedIndex].value;
  //alert(selectedValue);
  x = selectedValue;
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