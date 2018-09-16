package IndexSearch;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.math.*;

import fileManager.*;

public class TfIdf_Indexer implements I_Indexer{
	private Map<String, Double> Idfdict ;
	private  Set<String> WordSet; 
	private ArrayList<FileFather> FileList;

	//CONSTRUCTOR 
	public TfIdf_Indexer(ArrayList<FileFather> pFileList) {
		super();
		FileList = pFileList;
		WordSet =  WordSetMaker(); 
		Idfdict = IdfDictMaker();   
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
	public Map<String, Double> IdfDictMaker() {
		 for (String actualWord : WordSet) {
			 Idfdict.put(actualWord, (double) 0);
		 }
		return Idfdict;
	}
	
	public Set<String> WordSetMaker() {
		 for (FileFather file:FileList) {
			 Map<String, Double> dict = file.getDict();
			 for (Map.Entry<String, Double> entry: dict.entrySet()) {
				 String word = entry.getKey();
				 if (Exists(word)) continue;
				 else {
					 WordSet.add(word); 
				 }
			 }
		 }
		return WordSet;
		 
	}
	
	public boolean Exists( String pWord) {
		if (WordSet.isEmpty()) {
			return false;
		}
	    for (String actualWord : WordSet) {
	        if (pWord == actualWord) {
	        	return true;
	        }else continue;
	     }
		return false;
		
	}
	
	public void TfCalculator() {
		for (FileFather file: FileList) {
			Map<String, Double> dict = file.getDict();
			for (Map.Entry<String, Double> doc: dict.entrySet()) {
				doc.setValue(doc.getValue()/file.getAmount());
			}
		}
	}
	
	public void idfDict() {
		for (FileFather file: FileList) {
			Map<String, Double> dict = file.getDict();
			for (Map.Entry<String, Double> doc: dict.entrySet()) {
				String word = doc.getKey();	
				         Idfdict.put(word,(double) +1);
				
			}	
		}
	}
	
public void IdfCalculator() {
	int CantFileFather = FileList.size(); 
	for (Map.Entry<String, Double> entry: Idfdict.entrySet()) {
		entry.setValue(Math.log(CantFileFather/entry.getValue()));
	}
}

public void TfIdfCalculator() {
	for (FileFather file: FileList) {
		Map<String, Double> dict = file.getDict();
		for (Map.Entry<String, Double> doc: dict.entrySet()) {
			String word= doc.getKey();
			doc.setValue(doc.getValue()*Idfdict.get(word));
		}
	}
}


@Override
public void indexer() {
	// TODO Auto-generated method stub
	
}
}
