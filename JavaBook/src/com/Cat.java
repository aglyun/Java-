package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Cat extends JDialog{
	/**
	  * 查找和替换功能的类，所有的注释由上往下阅读
	 * 
	 * */
	// 创建常量并且指定到Main函数中的文本域，ta=文本域
	protected static final JTextArea ta = Main.ta;
	// 弹窗构造器
	public Cat(JFrame frame) {
		super(frame,"查找/替换",true);  // 为真，就阻塞其他窗口
		// 获取容器
		Container c = getContentPane();
		// 创建容器
		c.setLayout(null);				
		// 新建输入框和按钮
		TextField t1s = new TextField(30);
		TextField t2s = new TextField(30);   
		JButton b1 = new JButton("查找"),b2 = new JButton("替换");
		
		// 添加标签		
		Label label1 = new Label();  // 提升已经找到的数量
		Label label2 = new Label();	 // 提示已经替换的数量
		// 设置组件的位置和大小(绝对位置)
		t1s.setBounds(10,30,170,30);  // x,y,宽,高
		b1.setBounds(190,30,80,30);			
		t2s.setBounds(10,80,170,30);
		b2.setBounds(190,80,80,30);
		label1.setBounds(130, 150, 100, 30);
		label2.setBounds(130, 160, 300, 60);
		
		// 设置文本框输入文字的大小
		t1s.setFont(new Font("正常",Font.BOLD,20));
		t2s.setFont(new Font("正常",Font.BOLD,20));
		
		// 添加组件到容器
		c.add(t1s);
		c.add(b1);
		c.add(t2s);
		c.add(b2);
		c.add(label1);
		c.add(label2);
		
		setResizable(false);   		    // 设置弹窗是否可以改变大小
		setBounds(555,255,300,250);	 	// x,y,宽,高			
		c.validate();					// 刷新容器
		
		// 菜单监听事件(查找按钮事件)	
		b1.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {										
				// ta 是文本域，tls 是输入框
				String s1 = ta.getText();    // 定义字符串s1用来请求文本域的数据
				String s2 = t1s.getText();	 //  同样，s2用来存储文本框的数据						
				// 定义变量用于计数
				int a = 0;
				int b = 0;
				// 判断文本框是否为空
				if (s2.length()!=0) {
					while ((a = s1.indexOf(s2,a))!=-1) {
						a = a+s2.length();
						b ++;}			
				}else {}
				// 提示找到了字符的数量
				label1.setText("找到 "+b+" 个字符");					
			}
		});
		
		 // 添加事件
		b2.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				String tString1 = ta.getText();  // 请求文本域的数据储存到字符串
				String tString2 = t1s.getText(); // 请求文本框的数据并且储存到字符串
				String tString3 = t2s.getText(); // 请求替换文本框中的数据并且储存到字符串			
				// 定义字符串用来储存替换后的数据
				String Th = "";
				// s1(简称)是文本域的数据，调用replace方法，查找s2的文本，并且替换成s3指定的文本
				Th = tString1.replace(tString2, tString3);
				// ta 文本域的内容重写为Th的内容
				label2.setText("已替换成  "+tString3 +" 字符");
				// 文本域内容重新替换
				ta.setText(Th);		
			}					    
		});		
	}
}
