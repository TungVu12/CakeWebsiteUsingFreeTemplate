/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Account;
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
public class DAOAccount extends DBConnect{
    
    public Account checkUser(String user, String password){
        try {
            String sql ="select * from admin where username = ? and password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Account a = new Account();
                a.setAdminID(rs.getInt("adminID"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setRole(rs.getString("role"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int signup(Account a){
        int n=0;
        String sql = "insert into admin (username, password) "
                + "values('"+a.getUsername()+"','"+a.getPassword()+"')";
       // System.out.println(sql);
        try {
            //Statemetn
            Statement state=conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return n;
    }
    
    public List<Account> getAll(){
        Account a = null;
        List<Account> list = new ArrayList<>();
        try {
            String sql ="select * from admin";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                list.add(a);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   public int signupAccount(Account a){
       int n = 0;
       try {
            String sql = "insert into admin (username, password, role) "
                + "values(?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, a.getUsername());
            statement.setString(2, a.getPassword());
            statement.setString(3, a.getRole());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
       return n;
   }
   
   public int DeleteAccount(int id){
       int n = 0;
        try {
            String sql ="delete from admin where adminID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
   }
   
   public int updateAccount(Account a, int id){
       int n =0;
       try {
            String sql ="Update admin SET [username] = ?,  [password]  = ? where adminID= ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, a.getUsername());
            statement.setString(2, a.getPassword());
            statement.setInt(1, id);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
       return n;
   }
   
   public int changePassword(String username, String oldpass, String newpass, int id){
       int n =0;
       try {
           if(checkUser(username, oldpass) == null){
               System.out.println("Account does not exist !");
           }
           else{
            String sql ="update admin set password = ? where adminID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newpass);
            statement.setInt(2, id);
            n = statement.executeUpdate();
            return n;
           }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
       return n;
   }
   
   //login
   
    public static void main(String[] args) {
        DAOAccount dao = new DAOAccount();
        int n = dao.signupAccount(new Account("HanNa", "123456789","guest"));
//        int n  = dao.changePassword("xtungvu12", "xtungbandau2001", "xtungvu12", 1);
       if(n>0){
           System.out.println("inserted");
        }
    }
    /*
    try {
            String sql ="";
            PreparedStatement statement = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    */
 }

