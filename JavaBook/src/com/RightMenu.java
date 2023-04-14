package com;

import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.event.*;
import javax.swing.*;


public class RightMenu extends MenuBars{
	/**
	  * 右键菜单类，所有的注释由上往下阅读
	 * 
	 * */	
    // 要使用系统的剪切板，需要先获取，对象是剪切板的首字母拼音(JQB)
	Clipboard JQB = Toolkit.getDefaultToolkit().getSystemClipboard();
	
	// 复制方法(非事件)	
	public void Cp() {
		StringSelection copys = new StringSelection(ta.getSelectedText());
		// 将剪切板放到定义的对象中
		JQB.setContents(copys, null);
		// 判断剪切板中是否有StringFlavor的内容
		if (JQB.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			// 将粘贴的按钮事件设置为真，也就是触发它的事件
			poasteItem.setEnabled(true);
		}	
	}
	
	// 粘贴方法(非事件)
	public void Pa() {
		// 判断是否含有内容
		if (JQB.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
			try {
				// 取出剪切板的内容，并且存储在字符变量
				String str = (String)JQB.getData(DataFlavor.stringFlavor);
				// 将文本域中的内容替换成str中的内容
				ta.replaceRange(str, ta.getSelectionStart(),ta.getSelectionEnd());
				// setEnabled方法是激活该事件，false为不触发事件
				poasteItem.setEnabled(true);
			} 
			catch (Exception e2) {
				e2.printStackTrace();
			}
		}	
	}
	
    // 键自动换行方法(非事件) 
	public void Wline() {
		// 判断复选框是否被勾选
		if (wline.getState()) {
			ta.setLineWrap(true);           // 为真，文本域的内容就自动换行
			ta.setWrapStyleWord(true);      // 换行但不断字	
		} else {
			ta.setLineWrap(false);			// 取消换行
		}					
	}
	 
	// 创建静态容器，所有文件都可以引用
    static JPanel Rp = new JPanel();   
	public void init() {
		pop.add(wline);			// 自动换行
	    pop.addSeparator();		// 分割线
	    pop.add(copyItem);		// 拷贝
	    pop.add(poasteItem);	// 粘贴
	    pop.addSeparator();  	
	    format.add(fontItem);	// 将字体和格式组合
	    pop.add(format);        // 添加格式	  
	      
	    // 右键字体事件
	    fontItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				// 调用字体事件
				Formats formats = new Formats(f);
				// 显示格式的弹窗
				formats.setVisible(true);					
			}
		});	
	    
	    // 右键复制按钮方法
	    copyItem.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				Cp();	// 调用复制方法			
			}
		});
	    // 右键粘贴按钮方法
	    poasteItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Pa();	// 调用粘贴方法		
			}
		});
	    
	    // 右键自动换行事件
	    wline.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				Wline();  // 调用自动换行方法				
			}
		});
	}		
}
