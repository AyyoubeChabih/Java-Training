package org.mql.java.services;

import java.util.List;

import org.mql.java.annotation.Item;
import org.mql.java.annotation.menu;
import org.mql.java.models.Document;

@menu("Gestion des documents")
public class DocumentService {

	public DocumentService() {
		
	}

	@Item(value = "Nouveau document", icon = "resources/icons/add.png")
	public void add() {
		System.out.println("Ajout d'un document");
	}
	
	@Item(index = 1, value = "Suppression d'un document")
	public void remove() {
		System.out.println("Suppression d'un document");
	}
	
	@Item(index = 2, value = "Liste des documents")
	public List<Document> list() {
		System.out.println("Récupération de la liste des documents");
		return null;
	}
	
	@Item(index = 3, value = "Quitter", before = "separator")
	public void exit() {
		System.exit(0);
	}
}
