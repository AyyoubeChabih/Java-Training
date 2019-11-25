package org.mql.xml.parsers;

import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;

import org.mql.xml.models.Publisher;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class PublisherDOMParser {
	private Vector<Publisher> publishers;
	
	public PublisherDOMParser() {
		publishers = new Vector<>();
	}
	
	public PublisherDOMParser(String source) {
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
		publishers = new Vector<>();
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node pub = list.item(i);
			if(pub.getNodeName().equals("publisher")) {
				ectractPublisher(pub);
			}
		}
	}

	public void ectractPublisher(Node node) {
		Publisher publisher = new Publisher(getIntAttribute(node, "id"));
		publishers.add(publisher);
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			if(list.item(i).getNodeName().equals("name")) {
				publisher.setName(getValue(list.item(i)));
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

	public Vector<Publisher> getPublishers() {
		return publishers;
	}
}
