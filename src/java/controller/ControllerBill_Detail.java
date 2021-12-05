/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Bill_Detail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOBill_Detail;

/**
 *
 * @author pc
 */
public class ControllerBill_Detail extends HttpServlet {

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
            DAOBill_Detail dao = new DAOBill_Detail();
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if (service.equals("listBillDetail")) {
                String oID = request.getParameter("oID");
                if (oID == null) {
                    out.println("Not Data");
                } else {
                    String sql = "select *from BillDetail where oID = '"+oID+"'";
                     ResultSet rs = dao.getDat(sql);
                    String tilte = "List All for Admin";
                //set data for view
                    request.setAttribute("rs", rs);
                    request.setAttribute("title", tilte);
                }
                request.getRequestDispatcher("Admin/Bill_Detail.jsp").forward(request, response);
            }
            
            if (service.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String pid = request.getParameter("pid");
                    ResultSet rs = dao.getDat("Select * from BillDetail where pid ='" + pid + "'");
                    request.setAttribute("rs", rs);
                    request.getRequestDispatcher("view/Bill_Detail/update.jsp").forward(request, response);
                } else {
                    String pid = request.getParameter("id");
                    String quan = request.getParameter("quantity");
                    int quantity = Integer.parseInt(quan);
                    String money = request.getParameter("price");
                    double price = Double.parseDouble(money);
                    String tt = request.getParameter("total");
                    double total = Double.parseDouble(tt);

                    Bill_Detail b = new Bill_Detail(quantity, price, total);
                    dao.update(b, pid);
                    response.sendRedirect("ControllerBill");
                }
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
