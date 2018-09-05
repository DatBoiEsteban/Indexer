package fileManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class Files {
	private File file;
	private int amount;
	
	protected void readFile(String fileName) {
		file = new File(fileName);
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

	public abstract void parse();

	public Map<String, Integer> filDict(String text) {
		Map<String, Integer> dict = new HashMap<String, Integer>();
		String words[] = text.split(" ");
		this.amount = words.length;
		for (int i = 0; i < words.length; i++) {
			if (!dict.containsKey(words[i])) {
				dict.put(words[i], 1);
			} else {
				dict.replace(words[i], dict.get(words[i]), dict.get(words[i]) + 1);
			}
		}
		return dict;

	}

}
