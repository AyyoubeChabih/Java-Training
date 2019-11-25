package org.mql.java.swing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Form extends JPanel{
	private JPanel container;
	private int labelWidth = 100;
	
	public Form(String title) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		add(container);
		if(!title.equals("") && !title.equals(":")) title += " : ";
		container.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(),
				title
		));
	}

	public Form() {
		this("");
	}
	
	public Form(int labelWidth) {
		this();
		this.labelWidth = labelWidth;
	}
	
	public Form(String title, int labelWidth) {
		this(title);
		this.labelWidth = labelWidth;
	}

	public int getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(int labelWidth) {
		this.labelWidth = labelWidth;
	}
	
	public void add(String label, int size) {
		LabeledTextField t1 = new LabeledTextField(label, size, labelWidth);
		container.add(t1);
	}
}
