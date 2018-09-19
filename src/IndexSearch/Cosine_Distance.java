package IndexSearch;

import query.Query;

public class Cosine_Distance implements I_Distance {
    Double[][] Distances;
    

	public Cosine_Distance(TfIdf_Indexer pIndex, Query pQuery) {
		super();
		
		Distances =  new Double[pIndex.getFileList().size()][1];
		for(int i=0; i<pIndex.getFileList().size();i++) {
			Distances[i]=DistanceCalculator(pIndex.getIndex()[i],pQuery.getQueryVector());
		}
	}




	public Double[] DistanceCalculator(Double[] pDoc, Double[] pQuery) {
		 Double[] distance = new Double[1];
		 double dotProduct = 0.0;
		 double normA = 0.0;
		 double normB = 0.0;
		    for (int i = 0; i < pDoc.length; i++) {
		        dotProduct += pDoc[i] * pQuery[i];
		        normA += Math.pow(pDoc[i], 2);
		        normB += Math.pow(pQuery[i], 2);
		    }   
		    distance[0]= dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
		 return distance;
	}

}
