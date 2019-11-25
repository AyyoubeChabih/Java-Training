package org.mql.xml.parsers;

import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.mql.xml.models.Author;
import org.mql.xml.models.Date;
import org.mql.xml.models.Document;
import org.mql.xml.models.Publisher;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class DocumentSAXParser extends DefaultHandler{
	private Vector<Document> documents;
	private Document document;
	private String tag = null;
	
	public DocumentSAXParser(String source) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(source, this);
		} catch (Exception e) {
			System.out.println("Erreur : "+e.getMessage());
		}
		
	}
	

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(" - "+qName);
		
		tag = qName;
		
		if(qName.equals("documents")) {
			documents = new Vector<>();
		}else if(qName.equals("document")){
			//attributes.getValue(attributes.getIndex("id"));
			int id = Integer.parseInt(attributes.getValue("id"));
			document = new Document(id);
			documents.add(document);
		}else if("date".equals(qName)) {
			int day = Integer.parseInt(attributes.getValue("day"));
			int month = Integer.parseInt(attributes.getValue("month"));
			int year = Integer.parseInt(attributes.getValue("year"));
			document.setDate(new Date(day, month,year));
		}else if("publisher".equals(qName)) {
			int ref = Integer.parseInt(attributes.getValue("ref"));
			PublisherSAXParser parser = new PublisherSAXParser("resources/db/documents/publishers.xml");
			Vector<Publisher> pubs = parser.getPublishers();
			for(Publisher pub : pubs) {
				if(pub.getId()==ref) {
					document.setPublisher(pub);
					break;
				}
			}
		}else if("author".equals(qName)) {
			int ref = Integer.parseInt(attributes.getValue("ref"));
			AuthorSAXParser parser = new AuthorSAXParser("resources/db/documents/authors.xml");
			Vector<Author> auths = parser.getAuthors();
			for(Author auth : auths) {
				if(auth.getId()==ref) {
					document.addAuthor(auth);
				}
			}
		}
	}
	
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		tag = null;
	}
	
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("title".equals(tag)) {
			String text = new String(ch, start,length);
			document.setTitle(text);
		}else if("price".equals(tag)) {
			Double price = Double.parseDouble(new String(ch, start,length));
			document.setPrice(price);
		}
	}
	
	
	public void startDocument() throws SAXException {
		System.out.println(">> Début d'analyse");
	}
	
	
	public void endDocument() throws SAXException {
		System.out.println(">> Fin d'analyse");
	}


	public Vector<Document> getDocuments() {
		return documents;
	}
}