package com.viewtools;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.enumclass.ImagesEnum;
import com.enumclass.ToolsEnum;
import com.init.ImageLoad;

public class HttpTools extends JFrame {

	private static final long serialVersionUID = 1L;

	public static HttpTools httptools = null;

	public static Object lock = new Object();
	
	private JLabel url_jlabel;
	private JTextField url_jtextfield;
	private JLabel type_jlabel;
	private JComboBox<Object> type_jcombobox;
	private JLabel time_jlabel;
	private JComboBox<Object> time_jcombobox;
	private JScrollPane parameter_jscrollpane;
	private JButton send_jbutton;
	private JTextArea result_jtextarea;
	
	private JButton getSend_jbutton(){
		if(send_jbutton == null){
			send_jbutton = new JButton();
			send_jbutton.setBounds(20,255,490,40);
			send_jbutton.setText(ToolsEnum.HTTPTOOLSREQUESTBUTTON.getValue());
			send_jbutton.setFont(new Font("楷体", Font.BOLD, 14));
		}
		return send_jbutton;
	}
	private JScrollPane getParameter_jscrollpane(){
		if(parameter_jscrollpane == null){
			parameter_jscrollpane = new JScrollPane();
			parameter_jscrollpane.setSize(new Dimension(500,100));//设置大于多少，显示滚动条
			parameter_jscrollpane.setBounds(20,95, 490, 150);
		}
		return parameter_jscrollpane;
	}
	private JComboBox<Object> getTime_jcombobox(){
		if(time_jcombobox == null){
			time_jcombobox = new JComboBox<Object>(new String[]{"30秒","60秒","120秒","180秒"});
			time_jcombobox.setBounds(338, 53, 170, 33);
		}
		return time_jcombobox;
	}
	private JLabel getTime_jlabel(){
		if(time_jlabel == null){
			time_jlabel = new JLabel();
			time_jlabel.setText(ToolsEnum.HTTPTOOLSTIMELABELTITLE.getValue());
			time_jlabel.setHorizontalAlignment(SwingConstants.CENTER);//设置居中对齐
			time_jlabel.setBounds(260, 53, 79, 33);
		}
		return time_jlabel;
	}
	private JComboBox<Object> getType_jcombobox(){
		if(type_jcombobox == null){
			type_jcombobox = new JComboBox<Object>(new String[]{"GET","POST"});
			type_jcombobox.setBounds(87, 51, 170, 33);
		}
		return type_jcombobox;
	}
	private JLabel getType_jlabel(){
		if(type_jlabel == null){
			type_jlabel = new JLabel();
			type_jlabel.setText(ToolsEnum.HTTPTOOLSREQUESTTYPELABELTITLE.getValue());
			type_jlabel.setHorizontalAlignment(SwingConstants.CENTER); //设置居中对齐
			type_jlabel.setBounds(10, 51, 79, 33);
		}
		return type_jlabel;
	}
	private JTextField getUrl_jtextfield(){
		if(url_jtextfield == null){
			url_jtextfield = new JTextField();
			url_jtextfield.setFont(new Font("楷体", Font.BOLD, 14));
			url_jtextfield.setBounds(87, 10, 419, 33);
		}
		return url_jtextfield;
	}
	private JLabel getUrl_jlabel(){
		if(url_jlabel == null){
			url_jlabel = new JLabel();
			url_jlabel.setText(ToolsEnum.HTTPTOOLSURLLABELTITLE.getValue());
			url_jlabel.setHorizontalAlignment(SwingConstants.CENTER); //设置居中对齐
			url_jlabel.setBounds(10, 10, 79, 33);
		}
		return url_jlabel;
	}
	
