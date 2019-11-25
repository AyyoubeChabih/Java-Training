package org.mql.xml.parsers;

import java.util.Vector;

import javax.swing.JFrame;

import org.mql.xml.models.Document;
import org.mql.xml.parsers.swing.SwingConfig;

public class Exempless {

	public Exempless() {
		exp01();
	}

	public void exp03() {
		JFrame fi = new JFrame("Configuration XML");
		SwingConfig config = new SwingConfig("resources/config/menubar.xml");
		
		fi.setJMenuBar(config.getMenuBar());
		
		fi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fi.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fi.setVisible(true);
	}
	
	public void exp02() {
		DocumentSAXParser parser = new DocumentSAXParser("resources/db/documents/documents.xml");
		Vector<Document> docs = parser.getDocuments();
		for(Document doc : docs) {
			System.out.println(doc);
		}
	}

	public void exp01() {
		DocumentDOMParser parser = new DocumentDOMParser("resources/db/documents/documents.xml");
		Vector<Document> docs = parser.getDocuments();
		for(Document doc : docs) {
			System.out.println(doc);
		}
	}
	
	public static void main(String[] args) {
		new Exempless();
	}
}
