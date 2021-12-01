<%-- 
    Document   : listar
    Created on : 1 dic. 2021, 10:55:41
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Futbolistas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <div class="container"">
            <h1>Listado de Futbolistas </h1>
            <a class="btn btn-primary" href="Servlet?op=insertar">Nuevo Producto</a>
            <%
                List<Futbolistas> listaFutbolistas = (List<Futbolistas>) request.getAttribute("listado");
                String mensaje = (String) request.getAttribute("mensaje");
                
            %>
            <h2 class="alert alert-success"><%=mensaje%></h2>
            <table class="table table-bordered table-dark">
                <% for (Futbolistas f : listaFutbolistas) { %>
                <tr>
                    <td> <%= f.getId()%></td>
                    <td> <%= f.getNombre()%> </td>
                    <td> <%= f.getApellidos()%>  </td>
                    <td> <%= f.getDorsal()%></td>
                    <td> <%= f.getEquipo()%></td>
                    <td><a href="Servlet?op=borrar&id=<%=f.getId()%>" onclick="return Confirmation()">Borrar</a></td>
                    <td><a href="Servlet?op=actualizar&id=<%=f.getId()%>">Actualizar</a></td>
                </tr>          
                <% }%>
            </table>
            
            <script>
                function Confirmation() {
                    if (confirm("Esta seguro/a de que \n\
                            quiere eliminar el producto?")) {
                        alert("El registro se eliminará");
                        return true;
                    } else {
                        return false;
                    }
                }
            </script>
    </body>
</html>
