/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOCustomer;

/**
 *
 * @author pc
 */
public class ControllerCustomer extends HttpServlet {

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
            DAOCustomer dao = new DAOCustomer();
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAll";
            }

            if (service.equals("listAll")) {
                //step 2: Prepare data for view
                String sql = "select *from Customer";
                ResultSet rs = dao.getDat(sql);
                String tilte = "List All for Admin";
                //set data for view
                request.setAttribute("ketqua", rs);
                request.setAttribute("title", tilte);
                //step 3: select view 
                RequestDispatcher disp = request.getRequestDispatcher("Admin/Customer.jsp");
                // Run
                disp.forward(request, response);
            }
            
            if (service.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String id = request.getParameter("id");
                    int cid = Integer.parseInt(id);
                    ResultSet rs = dao.getDat("Select * from Customer where cid ='" + cid + "'");
                    request.setAttribute("rs", rs);
                    request.getRequestDispatcher("view/Customer/update.jsp").forward(request, response);
                } else {
                    int cid = Integer.parseInt(request.getParameter("id"));
                    String name = request.getParameter("name");
                    String phone = request.getParameter("phone");
                    String add = request.getParameter("address");
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String newpass = request.getParameter("newpassword");
                    String sta = request.getParameter("status");
                    int status = Integer.parseInt(sta);

                    Customer c = new Customer(name, phone, add, username, status);
                    dao.UpdateCustomer(cid, c);
                    if (dao.Checkuser(username, password) != null) {
                        dao.changePassword(username, password, newpass, cid);
                    }
                    //dao.addCustomer(c);
                    response.sendRedirect("ControllerCustomer");
                }
            }
            
            
            if (service.equals("add")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("view/Customer/add.jsp").forward(request, response);
                } else {
                    String name = request.getParameter("name");
                    String phone = request.getParameter("phone");
                    String add = request.getParameter("address");
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String sta = request.getParameter("status");
                    int status = Integer.parseInt(sta);

                    Customer c = new Customer(name, phone, add, username, password, status);
                    dao.addCustomer(c);
                    response.sendRedirect("ControllerCustomer");
                }
            }
            
            if(service.equals("account")){
                
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
