/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Category;
import entity.Product;
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
 * @author HP
 */
public class DAOProduct extends DBConnect {
//    DBConnect dbConn;
//    Connection connect;
//
//    public DAOProduct(DBConnect dbconn) {
//        this.dbConn=dbconn;
//        connect=dbconn.conn;
//    }
//    DAO: insert, update,delete,search(select)

//BTVN : Check Foreign key Constraint
//       getAll() tat ca cac bang    
    
    
    public int insertProduct(Product pro){
        int n=0;
        String sql="insert into Product(pid,pname,quantity,price,image,description,status,cateID) "
                + "values('"+pro.getPid()+"','"+pro.getPname()+"',"+pro.getQuantity()+
                ","+pro.getPrice()+",'"+pro.getImage()+"','"+pro.getDescription()+"',"+pro.getStatus()+","
                +pro.getCateID()+")";
       // System.out.println(sql);
        try {
            //Statemetn
            Statement state=conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public int addProduct(Product p){
        int n = 0;
         try {
            String sql = "insert into Product(pid,pname,quantity,price,image,description,status,cateID) "
                + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, p.getPid());
            statement.setString(2, p.getPname());
            statement.setInt(3, p.getQuantity());
            statement.setDouble(4, p.getPrice());
            statement.setString(5, p.getImage());
            statement.setString(6, p.getDescription());
            statement.setInt(7, p.getStatus());
            statement.setInt(8, p.getCateID().getCateID());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int updateProduct(Product pro){
        int n = 0;
        try {
            String sql = "update Product set pname = ?,quantity = ?,price = ?"
                    + ",image = ?,description = ?,status = ?,cateID = ? where pid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pro.getPname());
            statement.setInt(2, pro.getQuantity());
            statement.setDouble(3, pro.getPrice());
            statement.setString(4, pro.getImage());
            statement.setString(5, pro.getDescription());
            statement.setInt(6, pro.getStatus());
            statement.setInt(7, pro.getCateID().getCateID());
            statement.setString(8, pro.getPid());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int removeProductbyChangeStatus(String id){
        int n = 0;
        try {
            String sql ="update Product set status = 0\n"
                    + "where pid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  n;
    }
    
    public int removeProductbyID(String id){
        int n = 0;
        try {
            String sql ="delete from Product where pid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, id);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  n;
    }
    
    public int changeStatus(String id, int status){
        int n = 0;
        try {
            String sql = "update Product set status = ?\n"
                    + "where pid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, status);
            statement.setString(2, id);
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    //update quantity
    public int updateProductQuantity(String id, int quan){
        int n = 0;
        try {
            String sql = "UPDATE [Product]\n"
                    + "   SET [quantity] = ([quantity] + ?)\n"
                    + " \n"
                    + " WHERE [pid] = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, quan);
            stm.setString(2, id);
            n = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public List<Product> getAll(){
        List<Product> list = new ArrayList<>();
        Product p = null;
        try {
            String sql = "Select * from Product";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                p = new Product();
                p.setPid(rs.getString("pid"));
                p.setPname(rs.getString("pname"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setImage(rs.getString("image"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));
                Category c = new Category();
                c.setCateID(rs.getInt("cateID"));
                p.setCateID(c);
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
//    public List<Product> getPrice(double from, double to){
//        List<Product> list = new ArrayList<>();
//        String sql = "select * from Product where price between "+from+" and "+to+"";
//        return list;
//    }
    
    public List<Product> searchProduct(String name){
        List<Product> list = new ArrayList<>();
        try {
            String sql = "select * from Product where pname like ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Product p = new Product();
                p.setPid(rs.getString("pid"));
                p.setPname(rs.getString("pname"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setImage(rs.getString("image"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));
                Category c = new Category();
                c.setCateID(rs.getInt("cateID"));
                p.setCateID(c);
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public Product getProduct(String pid){
        try {
            Product p = new Product();
            String sql = "select * from Product where pid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, pid);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                p.setPid(rs.getString("pid"));
                p.setPname(rs.getString("pname"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setImage(rs.getString("image"));
                p.setDescription(rs.getString("description"));
                p.setStatus(rs.getInt("status"));
                Category c = new Category();
                c.setCateID(rs.getInt("cateID"));
                p.setCateID(c);
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public int changeQuantity(String pid, int quantity) {
        int n =0;
        
        String presql = "update Product set quantity=? where pid=?";
        try {
            PreparedStatement pre = conn.prepareStatement(presql);
            pre.setInt(1, quantity);
            pre.setString(2, pid);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public static void main(String[] args) {
        DAOProduct dao=new DAOProduct();
        //System.out.println(dao.searchProduct("Grape Cake"));
//        int n=dao.insertProduct(new Product("1","Chocolate Tart",2, 500,"no image","second hand",1,new Category(1)));
//        //int n = dao.updateProductQuantity("1",5);
//       // System.out.println(dao.getAll());
//        if(n>0)
//            System.out.println("inserted");
        System.out.println(dao.getProduct("P02"));
    }
    
   
            
}
