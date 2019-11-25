package org.mql.java.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class CopyAction implements ActionListener{
	private JTextField source, target;
	
	public CopyAction(JTextField source, JTextField target) {
		super();
		this.source = source;
		this.target = target;
	}

	public void actionPerformed(ActionEvent e) {
		target.setText(source.getText());
	}

}
