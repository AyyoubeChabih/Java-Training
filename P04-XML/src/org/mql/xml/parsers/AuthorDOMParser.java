package org.mql.xml.parsers;

import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.mql.xml.models.Author;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AuthorDOMParser {
	private Vector<Author> authors;
	
	public AuthorDOMParser() {
		authors = new Vector<>();
	}
	
	public AuthorDOMParser(String source) {
		this();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(source);
			Node root = document.getFirstChild();
			
			while(root.getNodeType() != Node.ELEMENT_NODE) {
				root.getNextSibling();
			}
			extractPublishers(root);
		} catch (Exception e) {
			System.out.println("Erreur "+e.getMessage());
		}
	}

	public void extractPublishers(Node node) {
		authors = new Vector<>();
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node pub = list.item(i);
			if(pub.getNodeName().equals("author")) {
				ectractPublisher(pub);
			}
		}
	}

	public void ectractPublisher(Node node) {
		Author author = new Author(getIntAttribute(node, "id"));
		authors.add(author);
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			if(list.item(i).getNodeName().equals("name")) {
				author.setName(getValue(list.item(i)));
			}
		}
	}

	private String getValue(Node node) {
		return node.getFirstChild().getNodeValue();
	}

	private int getIntAttribute(Node node, String attribute) {
		int v = 0;
		try {
			v = Integer.parseInt(node.getAttributes().getNamedItem(attribute).getNodeValue());
		} catch (Exception e) {}
		return v;
	}

	public Vector<Author> getAuthors() {
		return authors;
	}
}