<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%  
    String strUsuario = "";
    HttpSession sesionOk = request.getSession();

    if (sesionOk.isNew())
    {
        request.getRequestDispatcher("../index.jsp").forward(request, response);
      //  response.sendRedirect("login.jsp");
        return;
    }
    
    if (sesionOk == null)
    {
        request.getRequestDispatcher("../index.jsp").forward(request, response);
       // response.sendRedirect("login.jsp");
    }
    else
    {
        if (sesionOk.getAttribute("strUsuario") == null)
        {
            request.getRequestDispatcher("../index.jsp").forward(request, response);
            //response.sendRedirect("login.jsp");
        }else {
        strUsuario = (String)sesionOk.getAttribute("strUsuario");
    }
    }

%>


