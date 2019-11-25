package org.mql.java.reflexion;

import java.awt.Color;
import java.awt.FlowLayout;
import java.lang.reflect.Field;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.mql.java.annotation.TextField;

public class Form extends JPanel{
	private JPanel container;
	private int labelWidth = 100;
	
	public Form(String title) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		add(container);
		setTitle(title);
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

	public Form(Object model) {
		this();
		Field f[] = model.getClass().getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			TextField txt = f[i].getAnnotation(TextField.class);
			if(txt != null) {
				add(txt.value(), txt.size());
			}
		}
		setValue(model);
		
		String title = model.getClass().getSimpleName();
		org.mql.java.annotation.Form form = model.getClass().getAnnotation(org.mql.java.annotation.Form.class);
		if(form != null && !form.title().equals("")) {
			title = form.title();
		}
		setTitle(title);
	}
	
	public void setTitle(String title) {
		if(!title.equals("") && !title.equals(":")) title += " : ";
		container.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(),
				title
		));
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
	
	public void setValue(int index, Object value) {
		((LabeledTextField)container.getComponent(index)).setValue(value); // here  
	}
	
	public String getValue(int index) {
		return ((LabeledTextField)container.getComponent(index)).getValue();
	}
	
	public void setValue(Object model) {
		Field f[] = model.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < f.length; i++) {
				TextField txt = f[i].getAnnotation(TextField.class);
				if(txt != null) {
					f[i].setAccessible(true);
					setValue(i, f[i].get(model));
					//System.out.println(model);
					f[i].setAccessible(false);	
				}
			}
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
}
