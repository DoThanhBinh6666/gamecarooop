/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/**
 *
 * @author binh0
 */
public class Ratings extends javax.swing.JFrame {

    /**
     * Creates new form ratings
     */
    public Ratings() {
        initComponents();
        this.setIconImage(new ImageIcon("src/IMG/icon game.png").getImage());
        this.setTitle("Caro Game");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        find = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        rank = new javax.swing.JButton();
        txtidnguoichoi = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nhập ID người chơi :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        find.setText("Tìm Kiếm");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });
        getContentPane().add(find, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 80, -1));

        exit.setText("Thoát");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 140, -1, -1));

        rank.setText("Bảng xếp hạng");
        rank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankActionPerformed(evt);
            }
        });
        getContentPane().add(rank, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 110, -1));
        getContentPane().add(txtidnguoichoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 150, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("THÔNG TIN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ratings.png"))); // NOI18N
        jLabel2.setText(" ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
    int confirmed = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát không?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);

    if (confirmed == JOptionPane.YES_OPTION);
      Home homeFrame = new Home(); // tạo một đối tượng JFrame mới
      homeFrame.setVisible(true); // hiển thị JFrame mới
      this.dispose(); // đóng JFrame hiện tại        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
     String ID= txtidnguoichoi.getText();

    // Kiểm tra xem giá trị của trường idNguoiChoi có phải là số không âm hay không
    if (ID.length() > 10) {
        JOptionPane.showMessageDialog(null, "ID không được vượt quá 6 ký tự.");
    } else {
        // xử lý khi ID hợp lệ
    }
    if (ID.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập ID");
        return;
    }
    if (!ID.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "ID người chơi phải là số nguyên không âm!");
        return;
    } 


    // Thực hiện kết nối tới cơ sở dữ liệu
    String url = "jdbc:mysql://localhost:3306/doangame";
    String username = "root";
    String password = "";

    try (Connection conn = DriverManager.getConnection(url, username, password)) {
 
        // Tạo câu truy vấn SQL để lấy thông tin người chơi theo ID
        String query1 = "SELECT so_tran_thang, diem_so FROM nguoi_choi WHERE ID = ?";
        PreparedStatement statement1 = conn.prepareStatement(query1);

        // Thiết lập giá trị cho các tham số của truy vấn
        statement1.setInt(1, Integer.parseInt(ID));

        // Thực thi truy vấn và lấy kết quả
        java.sql.ResultSet rs1 = statement1.executeQuery();

        // Lấy dữ liệu từ ResultSet và hiển thị chúng trên giao diện người dùng
        if (rs1.next()) {
            int so_tran_thang = rs1.getInt("so_tran_thang");
            int diem_so = rs1.getInt("diem_so");
            JOptionPane.showMessageDialog(this, "Số trận thắng: " + so_tran_thang + "\nĐiểm số: " + diem_so);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin người chơi với ID: " + ID);      
        } 
    } catch (SQLException e) {
    e.printStackTrace();
}
    }//GEN-LAST:event_findActionPerformed

    private void rankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankActionPerformed
        // TODO add your handling code here:
        String url = "jdbc:mysql://localhost:3306/doangame";
    String username = "root";
    String password = "";

    try (Connection conn = DriverManager.getConnection(url, username, password)) {
 
        String query2 = "SELECT ten_nguoi_choi, diem_so FROM nguoi_choi ORDER BY diem_so DESC";
        PreparedStatement statement2 = conn.prepareStatement(query2);

        // Thực thi truy vấn và lấy kết quả
        java.sql.ResultSet rs2 = statement2.executeQuery();

        // Tạo một bảng để hiển thị danh sách các người chơi theo thứ tự giảm dần của điểm số
    // Tạo một bảng để hiển thị danh sách các người chơi theo thứ tự giảm dần của điểm số
String[] columnNames = {"Thứ tự", "Tên người chơi", "Điểm số"};
Object[][] data = new Object[30][3];
int i = 0;
int rank = 1;
while (rs2.next() && i < 30) {
    data[i][0] = rank++;
    data[i][1] = rs2.getString("ten_nguoi_choi");
    data[i][2] = rs2.getInt("diem_so");
    i++;
}
JTable table = new JTable(data, columnNames);
JScrollPane scrollPane = new JScrollPane(table);
JOptionPane.showMessageDialog(this, scrollPane, "Xếp hạng người chơi", JOptionPane.PLAIN_MESSAGE );

} catch (SQLException e) {
    e.printStackTrace();
}
    }//GEN-LAST:event_rankActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ratings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ratings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ratings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ratings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ratings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JButton find;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton rank;
    private javax.swing.JPasswordField txtidnguoichoi;
    // End of variables declaration//GEN-END:variables

    private static class ResultSet {

        public ResultSet() {
        }
    }
}
