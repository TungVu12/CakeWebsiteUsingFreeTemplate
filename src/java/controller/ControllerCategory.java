/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOCategory;

/**
 *
 * @author pc
 */
public class ControllerCategory extends HttpServlet {

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
            DAOCategory dao = new DAOCategory();
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("service");
            if (service == null) {
                service = "listCate";
            }

            if (service.equals("listCate")) {
                //step 2: Prepare data for view
                String sql = "select *from Category";
                ResultSet rs = dao.getDat(sql);
                String tilte = "List All for Admin";
                //set data for view
                request.setAttribute("rs", rs);
                request.setAttribute("title", tilte);
                //step 3: select view 
                RequestDispatcher disp = request.getRequestDispatcher("Admin/Category.jsp");
                // Run
                disp.forward(request, response);
            }

            if (service.equals("add")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    request.getRequestDispatcher("view/Category/add.jsp").forward(request, response);
                } else {
                    String name = request.getParameter("name");
                    String sta = request.getParameter("status");
                    int status = Integer.parseInt(sta);

                    Category c = new Category(name, status);
                    dao.addCate(c);
                    response.sendRedirect("ControllerCategory");
                }
            }

            if (service.equals("update")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    String id = request.getParameter("cid");
                    int cid = Integer.parseInt(id);
                    ResultSet rs = dao.getDat("Select * from Category where cateID ='" + cid + "'");
                    request.setAttribute("rs", rs);
                    request.getRequestDispatcher("view/Category/update.jsp").forward(request, response);
                } else {
                    int cateID = Integer.parseInt(request.getParameter("cid"));
                    String name = request.getParameter("name");
                    String sta = request.getParameter("status");
                    int status = Integer.parseInt(sta);

                    Category c = new Category(name, status);
                    //dao.addCate(c);
                    dao.UpdateCategory(c, cateID);
                    response.sendRedirect("ControllerCategory");
                }
            }
            
            if(service.equals("delete")){
                String id = request.getParameter("cid");
                int cid = Integer.parseInt(id); 
                dao.DeleteByChangeStatus(cid);
                response.sendRedirect("ControllerCategory");
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
