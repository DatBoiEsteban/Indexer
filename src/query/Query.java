package query;

import java.util.HashMap;
import java.util.Map;

public class Query {

	private Map<String, Integer> dict = new HashMap<String, Integer>();
	String[] wordsToDelete;
	private int amountOfDocs;

	public Query(String query, int pAmountOfDocs) {
		amountOfDocs = pAmountOfDocs;
		WTD wtd = new WTD();
		wordsToDelete = wtd.getWTD();
		String[] words = query.toLowerCase().split(" ");
		String text = "";
		for (String word : words) {
			for (String wTD : wordsToDelete) {
				if (word != wTD) {
					text += word + " ";
				}
			}
		}
		fillDict(text);
	}

	private void fillDict(String text) {
		String words[] = text.split(" ");
		// this.amount = words.length;
		for (int i = 0; i < words.length; i++) {
			if (!dict.containsKey(words[i])) {
				dict.put(words[i], 1);
			} else {
				dict.replace(words[i], dict.get(words[i]), dict.get(words[i]) + 1);
			}
		}
		setDict(dict);
	}

	public Map<String, Integer> getDict() {
		return dict;
	}

	public void setDict(Map<String, Integer> dict) {
		this.dict = dict;
	}

	public int getAmountOfDocs() {
		return amountOfDocs;
	}

}
