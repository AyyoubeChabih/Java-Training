package org.mql.xml.parsers;

import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.mql.xml.models.Author;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AuthorSAXParser extends DefaultHandler{
	private Vector<Author> authors;
	private Author author;
	private String tag = null;
	
	public AuthorSAXParser(String source) {
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
		
		if(qName.equals("authors")) {
			authors = new Vector<>();
		}else if(qName.equals("author")){
			int id = Integer.parseInt(attributes.getValue("id"));
			author = new Author(id);
			authors.add(author);
		}
	}
	
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		tag = null;
	}
	
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		if("name".equals(tag)) {
			String text = new String(ch, start,length);
			author.setName(text);
		}
	}
	
	
	public void startDocument() throws SAXException {
		
	}
	
	
	public void endDocument() throws SAXException {
		
	}


	public Vector<Author> getAuthors() {
		return authors;
	}

}