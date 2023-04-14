package com;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Formats extends JDialog{	
	/**
	 * 
	 * 格式类，字体颜色和大小，监控事件
	 * 所有的注释由上往下阅读
	 * 
	 * */
	// 创建常量并且指定到Main函数中的文本域，ta=文本域
	protected static final Component ta = Main.ta;
	// 窗口构造器
	public Formats(JFrame frame) {
		// 阻塞其他窗口
		super(frame, "字体", true);
		// 获取它的容器
		Container c = getContentPane();
		
		// 将容器设置成FlowLayout布局(流布局)
		// c.setLayout(new FlowLayout(10, 20, 20));
		setLayout(null);
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
		// 添加确定按钮	
		JButton b1 = new JButton("确定");
		// 设置组件的绝对布局(标签)
		l1.setBounds(35, 30, 80, 30);    // x,y,宽，高
		l2.setBounds(35, 70, 80, 30);
		l3.setBounds(35, 110, 80, 30);
		// 下拉框
		coch1.setBounds(115, 30, 60, 25);
		coch2.setBounds(115, 70, 60, 25);
		coch3.setBounds(115, 110, 60, 25);
		// 按钮
		b1.setBounds(75,160,60,30);
		// 将设置好位置的组件追加到容器
		c.add(l1);			// 
		c.add(coch1);
		c.add(l2);
		c.add(coch2);
		c.add(l3);
		c.add(coch3);
		c.add(b1);
						
		setResizable(false);    	   // 设置弹窗是否可以改变大小
		setBounds(555,255,230,260);    // 设置弹窗出现的位置和大小		
		validate();					   // 刷新容器
		
		// ‘格式’按钮的触发事件在这里					
		// 添加字体颜色事件		
		coch1.addItemListener(new ItemListener() {		
			public void itemStateChanged(ItemEvent e) {			
				int color = coch1.getSelectedIndex();			
				switch (color) {
				case 0:ta.setForeground(Color.red);break;
				case 1:ta.setForeground(Color.blue);break;
				case 2:ta.setForeground(Color.green);break;
				case 3:ta.setForeground(Color.yellow);break;
				case 4:ta.setForeground(Color.pink);break;
				case 5:ta.setForeground(Color.orange);break;
				case 6:ta.setForeground(Color.black);break;
				case 7:ta.setForeground(Color.white);break;
				default:break;}							
			}
		});
		
		 //添加字号大小事件
		 coch2.addItemListener(new ItemListener() {						
			public void itemStateChanged(ItemEvent e) {
				int size = coch2.getSelectedIndex();	
				// 根据序号来执行对应的事件
				switch (size) {    
				case 0:ta.setFont(new Font("黑体",Font.BOLD,52));break;
				case 1:ta.setFont(new Font("黑体",Font.BOLD,42));break;
				case 2:ta.setFont(new Font("黑体",Font.BOLD,32));break;
				case 3:ta.setFont(new Font("黑体",Font.BOLD,22));break;
				case 4:ta.setFont(new Font("黑体",Font.BOLD,12));break;					
				default:break;}						
			}
		});

		 // 添加字体风格事件
		 coch3.addItemListener(new ItemListener() {				
			public void itemStateChanged(ItemEvent e) {
				int type = coch3.getSelectedIndex();
				if (type == 0) {ta.setFont(new Font("斜体",Font.LAYOUT_NO_START_CONTEXT,20));}					
				else if (type== 1) {ta.setFont(new Font("粗斜体",Font.BOLD+Font.ITALIC,20));}
				else if (type == 2) {ta.setFont(new Font("正常",Font.BOLD,20));}
			}
		});	
		 
		 // 同上，字体弹窗中按钮的事件
		 b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 这个事件是当点击确认按钮时关闭弹窗	
				
				setVisible(false);				
			}
		});	
		
		 
	}
}


