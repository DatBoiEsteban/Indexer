package fileManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileJson extends FileFather {

	private JSONArray valuesArr = new JSONArray();

	public FileJson(String filePath) {
		super.readFile(filePath);
	}

	@Override
	public void parse() {
		try {
			JSONParser parser = new JSONParser();
			Object jsnObj = parser.parse(new FileReader(super.getPath()));
			if(isJSONArray(jsnObj)) {
				getArray((JSONArray) jsnObj);
			}else {
				getValues((JSONObject) jsnObj);	
			}
			String text = "";
			for(int i = 0; i < valuesArr.size(); i++) {
				if(valuesArr.get(i) != null) {
					text += valuesArr.get(i).toString() + " ";	
				}
			}
			super.filDict(text);

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + super.getName() + "'");

		} catch (IOException ex) {
			System.out.println("Error reading file '" + super.getName() + "'");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private void getArray(JSONArray arr) {
		for (int i = 0; i < arr.size(); i++) {
			
			if(!(arr.get(i) instanceof JSONObject)) {
				valuesArr.add(arr.get(i));
			}else {
				getValues((JSONObject) arr.get(i));	
			}
			
		}
	}

	private boolean isJSONArray(Object obj) {
		if (obj instanceof JSONArray) {
			return true;
		} else {
			return false;
		}
	}

	private void getValues(JSONObject obj) {
		Set<String> keys = obj.keySet();
		for (String key : keys) {
			if (isJSONArray(obj.get(key))) {
				getArray((JSONArray)obj.get(key));
			} else {
				valuesArr.add(obj.get(key));
			}
		}
	}
}
