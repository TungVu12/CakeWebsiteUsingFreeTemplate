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
public class Bill {
    private String oID;
    private String dateCreate;
    private String cname;
    private String cphone;
    private String cAddress;
    private double totalmoney;
    private int status;
    private Customer cid;

    public Bill() {
    }

    public Bill(String oID, String dateCreate, String cname, String cphone, String cAddress, double totalmoney, int status, Customer cid) {
        this.oID = oID;
        this.dateCreate = dateCreate;
        this.cname = cname;
        this.cphone = cphone;
        this.cAddress = cAddress;
        this.totalmoney = totalmoney;
        this.status = status;
        this.cid = cid;
    }

    public Bill(String oID, String dateCreate, String cname, String cphone, String cAddress, int status, Customer cid) {
        this.oID = oID;
        this.dateCreate = dateCreate;
        this.cname = cname;
        this.cphone = cphone;
        this.cAddress = cAddress;
        this.status = status;
        this.cid = cid;
    }

    public Bill(String cname, String cphone, String cAddress) {
        this.cname = cname;
        this.cphone = cphone;
        this.cAddress = cAddress;
    }

    public Bill(String cname, String cphone, String cAddress, int status) {
        this.cname = cname;
        this.cphone = cphone;
        this.cAddress = cAddress;
        this.status = status;
    }
    
    

    public Bill(String oID) {
        this.oID = oID;
    }
       
    public String getoID() {
        return oID;
    }

    public void setoID(String oID) {
        this.oID = oID;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Customer getCid() {
        return cid;
    }

    public void setCid(Customer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Bill{" + "oID=" + oID + ", dateCreate=" + dateCreate + ", cname=" + cname + ", cphone=" + cphone + ", cAddress=" + cAddress + ", totalmoney=" + totalmoney + ", status=" + status + ", cid=" + cid + '}';
    }
    
}
