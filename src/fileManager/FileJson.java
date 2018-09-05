package fileManager;

import java.io.FileReader;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileJson extends Files {
	JSONParser parser = new JSONParser();

	
	public FileJson(String fileName) {
		super.readFile(fileName);
	}

	@Override
	public Map<String, Integer> parse() {
		try {
			Object obj = parser.parse(new FileReader(super.getName()));
			JSONObject jsnObj = (JSONObject) obj;
			Set<String> it = jsnObj.entrySet();
			System.out.println(it.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
