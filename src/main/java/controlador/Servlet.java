/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Crud;
import modelo.Futbolistas;

/**
 *
 * @author DAW-A
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = "listar";
        if (request.getParameter("op") != null) {
            op = request.getParameter("op");
        }
        if (op.equals("insertar")) {

            request.setAttribute("operacion", "insertardatos");
            request.setAttribute("mensaje", "");
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);

        }
        if (op.equals("listar")) {
            listar(request, response);
        }
        if (op.equals("insertar")) {

            request.setAttribute("operacion", "insertardatos");
            request.setAttribute("mensaje", "");
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);

        }
        if (op.equals("borrar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (Crud.destroyFutbolistas(id) > 0) {
                request.setAttribute("mensaje", "Producto on id " + id + " Borrado");
            } else {
                request.setAttribute("mensaje", "No se ha borrado ningun producto");
            }
            this.listar(request, response);
        }
        if (op.equals("actualizar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Futbolistas miFutbolista = Crud.getFutbolista(id);
            request.setAttribute("operacion", "actualizardatos");
            request.setAttribute("futbolista", miFutbolista);
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);

        }
        if (op.equals("actualizardatos")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellidos");
            int dorsal = Integer.parseInt(request.getParameter("dorsal"));
            String equipo = request.getParameter("equipo");

            Futbolistas miFutbolistas = new Futbolistas(id, nombre, apellido, dorsal, equipo);
            if (Crud.actualizaFutbolistas(miFutbolistas) > 0) {
                request.setAttribute("mensaje", "Futbolista on id " + id + " actualizado");
            } else {
                request.setAttribute("mensaje", "Futbolista no actualizado");
            }
            request.setAttribute("futbolista", miFutbolistas);
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);

        }
        if (op.equals("insertardatos")) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellidos");
            int dorsal = Integer.parseInt(request.getParameter("dorsal"));
            String equipo = request.getParameter("equipo");

            Futbolistas miFutbolista = new Futbolistas();
            miFutbolista.setNombre(nombre);
            miFutbolista.setApellidos(apellido);
            miFutbolista.setDorsal(dorsal);
            miFutbolista.setEquipo(equipo);
            this.listar(request, response);
            Crud.insertaFutbolista(miFutbolista);
        }

    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Futbolistas> listaFutbolistas = Crud.getFutbolistas();

        request.setAttribute("listado", listaFutbolistas);
        request.setAttribute("mensaje", "");
        request.getRequestDispatcher("listar.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
