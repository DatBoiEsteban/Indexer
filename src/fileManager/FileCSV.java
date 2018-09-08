package fileManager;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class FileCSV extends FileFather {

	public FileCSV(String fileName) {
		super.readFile(fileName);
	}

	@Override
	public void parse() {
		try {
			Reader in = new FileReader(super.getName());
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
