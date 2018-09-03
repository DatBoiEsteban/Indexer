package fileManager;

import java.util.HashMap;
import java.util.Map;

public abstract class File {
	private String Name;
	private String Route;

	public String getName() {
		return Name;
	}

	public void setName(String pName) {
		Name = pName;
	}

	public String getRoute() {
		return Route;
	}

	public void setRoute(String pRoute) {
		Route = pRoute;
	}

	public abstract Map<String, Integer> parse(String file);

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
