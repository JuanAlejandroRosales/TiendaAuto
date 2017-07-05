<%-- 
    Document   : vendedorListado
    Created on : 31-mar-2015, 20:02:22
    Author     : alumno
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado</title>
    </head>
    <body>
        <h1>Vendedor listado</h1>
        <table>            
            <tbody>
                <c:forEach var="var" items="${requestScope.lista}">
                    <tr>
                        <td>${var.id}</td>
                        <td>${var.codigo}</td>
                        <td>${var.nombre}</td>                                    
                    </tr>
                </c:forEach>                                
            </tbody>
        </table>

    </body>
</html>
