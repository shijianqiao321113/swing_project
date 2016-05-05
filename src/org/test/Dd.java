package org.test;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Dd extends JFrame {

	public Dd() throws HeadlessException {
		super("将程序图标写到任务栏中");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		setDesktop();
	}

	public static void main(String[] args) {
		new Dd();
	}

	public static void setDesktop() {
		SystemTray st = SystemTray.getSystemTray();
		PopupMenu pm = new PopupMenu();
		if (SystemTray.isSupported()) {// 判断当前平台是否支持系统托盘
			Image image = Toolkit.getDefaultToolkit().getImage("D:\\my_working_directory\\eclipse_x64_work\\Windows_Utils\\images\\http_tools_TrayIcon_image.png");// 定义托盘图标的图片
			/////////// 设置右击图标菜单
			MenuItem openBrowser = new MenuItem("Open My Blog");
			openBrowser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			MenuItem sendMail = new MenuItem("Send Mail to me");
			sendMail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			MenuItem edit = new MenuItem("Edit Text File");
			sendMail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			// 关闭
			MenuItem exitMenu = new MenuItem("&Exit");
			exitMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			pm.add(openBrowser);
			pm.add(sendMail);
			pm.add(edit);
			pm.addSeparator();// 横线
			pm.add(exitMenu);
			//////////
			TrayIcon ti = new TrayIcon(image, "时间计算", pm);
			try {
				st.add(ti);
			} catch (AWTException ex) {
				ex.printStackTrace();
			}
		}
	}
}