package org.test;

/*
 * 简单Swing事件处理程序
 * 作者：刘怀帮
 * 日期：2010年12月8日
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleEvent {
	// 创建UI
	public void createUI() {
		// 创建窗体框架JFram
		JFrame jframe = new JFrame("简单事件处理示例");
		// 设置窗体关闭时操作
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 创建按钮组件，并给按钮组件添加动作事件监听器
		JButton button = new JButton("测试");
		// 给button增加监听器
		button.addActionListener(new ClickAction());
		jframe.getContentPane().add(button);
		// 设置窗体大小
		jframe.setSize(250, 120);
		// 显示 窗体界面
		jframe.setVisible(true);
	}

	// 事件处理内部类ion
	class ClickAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("用于执行了单击操作");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleEvent examle = new SimpleEvent();
		examle.createUI();

	}
}