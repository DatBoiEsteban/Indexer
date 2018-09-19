package IndexSearch;

import query.Query;

public class ManhattanDistance implements I_Distance {
	
	  Double[][] Distances;
	    

		public ManhattanDistance(TfIdf_Indexer pIndex, Query pQuery) {
			super();
			
			Distances =  new Double[pIndex.getFileList().size()][1];
			for(int i=0; i<pIndex.getFileList().size();i++) {
				Distances[i]=DistanceCalculator(pIndex.getIndex()[i],pQuery.getQueryVector());
			}
		}




		@Override
		public Double[] DistanceCalculator(Double[] pDoc, Double[] pQuery) {
			 Double[] distance = new Double[1];
			 double Result = 0.0;
			  for (int i = 0; i < pDoc.length; i++) {
			        Result += Math.abs(pDoc[i]-pQuery[i]);
			    }   
			    distance[0]= Result;
			 return distance;
		}

	

}

