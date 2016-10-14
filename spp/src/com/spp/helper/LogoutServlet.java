/*
 * LogoutServlet.java
 *
 * Created on August 17, 2006, 4:29 PM
 */

package com.spp.helper;

import java.io.*;


import javax.servlet.*;
import javax.servlet.http.*;


public class LogoutServlet extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        request.getSession(true).invalidate();
       /* response.sendRedirect("http://localhost:5050/globalsp/");*/
        /*response.sendRedirect("http://service.reporting.ime.reuters.com:8080/globalsp/");*/
        response.sendRedirect("https://safe.thomson.com/auth/safe_logout");
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
