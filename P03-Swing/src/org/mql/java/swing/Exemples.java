package org.mql.java.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class Exemples extends JFrame{

	public Exemples() {
		exp13();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	void exp01() {
		JLabel l1 = new JLabel("indentificateur : ");
		JTextField t1 = new JTextField(20); // 20 : nombre des caracteres
		JButton b1 = new JButton("Valider");
		
		JPanel p1 = new JPanel();
		//p1.setLayout(new GridLayout(2, 2));
		//p1.setLayout(new BorderLayout()); les composants dans placer au center et l'un ecrase l'autre
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);
		
		setContentPane(p1);
	}

	void exp02() {
		JLabel l1 = new JLabel("indentificateur : ");
		l1.setBackground(Color.BLUE);
		l1.setOpaque(true); // pour : transaparent = false
		l1.setForeground(Color.WHITE);
		JTextField t1 = new JTextField(20); // 20 : nombre des caracteres
		JButton b1 = new JButton("Valider");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout()); 
		p1.add("West", l1);
		p1.add("North",t1);
		p1.add("South",b1);
		
		setContentPane(p1);
	}
	
	void exp03() {
		JButton b1 = new JButton("Valider");
		JButton b2 = new JButton("Inserer");
		JButton b3 = new JButton("Annuler");
		JPanel p1 = new JPanel();
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		JPanel content = new JPanel(new BorderLayout()); 

		content.add("South", p1);
		
		setContentPane(content);
	}
	
	void exp04() {
		
		ButtonPanel p1 = new ButtonPanel("Valider", "Insérer", "Annuler");
		
		JPanel content = new JPanel(new BorderLayout()); 

		content.add("South", p1);
		
		setContentPane(content);
	}
	
	void exp05() {
		JPanel form = new JPanel();
		form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS)); 
		LabeledTextField t1 = new LabeledTextField("Identificateur", 30); // cree panel, layoutmanager, cree lebel , lajouter, cree textfield , lajouter
		LabeledTextField t2 = new LabeledTextField("Nom", 30);
		LabeledTextField t3 = new LabeledTextField("Prénom", 30);
		LabeledTextField t4 = new LabeledTextField("Adresse email", 30);
		
		form.add(t1);
		form.add(t2);
		form.add(t3);
		form.add(t4);
		
		setContentPane(form);
	}
	
	void exp06() {
		Form form = new Form("Nouveau Contact", 140);

		form.add("Identificateur", 20); // cree panel, layoutmanager, cree lebel , lajouter, cree textfield , lajouter
		form.add("Nom", 30);
		form.add("Prénom", 30);
		form.add("Tél", 30);
		form.add("Adresse email", 30);
		
		setContentPane(form);
	}
	
	void exp07() {
		JMenuBar menu = new JMenuBar();
		JMenu m1 = new JMenu("File");
		menu.add(m1);
		JMenuItem m11  = new JMenuItem("New");
		JMenuItem m12  = new JMenuItem("Open");
		JMenuItem m13  = new JMenuItem("Save");
		JMenuItem m14  = new JMenuItem("Exit");
		m1.add(m11);
		m1.add(m12);
		m1.add(m13);
		m1.addSeparator();
		m1.add(m14);
		
		setJMenuBar(menu);
	}
	
	void exp08() {
		String m[][] = {
			{"File", "New", "Open", "Save", "-", "Exit"},
			{"Edit", "Copy", "Cut", "Paste"}
		};
		
		Menu menu = new Menu(m);
		menu.addActionListener("exit", new ExitAction());
		setJMenuBar(menu);
	}
	
	void exp09() {
		AbstractButton b[] = {
				new JButton("Quiter"),
				new JToggleButton("option"),
				new JCheckBox("option2"),
				new JRadioButton("option3"),
				new JMenuItem("option4")
		};
		
		b[0].addActionListener(new ExitAction());
		JPanel p1 = new JPanel();
		for (int i = 0; i < b.length; i++) {
			p1.add(b[i]);
		}
		
		getContentPane().add("North", p1);
	}
	
	void exp10() {
		JTextField t1 = new JTextField(20);
		JTextField t2 = new JTextField(20);
		JButton b1 = new JButton("Copier");
		b1.addActionListener(new CopyAction(t1,t2));
		JPanel p1 = new JPanel();
		p1.add(t1);
		p1.add(t2);
		p1.add(b1);
		
		setContentPane(p1);
	}
	
	void exp11() {
		TextList t = new TextList();
		getContentPane().add(t);
	}
	
	void exp12() {
		ButtonPanel p1 = new ButtonPanel("Valider", "Imprimer", "Annuler");
		p1.addActionListener(new MultipleActionListener());
		getContentPane().add("South", p1);
	}
	
	void exp13() {
		ChoicePanel p1 = new ChoicePanel(ChoicePanel.MULTIPLE, "Stockage", "Fichier Plat", "XML", "Base de données");
		getContentPane().add("North", p1);
		
		JButton b1 = new JButton("Choix");
		
		class ChoicesAction implements ActionListener{
			private ChoicePanel choicePanel;
			
			public ChoicesAction(ChoicePanel choicePanel) {
				super();
				this.choicePanel = choicePanel;
			}
			public void actionPerformed(ActionEvent e) {
				System.out.println(Arrays.toString(choicePanel.getValues()));
			}
		};
		b1.addActionListener(new ChoicesAction(p1));
		getContentPane().add("South", b1);
	}
	
	public static void main(String[] args) {
		new Exemples();
	}
}
