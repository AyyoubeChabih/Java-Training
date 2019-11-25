package org.mql.xml.parsers;

import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.mql.xml.models.Publisher;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PublisherSAXParser extends DefaultHandler{
	private Vector<Publisher> publishers;
	private Publisher publisher;
	private String tag = null;
	
	public PublisherSAXParser(String source) {
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
		
		if(qName.equals("publishers")) {
			publishers = new Vector<>();
		}else if(qName.equals("publisher")){
			int id = Integer.parseInt(attributes.getValue("id"));
			publisher = new Publisher(id);
			publishers.add(publisher);
		}
	}
	
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		tag = null;
	}
	
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("name".equals(tag)) {
			String text = new String(ch, start,length);
			publisher.setName(text);
		}
	}
	
	
	public void startDocument() throws SAXException {
		
	}
	
	
	public void endDocument() throws SAXException {
		
	}


	public Vector<Publisher> getPublishers() {
		return publishers;
	}

}
