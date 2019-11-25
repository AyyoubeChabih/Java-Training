package org.mql.java.models;

import org.mql.java.annotation.Form;
import org.mql.java.annotation.TextField;

@Form(title = "Saisie d'un document")
public class Document {
	@TextField("Identificateur")
	private int id;
	@TextField(value = "Titre", size = 30)
	private String title;
	@TextField(value = "Prix", size = 8)
	private double price;
	private Publisher publisher;
	
	public Document() {
		
	}
	
	public Document(int id) {
		super();
		this.id = id;
	}
	
	public Document(int id, String title, double price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
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
	
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String toString() {
		return "ID :: "+this.getId()+" | Title :: "+this.getTitle()+" | Price :: "+this.getPrice() + "Publisher :: "+getPublisher();
	}
	
	private void increment(int step) {
		id += step;
	}
	
	private void increment() {
		id += 1;
	}
}

