/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class DAOCustomer extends DBConnect{
    
    public List<Customer> getAll(){
        List<Customer> list = new ArrayList<>();
        try {
            String sql = "select * from Customer";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Customer c = new Customer();
                c.setCid(rs.getInt(1));
                c.setCname(rs.getString(2));
                c.setCphone(rs.getString(3));
                c.setcAddress(rs.getString(4));
                c.setUsername(rs.getString(5));
                c.setPassword(rs.getString(6));
                c.setStatus(rs.getInt(7));
                list.add(c);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public int insertCustomer(Customer c){
         int n=0;
        String sql = "insert into Customer (cname,cphone,cAddress,username,password,status) "
                + "values('"+c.getCname()+"','"+c.getCphone()+"','"+c.getcAddress()+"','"+c.getUsername()+"','"+c.getPassword()+"','"+c.getStatus()+"')";
       // System.out.println(sql);
        try {
            //Statemetn
            Statement state=conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return n;
    }
    
    public int addCustomer(Customer c){
        int n = 0;
        try {
            String sql = "insert into Customer (cname,cphone,cAddress,username,password,status) "
                + "values(?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, c.getCname());
            statement.setString(2, c.getCphone());
            statement.setString(3, c.getcAddress());
            statement.setString(4, c.getUsername());
            statement.setString(5, c.getPassword());
            statement.setInt(6, c.getStatus());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int changeStatus(int cid, int status){
        int n =0;
        try {
            String sql = "update Customer set status = ? where cid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, status);
            statement.setInt(2, cid);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int UpdateCustomer(int cid, Customer c){
        int n = 0;
        try {
            String sql = "update Customer set cname = ?, cphone = ?, \n" +
                          "cAddress = ?, username = ?, status = ? where cid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, c.getCname());
            statement.setString(2, c.getCphone());
            statement.setString(3, c.getcAddress());
            statement.setString(4, c.getUsername());
            statement.setInt(5, c.getStatus());
            statement.setInt(6, cid);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public Customer Checkuser(String username, String password) {
        String sql = "SELECT * FROM Customer WHERE username = ? and password = ?";
        try (
                PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Customer c = new Customer();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                c.setCphone(rs.getString("cphone"));
                c.setcAddress(rs.getString("cAddress"));
                c.setUsername(rs.getString("username"));
                c.setPassword(rs.getString("password"));
                c.setStatus(rs.getInt("status"));
                return c;
            }
        } catch (SQLException ex) {

        }
        return null;
    }
    
    public int changePassword(String username, String oldpass,
            String newPass, int cid) {
        int n = 0;
        try {
            if (Checkuser(username, oldpass) == null) {
                System.out.println("Account does not exist!");
            } else {
                String sql = "update Customer set password=? where cid=?";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, newPass);
                statement.setInt(2, cid);
                n = statement.executeUpdate();
                return n;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int DeleteCustomerbyid(int cid) {
        int n = 0;
        try {
            String sql = "delete from Customer where cid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cid);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public Customer getOne(String username) {

        String sql = "SELECT * FROM Customer WHERE username = ?";
        Customer c = new Customer();
        try (
            PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
            }
        } catch (SQLException ex) {
        }
        return c;
    }
    
    public static void main(String[] args) {
        DAOCustomer dao = new DAOCustomer();
//        int n = dao.addCustomer(new Customer("Yasuo","0976018301", "China", "luyi022001", "123456cd", 1));      
//       if(n>0){
//          System.out.println("inserted");
//      }
        Customer c = dao.getOne("xtungvu");
        System.out.println(c);
    }
}
