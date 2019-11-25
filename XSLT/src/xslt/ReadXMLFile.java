package helllo;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.Vector;

public class ReadXMLFile {
	private int nbColumns = 0;
	private int nbRows = 0;
	private String[] titles;
	private String[][] data;
	
	public ReadXMLFile(String source, String dataSource, String ...childs) {
	    try {

	    	File fXmlFile = new File(source);
	    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    	Document doc = dBuilder.parse(fXmlFile);
	    			
	    	doc.getDocumentElement().normalize();

			titles = childs.clone();
	    	
	    	String s = doc.getDocumentElement().getChildNodes().item(1).getNodeName();
	    	
	    	NodeList nList = doc.getElementsByTagName(s);
	    	
	    	Vector<String> columns = new Vector<>();
	    	
	    	if(!doc.getDocumentElement().getNodeName().equals("table")) {
	    		nbRows = nList.getLength();
	    	}else {
	    		nbColumns = nList.getLength();
	    	}
	    	
	    	data = new String[nbRows][childs.length];
	    	
	    	for (int temp = 0; temp < nList.getLength(); temp++) {
	    			
	    		Node nNode = nList.item(temp);
	    				
	    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

	    			Element eElement = (Element) nNode;
	    			for (int i = 0; i < childs.length; i++) {
	    				if(!doc.getDocumentElement().getNodeName().equals("table")) {
	    					data[temp][i] = eElement.getElementsByTagName(childs[i]).item(0).getTextContent();
	    				}else {
	    					columns.add(eElement.getElementsByTagName(childs[i]).item(0).getTextContent());
	    					i++;
	    				}
					}
	    		}
	    	}
	    	
	    	if(!columns.isEmpty() && doc.getDocumentElement().getNodeName().equals("table")) {
	    		String[] cols = new String[columns.size()];
	    		columns.toArray(cols);
	    		ReadXMLFile XMLdata = new ReadXMLFile(dataSource,null,cols);
	    		nbRows = XMLdata.getNbRows();
	    		titles = XMLdata.getTitles();
	    		data = XMLdata.getData();
	    	}
	    	
	        } catch (Exception e) {
	    	e.printStackTrace();
	        }
	}

	public int getNbColumns() {
		return nbColumns;
	}

	public int getNbRows() {
		return nbRows;
	}

	public String[] getTitles() {
		return titles;
	}

	public String[][] getData() {
		return data;
	}
}
