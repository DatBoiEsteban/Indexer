package IndexSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fileManager.FileFather;

public class TfIdf_Indexer extends Thread implements I_Indexer {
	private Map<String, Double> Idfdict = new HashMap<String, Double>();
	private Set<String> WordSet = new HashSet<String>();
	private ArrayList<FileFather> FileList;
	private Object Index[][];
	private Boolean finished = false;

	// CONSTRUCTOR
	public TfIdf_Indexer(ArrayList<FileFather> pFileList) {
		FileList = pFileList;
	}

	public Object[][] getIndex() {
		return Index;
	}

	public ArrayList<FileFather> getFileList() {
		return FileList;
	}

	public void setFileList(ArrayList<FileFather> fileList) {
		FileList = fileList;
	}

	public Map<String, Double> getIdfdict() {
		return Idfdict;
	}

	public void setIdfdict(Map<String, Double> idfdict) {
		Idfdict = idfdict;
	}

	public Set<String> getWordSet() {
		return WordSet;
	}

	public void setWordSet(Set<String> wordSet) {
		WordSet = wordSet;
	}

	public void IdfDictMaker() {
		for (String actualWord : this.WordSet) {
			this.Idfdict.put(actualWord, (double) 0);
		}
	}

	public void WordSetMaker() {
		for (FileFather file : this.FileList) {
			Map<String, Double> dict = file.getDict();
			for (Map.Entry<String, Double> entry : dict.entrySet()) {
				String word = entry.getKey();
				if (!(this.WordSet.contains(word))) {
					this.WordSet.add(word);
				}
			}
		}

	}

	public void TfCalculator(Map<String, Double> pDict, int WordAmount) {
		for (Map.Entry<String, Double> doc : pDict.entrySet()) {
			doc.setValue(doc.getValue() / WordAmount);
		}
	}

	public void idfDict() {
		for (FileFather file : FileList) {
			Map<String, Double> dict = file.getDict();
			for (Map.Entry<String, Double> doc : dict.entrySet()) {
				String word = doc.getKey();
				Idfdict.put(word, (double) +1);

			}
		}
	}

	public void IdfCalculator() {
		int CantFileFather = FileList.size();
		for (Map.Entry<String, Double> entry : Idfdict.entrySet()) {
			entry.setValue(Math.log(CantFileFather / entry.getValue()));
		}
	}

	public void TfIdfCalculator(Map<String, Double> pDict) {
		for (Map.Entry<String, Double> doc : pDict.entrySet()) {
			String word = doc.getKey();
			if (Idfdict.containsKey(word)) {
				doc.setValue(doc.getValue() * Idfdict.get(word));
			}
		}
	}

	public Double[] RoadMaker(FileFather pFile) {
		Map<String, Double> dict = pFile.getDict();
		Double road[] = new Double[WordSet.size()];
		int position = 0;
		for (String actualWord : WordSet) {
			if (dict.containsKey(actualWord)) {
				road[position] = dict.get(actualWord);
				position++;
			} else {
				road[position] = (double) 0;
				position++;
			}
		}
		return road;
	}

	public void Calculations() {
		for (FileFather actualfile : FileList) {
			Map<String, Double> dict = actualfile.getDict();
			TfCalculator(dict, actualfile.getAmount());
			TfIdfCalculator(dict);
		}
	}

	public void run() {
		WordSetMaker();
		IdfDictMaker();
		idfDict();
		IdfCalculator();
		Calculations();
		Index = new Double[FileList.size()][WordSet.size()];
		Index = indexer();
		finished = true;
	}

	public Boolean isFinished() {
		return finished;
	}

	public Double[][] indexer() {
		Double[][] index = new Double[FileList.size()][WordSet.size()];
		int position = 0;
		for (FileFather file : FileList) {
			index[position] = RoadMaker(file);
			position++;
		}
		return index;

	}

}
