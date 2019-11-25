package org.mql.xml.models;

import java.util.Vector;

public class Document {
	private int id;
	private String title;
	private double price;
	private Date date;
	private Publisher publisher;
	private Vector<Author> authors;
	
	public Document() {
		authors = new Vector<>();
	}
	
	public Document(int id) {
		super();
		this.id = id;
		authors = new Vector<>();
	}
	
	public Document(int id, String title, double price, Date date, Publisher publisher, Vector<Author> authors) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.date = date;
		this.publisher = publisher;
		this.authors = authors;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Vector<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Vector<Author> authors) {
		this.authors = authors;
	}

	public void addAuthor(Author author) {
		authors.add(author);
	}
	
	public String toString() {
		String auths = "Authors :: ";
		for(Author auth : authors) {
			auths += auth.getName() + ",";
		}
		return "ID :: "+this.getId()+" | Title :: "+this.getTitle()+" | Price :: "+this.getPrice()+" | Date :: "+this.getDate()+" | Publisher :: "+this.getPublisher().getName()+" | "+auths;
	}
}
