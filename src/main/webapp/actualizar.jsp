<%-- 
    Document   : actualizar
    Created on : 1 dic. 2021, 11:33:13
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <h1>Futbolista</h1>
        <%
           String mensaje = ( String ) request.getAttribute("mensaje");
           String operacion = ( String ) request.getAttribute("operacion");
           if ( mensaje!=null) out.println(mensaje);
         %>
        
        <form action="Servlet">
            <input type="text" value="<%=operacion%>" name="op">           
            <p>ID:<input type="text" value="${futbolista.id()}" name="id" readonly></p>
            <p>Nombre:<input type="text" value="${futbolista.nombre}" name="nombre"></p>
            <p>Apellidos:<input type="text" value="${futbolista.apellido}" name="apellidos"></p>
            <p>Dorsal:<input type="text" value="${futbolista.dorsal}" name="dorsal"></p>
            <p>Equipo:<input type="text" value="${futbolista.equipo}" name="equipo"></p>
            
            <input type="submit" value="Actualizar producto">
            <a href="listar.jsp">listar</a>
        </form>
    </body>
</html>
