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
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author binh0
 */
public class Register extends javax.swing.JFrame {


    /**
     * Creates new form register
     */
    public Register() {
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
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txttennguoichoi = new javax.swing.JTextField();
        txtidnguoichoi = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên Người Chơi");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 120, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 100, -1));

        jButton1.setText("Đăng Ký");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 87, -1));

        txttennguoichoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttennguoichoiActionPerformed(evt);
            }
        });
        getContentPane().add(txttennguoichoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 119, -1));
        getContentPane().add(txtidnguoichoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 6, 37, -1));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Home homeFrame = new Home(); // tạo một đối tượng JFrame mới
      homeFrame.setVisible(true); // hiển thị JFrame mới
      this.dispose(); // đóng JFrame hiện tại
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txttennguoichoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttennguoichoiActionPerformed
        
    }//GEN-LAST:event_txttennguoichoiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String ten_nguoi_choi= txttennguoichoi.getText();
    String ID = txtidnguoichoi.getText();

    // Kiểm tra xem giá trị của trường idNguoiChoi có phải là số không âm hay không
    if (!ID.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "ID người chơi phải là số nguyên không âm!");
        return;
    } 

    // Thực hiện kết nối tới cơ sở dữ liệu
    String url = "jdbc:mysql://localhost:3306/doangame";
    String username = "root";
    String password = "";

    try (Connection conn = DriverManager.getConnection(url, username, password)) {
        // Chuẩn bị truy vấn chèn dữ liệu
        String query = "INSERT INTO nguoi_choi (ten_nguoi_choi, ID) VALUES (?, ?)";
        PreparedStatement statement = conn.prepareStatement(query);
   
        // Thiết lập giá trị cho các tham số của truy vấn
        statement.setString(1, ten_nguoi_choi);
        statement.setInt(2, Integer.parseInt(ID)); 

        // Thực thi truy vấn chèn dữ liệu và lấy số lượng bản ghi bị ảnh hưởng
        int rowsInserted = statement.executeUpdate();

        // In ra thông báo nếu chèn dữ liệu thành công
        if (rowsInserted > 0) {
            System.out.println("Thêm thành công,sẵn sàng thịt mấy con gà thôi nào");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }   
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtidnguoichoi;
    private javax.swing.JTextField txttennguoichoi;
    // End of variables declaration//GEN-END:variables
}
