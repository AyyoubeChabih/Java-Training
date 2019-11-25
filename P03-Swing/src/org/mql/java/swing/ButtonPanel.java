package org.mql.java.swing;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{

	public ButtonPanel(String ...labels) {
		for (int i = 0; i < labels.length; i++) {
			JButton b = new JButton(labels[i]);
			b.setName(labels[i].toLowerCase());
			add(b);
		}
	}

	public JButton getButton(int index) {
		return (JButton)getComponent(index);
	}
	
	public void addActionListener(int index, ActionListener listener) {
		getButton(index).addActionListener(listener);
	}
	
	public void addActionListener(ActionListener listener) {
		for (int i = 0; i < getComponentCount(); i++) {
			getButton(i).addActionListener(listener);
		}
	}
}
