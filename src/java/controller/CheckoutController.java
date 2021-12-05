/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Bill;
import entity.Bill_Detail;
import entity.Customer;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOBill;
import model.DAOBill_Detail;
import model.DAOCustomer;
import model.DAOProduct;

/**
 *
 * @author pc
 */
public class CheckoutController extends HttpServlet {

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
            HttpSession session = request.getSession();
            String service = request.getParameter("service");

            if (service.equals("checkout")) {

                DAOBill dbbill = new DAOBill();
                DAOBill_Detail dbdetail = new DAOBill_Detail();
                DAOProduct dao = new DAOProduct();
                java.util.Enumeration em = session.getAttributeNames();
                Date utildate = new Date();
                java.sql.Date sqldate = new java.sql.Date(utildate.getTime());
                Account a = (Account) session.getAttribute("user");
                if (a != null) {
                    Customer customer = new DAOCustomer().getOne(a.getUsername());

                    int oId = 0;
                    String sql = "select COUNT(*) as count from Bill";
                    ResultSet rs = dbbill.getDat(sql);
                    try {
                        if (rs.next()) {
                            int lastId = Integer.parseInt(rs.getString("count"));
                            oId = lastId + 1;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    session.setAttribute("customer", customer);

                    double total = Double.parseDouble(request.getParameter("totalmoney"));

                    String cname = request.getParameter("cname");
                    String cphone = request.getParameter("cphone");
                    String caddress = request.getParameter("caddress");
                    
                    
                    
                    if (cname.equals("") || cphone.equals("") || caddress.equals("")) {
                        request.getRequestDispatcher("showCartController").forward(request, response);
                        return;
                    } else {
                        Bill bill = new Bill(oId + "", sqldate.toString(), cname, cphone, caddress, total, 0, new Customer(customer.getCid()));
                        dbbill.addBill(bill);
                    }
                    //********************
                    while (em.hasMoreElements()) {
                        String pid = em.nextElement().toString();
                        try {
                            Product pro = (Product) session.getAttribute(pid);
                            Bill_Detail detail = new Bill_Detail(new Product(pid), new Bill(oId + ""), pro.getQuantity(), pro.getPrice(), total);
                            dbdetail.addBillDetail(detail);
                            ResultSet rs1 = dao.getDat("select quantity from Product where pid='" + pid + "'");
                            if (rs1.next()) {
                                int quantity = Integer.parseInt(rs1.getString("quantity"));
                                dao.changeQuantity(pid, quantity - pro.getQuantity());
                            }
                        } catch (Exception e) {
                            continue;
                        }
                        session.removeAttribute(pid);
                    }
                    response.sendRedirect("HomeController");
                } else {
                    response.sendRedirect("LoginController");
                }
            }

            if (service.equals("update")) {
                DAOProduct dao = new DAOProduct();
                java.util.Enumeration em = session.getAttributeNames();
                Product pro;
                while (em.hasMoreElements()) {
                    String pid = em.nextElement().toString();
                    try {
                        try {
                            pro = (Product) session.getAttribute(pid);
                        } catch (Exception e) {
                            continue;
                        }
                        ResultSet rs = dao.getDat("select quantity from Product where pid ='" + pid + "'");
                        if (rs.next()) {
                            int storage = Integer.parseInt(rs.getString("quantity"));
                            int newQuan = Integer.parseInt(request.getParameter(pid + "newquantity"));
                            if (newQuan > storage) {
                                out.println("<h1>Out of Product</h1>");
                                out.print("<p><a href=\"showCartController\">Back to Cart</a></p>");
                                return;
                            } else {
                                if (newQuan == 0) {
                                    session.removeAttribute(pid);
                                } else {
                                    pro.setQuantity(newQuan);
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        continue;
                    }
                }
                request.getRequestDispatcher("showCartController").forward(request, response);
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
