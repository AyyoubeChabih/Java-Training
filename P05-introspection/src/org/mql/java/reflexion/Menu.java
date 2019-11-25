package org.mql.java.reflexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.mql.java.annotation.Item;
import org.mql.java.annotation.menu;

public class Menu extends JMenuBar{
	private String iconsFolder = "resources/edit/"; // constructeur ??
	private String extension = ".gif";
	
	public Menu(String m[][]) {
		for (int i = 0; i < m.length; i++) {
			addMenu(m[i]);
		}
	}

	public Menu(Object service) {
		menu menu = service.getClass().getAnnotation(menu.class);
		if(menu != null) {
			JMenu m = new JMenu(menu.value());
			add(m);
			Method methods[] = service.getClass().getDeclaredMethods();
			Method indexedMethods[] = new Method[methods.length];
			
			for (int i = 0; i < indexedMethods.length; i++) {
				Item item = methods[i].getDeclaredAnnotation(Item.class);
				if(item != null) {
					indexedMethods[item.index()] = methods[i];
				}
			}
			
			for (int i = 0; i < indexedMethods.length; i++) {
				Item item = indexedMethods[i].getDeclaredAnnotation(Item.class);
				if(item != null) {
					if(item.before().equals("separator")) {
						m.addSeparator();
					}
					ImageIcon icon = new ImageIcon(item.icon());
					JMenuItem mi = new JMenuItem(item.value(), icon);
					mi.addActionListener(new ActionListenerInvoker(indexedMethods[i], service));
					m.add(mi);
				}
			}
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
				m.add(item);
			}
		}
	}
	
	private class ActionListenerInvoker implements ActionListener{
		private Method method;
		private Object object;

		public ActionListenerInvoker(Method method, Object object) {
			super();
			this.method = method;
			this.object = object;
		}

		public void actionPerformed(ActionEvent e) {
			try {
				method.invoke(object);
			} catch (Exception ex) {
				System.out.println("Erreur : " + ex.getMessage());
			}
		}
	}
}
