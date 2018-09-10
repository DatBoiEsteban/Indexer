package fileManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class FileCSV extends FileFather {

	public FileCSV(String filePath) {
		super.readFile(filePath);
	}

	@Override
	public void parse() {
		try {
			Reader in = new FileReader(super.getPath());
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
			for (CSVRecord record : records) {
				String text = record.get(0);
				String column;
				for (int i = 1; i < record.size(); i++) {
					column = record.get(i);
					text = text + " " + column;
				}
				super.filDict(text);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + super.getName() + "'");

		} catch (IOException ex) {
			System.out.println("Error reading file '" + super.getName() + "'");
		}
	}

}
