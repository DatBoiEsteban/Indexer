package fileManager;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class FileCSV extends Files {
	private Map<String, Integer> dict = new HashMap<String, Integer>();

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
				setDict(super.filDict(text));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, Integer> getDict() {
		return dict;
	}

	public void setDict(Map<String, Integer> dict) {
		this.dict = dict;
	}

}
