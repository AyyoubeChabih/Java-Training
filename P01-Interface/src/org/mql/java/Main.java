package org.mql.java;

public class Main {
	public Main() {
		test01();
	}
	
	public void test01() {
		DataManager dm = new DataManager();
		
		dm.addPrinter(new ConsolePrinter());
		dm.addPrinter(new DialogPrinter());
		dm.addPrinter(new FlatFilePrinter("resources/Modules.txt"));
		
		dm.add("Ing�nierie de l'objet");
		dm.add("D�v Web");
		dm.add("Design Patterns en Java");
		dm.add("Gestion de projets");
		dm.add("Frameworks Java EE");
		
		dm.sort();
		dm.print();
	}
	public static void main(String[] args) {
		new Main();
	}

}
