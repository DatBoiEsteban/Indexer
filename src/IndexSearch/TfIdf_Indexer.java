package IndexSearch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fileManager.FileFather;

public class TfIdf_Indexer implements I_Indexer{
	private Map<String, Double> Idfdict ;
	private  Set<String> WordSet; 
	private ArrayList<FileFather> FileList;
	private  Double Index[][];
	private static TfIdf_Indexer UniqueIndexer;
	
	//CONSTRUCTOR 
	private TfIdf_Indexer(ArrayList<FileFather> pFileList) {
		super();
		FileList = pFileList;
		WordSet =  WordSetMaker(); 
		Idfdict = IdfDictMaker();
		idfDict();
		IdfCalculator();
		Calculations();
		Index = new Double[FileList.size()][WordSet.size()];
		Index = indexer();
	}
	private synchronized static void createInstance(ArrayList<FileFather> pFileList) {
		if(UniqueIndexer==null) {
			UniqueIndexer = new TfIdf_Indexer(pFileList);
		}
	}
	public static TfIdf_Indexer getInstance(ArrayList<FileFather> pFileList) {
		createInstance(pFileList);
		
		
		return UniqueIndexer;
		
	}
	public Double[][] getIndex(){
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
		Map<String, Double> idfdict = new HashMap<String, Double>();
		 for (String actualWord : WordSet) {
			 idfdict.put(actualWord, (double) 0);
		 }
		return idfdict;
	}
	
	public Set<String> WordSetMaker() {
		Set<String> WordSet = new HashSet<String>(); 
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
	public void Calculations() {
		for (FileFather actualfile: FileList) {
			Map<String, Double> dict = actualfile.getDict();
			TfCalculator(dict,actualfile.getAmount());
			TfIdfCalculator(dict);
		}
	}
	
	
	public void TfCalculator(Map<String, Double> pDict, int WordAmount) {
			for (Map.Entry<String, Double> doc: pDict.entrySet()) {
				doc.setValue(doc.getValue()/WordAmount);
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

public void TfIdfCalculator(Map<String, Double> pDict) {
		for (Map.Entry<String, Double> doc: pDict.entrySet()) {
			String word= doc.getKey();
			if (Idfdict.containsKey(word)) {
				doc.setValue(doc.getValue()*Idfdict.get(word));
			}else continue;
		}
}

public  Double[] RoadMaker(FileFather pFile) {
	Map<String, Double> dict = pFile.getDict();
	Double road[] = new Double[WordSet.size()];
	int position = 0; 
	//road[0]= pFile;
	 for (String actualWord : WordSet) {
			 if(dict.containsKey(actualWord)) {
				 road[position]=dict.get(actualWord);
				 position++;
			 }else {
				 road[position]=(double) 0;
				 position++;
			 }
			   
		 
	 }
	 return road;
	}


//@Override
public Double[][] indexer() {
	Double[][]index = new Double[FileList.size()][WordSet.size()];
	int position =0;
	for (FileFather file: FileList) {
	 index[position]=RoadMaker(file);
	 position++; 
	}
	return index;
		 
	}
		
		
	
	

}
