/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOAccount;

/**
 *
 * @author pc
 */
public class ControllerAdmin extends HttpServlet {

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
        DAOAccount dao = new DAOAccount();
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAll";
            }

            if (service.equals("listAll")) {
                //step 2: Prepare data for view
                String sql = "select *from admin";
                ResultSet rs = dao.getDat(sql);
                String tilte = "List All for Admin";
                //set data for view
                request.setAttribute("rs", rs);
                request.setAttribute("title", tilte);
                //step 3: select view 
                RequestDispatcher disp = request.getRequestDispatcher("Admin/Admin.jsp");
                // Run
                disp.forward(request, response);
            }
            
            if (service.equals("add")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("view/Account/add.jsp").forward(request, response);
                } else {
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    Account a = new Account(username, password);
                    dao.signupAccount(a);
                    response.sendRedirect("ControllerAdmin");
                }
            }

            if (service.equals("delete")) {
                String id = request.getParameter("id");
                int accid = Integer.parseInt(id);
                dao.DeleteAccount(accid);
                response.sendRedirect("ControllerAdmin");
            }

            if (service.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String id = request.getParameter("id");
                    int accid = Integer.parseInt(id);
                    ResultSet rs = dao.getDat("Select * from admin where adminID ='" + accid + "'");
                    request.setAttribute("rs", rs);
                    request.getRequestDispatcher("view/Account/update.jsp").forward(request, response);
                } 
                else {
                    int aid = Integer.parseInt(request.getParameter("id"));
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String newpassword = request.getParameter("newpassword");

                    Account a = new Account(username, password);
                    //dao.signupAccount(a);
                    if (newpassword == null) {
                        newpassword = password;
                    } else {
                        dao.changePassword(username, password, newpassword, aid);
                    }
                    response.sendRedirect("ControllerAdmin");
                }
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
