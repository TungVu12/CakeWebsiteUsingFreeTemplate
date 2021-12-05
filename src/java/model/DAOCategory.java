/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Category;
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
public class DAOCategory extends DBConnect{
    
    public List<Category> getAll(){
        List<Category> list = new ArrayList<>();
        try {
            String sql = "Select * from Category";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Category c = new Category();
                c.setCateID(rs.getInt(1));
                c.setCateName(rs.getString(2));
                c.setStatus(rs.getInt(3));
                list.add(c);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int insertCate(Category c){
        int n=0;
        String sql = "INSERT INTO Category (cateName,status) values('"+c.getCateName()+"','"+c.getStatus()+"')";
       // System.out.println(sql);
        try {
            //Statemetn
            Statement state=conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public int addCate(Category c){
        int n = 0;
        try {
            String sql = "INSERT INTO Category (cateName,status) values (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, c.getCateName());
            statement.setInt(2, c.getStatus());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int UpdateCategory(Category c, int id){
        int n = 0;
        try {
            String sql = "update Category set cateName = ?, status = ? where cateID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, c.getCateName());
            statement.setInt(2, c.getStatus());
            statement.setInt(3, id);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int changeStatus(int cateID){
        int n = 0;
        try {
            String sql = "update category set status= 0 where cateID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cateID);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int Delete(int cateID){
        int n = 0;
        try {
            String sql = "delete from Category where cateID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cateID);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int DeleteByChangeStatus(int cateID){
        int n = 0;
        try {
            String sql = "update Category set status = 0 where cateID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, cateID);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public static void main(String[] args) {
        DAOCategory c = new DAOCategory();
        System.out.println(c.getAll());
        //int n = c.addCate(new Category("CupCake", 1));
//        int n = c.UpdateCategory(new Category("Vanila", 1), 1);
//        if(n > 0){
//            System.out.println("inserted");
//        }
    }
    
    
}
