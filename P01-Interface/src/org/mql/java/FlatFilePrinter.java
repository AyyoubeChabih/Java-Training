package org.mql.java;

import java.io.FileWriter;

public class FlatFilePrinter implements Printer{
	private String source;
	
	public FlatFilePrinter(String source) {
		super();
		this.source = source;
	}
	
	public void print(String t[]) {
		try {
			FileWriter out = new FileWriter(source);
			for (int i = 0; i < t.length; i++) {
				out.write(t[i]+"\n");
			}
			out.close();
		}catch(Exception e) {
			System.err.println("Erreur : "+e.getMessage());
		}
	}
}
