package fileManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class FileFather {
	private File file;
	private int amount;
	private Map<String, Integer> dict = new HashMap<String, Integer>();

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

	protected void setDict(Map<String, Integer> pDict) {
		dict = pDict;
	}

	public Map<String, Integer> getDict() {
		return dict;
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
				dict.put(words[i], 1);
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
