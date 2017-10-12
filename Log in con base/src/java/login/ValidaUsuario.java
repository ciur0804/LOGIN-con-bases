/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import Base.Conexion;


/**
 *
 * @author Alumno
 */
public class ValidaUsuario extends HttpServlet {    
Conexion Conexion = new Conexion();
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
        
        try (PrintWriter out = response.getWriter()) {
            
            String usuario;
            String password;
            String sub;
            usuario = request.getParameter("usuario");
            password = request.getParameter("password");
            sub = request.getParameter("verificar");
            out.println("<html>");
            out.println("<head></head>");
            out.println("<body>");      
            out.print("<p> Boop </p>");
            //comprobación de la conexión
            out.print(Conexion.getConexion());    
            //conexión
            try {
                Conexion.Conectar();
                ResultSet rsx = Conexion.consulta("select * from usuarios where nombre ='"+usuario+"' and contra='"+password+"';");
                if (rsx.next()) 
                    out.print("<p>Valido</p>");
                else out.print("<p>no existe</p>");
                
            }
            catch (Exception e){
                out.print("<p>Oh noes</p>");
            }
                       
            out.println("</body>");
            out.println("</html>");
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
