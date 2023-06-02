/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDAO extends DAO{

    public UserDAO() {
        super();
    }
    public User verifyUser(User user) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT *\n"
                    + "FROM nguoi_choi\n"
                    + "WHERE ten_nguoi_choi = ?\n"
                    + "AND ID = ?");
            preparedStatement.setInt(1, user.getID());
            preparedStatement.setString(2, user.getTen_nguoi_choi());
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                        
                );
                        }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByID(int ID) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM nguoi_choi\n"
                    + "WHERE ID=?");
            preparedStatement.setInt(1, ID);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
             if (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                        
                );
                        }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO nguoi_choi(ID, ten_nguoi_choi)\n"
                    + "VALUES(?,?)");
            preparedStatement.setInt(1, user.getID());
            preparedStatement.setString(2, user.getTen_nguoi_choi());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public int getSo_tran_thang(int ID) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT nguoi_choi.so_tran_thang\n"
                    + "FROM nguoi_choi\n"
                    + "WHERE nguoi_choi.ID = ?");
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }
    public int getSo_tran_thua(int ID) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT nguoi_choi.so_tran_thua\n"
                    + "FROM nguoi_choi\n"
                    + "WHERE nguoi_choi.ID = ?");
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }
    
    public void addSo_tran_thua(int ID){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE nguoi_choi\n"
                    + "SET nguoi_choi.So_tran_thua = ?\n"
                    + "WHERE nguoi_choi.ID = ?");
            preparedStatement.setInt(1, new UserDAO().getSo_tran_thua(ID)+1);
            preparedStatement.setInt(2, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addWinGame(int ID){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE nguoi_choi\n"
                    + "SET nguoi_choi.so_tran_thang = ?\n"
                    + "WHERE nguoi_choi.ID = ?");
            preparedStatement.setInt(1, new UserDAO().getSo_tran_thang(ID)+1);
            preparedStatement.setInt(2, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public int getSo_tran(int ID) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT user.NumberOfGame\n"
                    + "FROM nguoi_choi\n"
                    + "WHERE nguoi_choi.ID = ?");
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return -1;
    }

    public void addGame(int ID) {
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE nguoi_choi\n"
                    + "SET nguoi_choi.so_tran_thang = ?\n"
                    + "WHERE nguoi_choi.ID = ?");
            preparedStatement.setInt(1, new UserDAO().getSo_tran_thang(ID) + 1);
            preparedStatement.setInt(2, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void decreaseGame(int ID){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE nguoi_choi\n"
                    + "SET nguoi_choi.so_tran_thang = ?\n"
                    + "WHERE nguoi_choi.ID = ?");
            preparedStatement.setInt(1, new UserDAO().getSo_tran_thang(ID) - 1);
            preparedStatement.setInt(2, ID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   
    
}
