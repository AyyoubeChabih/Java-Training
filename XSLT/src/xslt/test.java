package helllo;

import javax.xml.transform.*;

import javax.xml.transform.stream.*;

import org.xml.sax.*;

import java.io.IOException;

public class test{

	public static void main(String[] args)
	
	throws TransformerException, TransformerConfigurationException,
	
	SAXException, IOException    
	
	{
	
		TransformerFactory tFactory = TransformerFactory.newInstance();
		
		Transformer transformerXML = tFactory.newTransformer(new StreamSource("resources/createTable.xsl"));
		
		transformerXML.transform(new StreamSource("resources/table_Etudiant.xml"), new StreamResult("results/etudiant.xml"));
		
		Transformer transformerXSD = tFactory.newTransformer(new StreamSource("resources/createConstraints.xsl"));
		
		transformerXSD.transform(new StreamSource("resources/table_Etudiant.xml"), new StreamResult("results/etudiant.xsd"));
	
	}  

}
