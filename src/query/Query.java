package query;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import IndexSearch.TfIdf_Indexer;
public class Query {

	private Map<String, Double> dict = new HashMap<String, Double>();
	String[] wordsToDelete;
	private int amountOfDocs;
	private int amountOfWords;
    private Double[] QueryVector;

	public Query(String query, int pAmountOfDocs,TfIdf_Indexer pIndex) {
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
		amountOfWords = words.length;
		fillDict(text);
		QueryTfIdfCalculator(pIndex);
		QueryVector=QueryVectorMaker(pIndex.getWordSet());
	}
	
	private Double[] QueryVectorMaker(Set<String> pWordSet) {
	Double[] queryVector = new Double[pWordSet.size()];
	int position =0;
	for (String actualWord : pWordSet) {
			if (dict.containsKey(actualWord)) {
				queryVector[position]=(double)dict.get(actualWord);
				position++;
			}else {
				queryVector[position]=(double)0;
				position++;
			}
			
	}
	return queryVector;
	}
	
	private void  QueryTfIdfCalculator(TfIdf_Indexer pIndex) {
			pIndex.TfCalculator(dict, amountOfWords);
			pIndex.TfIdfCalculator(dict);
	}

	private void fillDict(String text) {
		String words[] = text.split(" ");
		// this.amount = words.length;
		for (int i = 0; i < words.length; i++) {
			if (!dict.containsKey(words[i])) {
				dict.put(words[i], (double) 1);
			} else {
				dict.replace(words[i], dict.get(words[i]), dict.get(words[i]) + 1);
			}
		}
		setDict(dict);
	}



	public Map<String, Double> getDict() {
		return dict;
	}

	public void setDict(Map<String, Double> dict) {
		this.dict = dict;
	}

	public int getAmountOfWords() {
		return amountOfWords;
	}

	public void setAmountOfWords(int amountOfWords) {
		this.amountOfWords = amountOfWords;
	}

	public Double[] getQueryVector() {
		return QueryVector;
	}

	public void setQueryVector(Double[] queryVector) {
		QueryVector = queryVector;
	}

	public void setAmountOfDocs(int amountOfDocs) {
		this.amountOfDocs = amountOfDocs;
	}

	public int getAmountOfDocs() {
		return amountOfDocs;
	}

}
