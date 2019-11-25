package org.mql.java.swing;

import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar{
	private String iconsFolder = "resources/edit/"; // constructeur ??
	private String extension = ".gif";
	private Hashtable<String, JMenuItem> items;
	
	public Menu(String m[][]) {
		items = new Hashtable<>();
		for (int i = 0; i < m.length; i++) {
			addMenu(m[i]);
		}
	}

	public void addMenu(String t[]) {
		JMenu m = new JMenu(t[0]);
		add(m);
		for (int i = 1; i < t.length; i++) {
			if(t[i].equals("-")) m.addSeparator();
			else {
				ImageIcon icon = new ImageIcon(iconsFolder + t[i] + extension);
				JMenuItem item = new JMenuItem(t[i], icon);
				item.setName(t[i].toLowerCase());
				items.put(t[i].toLowerCase(), item);
				m.add(item);
			}
		}
	}
	
	public void addActionListener(ActionListener listener) {
		// premier solution
		for (int i = 0; i < getMenuCount(); i++) {
			for (int j = 0; j < getMenu(i).getItemCount(); j++) {
				getMenu(i).getItem(j).addActionListener(listener);
			}
		}
		/* deuxieme solution
		Collection<JMenuItem> m = items.values();
		for (JMenuItem item : m) {
			item.addActionListener(listener);
		} */
	}
	
	public void addActionListener(String key, ActionListener listener) {
		JMenuItem item = items.get(key.toLowerCase());
		if (item != null) {
			item.addActionListener(listener);
		}
	}
}
