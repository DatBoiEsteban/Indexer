package fileManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class FileFather {
	private File file;
	private int amount;
	private Map<String, Double> dict = new HashMap<String, Double>();

	protected void readFile(String filePath) {
		file = new File(filePath);
	}

	public String getName() {
		return file.getName();
	}

	public String getPath() {
		return file.getPath();
	}

	public int getAmount() {
		return amount;
	}

	public Map<String, Double> getDict() {
		return dict;
	}

	protected void setDict(Map<String, Double> dict) {
		this.dict = dict;
	}

	public String toString() {
		return dict.toString();
	}

	public abstract void parse();

	public void filDict(String text) {
		String[] charToDel = {",",".",":",";","-","_","+","*","¿", "?","!", "¡" };
		String words[] = text.toLowerCase().split(" ");
		for (String chars : charToDel) {
			for (int i = 0; i<words.length; i++) {
				if (words[i].endsWith(chars)) {
					words[i] = words[i].substring(0, words[i].length()-1);
				}
			}
		}

		this.amount = words.length;
		for (int i = 0; i < words.length; i++) {
			if (!dict.containsKey(words[i])) {
				dict.put(words[i], (double) 1);
			} else {
				dict.replace(words[i], dict.get(words[i]), dict.get(words[i]) + 1);
			}
		}
		if (dict.containsKey("\n")) {
			dict.remove("\n");
		}
		if (dict.containsKey("")) {
			dict.remove("");
		}
		setDict(dict);

	}

}
