package org.mql.java.reflexion;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.mql.java.models.Document;

public class Test {
	public static void main(String[] args) {
		
		Document doc = new Document();
		doc.setPrice(20);
		
		Method m = null;
		
		try {
			m = Document.class.getDeclaredMethod("toString");
			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			
		}
		
		try {
			System.out.println(m.invoke(doc));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
