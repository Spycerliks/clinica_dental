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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Atencion;
import modelo.Dentista;
import modelo.Paciente;
import modelo.Tratamiento;
import modelo.Usuario;

/**
 *
 * @author matias
 */
public class consultarAtencion extends HttpServlet {

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
            out.println("<title>Servlet consultarAtencion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet consultarAtencion at " + request.getContextPath() + "</h1>");
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
            AtencionDAO aDAO = new AtencionDAO();
            PacienteDAO pDAO = new PacienteDAO();
            DentistaDAO dDAO = new DentistaDAO();
            TratamientoDAO tDAO = new TratamientoDAO();

            try {
                ArrayList<Atencion> ate = aDAO.listarAtencion();
                ArrayList<Paciente> pac = pDAO.listarPaciente();
                ArrayList<Dentista> den = dDAO.listarDentista();
                ArrayList<Tratamiento> trat = tDAO.listarTratamiento();
                
                request.setAttribute("atenciones", ate);
                request.setAttribute("pacientes", pac);
                request.setAttribute("dentistas", den);
                request.setAttribute("tratamientos", trat);
                request.getRequestDispatcher("WEB-INF/consultarAtencion.jsp").forward(request, response);
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
            String id = request.getParameter("id");
            
            try {
                aDAO.eliminar(Integer.parseInt(id));
                response.sendRedirect("consultarAtencion");
            } catch (Exception e) {
                e.printStackTrace();
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
