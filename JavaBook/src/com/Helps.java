package com;

import javax.swing.*;


public class Helps extends JDialog {
	/**
	 * 
	 * 关于笔记本类，存放笔记本弹窗的有关组件
	 * 所有的注释由上往下阅读
	 * 
	 * */
	public Helps(JFrame frame) {
		// 阻塞其他窗口
		super(frame, "关于记事本", true);
		// 获取布局的容器
		getContentPane();         
		setLayout(null);    // 使用绝对布局
		// 创建标签
		JLabel L1 = new JLabel("记事本");		
		JLabel L2 = new JLabel("1、某某某");
		JLabel L3 = new JLabel("1、某某某");
		JLabel L4 = new JLabel("1、某某某");
		// 设置组件的位置和大小
		L1.setBounds(75,10,40,40); 	// x,y,宽,高
		L2.setBounds(55,45,80,40);
		L3.setBounds(55,65,80,40);
		L4.setBounds(55,85,80,40);
		// 把组件添加到布局
		add(L1);
		add(L2);	
		add(L3);
		add(L4);
	
		setBounds(300,300,200,200);    // 窗体坐标和大小
		setResizable(false);		   // 设置弹窗不可更改大小
		// 刷新容器
		validate();	
	
	}

}
