package com;

import java.awt.event.*;
import javax.swing.*;
import java.io.File;		// io输入输出用到的库
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


// 继承主函数，获得主函数中的所有组件属性
public class MenuBars extends Main{
	/**
	 * 菜单条，包括组件的功能，所有的注释由上往下阅读
	 * 
	 * */
	// 创建菜单选项
	JMenu file = new JMenu("文件(F)");
	JMenu edit = new JMenu("编辑(E)");
	JMenu format = new JMenu("格式(O)");
	JMenu help = new JMenu("帮助(H)");
	// 在编辑的选项中添加菜单组件
	JMenuItem newItem = new JMenuItem("新建(N)");
	JMenuItem openItem = new JMenuItem("打开(O)...");
	JMenuItem saveItem = new JMenuItem("保存(S)");
	JMenuItem closeItem = new JMenuItem("关闭(C)");
	JMenuItem exitItem = new JMenuItem("退出(X)");
	// 编辑菜单	
	JMenuItem copyItem = new JMenuItem("复制(C)");
	JMenuItem poasteItem = new JMenuItem("粘贴(P)");
	JMenuItem findItem = new JMenuItem("查找(F)");
	JMenuItem receItem = new JMenuItem("替换(R)");
	// 格式菜单
	JCheckBoxMenuItem wline = new JCheckBoxMenuItem("自动换行(W)...");
	JMenuItem fontItem = new JMenuItem("字体(F)...");
	// 帮助菜单、
	JMenuItem aboutlItem = new JMenuItem("关于记事本(A)");
	
	// 添加标签
	JLabel l1 = new JLabel("字体颜色：");
	JLabel l2 = new JLabel("字体大小：");
	JLabel l3 = new JLabel("字体风格：");
	// 添加下拉框列表
	String[] color = new String[] 
			{"红色","蓝色","绿色","黄色","粉色","橙色","黑色","白色"};
	String[] size = new String[] {"超级大号","超大号","大号","中号","小号"};
	String[] type = new String[] {"斜体","粗斜体","正常"};
	JComboBox<String> coch1 = new JComboBox<>(color);
	JComboBox<String> coch2 = new JComboBox<>(size);
	JComboBox<String> coch3 = new JComboBox<>(type);
	
	/**
	 * 1、组装组件
	 * 2、事件监听器和触发事件入口，包括所有组件的事件
	 * 
	 * */
	public void mbs() {	
		// 给文件菜单项添加菜单组件
		file.add(newItem);
		file.add(openItem);
		file.add(saveItem);
		file.add(closeItem);
		file.addSeparator();   // 分割线
		file.add(exitItem);
		
		// 给编辑添加菜单组件
		edit.add(copyItem);
		edit.add(poasteItem);
		edit.addSeparator();   // 分割线
		edit.add(findItem);
		edit.add(receItem);
		
		// 给格式添加菜单组件
		format.add(wline);		
		format.addSeparator();   // 分割线
		format.add(fontItem);
		// 给帮助添加菜单组件
		help.add(aboutlItem);		
	
		// 将菜单在窗口中显示
		mb.add(file);		// 菜单项(文件)
		mb.add(edit);		// 菜单项(编辑)
		mb.add(format);		// 菜单项(格式)
		mb.add(help);		// 菜单项(帮助)
		
		// 菜单监听事件(退出事件)
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// 菜单监听事件(关于事件)
		aboutlItem.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				Helps hs= new Helps(f); // 创建子窗口对象
				hs.setVisible(true);    // 显示子窗口			
			}
		});
		
		// 菜单监听事件(按钮打开文件事件)
		openItem.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {		
				openfile.setVisible(true);	//  显示打开文件的对话框
				// 读取文件路径和文件名
				File file = new File(openfile.getDirectory()+openfile.getFile());
			 try {  // 捕捉打开读取文件错误
				 // 创建字符输入流
				FileReader fr = new FileReader(file);
				// 创建数组，长度为999...
				char[] sttr = new char[999999];   
				// 整形变量，用于读取到的字符数
				int a = 0;
				
				try {  // 捕捉读取字符错误
					// 循环读取字符过程
					while ((a = fr.read(sttr)) > 0 ) {
						// 取出数组中的字符，然后转化成字符，将字符在文本域显示
						ta.setText(new String(sttr,0,a));  // ta是文本域的对象
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// 也可以设置输出错误信息
					
			   } 
			}
		});
		
		// 菜单监听事件(按钮保存文件事件)
		saveItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				// savefile 是一个保存的按钮
				savefile.setVisible(true);
				try {					
					FileWriter fw = new FileWriter(savefile.getDirectory()+savefile.getFile());  // 输出流
					// 将文本域的文件写入到文件
					String sttr ;    // 字符变量，存储文本					
					sttr = ta.getText();  // 获取文本域的内容，赋值给sttr					
					// System.out.println(sttr); // 这个测试是否可以正常输出文本域的内容					
					fw.write(sttr);    // write 写入内容					
					fw.close();		 // 关闭文件
					
				} catch (IOException e1) {
					
				}			
			}
		});
		  
		// 菜单监听事件(自动换行事件)
		wline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			// 判断复选框是否被勾选
				if (wline.getState()) {
					ta.setLineWrap(true);           // 为真，文本域的内容就自动换行
					ta.setWrapStyleWord(true);      // 换行但不断字	
				} else {
					ta.setLineWrap(false);			// 取消换行
				}					
			}
		});
		
		// 菜单监听事件(按钮关闭文件事件)
		closeItem.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				// 当点击关闭文件时，清空文本域的内容
				ta.setText("");							
			}
		});
		// 菜单监听事件(格式按钮事件)
		 fontItem.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				// 创建对象
				Formats formats = new Formats(f);
				// 显示格式的弹窗
				formats.setVisible(true);			
			}
		});
	   
		// 菜单监听事件(查找/替换按钮事件)
		findItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Cat cat = new Cat(f);	// 创建查看按钮弹窗对象
				cat.setVisible(true);	// 显示弹窗			
			}
		});
		receItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cat cat = new Cat(f);	// 同上
				cat.setVisible(true);					
			}
		});
	
		// 菜单监听事件(新建文件按钮事件)
		newItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
			NewFile newFile = new NewFile(f);
			newFile.setVisible(true);
				
			}
		});
		
		 // 菜单监听事件(复制事件)
	    copyItem.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				RightMenu rm = new RightMenu();
				rm.Cp();	// 调用复制方法			
			}
		});
	    // 菜单监听事件(粘贴事件)
	    poasteItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				RightMenu rm = new RightMenu();
				rm.Pa();	// 调用粘贴方法		
			}
		});	
	  
	 // 鼠标右键菜单事件，在这里调用方法
	RightMenu rightMenu = new RightMenu();
	rightMenu.init();	
	}
}
