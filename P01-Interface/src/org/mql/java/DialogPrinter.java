package org.mql.java;

import javax.swing.JOptionPane;

public class DialogPrinter implements Printer{
	public void print(String t[]) {
		JOptionPane.showMessageDialog(null, t);
	}
}
