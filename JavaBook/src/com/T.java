package com;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class T extends JFrame{

	public T () {
		super("GridLayout");
		 Container  con=this.getContentPane();
         con.setLayout(new GridLayout(2,3));
         con.add(new JButton("a1"));  
         con.add(new JButton("a2"));
         con.add(new JButton("a3"));  
         con.add(new JButton("a4"));
         con.add(new JButton("a5"));
         con.add(new JButton("a6"));
         setSize(300,120);
         setVisible(true);

	}
	public static void main(String[] args) {
		new T();
	}
}
