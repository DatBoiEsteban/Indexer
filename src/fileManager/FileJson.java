package fileManager;

import java.io.FileReader;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileJson extends FileFather {

	private JSONArray valuesArr = new JSONArray();

	public FileJson(String fileName) {
		super.readFile(fileName);
	}

	@Override
	public void parse() {
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsnObj = (JSONObject) parser.parse(new FileReader(super.getName()));
			getValues(jsnObj);
			String text = "";
			for(int i = 0; i < valuesArr.size(); i++) {
				text += valuesArr.get(i).toString() + " ";
			}
			super.filDict(text);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getArray(JSONArray arr) {
		for (int i = 0; i < arr.size(); i++) {
			getValues((JSONObject)arr.get(i));
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
