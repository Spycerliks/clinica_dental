/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.PacienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Paciente;
import modelo.Usuario;

/**
 *
 * @author matias
 */
public class agregarPaciente extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet agregarPaciente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet agregarPaciente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);
        HttpSession s = request.getSession();
        Usuario u = (Usuario) s.getAttribute("usuario");

        if (u == null) {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("WEB-INF/agregarPaciente.jsp").forward(request, response);
        }
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
        //processRequest(request, response);
        HttpSession s = request.getSession();
        Usuario u = (Usuario) s.getAttribute("usuario");

        if (u == null) {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        } else {
            String rut = request.getParameter("rut");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");
            
            Paciente p = new Paciente();
            
            p.setRut(rut);
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setDireccion(direccion);
            p.setTelefono(Integer.parseInt(telefono));
            p.setEmail(email);

            PacienteDAO pDAO = new PacienteDAO();
            
            try {
                pDAO.insertar(p);
                request.setAttribute("mensaje", "Se ha ingresado el paciente");
                request.getRequestDispatcher("WEB-INF/agregarPaciente.jsp").forward(request, response);
            } catch (SQLException ex) {
                ex.getStackTrace();
                request.setAttribute("mensaje", "No se ha ingresado el paciente");
            } catch (NamingException ex) {
                Logger.getLogger(agregarPaciente.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", "No se ha ingresado el paciente");
            }
        }
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
