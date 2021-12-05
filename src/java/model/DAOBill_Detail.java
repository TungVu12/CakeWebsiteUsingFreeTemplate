/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Bill;
import entity.Bill_Detail;
import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class DAOBill_Detail extends DBConnect{
    
    public List<Bill_Detail> getAll(){
        List<Bill_Detail> list = new ArrayList<>();
        try {
            String sql = "select b.oID, b.pid, b.price, b.quantity, b.total, \n"
                    + "e.cname as billname, p.pname as productname from BillDetail b\n"
                    + "inner join Product p on p.pid = b.pid\n"
                    + "inner join Bill e on e.oID = b.oID";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Bill_Detail b = new Bill_Detail();
                Bill o = new Bill();
                o.setoID(rs.getString("oID"));
                b.setOid(o);
                Product p = new Product();
                p.setPid(rs.getString("pid"));
                b.setPid(p);
                b.setPrice(rs.getDouble("price"));
                b.setQuantity(rs.getInt("quantity"));
                b.setTotal(rs.getDouble("total"));
                o.setCname(rs.getString("billname"));
                p.setPname(rs.getString("productname"));
                list.add(b);             
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int addBillDetail(Bill_Detail b){
        int n =0;
        try {
            String sql = "insert into  BillDetail(pid,oID,quantity,price,total) values (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, b.getPid().getPid());
            statement.setString(2, b.getOid().getoID());
            statement.setInt(3, b.getQuantity());
            statement.setDouble(4, b.getPrice());
            statement.setDouble(5, b.getTotal());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int update(Bill_Detail b, String pid){
        int n = 0;
        try {
            String sql = "Update BillDetail set total = ?, quantity = ?, price = ? where pid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setDouble(1, b.getTotal());
            statement.setInt(2, b.getQuantity());
            statement.setDouble(3, b.getPrice());
            statement.setString(4, pid);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill_Detail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public static void main(String[] args) {
        DAOBill_Detail dao = new DAOBill_Detail();
        System.out.println(dao.getAll());
        int n = dao.update(new Bill_Detail(50000, 3, 10000), "P02");
        if(n > 0){
            System.out.println("inserted");
        }
    }
}
