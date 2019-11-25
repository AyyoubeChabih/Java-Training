package org.mql.java.reflexion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JFrame;

import org.mql.java.models.Document;
import org.mql.java.models.Publisher;
import org.mql.java.services.DocumentService;

public class Exemples {

	public Exemples() {
		exp07();
	}
	
	public void exp01() {
		Class<?> cls = Document.class;
		reflexion(cls);
	}

	void exp02() {
		Document d1 = new Document();
		reflexion(d1.getClass());
	}
	
	void reflexion(Class<?> cls) {
		System.out.println(cls.getName());
		
		System.out.println("Liste des propriétés :");
		
		Field f[] = cls.getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			System.out.println(" - " + f[i].getName());
		}
		
		System.out.println("Liste des méthodes :");
		
		Method m[] = cls.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			System.out.println(" - " + m[i].getName());
		}
	}

	void exp03() {
		Document d1 = new Document(101, "La refléxion en Java", 654);
		Field f[] = d1.getClass().getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			Object value = null;
			try {
				boolean state = f[i].isAccessible();
				f[i].setAccessible(true);
				value = f[i].get(d1);
				f[i].setAccessible(state);
			} catch (Exception e) {
				System.out.println("Error : " + e.getMessage());
			}
			System.out.println(f[i].getName() + " = " + value);
		}
	}

	void exp04() {
		Document d1 = new Document();
		try {
			Field f = d1.getClass().getDeclaredField("title");
			f.setAccessible(true);
			f.set(d1, "Valeur affecter par refléxion");
			f.setAccessible(false);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		System.out.println(d1);
	}

	void exp05() {
		Document d1 = new Document(101, "La refléxion en Java", 654);
		//reflexion(d1.getClass());
		try {
			Method m = d1.getClass().getDeclaredMethod("increment"); // la méthode sans parametre
			boolean state = m.isAccessible();
			m.setAccessible(true);
			m.invoke(d1);
			m.setAccessible(state);
			System.out.println(d1);
			
			m = d1.getClass().getDeclaredMethod("increment", int.class); // la méthode avec parametre
			state = m.isAccessible();
			m.setAccessible(true);
			m.invoke(d1, 10);
			m.setAccessible(state);
			System.out.println(d1);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	void exp06() {
		try {
			Class cls = Class.forName("org.mql.java.models.Document");
			Constructor<?> constructor = cls.getDeclaredConstructor(int.class, String.class, double.class); // tous les const soit public soit prive
			Object x = constructor.newInstance(101, "Introspection", 765);
			System.out.println(x);
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}

	void exp07() {
		Document d1 = new Document(101, "La refléxion en Java", 654);
		//Form form = new Form(d1);
		Form form = new Form(new Publisher(10, "Eyrolles"));
		JFrame f1 = new JFrame();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setContentPane(form);
		f1.pack();
		f1.setVisible(true);
	}

	void exp08() {
		DocumentService service = new DocumentService();
		Menu menu = new Menu(service);
		JFrame f1 = new JFrame();
		f1.setJMenuBar(menu);
		
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(500, 300);
		f1.setVisible(true);
	}

	public static void main(String[] args) {
		new Exemples();
	}
}