package org.mql.java.swing;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MultipleActionListener implements ActionListener{

	public MultipleActionListener() {

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("MultipleActionListener");
		Component src = (Component)e.getSource();
		System.out.println(src.getName());
		if (src.getName().equals("imprimer")) {
			
		} else if (src.getName().equals("annuler")) {
			System.exit(0);
		}
	}

}
