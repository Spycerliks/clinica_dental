/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.AtencionDAO;
import DAO.DentistaDAO;
import DAO.PacienteDAO;
import DAO.TratamientoDAO;
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
import modelo.Atencion;
import modelo.Usuario;

/**
 *
 * @author matias
 */
public class modificarAtencion extends HttpServlet {

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
            out.println("<title>Servlet modificarAtencion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet modificarAtencion at " + request.getContextPath() + "</h1>");
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
            String id = request.getParameter("id");
            AtencionDAO aDAO = new AtencionDAO();
            PacienteDAO pDAO = new PacienteDAO();
            DentistaDAO dDAO = new DentistaDAO();
            TratamientoDAO tDAO = new TratamientoDAO();
            
            try {
                request.setAttribute("atencion", aDAO.findById(Integer.parseInt(id)));
                request.setAttribute("pacs", pDAO.listarPaciente());
                request.setAttribute("dens", dDAO.listarDentista());
                request.setAttribute("trats", tDAO.listarTratamiento());
                
                request.getRequestDispatcher("WEB-INF/modificarAtencion.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            AtencionDAO aDAO = new AtencionDAO();
            PacienteDAO pDAO = new PacienteDAO();
            DentistaDAO dDAO = new DentistaDAO();
            TratamientoDAO tDAO = new TratamientoDAO();
            
            String id = request.getParameter("id");
            String dia = request.getParameter("dia");
            String mes = request.getParameter("mes");
            String anio = request.getParameter("anio");
            String paciente = request.getParameter("pac");
            String dentista = request.getParameter("den");
            String tratamiento = request.getParameter("trat");
            String descripcion = request.getParameter("descripcion");
            
            Atencion a = new Atencion();
            
            a.setId_atencion(Integer.parseInt(id));
            a.setDia(Integer.parseInt(dia));
            a.setMes(Integer.parseInt(mes));
            a.setAnio(Integer.parseInt(anio));
            a.setDescripcion(descripcion);
            
            try {
                a.setPaciente(pDAO.findById(Integer.parseInt(paciente)));
                a.setDentista(dDAO.findById(Integer.parseInt(dentista)));
                a.setTratamiento(tDAO.findById(Integer.parseInt(tratamiento)));
                aDAO.actualizar(a);
                
                request.setAttribute("mensaje", "Se ha modificado la atención");
                request.getRequestDispatcher("WEB-INF/modificarAtencion.jsp").forward(request, response);
            } catch (SQLException ex) {
                ex.getStackTrace();
                request.setAttribute("mensaje", "No se ha modificado la atención");
            } catch (NamingException ex) {
                Logger.getLogger(agregarPaciente.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", "No se ha modificado la atención");
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
