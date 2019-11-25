package org.mql.java.models;

import org.mql.java.annotation.Form;
import org.mql.java.annotation.TextField;

//@Form(title = "Saisie d'un Editeur")
@Form
public class Publisher {
	@TextField("Identificateur")
	private int id;
	@TextField(value = "Name", size = 30)
	private String name;
	
	public Publisher() {

	}

	public Publisher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "ID = " + getId() + " , Name = " + getName();
	}
}
