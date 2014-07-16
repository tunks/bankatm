/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.atm;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tune
 */
@WebServlet(name = "AtmWithdraw", urlPatterns = {"/AtmWithdraw"})
public class AtmWithdraw extends HttpServlet {

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
        request.getRequestDispatcher("/WEB-INF/view/atm/AtmWithdraw.jsp").forward(request, response);
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
        
        int WAmount = Integer.parseInt(request.getParameter("WAmount"));
        
        //check accout have more money than user request
        //double AAmount = 25; //assume
        int CardId = 888; //assume
        double AAmount = AtmActions.getAmountfromCustomerID(AtmActions.getCustomerIDfromCardID(CardId));
      
        System.out.println("AAmount = "+AAmount);
        if(WAmount > AAmount) {
            request.setAttribute("InvalidMessage", "Money in your account is not enought to do the transaction");
            request.getRequestDispatcher("/WEB-INF/view/atm/AtmWithdrawInvalid.jsp").forward(request, response);
        }
  
        //check transection not over than 1000$ per day
        CardId = 888; //assume
        Date today = AtmActions.getTodayDate();
        
        //double WTran = 88; //assume
        double WTran = AtmActions.getAmountWithdrawFromTransactioin(CardId, today);
        System.out.println("WTran = " + WTran);
        if(WTran + WAmount > 1000) {
            request.setAttribute("InvalidMessage", "You Can not withdraw the money more that 1000$ per day");
            request.getRequestDispatcher("/WEB-INF/view/atm/AtmWithdrawInvalid.jsp").forward(request, response);
        }
        
        
        
        //update table account
        
        //update table transaction
        
        //sent sms
        
        
        request.setAttribute("ValidMessage", "your withdraw transaction<br>is completed");
        request.getRequestDispatcher("/WEB-INF/view/atm/AtmWithdrawValid.jsp").forward(request, response);
        
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
