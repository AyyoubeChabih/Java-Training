package org.mql.xml.parsers;

import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.mql.xml.models.Author;
import org.mql.xml.models.Date;
import org.mql.xml.models.Document;
import org.mql.xml.models.Publisher;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DocumentDOMParser {
	private Vector<Document> documents;
	
	public DocumentDOMParser() {
		documents = new Vector<>();
	}
	
	public DocumentDOMParser(String source) {
		this();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			org.w3c.dom.Document document = builder.parse(source); // pointe sur la racine '/'
			Node root = document.getFirstChild(); // c'est pas forcement un element il peut etre un commentaire
			while(root.getNodeType() != Node.ELEMENT_NODE) { // je sort lorsque je tempe sur un element
				root.getNextSibling();
			}
			extractDocuments(root);
		}catch (Exception e) {
			System.out.println("Erreur "+e.getMessage());
		}
	}
	
	public void extractDocuments(Node node) {
		documents = new Vector<>();
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node doc = list.item(i);
			if(doc.getNodeName().equals("document")) {
				extractDocument(doc);
			}
		}
	}

	void extractDocument(Node node) {
		Document doc = new Document(getIntAttribute(node, "id"));
		documents.add(doc);
		NodeList props = node.getChildNodes();
		for (int i = 0; i < props.getLength(); i++) {
			if(props.item(i).getNodeName().equals("title")) {
				doc.setTitle(getValue(props.item(i)));
			}else if(props.item(i).getNodeName().equals("price")) {
				doc.setPrice(getDoubleValue(props.item(i)));
			}else if(props.item(i).getNodeName().equals("date")) {
				doc.setDate(new Date(getIntAttribute(props.item(i), "day"), getIntAttribute(props.item(i), "month"), getIntAttribute(props.item(i), "year")));
			}else if(props.item(i).getNodeName().equals("publisher")) {
				int ref = Integer.parseInt(props.item(i).getAttributes().getNamedItem("ref").getNodeValue());
				PublisherDOMParser parser = new PublisherDOMParser("resources/db/documents/publishers.xml");
				Vector<Publisher> pubs = parser.getPublishers();
				for(Publisher pub : pubs) {
					if(pub.getId() == ref) {
						doc.setPublisher(pub);
						break;
					}
				}
			}else if(props.item(i).getNodeName().equals("authors")) {
				NodeList list = props.item(i).getChildNodes();
				for (int j = 0; j < list.getLength(); j++) {
					if(list.item(j).getNodeName().equals("author")) {
						int ref = Integer.parseInt(list.item(j).getAttributes().getNamedItem("ref").getNodeValue());
						AuthorDOMParser parser = new AuthorDOMParser("resources/db/documents/authors.xml");
						Vector<Author> auths = parser.getAuthors();
						for(Author auth : auths) {
							if(auth.getId() == ref) {
								doc.addAuthor(auth);
								break;
							}
						}
					}
				}
			}
		}
	}
	
	public String getValue(Node node) {
		return node.getFirstChild().getNodeValue(); // pour text ce n'est pas un text c'est un noeud
	}
	
	public double getDoubleValue(Node node) {
		String value = node.getFirstChild().getNodeValue();
		double v = 0;
		try {
			v = Double.parseDouble(value);
		}catch(Exception e) {}
		return v;
	}
	
	public int getIntAttribute(Node node, String attribute) {
		int v = 0;
		try {
			v = Integer.parseInt(node.getAttributes().getNamedItem(attribute).getNodeValue());
		} catch (Exception e) {}
		return v;
	}
	
	public Vector<Document> getDocuments(){
		return documents;
	}
}
