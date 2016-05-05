package org.test;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.sun.jna.platform.WindowUtils;

public class JFrameBackground extends JFrame {

	public static void main(String[] args) {
        JFrame frame = new JFrame();  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setBounds(500, 500, 300, 300);  
        System.setProperty("sun.java2d.noddraw","true");
        WindowUtils.setWindowAlpha(frame, 0.5f);
        JPanel pane = new JPanel() {  
            public void paint(Graphics g) {  
                super.paint(g);  
  
                g.setColor(Color.red);  
                g.fill3DRect(10, 10, 100, 100, true);  
            }  
        };  
  
        frame.setContentPane(pane);  
        frame.setVisible(true);  
	}
}
