package org.test;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame implements ItemListener {
	JComboBox A, B, C;
	JPanel pane;

	private Test() {
		setBounds(400, 200, 400, 300);
		pane = new JPanel();
		String a[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		A = new JComboBox(a);
		A.addItemListener(this);
		String b[] = { "1", "2", "3", "4", "5" };
		B = new JComboBox(b);
		B.addItemListener(this);
		pane.add(A);
		pane.add(B);
		add(pane);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Test();
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == A) {
			B.removeAllItems();
			String s = (String) e.getItem();
			int n = Integer.parseInt(s);
			for (int i = 1; i <= n; i++) {
				B.addItem(i);
			}
		}
	}
}