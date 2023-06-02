/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class XOButton extends JButton {
	private ImageIcon X;
	private ImageIcon O;
	public Point point;
	public static boolean isXMove = true;
	public int value = 0;
	
	public XOButton(int x, int y) {
		X = new ImageIcon("src/IMG/X1.png");
		O = new ImageIcon("src/IMG/O1.png");
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		this.setIcon(new ImageIcon("src/IMG/blank.png"));
		this.point = new Point(x, y);
                XOButton _this = this;
		this.addMouseListener( new MouseListener() {

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if(_this.isEnabled()){
                            _this.setIcon(new ImageIcon("src/IMG/blank.png"));
                        }
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if(_this.isEnabled()) {
                            
                            _this.setIcon(new ImageIcon("src/IMG/X1.png"));
                        }
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // TODO Auto-generated method stub

                    }
                });
	}
	
	public void setState(Boolean isXMove) {
		if (isXMove) {
			setIcon(X);
			value = 2;
			XOButton.isXMove = false;
                        this.setDisabledIcon(X);
		} else {
			setIcon(O);
			value = 1;
                        this.setDisabledIcon(O);
			XOButton.isXMove = true;
		}
	}
        public void resetState(){
            value = 0;
            this.setEnabled(true);
            this.setIcon(new ImageIcon("src/IMG/blank.png"));
            this.setDisabledIcon(new ImageIcon("src/IMG/blank.png"));
        }
	
	
}