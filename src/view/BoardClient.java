package view;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public final class BoardClient extends javax.swing.JFrame {
    static String tenNguoiChoi1;
    static Integer idNguoiChoi1;
    static Integer idNguoiChoi2;
    static String tenNguoiChoi2;
    public int score1 = 0;
    public int score2 = 0;
    final int n = 19, m = 19;
    JButton[][] btn;
    JButton lastMove = null;
    public int diem = 0;
    public int currentPlayer = 1;

    public BoardClient() {
        initComponents();
        // board
        String[] options = {"Người chơi 1", "Người chơi 2"};
        int result = JOptionPane.showOptionDialog(this, "Chọn người chơi đi trước", "Bắt đầu trận đấu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (result == JOptionPane.YES_OPTION) {
            currentPlayer = 1;
            JOptionPane.showMessageDialog(null, "Người chơi 1 đi trước");
        } else {
            currentPlayer = 2;
            JOptionPane.showMessageDialog(null, "Người chơi 2 đi trước");
        }
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
                    if (currentPlayer == 1) {
                        btn[i][j].setText("X");
                        btn[i][j].setForeground(Color.RED);
                        btn[i][j].setFont(new Font("Arial", Font.BOLD, 12));
                        diem++;
                        if (win(i, j, btn[i][j].getText())) {
                            btn[i][j].setBackground(Color.pink);
                            JOptionPane.showMessageDialog(null, "Người chơi 1 thắng!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
                                            if (currentPlayer == 1) {
                                                try {
                                                    java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doangame", "root", "");
                                                    String updateQuery = "UPDATE nguoi_choi SET diem_so = diem_so + 20, so_tran_thang = so_tran_thang + 1 WHERE ID = ?";
                                                    PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                                                    pstmt.setInt(1, idNguoiChoi1);
                                                    pstmt.executeUpdate();
                                                    pstmt.close();
                                                    conn.close();
                                                } catch (SQLException ex) {
                                                    ex.printStackTrace();
                                                }
                                                try {
                                                    java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doangame", "root", "");
                                                    String updateQuery = "UPDATE nguoi_choi SET diem_so = diem_so - 10 WHERE id = ?";
                                                    PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                                                    pstmt.setInt(1, idNguoiChoi2);
                                                    pstmt.executeUpdate();
                                                    pstmt.close();
                                                    conn.close();
                                                } catch (SQLException ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                try {
                                                    java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doangame", "root", "");
                                                    String updateQuery = "UPDATE nguoi_choi SET diem_so = diem_so + 20, so_tran_thang = so_tran_thang + 1 WHERE ID = ?";
                                                    PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                                                    pstmt.setInt(1, idNguoiChoi2);
                                                    pstmt.executeUpdate();
                                                    pstmt.close();
                                                    conn.close();
                                                } catch (SQLException ex) {
                                                    ex.printStackTrace();
                                                }
                                                try {
                                                    java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doangame", "root", "");
                                                    String updateQuery = "UPDATE nguoi_choi SET diem_so = diem_so - 10 WHERE ID = ?";
                                                    PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                                                    pstmt.setInt(1, idNguoiChoi1);
                                                    pstmt.executeUpdate();
                                                    pstmt.close();
                                                    conn.close();
                                                } catch (SQLException ex) {
                                                    ex.printStackTrace();
                                                }
                                            }

                            tangdiem1();
                            for (int i1 = 0; i1 < n; i1++) {
                                for (int j1 = 0; j1 < m; j1++) {
                                    btn[i1][j1].setText("");
                                    btn[i1][j1].setBackground(Color.white);
                                }
                            }
                        }
                        currentPlayer = 2;
                    } else {
                        btn[i][j].setText("O");
                        btn[i][j].setForeground(Color.blue);
                        btn[i][j].setFont(new Font("Arial", Font.BOLD, 12));
                        diem++;
                        if (win(i, j, btn[i][j].getText())) {
                            btn[i][j].setBackground(Color.green);
                            JOptionPane.showMessageDialog(null, "Người chơi 2 thắng!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
                            tangdiem2();
                            JOptionPane.showMessageDialog(null, "Trò Chơi Mới", "Thoát", JOptionPane.INFORMATION_MESSAGE);
                            if (currentPlayer == 1) {
                                                try {
                                                    java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doangame", "root", "");
                                                    String updateQuery = "UPDATE nguoi_choi SET diem_so = diem_so + 20, so_tran_thang = so_tran_thang + 1 WHERE ID = ?";
                                                    PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                                                    pstmt.setInt(1, idNguoiChoi1);
                                                    pstmt.executeUpdate();
                                                    pstmt.close();
                                                    conn.close();
                                                } catch (SQLException ex) {
                                                    ex.printStackTrace();
                                                }
                                                try {
                                                    java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doangame", "root", "");
                                                    String updateQuery = "UPDATE nguoi_choi SET diem_so = diem_so - 10 WHERE id = ?";
                                                    PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                                                    pstmt.setInt(1, idNguoiChoi2);
                                                    pstmt.executeUpdate();
                                                    pstmt.close();
                                                    conn.close();
                                                } catch (SQLException ex) {
                                                    ex.printStackTrace();
                                                }
                                            } else {
                                                try {
                                                    java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doangame", "root", "");
                                                    String updateQuery = "UPDATE nguoi_choi SET diem_so = diem_so + 20, so_tran_thang = so_tran_thang + 1 WHERE ID = ?";
                                                    PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                                                    pstmt.setInt(1, idNguoiChoi2);
                                                    pstmt.executeUpdate();
                                                    pstmt.close();
                                                    conn.close();
                                                } catch (SQLException ex) {
                                                    ex.printStackTrace();
                                                }
                                                try {
                                                    java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/doangame", "root", "");
                                                    String updateQuery = "UPDATE nguoi_choi SET diem_so = diem_so - 10 WHERE ID = ?";
                                                    PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                                                    pstmt.setInt(1, idNguoiChoi1);
                                                    pstmt.executeUpdate();
                                                    pstmt.close();
                                                    conn.close();
                                                } catch (SQLException ex) {
                                                    ex.printStackTrace();
                                                }}
                            for (int i1 = 0; i1 < n; i1++) {
                                for (int j1 = 0; j1 < m; j1++) {
                                    btn[i1][j1].setText("");
                                    btn[i1][j1].setBackground(Color.white);
                                }
                            }
                        }
                        currentPlayer = 1;
                    }
                }

            }
        }
    }
    public void tangdiem1(){
        score1++;
        lbTiso1.setText(score1 + "-" + score2);
        String e = lbTiso1.getText();
        lbTiso1.setText(e);
    }
    public void tangdiem2(){
        score2++;
        lbTiso1.setText(score1 + "-" + score2);
        String e = lbTiso1.getText();
        lbTiso1.setText(e);
        
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
        lbTiso1 = new javax.swing.JLabel();
        plPlayer = new javax.swing.JPanel();
        lbAvartar2 = new javax.swing.JLabel();
        lbAvartar1 = new javax.swing.JLabel();
        lbTen1 = new javax.swing.JLabel();
        lbTen2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Caro");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        plBoardContainer.setBorder(null);
        plBoardContainer.setLayout(new java.awt.GridBagLayout());

        plScore.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Tỉ số", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 16))); // NOI18N

        lbTiso1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lbTiso1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTiso1.setText(" ");

        javax.swing.GroupLayout plScoreLayout = new javax.swing.GroupLayout(plScore);
        plScore.setLayout(plScoreLayout);
        plScoreLayout.setHorizontalGroup(
            plScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plScoreLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lbTiso1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plScoreLayout.setVerticalGroup(
            plScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(plScoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTiso1))
        );

        plPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Người chơi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 16))); // NOI18N

        lbAvartar2.setBackground(new java.awt.Color(255, 153, 153));
        lbAvartar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/2 (1).png"))); // NOI18N
        lbAvartar2.setBorder(null);

        lbAvartar1.setBackground(new java.awt.Color(255, 153, 153));
        lbAvartar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/1 (1).png"))); // NOI18N
        lbAvartar1.setBorder(null);

        lbTen1.setText("Bình");

        lbTen2.setText("Linh");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/O1.png"))); // NOI18N
        jLabel1.setText(" ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/X2.png"))); // NOI18N
        jLabel2.setText(" ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/swords-1.png"))); // NOI18N

        javax.swing.GroupLayout plPlayerLayout = new javax.swing.GroupLayout(plPlayer);
        plPlayer.setLayout(plPlayerLayout);
        plPlayerLayout.setHorizontalGroup(
            plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAvartar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbAvartar2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(plPlayerLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plPlayerLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addComponent(lbTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plPlayerLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbTen2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        plPlayerLayout.setVerticalGroup(
            plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAvartar1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(lbAvartar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plPlayerLayout.createSequentialGroup()
                        .addComponent(lbTen1)
                        .addGap(6, 6, 6))
                    .addComponent(lbTen2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plPlayerLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(11, 11, 11))
                        .addGroup(plPlayerLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(plPlayerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 16))); // NOI18N

        jButton2.setText("Ván mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Trang chủ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Thoát");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton3)
                        .addGap(22, 22, 22)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton2)
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
                .addComponent(plBoardContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(plPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(plPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        plBoardContainer.getAccessibleContext().setAccessibleName("");
        plBoardContainer.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Trò Chơi Mới", "Thoát", JOptionPane.INFORMATION_MESSAGE);
            for (int i1 = 0; i1 < n; i1++) {
                for (int j1 = 0; j1 < m; j1++) {
                    btn[i1][j1].setText("");
                    btn[i1][j1].setBackground(Color.white);
                }
            }
            
 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Bạn muốn thoát?", "Thoát", JOptionPane.INFORMATION_MESSAGE);
        Home Home = new Home();
        Home.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed
    
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbAvartar1;
    private javax.swing.JLabel lbAvartar2;
    private javax.swing.JLabel lbTen1;
    private javax.swing.JLabel lbTen2;
    private javax.swing.JLabel lbTiso1;
    private javax.swing.JPanel plBoardContainer;
    private javax.swing.JPanel plPlayer;
    private javax.swing.JPanel plScore;
    // End of variables declaration//GEN-END:variables
}
