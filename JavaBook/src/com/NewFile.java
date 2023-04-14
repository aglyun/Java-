package com;

import java.awt.*;    			// 组件库
import java.awt.event.*;		// 事件库
import java.io.*;				// 文件输出输入库
import javax.swing.*;			// swing组件库
import javax.swing.text.JTextComponent;


public class NewFile extends JDialog{	
	/**
	 * 新建文件，包括组件和事件，所有的注释由上往下阅读
	 * 
	 * */
	// 创建常量并且指定到Main函数中的文本域，ta=文本域
	protected static final JTextComponent ta = Main.ta;
	// 弹窗构造器
	public NewFile(JFrame frame) {
		super(frame,"新建文件",true);
		Container c = getContentPane();		// 获取容器
		// 设置容器的布局
		c.setLayout(null);
		JLabel L1 = new JLabel("输入文件名：");		// 提示标签
		JTextField jt = new JTextField(15);		// 创建文本框，用来输入文件名			
		JButton button = new JButton("确定");		// 确定按钮
		
		// 设置标签、文本框、按钮的绝对位置
		L1.setBounds(30,12,100,30);
		jt.setBounds(30,42,200,30);				// x,y,宽,高
		button.setBounds(255,42,60,30);			
		// 把标签、文本框、按钮追加到容器	
		add(L1);
		add(jt);
		add(button);
			
		// 设置窗口位置和大小
		setBounds(300,200,355,150);		
		setResizable(false);    				// 设置弹窗是否可以改变大小
		
		// 确定按钮事件
		button.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				// 新建文件，获取文件路径和文件名
				File newfile = new File(jt.getText()+"");			  				
				try {	// 捕捉开始
					// 建立文件	
					newfile.createNewFile();																
					// 创建成功后在文本域打开该文件
					try {  // 捕捉打开读取文件错误
						// 创建字符输入流
						FileReader fr = new FileReader(newfile);
						// 在文本域提示信息
						ta.setText("\n - 这个文本内容是新建文件成功后的提示 \n - 该文件被创建在项目的根目录下，如果文件名"
								+ "重复会默认打开该文件。\n"
								+ " - 如要修改提示显示，请到项目下的“NewFile.java”文件第53-55行代码进行修改");
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
							// 这个是内部捕捉异常的分支
						}
					} catch (FileNotFoundException e1) {
						// 外部捕捉异常分支							
					   } 
				} catch (IOException e1) {		
					// 最外层捕捉异常分支
				}	
				// 关闭弹窗
				setVisible(false);
			}   
		});	// 括号太多不用理睬	
	}	
}