	private void LoadUI(){
		JPanel jpanel = new JPanel();
		jpanel.setLayout(null);
		jpanel.setOpaque(true);//设置面板是否透明 true不透明  false透明
		jpanel.setBounds(0,0,this.getWidth(),this.getHeight());
		jpanel.setBackground(Color.white);//设置背景颜色
		jpanel.add(getUrl_jlabel(),null);
		jpanel.add(getUrl_jtextfield(),null);
		jpanel.add(getType_jlabel(),null);
		jpanel.add(getType_jcombobox(),null);
		jpanel.add(getTime_jlabel(),null);
		jpanel.add(getTime_jcombobox(),null);
		jpanel.add(getParameter_jscrollpane(),null);
		jpanel.add(getSend_jbutton(),null);
		this.getContentPane().add(jpanel);
	}
	
	/**
	 * @Title: getHttpTools
	 * @Description: 获取单例对象
	 * @author shi_jianqiao
	 * @date 2016年5月4日 下午5:05:22
	 * @return HttpTools
	 */
	public static HttpTools getHttpTools() {
		synchronized (lock) {
			if (httptools == null) {
				httptools = new HttpTools();
			}
			return httptools;
		}
	}

	/**
	 * 构造函数
	 */
	public HttpTools() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setTitle(ToolsEnum.HTTPTOOLSTITLENAME.getValue());// 窗口标题
		this.setResizable(false);// 禁止改变窗口大小,默认true(可以改变)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗口,结束后台程序
		this.setSize(750, 620);// 设置窗口长宽
		this.setIconImage(ImageLoad.images.get(ImagesEnum.HTTP_TOOLS_WINDOWS_IMAGE.getValue()).getImage());
		this.setLocationRelativeTo(null);// 设置窗口默认屏幕居中显示
		this.loadSystemTray(ImageLoad.images.get(ImagesEnum.HTTP_TOOLS_TRAYICON_IMAGE.getValue()).getImage());// 加载系统托盘
		this.getContentPane().setBackground(Color.white); // 窗口的默认背景色为白色
		
		LoadUI();//加载布局
		
		this.setLayout(null);// 去掉默认布局
		this.setVisible(true);// 显示窗口
	}

	/**
	 * @Title: loadSystemTray
	 * @Description: 加载系统托盘
	 * @author shi_jianqiao
	 * @date 2016年5月4日 下午4:40:29 void
	 */
	private void loadSystemTray(Image trayImage) {
		SystemTray st = SystemTray.getSystemTray();
		if (SystemTray.isSupported()) {// 判断当前平台是否支持系统托盘
			PopupMenu pm = new PopupMenu();
			// 设置右击图标菜单
			MenuItem openBrowser = new MenuItem(ToolsEnum.HTTPTOOLSSYSTEMTRAYSHOWWINDOWS.getValue());
			openBrowser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HttpTools.getHttpTools().setVisible(true);
					return;
				}
			});
			// 关闭
			MenuItem exitMenu = new MenuItem(ToolsEnum.HTTPTOOLSSYSTEMEXIT.getValue());
			exitMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					return;
				}
			});
			pm.add(openBrowser);
			pm.addSeparator();// 横线
			pm.add(exitMenu);

			TrayIcon ticon = new TrayIcon(trayImage, ToolsEnum.HTTPTOOLSTITLENAME.getValue(), pm);// 系统托盘图标
			ticon.addMouseListener(new MouseAdapter() {// 鼠标单击事件
				public void mousePressed(MouseEvent me) {
					if (me.getButton() == MouseEvent.BUTTON1) {
						HttpTools.getHttpTools().setVisible(true);
						return;
					}
				}
			});
			try {
				TrayIcon[] trayIcon = st.getTrayIcons();
				if (trayIcon != null && trayIcon.length > 0) {
					for (TrayIcon icon : trayIcon) {
						st.remove(icon);
					}
				}
				st.add(ticon);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// 启动加载所有的images图片
		if (!ImageLoad.loadImages()) {
			return;
		}
		// 创建窗体
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				HttpTools.getHttpTools();
			}
		});
	}
}
