package fileManager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class Files {
	private File file;
	
	protected void readFile(String fileName) {
		file = new File(fileName);
	}
	
	public String getName() {
		return file.getName();	
	}
	
	public String getPath() {
		return file.getPath();
	}

	public abstract Map<String, Integer> parse();

	public Map<String, Integer> filDict(String text) {
		Map<String, Integer> dict = new HashMap<String, Integer>();
		String words[] = text.split(" ");
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
