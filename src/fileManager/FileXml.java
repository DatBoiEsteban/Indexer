package fileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class FileXml extends FileFather {

	public FileXml(String filePath) {
		super.readFile(filePath);
	}

	@Override
	public void parse() {
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			builderFactory.setIgnoringElementContentWhitespace(true);
			builderFactory.setIgnoringComments(true);
			DocumentBuilder doc = builderFactory.newDocumentBuilder();
			Document document = doc.parse(new File(super.getPath()));
			String text = document.getDocumentElement().getTextContent();
			String[] newText = text.split("\n");
			for(String texto : newText){
				super.filDict(texto);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + super.getName() + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + super.getName() + "'");
		} catch (SAXException ex) {
			Logger.getLogger(FileXml.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(FileXml.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}