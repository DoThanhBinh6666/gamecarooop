package view;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public final class BoardClient extends javax.swing.JFrame {
    static String tenNguoiChoi1;
    static Integer idNguoiChoi1;
    static Integer idNguoiChoi2;
    static String tenNguoiChoi2;
    final int n = 19, m = 19;
    JButton[][] btn;
    JButton lastMove = null;
    public int diem = 0;

    public BoardClient() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // board
        plBoardContainer.setLayout(new GridLayout(m, n));
        initBoard();

    }

    public void initBoard() {
        plBoardContainer.removeAll();
        this.setIconImage(new ImageIcon("src/IMG/icon game.png").getImage());
        this.setTitle("Caro Game");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        btn = new JButton[n + 2][m + 2];

        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                btn[row][column] = createBoardButton(row, column);
                btn[row][column].addActionListener(new ActionListener(){
                      public void actionPerformed(ActionEvent e) {
        /**/

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (e.getSource() == btn[i][j] && !"X".equals(btn[i][j].getText()) && !"O".equals(btn[i][j].getText())) {
                    if (diem % 2 == 0) {
                        btn[i][j].setText("X");
                        btn[i][j].setForeground(Color.RED);
                        diem++;
                        if (win(i, j, btn[i][j].getText())) {
                            btn[i][j].setBackground(Color.red);
                            JOptionPane.showMessageDialog(null, "X win!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
                            for (int i1 = 0; i1 < n; i1++) {
                                for (int j1 = 0; j1 < m; j1++) {
                                    btn[i1][j1].setText("");
                                    btn[i1][j1].setBackground(Color.white);
                                }
                            }
                        }
                    } else {
                        btn[i][j].setText("O");
                        btn[i][j].setForeground(Color.BLACK);
                        diem++;
                        if (win(i, j, btn[i][j].getText())) {
                            btn[i][j].setBackground(Color.green);
                            JOptionPane.showMessageDialog(null, "O win!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
                            JOptionPane.showMessageDialog(null, "Trò Chơi Mới", "Thoát", JOptionPane.INFORMATION_MESSAGE);
                            for (int i1 = 0; i1 < n; i1++) {
                                for (int j1 = 0; j1 < m; j1++) {
                                    btn[i1][j1].setText("");
                                    btn[i1][j1].setBackground(Color.white);
                                }
                            }
                        }
                    }
//                JOptionPane.showMessageDialog(this, i + " " + j);
                }

            }
        }
    }

    //kiem tra thang 
    public boolean win(int x, int y, String name) {
        int k, j;
        int d = 0;
        // kt chieu doc
        for (k = -4; k <= 4; k++) {
            if (x + k >= 0 && x + k < n) {
                if (btn[x + k][y].getText() == name) {
                    d++;
                } else if (d < 5) {
                    d = 0;
                }
            }
        }
        if (d >= 5) {
            return true;
        } else {
            d = 0;
        }
        //xet ngang
        for (k = -5; k <= 5; k++) {
            if (y + k >= 0 && y + k < n) {
                if (btn[x][y + k].getText() == name) {
                    d++;
                } else if (d < 5) {
                    d = 0;
                }
            }
        }
        if (d >= 5) {
            return true;
        } else {
            d = 0;
        }
        //cheo
        for (k = -4, j = 4; k <= 4 && j >= -4; k++, j--) {
            if (y + k >= 0 && y + k < n && x + j >= 0 && x + j < m) {
                if (btn[x + j][y + k].getText() == name) {
                    d++;
                } else if (d < 5) {
                    d = 0;
                }
            }
        }
        if (d >= 5) {
            return true;
        } else {
            d = 0;
        }
        for (k = -4; k <= 4; k++) {
            if (y + k >= 0 && y + k < n && x + k >= 0 && x + k < m) {
                if (btn[x + k][y + k].getText() == name) {
                    d++;
                } else if (d < 5) {
                    d = 0;
                }
            }
        }
        if (d >= 5) {
            return true;
        }
        return false;
    }

                
     });
                //khi con trỏ chuột trỏ vào phần tử tương ứng nào

                plBoardContainer.add(btn[row][column]);
            }
        }
    }

    public void setLastMove(int row, int column) {
        lastMove = btn[row][column];
    }

    public void addPoint(int row, int column, String email) {
        if (lastMove != null) {
            lastMove.setBackground(new Color(180, 180, 180));
        }

        lastMove = btn[row][column];
        lastMove.setBackground(Color.yellow);
    }

    public JButton createBoardButton(int row, int column) {
        JButton b = new JButton();
        b.setFocusPainted(false);
        b.setBackground(new Color(180, 180, 180));
        b.setActionCommand("");
        // test
        // addPoint(row, column, "");
        return b;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plBoardContainer = new javax.swing.JPanel();
        plScore = new javax.swing.JPanel();
        lbPlayer1 = new javax.swing.JLabel();
        koten = new javax.swing.JLabel();
        lbPlayer2 = new javax.swing.JLabel();
        plPlayer = new javax.swing.JPanel();
        lbAvartar2 = new javax.swing.JLabel();
        lbAvartar1 = new javax.swing.JLabel();
        lbTen1 = new javax.swing.JLabel();
        lbTen2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jbUndo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Caro");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout plBoardContainerLayout = new javax.swing.GroupLayout(plBoardContainer);
        plBoardContainer.setLayout(plBoardContainerLayout);
        plBoardContainerLayout.setHorizontalGroup(
            plBoardContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 742, Short.MAX_VALUE)
        );
        plBoardContainerLayout.setVerticalGroup(
            plBoardContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        plScore.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Tỉ số", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 16))); // NOI18N

        lbPlayer1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbPlayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlayer1.setText("0");
        plScore.add(lbPlayer1);

        koten.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        koten.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        koten.setText("-");
        plScore.add(koten);

        lbPlayer2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbPlayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPlayer2.setText("0");
        plScore.add(lbPlayer2);

        plPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Người chơi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 16))); // NOI18N

        lbAvartar2.setBackground(new java.awt.Color(255, 153, 153));
        lbAvartar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153), 2));

        lbAvartar1.setBackground(new java.awt.Color(255, 153, 153));
        lbAvartar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153), 2));

        lbTen1.setText("Bình");

        lbTen2.setText("Linh");

        jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jProgressBar1.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jProgressBar1.setStringPainted(true);

        jLabel1.setText("Thời gian:");

        javax.swing.GroupLayout plPlayerLayout = new javax.swing.GroupLayout(plPlayer);
        plPlayer.setLayout(plPlayerLayout);
        plPlayerLayout.setHorizontalGroup(
            plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAvartar1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbAvartar2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(plPlayerLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lbTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTen2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plPlayerLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        plPlayerLayout.setVerticalGroup(
            plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAvartar1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(lbAvartar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTen1)
                    .addComponent(lbTen2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 16))); // NOI18N

        jbUndo.setText("Đánh lại");

        jButton2.setText("Ván mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Trang chủ");

        jButton4.setText("Thoát");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbUndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbUndo)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plBoardContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(plPlayer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plBoardContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(plScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        plBoardContainer.getAccessibleContext().setAccessibleName("");
        plBoardContainer.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(BoardClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BoardClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BoardClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BoardClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BoardClient().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton jbUndo;
    private javax.swing.JLabel koten;
    private javax.swing.JLabel lbAvartar1;
    private javax.swing.JLabel lbAvartar2;
    private javax.swing.JLabel lbPlayer1;
    private javax.swing.JLabel lbPlayer2;
    private javax.swing.JLabel lbTen1;
    private javax.swing.JLabel lbTen2;
    private javax.swing.JPanel plBoardContainer;
    private javax.swing.JPanel plPlayer;
    private javax.swing.JPanel plScore;
    // End of variables declaration//GEN-END:variables
}
