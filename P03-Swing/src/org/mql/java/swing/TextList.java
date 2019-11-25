package org.mql.java.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/* solution 1 : classe separe */

public class TextList /* class englobante */ extends JPanel implements ActionListener /* solution 2*/{
	private JTextField text;
	private JList<String> list;
	private DefaultListModel<String> model;
	
	public TextList() {
		setLayout(new BorderLayout());
		text = new JTextField();
		text.addActionListener(this);
		add("North", text);
		
		model = new DefaultListModel<>();
		list = new JList<>(model);
		
		add("Center", new JScrollPane(list));
		JButton b1 = new JButton("Clear");
		// Classe Locale 4 solution
		class ClearActionLocale implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				// il n'acces pas aux variable local, seulement les proprietes de la classe
				model.clear(); // cette classe locale a le droit d'acces aux attributs de classe englobante
			}
		}
		
		/* 5 solution classe anonyme
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear(); // cette classe locale a le droit d'acces aux attributs de classe englobante
			}
		});
		*/
		
		b1.addActionListener(new ClearActionLocale());
		add("South", b1);
	}

	public void actionPerformed(ActionEvent e) {
		model.addElement(text.getText());
		text.setText("");
	}
	
	// Class interne 3 solution
	private class ClearAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			model.clear(); // cette class interne a le droit d'acces aux attributs de classe englobante
		}
	}
}
