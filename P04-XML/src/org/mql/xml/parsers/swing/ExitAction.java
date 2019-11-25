package org.mql.xml.parsers.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitAction implements ActionListener{

	public ExitAction() {
		
	}

	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
