
package view;

import com.sun.jdi.connect.spi.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Graft extends javax.swing.JFrame {

    public Graft() {
        initComponents();
        this.setIconImage(new ImageIcon("src/IMG/icon game.png").getImage());
        this.setTitle("Caro Game");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txttennguoichoi1 = new javax.swing.JTextField();
        txttennguoichoi2 = new javax.swing.JTextField();
        txtbatdau = new javax.swing.JButton();
        txtid1 = new javax.swing.JPasswordField();
        txtid2 = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Người Chơi 1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 95, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Người Chơi 2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 100, -1));
        getContentPane().add(txttennguoichoi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 120, -1));
        getContentPane().add(txttennguoichoi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 130, -1));

        txtbatdau.setText("Bắt Đầu ");
        txtbatdau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbatdauActionPerformed(evt);
            }
        });
        getContentPane().add(txtbatdau, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 93, -1));
        getContentPane().add(txtid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 120, -1));
        getContentPane().add(txtid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 130, -1));

        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 90, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tên Người Chơi");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 91, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 48, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/graft.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 380, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbatdauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbatdauActionPerformed
    String tenNguoiChoi1 = txttennguoichoi1.getText();
    String tenNguoiChoi2 = txttennguoichoi2.getText();
    String id1 = String.valueOf(txtid1.getPassword());
    String id2 = String.valueOf(txtid2.getPassword());

    // Kiểm tra thông tin người chơi đã nhập đủ hay chưa
    if (tenNguoiChoi1.isEmpty() || tenNguoiChoi2.isEmpty() || id1.isEmpty() || id2.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin người chơi!");
        return;
    }
    
    // Kiểm tra xem id của người chơi 1 và người chơi 2 có giống nhau hay không
    if (id1.equals(id2)) {
        JOptionPane.showMessageDialog(this, "ID của người chơi 1 và người chơi 2 không được giống nhau!");
        return;
    }

    // Kiểm tra xem id của người chơi đã tồn tại trong cơ sở dữ liệu hay chưa
    String url = "jdbc:mysql://localhost:3306/doangame";
    String username = "root";
    String password = "";
    try (java.sql.Connection conn = DriverManager.getConnection(url, username, password)) {
        String query = "SELECT * FROM nguoi_choi WHERE ID = ?";
        PreparedStatement statement = conn.prepareStatement(query);

        statement.setInt(1, Integer.parseInt(id1));
        java.sql.ResultSet rs = statement.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "ID người chơi 1 chưa tồn tại!");
            return;
        }

        statement.setInt(1, Integer.parseInt(id2));
        rs = statement.executeQuery();

        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "ID người chơi 2 chưa tồn tại!");
            return;
        }

        // Lưu thông tin người chơi vào biến static trong lớp BoardClient
        BoardClient.idNguoiChoi1 = Integer.parseInt(id1);
        BoardClient.idNguoiChoi2 = Integer.parseInt(id2);
        BoardClient.tenNguoiChoi1 = tenNguoiChoi1;
        BoardClient.tenNguoiChoi2 = tenNguoiChoi2;

        // Hiển thị JFrame BoardClient
      BoardClient  BoardClient = new BoardClient();
        BoardClient.setVisible(true);
        dispose(); // Đóng JFrame Register
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    
    }//GEN-LAST:event_txtbatdauActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Home homeFrame = new Home(); // tạo một đối tượng JFrame mới
      homeFrame.setVisible(true); // hiển thị JFrame mới
      this.dispose();     
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graft().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton txtbatdau;
    private javax.swing.JPasswordField txtid1;
    private javax.swing.JPasswordField txtid2;
    private javax.swing.JTextField txttennguoichoi1;
    private javax.swing.JTextField txttennguoichoi2;
    // End of variables declaration//GEN-END:variables

    
}
