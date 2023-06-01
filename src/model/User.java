/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class User {
    private int ID;
    private String ten_nguoi_choi;
    private int diem;
    private int so_tran_thang;
    private int so_tran_thua;
    private int so_tran;
    

    public User(int ID, String ten_nguoi_choi, int diem, int so_tran_thang, int so_tran_thua, int so_tran) {
        this.ID = ID;
        this.ten_nguoi_choi = ten_nguoi_choi;
        this.diem = diem;
        this.so_tran_thang = so_tran_thang;
        this.so_tran_thua = so_tran_thua;
        this.so_tran = so_tran;
    }

    public User(int ID, String ten_nguoi_choi) {
        this.ID = ID;
        this.ten_nguoi_choi = ten_nguoi_choi;
    }

    public int getSo_tran() {
        return so_tran;
    }

    public void setSo_tran(int so_tran) {
        this.so_tran = so_tran;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTen_nguoi_choi() {
        return ten_nguoi_choi;
    }

    public void setTen_nguoi_choi(String ten_nguoi_choi) {
        this.ten_nguoi_choi = ten_nguoi_choi;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getSo_tran_thang() {
        return so_tran_thang;
    }

    public void setSo_tran_thang(int so_tran_thang) {
        this.so_tran_thang = so_tran_thang;
    }

    public int getSo_tran_thua() {
        return so_tran_thua;
    }

    public void setSo_tran_thua(int so_tran_thua) {
        this.so_tran_thua = so_tran_thua;
    }
    
    
}

    
