package helllo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Selection extends JFrame{

	public Selection() {
		selectData();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void selectData() {
		
		ReadXMLFile XMLdata = new ReadXMLFile("resources/table_Etudiant.xml","results/etudiants.xml", "name","type");
		
		JTable data = new JTable(XMLdata.getData(),XMLdata.getTitles());

		JScrollPane scrollPane = new JScrollPane(data);
		data.setFillsViewportHeight(true);
		
		setContentPane(scrollPane);
	}
	
	public static void main(String argv[]) {
			new Selection();
	}
}
