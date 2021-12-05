/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Bill;
import entity.Customer;
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
public class DAOBill extends DBConnect{
    
    public List<Bill> getAll(){
        List<Bill> list = new ArrayList<>();
        try {
            String sql = "select o.oID,o.dateCreate, o.cname, o.cphone ,o.cAddress, o.total, o.status, o.cid from bill o\n"
                    + "inner join Customer c on o.cid = c.cid";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Bill b  = new Bill();
                b.setoID(rs.getString(1));
                b.setDateCreate(rs.getString(2));
                b.setCname(rs.getString(3));
                b.setCphone(rs.getString(4));
                b.setcAddress(rs.getString(5));
                b.setTotalmoney(rs.getDouble(6));
                b.setStatus(rs.getInt(7));
                Customer c = new Customer();
                c.setCid(rs.getInt("cid"));
                b.setCid(c);
                list.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Bill> getAllbyCid(int cid){
        Bill b = new Bill();
        List<Bill> list = new ArrayList<>();
        try {
            String sql = "select o.oID,o.dateCreate,o.cname,o.cphone,o.cAddress,o.total,o.status,o.cid,c.cname\n"
                    + "from Bill o inner join Customer c on o.cid = c.cid where o.cid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cid);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                b.setoID(rs.getString(1));
                b.setDateCreate(rs.getString(2));
                b.setCname(rs.getString(3));
                b.setCphone(rs.getString(4));
                b.setcAddress(rs.getString(5));
                b.setTotalmoney(rs.getDouble(6));
                b.setStatus(rs.getInt(7));
                Customer c = new Customer();
                c.setCid(cid);
                b.setCid(c);
                list.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int addBill(Bill b){
        int n = 0;
        try {
            String sql = "insert into Bill(oID, dateCreate,cname,cphone, cAddress,total,status,cid) values (?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, b.getoID());
            statement.setString(2, b.getDateCreate());
            statement.setString(3, b.getCname());
            statement.setString(4, b.getCphone());
            statement.setString(5, b.getcAddress());
            statement.setDouble(6, b.getTotalmoney());
            statement.setInt(7, b.getStatus());
            statement.setInt(8, b.getCid().getCid());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int DeleteOrderbyid(int oid) {
        int n = 0;
        try {
            String sql = "Update [bill] set [status] = -1  where oid = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, oid);
            n = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int update(Bill b, String id){
        int n = 0;
        try {
            String sql = "update Bill set cname = ?, cAddress = ?, cphone = ?, status = ? where oID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, b.getCname());
            statement.setString(2, b.getcAddress());
            statement.setString(3, b.getCphone());
            statement.setInt(4, b.getStatus());
            statement.setString(5, id);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public List<Bill> getAllBillByCid(int cid){
        List<Bill> list = new ArrayList<>();
        try {
            String sql = "select * from Bill where cid=? order by oID desc";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cid);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Bill b  = new Bill();
                b.setoID(rs.getString(1));
                b.setDateCreate(rs.getString(2));
                b.setCname(rs.getString(3));
                b.setCphone(rs.getString(4));
                b.setcAddress(rs.getString(5));
                b.setTotalmoney(rs.getDouble(6));
                b.setStatus(rs.getInt(7));
                Customer c = new Customer();
                c.setCid(rs.getInt(8));
                b.setCid(c);
                list.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    public int changeStatus(String oID, int status){
        int n = 0;
        try {
            String sql = "update Bill set status = ? where oID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, status);
            statement.setString(2, oID);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBill.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public static void main(String[] args) {
        DAOBill dao = new DAOBill();
        //System.out.println(dao.getAllbyCid(6));
        System.out.println(dao.getAllBillByCid(5));
    }
}
