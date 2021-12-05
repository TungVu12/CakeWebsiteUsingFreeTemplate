/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author pc
 */
public class Bill_Detail {
    private Product pid;
    private Bill oid;
    private int quantity;
    private double price,total;

    public Bill_Detail() {
    }

    public Bill_Detail(Product pid, Bill oid, int quantity, double price, double total) {
        this.pid = pid;
        this.oid = oid;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public Bill_Detail(int quantity, double price, double total) {
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }
    
    

    public Product getPid() {
        return pid;
    }

    public void setPid(Product pid) {
        this.pid = pid;
    }

    public Bill getOid() {
        return oid;
    }

    public void setOid(Bill oid) {
        this.oid = oid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Bill_Detail{" + "pid=" + pid + ", oid=" + oid + ", quantity=" + quantity + ", price=" + price + ", total=" + total + '}';
    }
    
    
}
