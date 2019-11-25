package org.mql.xml.parsers.swing;

import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SwingConfig extends DefaultHandler{
	private JMenuBar menuBar;
	private String path = "";
	private JMenu menu;

	public SwingConfig(String config) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(config, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equals("menubar")) {
			menuBar = new JMenuBar();
			path = attributes.getValue("icons-path");
		}else if(qName.equals("menu")) {
			menu = new JMenu(attributes.getValue("name"));
			menuBar.add(menu);
		}else if(qName.equals("item")) {
			String name = attributes.getValue("name");
			String iconName = attributes.getValue("icon");
			String actionName = attributes.getValue("action");
			Icon icon = null;
			if(iconName != null) {
				icon = new ImageIcon(path+iconName);
			}
			JMenuItem item = new JMenuItem(name, icon);
			menu.add(item);
			
			if(actionName != null) {
				try {
					Class cls = Class.forName(actionName);
					ActionListener listener = (ActionListener)cls.newInstance();
					item.addActionListener(listener);
				} catch (Exception e) {}
			}
			
		}else if(qName.equals("separator")) {
			menu.addSeparator();
		}
	}
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}
	
}
