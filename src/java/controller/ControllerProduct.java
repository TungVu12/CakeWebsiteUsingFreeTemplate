/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOProduct;

/**
 *
 * @author pc
 */
public class ControllerProduct extends HttpServlet {

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
            DAOProduct dao = new DAOProduct();
            //step 1: get service from client (view)
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAll";
            }

            if (service.equals("listAll")) {
                //step 2: Prepare data for view
                String sql = "select *from Product";
                ResultSet rs = dao.getDat(sql);
                String tilte = "List All for Admin";
                //set data for view
                request.setAttribute("ketqua", rs);
                request.setAttribute("title", tilte);
                //step 3: select view 
                RequestDispatcher disp = request.getRequestDispatcher("Admin/Product.jsp");
                // Run
                disp.forward(request, response);
            }
            
            
            if (service.equals("add")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    ResultSet rsCate = dao.getDat("select * from Category");
                    request.setAttribute("rsCate", rsCate);
                    request.getRequestDispatcher("view/Product/add.jsp").forward(request, response);
                } 
                else {
                    String id = request.getParameter("id");
                    String pname = request.getParameter("pname");
                    String quant = request.getParameter("quantity");
                    int quantity = Integer.parseInt(quant);
                    String price = request.getParameter("price");
                    double Proprice = Double.parseDouble(price);
                    String imgname = request.getParameter("image");
                    String des = request.getParameter("des");
                    String sta = request.getParameter("status");
                    int status = Integer.parseInt(sta);
                    String cateID = request.getParameter("cate");
                    int cate = Integer.parseInt(cateID);
      
                    Product pro = new Product(id, pname, quantity, Proprice, imgname, des, status, new Category(cate));
                    dao.addProduct(pro);
                    response.sendRedirect("ControllerProduct");
                }
            }
            
            if (service.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) { // chua update
                    String pid = request.getParameter("pid");
                    ResultSet rs = dao.getDat("select * from Product where pid = '" + pid + "'");
                    request.setAttribute("rs", rs);
                    ResultSet rsCate = dao.getDat("select * from Category");
                    request.setAttribute("rsCate", rsCate);
                    request.getRequestDispatcher("view/Product/update.jsp").forward(request, response);
                } else {
                    //update
                    String id = request.getParameter("id");
                    String pname = request.getParameter("pname");
                    String quant = request.getParameter("quantity");
                    int quantity = Integer.parseInt(quant);
                    String price = request.getParameter("price");
                    double Proprice = Double.parseDouble(price);
                    String imgname = request.getParameter("image");
                    String des = request.getParameter("des");
                    String sta = request.getParameter("status");
                    int status = Integer.parseInt(sta);
                    String cateID = request.getParameter("cate");
                    int cate = Integer.parseInt(cateID);

                    //check validate: null, number, empty
                    if (id == null || id.equals("")) {
                        System.out.println("Input ID");
                    }

                    Product pro = new Product(id, pname, quantity, Proprice, imgname, des, status, new Category(cate));
                    //dao.addProduct(pro);
                    dao.updateProduct(pro);
                    response.sendRedirect("ControllerProduct");
                }
            }
            
            if (service.equals("delete")) {
                String pid = request.getParameter("pid");
                dao.removeProductbyChangeStatus(pid);
                response.sendRedirect("ControllerProduct");
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
