package com;

import java.awt.*;
import javax.swing.*;


public class Main{
	/**
	 * 
	 * 主函数，程序入口，使用该文件即可调用所有文件的事件
	 * 所有的注释由上往下阅读
	 * 
	 * */
	 // 使用右键菜单的常量Rp
	 private static final Component Rp = RightMenu.Rp;
	 // 创建静态右键菜单实例	
	 static JPopupMenu pop = new JPopupMenu();
	 // 创建静态菜单条方便其他文件引用
	 static JMenuBar mb = new JMenuBar();		
	 // 创建静态父窗口方便其他文件引用	
	 static JFrame f = new JFrame("模拟记事本 ");	
	 // 使用swing框架的文本域，awt的组件会屏蔽下拉框
	 static JTextArea ta = new JTextArea();  
	 
	 // 添加打开和保存文件的对话框
	 FileDialog openfile = new FileDialog(f,"选择要打开的文件",FileDialog.LOAD);
	 FileDialog savefile = new FileDialog(f,"选择要保存的文件",FileDialog.SAVE);
	
		
	// 主程序入口
	public static void main(String[] args) {
		// 添加右键菜单
		f.add(Rp);
		// 创建容器盛装网格布局
		JPanel p2 = new JPanel(new GridLayout(1,1));
			
		// 添加滚动条布局
		ScrollPane sc = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		// 在滚动条布局中添加文本域		
		sc.add(ta);
		// 把滚动条布局追加到网格布局当中
		p2.add(sc);
		// 把网格布局追加到窗口		
		f.add(p2);		
		// 添加菜单条
		f.setJMenuBar(mb);
	
		// 这个是调用全部文件的关键对象
		MenuBars aMenuBars = new MenuBars();
		aMenuBars.mbs();	// 调用菜单条里面的方法，该方法包含了所有组件的事件		
		// 调用右键菜单，不需要事件响应
		ta.setComponentPopupMenu(pop);
		
		// 显示窗口	
		f.setVisible(true);		
		// 布局大小，放在后面是让前面的组件正常显示
		f.setBounds(200,200,800,600);
		// 刷新容器
		f.validate();
		// 关闭窗口
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
