package controller.bank;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import common.Authenticate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ebrima
 */
public class Bank extends HttpServlet {

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

           HttpSession session = request.getSession();
           String user = (String)session.getAttribute("user");
           if ( user != null)
              request.getRequestDispatcher("/WEB-INF/view/bank/bank.jsp").forward(request, response);             
            else{
              request.setAttribute("reference","bank");
              request.getRequestDispatcher("/WEB-INF/view/login/login.jsp").forward(request, response);
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
         String username = request.getParameter("username");
        String password = request.getParameter("password");
        //String realPerson = request.getParameter("defaultReal");
        //String realPersonHash = request.getParameter("defaultRealHash");
        if(Authenticate.checkBankUser(username,password)) 
                //Validate.rpHash(realPerson).equals(realPersonHash))
        {
            // Return the existing session if there is one. Create a new session otherwise.
            HttpSession session = request.getSession();
         
            session.setAttribute("user",username);
            
            //response.sendRedirect("bank");
            processRequest(request, response);
        }
        else
        {
            String errorMsg = "Invalid login crendentials";
            request.setAttribute("errorMsg",errorMsg);
            request.setAttribute("reference","bank");
            request.getRequestDispatcher("/WEB-INF/view/login/login.jsp").forward(request, response);
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
