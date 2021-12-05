/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Bill;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOBill;

/**
 *
 * @author pc
 */
public class ControllerBill extends HttpServlet {

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
            DAOBill dao = new DAOBill();
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAll";
            }

            if (service.equals("listAll")) {
                //step 2: Prepare data for view
                String sql = "select * from Bill order by dateCreate asc";
                String sql2 = "select count(*) as total from Bill where status = 0";
                ResultSet rs = dao.getDat(sql);
                ResultSet rs1 = dao.getDat(sql2);
                String tilte = "List All for Admin";
                int total = 0;
                //set data for view
                request.setAttribute("rs", rs);
                try {
                    if(rs1.next()){
                        int totalAll = Integer.parseInt(rs1.getString("total"));
                        total += totalAll;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerBill.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("title", tilte);
                request.setAttribute("total", total);
                //step 3: select view 
                RequestDispatcher disp = request.getRequestDispatcher("Admin/Bill.jsp");
                // Run
                disp.forward(request, response);
            }
            
            if (service.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String oid = request.getParameter("oID");
                    ResultSet rs = dao.getDat("Select * from Bill where oID ='" + oid + "'");
                    request.setAttribute("rs", rs);
                    request.getRequestDispatcher("view/Bill/update.jsp").forward(request, response);
                } else {
                    String oID = request.getParameter("id");
                    String cname = request.getParameter("name");
                    String cphone = request.getParameter("phone");
                    String cAddress = request.getParameter("address");
                    String sta = request.getParameter("status");
                    int status = Integer.parseInt(sta);

                    Bill b = new Bill(cname, cphone, cAddress, status);
                    dao.update(b, oID);
                    response.sendRedirect("ControllerBill");
                }
            }
            
            
            if(service.equals("delete")){
                String id = request.getParameter("oID");
                int oID =Integer.parseInt(id);
                dao.DeleteOrderbyid(oID);
                response.sendRedirect("ControllerBill");
            }
            
            if(service.equals("cancel")){
                String oID = request.getParameter("oID");
                dao.changeStatus(oID, -1);
                response.sendRedirect("MyAccountController");
            }
            
            if(service.equals("received")){
                 String oID = request.getParameter("oID");
                 dao.changeStatus(oID, 2);
                 response.sendRedirect("ControllerBill");
            }
            
            if(service.equals("receivedByCustomer")){
                 String oID = request.getParameter("oID");
                 dao.changeStatus(oID, 2);
                 response.sendRedirect("MyAccountController");
            }
            
            if(service.equals("delivery")){
                String oID = request.getParameter("oID");
                dao.changeStatus(oID, 1);
                response.sendRedirect("ControllerBill");
            }
            
            if(service.equals("listWaiting")){
                String sql = "select * from Bill where status = 0";
                ResultSet rs = dao.getDat(sql);
                request.setAttribute("rs", rs);
                 RequestDispatcher disp = request.getRequestDispatcher("Admin/BillWaiting.jsp");
                // Run
                disp.forward(request, response);
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
