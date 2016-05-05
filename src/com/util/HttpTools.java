package com.util;

import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Color;

public class HttpTools extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HttpTools frame = new HttpTools();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HttpTools() {
		setBackground(Color.RED);
		setForeground(Color.WHITE);
		setTitle("HTTP工具");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 620);
		getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 520, 352);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请求URL：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 79, 33);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("楷体", Font.BOLD, 14));
		textField.setBounds(87, 10, 419, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("请求类型：");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 51, 79, 33);
		panel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(87, 51, 170, 33);
		comboBox.addItem("GET");
		comboBox.addItem("POST");
		
		panel.add(comboBox);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		
		JLabel label_1 = new JLabel("超时时间：");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(260, 53, 79, 33);
		panel.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(338, 53, 170, 33);
		comboBox_1.addItem("30秒");
		comboBox_1.addItem("60秒");
		comboBox_1.addItem("120秒");
		comboBox_1.addItem("180秒");
		panel.add(comboBox_1);
		
		table = new JTable(new String[][]{{"11","22"},{"22","33"}},new String[]{"222","333"});
		table.setBounds(31, 113, 419, 100);
		panel.add(table);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(530, 0, 214, 592);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(72, 456, -60, -60);
		getContentPane().add(textArea);
		
		ScrollPane scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(0, 361, 520, 231);
		getContentPane().add(scrollPane_1);
	}
}
