package IndexSearch;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import fileManager.FileFather;

public class TfIdf_Indexer implements I_Indexer{
	private Map<String, Double> Idfdict ;
	private  Set<String> WordSet; 
	private ArrayList<FileFather> FileList;
	private  Object Index[][];
	
	//CONSTRUCTOR 
	public TfIdf_Indexer(ArrayList<FileFather> pFileList) {
		super();
		FileList = pFileList;
		WordSet =  WordSetMaker(); 
		Idfdict = IdfDictMaker(); 
		Index = new Object[FileList.size()][WordSet.size()+1];
		Index = indexer();
	}
	public Object[][] getIndex(){
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
				 if (!(WordSet.contains(word))) {
					 WordSet.add(word);
				 }
					 
				 
			 }
		 }
		return WordSet;
		 
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

public  Object[] RoadMaker(FileFather pFile) {
	Map<String, Double> dict = pFile.getDict();
	Object road[] = new Object[WordSet.size()+1];
	road[0]= pFile.getPath();
	 for (String actualWord : WordSet) {
		 for(int i=1; i<WordSet.size();i++) {
			 if(dict.containsKey(actualWord)) {
				 road[i]=dict.get(actualWord);
			 }else road[i]=0;
		 }
	 }
	 return road;
	}


//@Override
public Object[][] indexer() {
	for (FileFather file: FileList) {
		for(int i=0; i<FileList.size();i++) {
			Index[i]=RoadMaker(file);
		}
	}
	return Index;
		 
	}
		
		
	
	

}
