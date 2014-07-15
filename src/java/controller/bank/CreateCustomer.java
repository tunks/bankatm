/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.bank;

import common.Authenticate;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fara1_000
 */
public class CreateCustomer extends HttpServlet {

    /*
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
        String user = (String) session.getAttribute("user");
        if (user != null) {
            request.getRequestDispatcher("/WEB-INF/view/bank/createcustomer.jsp").forward(request, response);
        } else {
            //request.setAttribute("reference", "bank");
            response.sendRedirect("bank");
        }

    }

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
//                First name: <input type="text" name="firstname"><br>
//                Last name: <input type="text" name="lastname"><br>
//                Address:<input type="text" name="address"><br>
//                Email: <input type="text" name="email"><br>
//                Phone: <input type="text" name="phone"><br>
//                Account Number: <input type="text" name="accountno"><br>
//                Initial Amount:<input type="text" name="iniamount"><br>
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String accountno = request.getParameter("accountno");
        String iniamount = request.getParameter("iniamount");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
