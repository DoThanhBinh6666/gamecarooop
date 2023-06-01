
package DAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class ConnectToXAMPP {

  public static void main(String[] args) throws SQLException {
    String url = "jdbc:mysql://localhost:3306/doangame";
    String user = "root";
    String password = "";
  
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      System.out.println("Ket noi thanh cong");
      System.out.println(conn.getCatalog());
    } catch(SQLException ex) {
      Logger.getLogger(ConnectToXAMPP.class.getName()).log(Level.SEVERE, "loi khi ket noi MySQL", ex);
    }
  }
}
