
package DAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class DAO {
    protected Connection con;

  public static void main(String[] args) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/doangame";
    String user = "root";
    String password = "";
  
    try (Connection con = DriverManager.getConnection(url, user, password)) {
      System.out.println("Ket noi thanh cong");
      System.out.println(con.getCatalog());
    } catch(SQLException ex) {
      Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, "loi khi ket noi MySQL", ex);
    }
  }
}
