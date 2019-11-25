package org.mql.java.swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LabeledTextField extends JPanel{

	public LabeledTextField(String label, int size) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if(!label.contains(":")) label += " : ";
		JLabel l1 = new JLabel(label); 
		add(l1);
		TextField t1 = new TextField(size);
		add(t1);
	}
	
	public LabeledTextField(String label, int size, int LabelWidth) {
		this(label, size);
		JLabel l1 = (JLabel)getComponent(0);
		l1.setPreferredSize(new Dimension(LabelWidth,getPreferredSize().height));
	}
	
	public void setValue(String value) {
		JTextField t1 = (JTextField)getComponent(1);
		t1.setText(value);
	}
	
	public String getValue() {
		JTextField t1 = (JTextField)getComponent(1);
		return t1.getText();
	}

}
